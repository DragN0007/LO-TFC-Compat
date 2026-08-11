package com.dragn0007.livestocktfc.mixin;

import com.dragn0007.dragnlivestock.entities.llama.OLlama;
import com.dragn0007.dragnlivestock.util.LivestockOverhaulCommonConfig;
import net.dries007.tfc.common.items.TFCItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(OLlama.class)
public abstract class OLlamaMixin extends Animal {

    @Shadow(remap = false) public abstract boolean wasMilked();
    @Shadow(remap = false) public int replenishMilkCounter;
    @Shadow(remap = false) public abstract void setMilked(boolean milked);
    @Shadow(remap = false) public abstract boolean isFemale();

    public OLlamaMixin(EntityType<? extends OLlamaMixin> entityType, Level level) {
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
}
