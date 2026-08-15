package com.dragn0007.livestocktfc.mixin;

import com.dragn0007.dragnlivestock.entities.goat.OGoat;
import com.dragn0007.dragnlivestock.entities.sheep.OSheep;
import com.dragn0007.dragnlivestock.util.LivestockOverhaulCommonConfig;
import net.dries007.tfc.common.items.TFCItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(OSheep.class)
public abstract class OSheepMixin extends Animal {

    @Shadow(remap = false) public abstract boolean wasMilked();
    @Shadow(remap = false) public int replenishMilkCounter;
    @Shadow(remap = false) public abstract void setMilked(boolean milked);
    @Shadow public abstract boolean isFemale();

    public OSheepMixin(EntityType<? extends OSheepMixin> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "mobInteract", at = @At("HEAD"), cancellable = true)
    public void mobInteract(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        ItemStack itemStack = player.getItemInHand(hand);
        Item bucketItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation("tfc", "wooden_bucket"));
        if (itemStack.is(TFCItems.WOODEN_BUCKET.get()) && !this.isBaby() && !this.wasMilked()) {
            if (!(Boolean) LivestockOverhaulCommonConfig.GENDERS_AFFECT_BIPRODUCTS.get() || (Boolean) LivestockOverhaulCommonConfig.GENDERS_AFFECT_BIPRODUCTS.get() && this.isFemale()) {
                player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
                ItemStack stack = new ItemStack(bucketItem, 1);
                CompoundTag fluidTag = new CompoundTag();
                fluidTag.putString("FluidName", "minecraft:milk");
                fluidTag.putInt("Amount", 1000);
                CompoundTag mainTag = new CompoundTag();
                mainTag.put("fluid", fluidTag);
                stack.setTag(mainTag);
                player.setItemInHand(hand, stack);
                this.replenishMilkCounter = 0;
                this.setMilked(true);
            }
        }
        cir.setReturnValue(InteractionResult.sidedSuccess(this.level().isClientSide));
    }

    @Inject(method = "dropCustomDeathLoot", at = @At("HEAD"))
    public void dropCustomDeathLoot(DamageSource p_33574_, int p_33575_, boolean p_33576_, CallbackInfo ci) {
        super.dropCustomDeathLoot(p_33574_, p_33575_, p_33576_);
        OSheep self = (OSheep) (Object) this;
        Item rennet = ForgeRegistries.ITEMS.getValue(new ResourceLocation("firmalife", "rennet"));
        if (rennet != null) {
            if (LivestockOverhaulCommonConfig.QUALITY.get()) {
                if (self.isExquisiteQuality()) {
                    this.spawnAtLocation(new ItemStack(rennet, random.nextInt(3)), 0F);
                } else if (self.isFantasticQuality()) {
                    this.spawnAtLocation(new ItemStack(rennet, random.nextInt(2)), 0F);
                } else if (self.isGreatQuality()) {
                    this.spawnAtLocation(new ItemStack(rennet, random.nextInt(2)), 0F);
                } else {
                    this.spawnAtLocation(new ItemStack(rennet, 1), 0F);
                }
            }
        }
    }
}
