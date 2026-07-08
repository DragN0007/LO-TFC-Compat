package com.dragn0007.livestocktfc.mixin;

import com.dragn0007.dragnlivestock.entities.cow.OCow;
import com.dragn0007.dragnlivestock.entities.goat.OGoat;
import com.dragn0007.dragnlivestock.entities.util.AbstractOMount;
import com.dragn0007.dragnlivestock.items.LOItems;
import com.dragn0007.dragnlivestock.util.LivestockOverhaulCommonConfig;
import net.dries007.tfc.common.items.TFCItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(OGoat.class)
public abstract class OGoatMixin extends AbstractOMount {

    @Shadow(remap = false) public abstract boolean wasMilked();
    @Shadow(remap = false) public int replenishMilkCounter;
    @Shadow(remap = false) public abstract void setMilked(boolean milked);

    public OGoatMixin(EntityType<? extends OGoatMixin> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "mobInteract", at = @At("HEAD"), cancellable = true)
    public void mobInteract(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        ItemStack itemStack = player.getItemInHand(hand);
        Item bucketItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation("tfc", "wooden_bucket"));
        if (itemStack.is(TFCItems.WOODEN_BUCKET.get()) && !this.isBaby() && !this.wasMilked()) {
            if (!LivestockOverhaulCommonConfig.GENDERS_AFFECT_BIPRODUCTS.get() || LivestockOverhaulCommonConfig.GENDERS_AFFECT_BIPRODUCTS.get() && this.isFemale()) {
                ItemStack stack = new ItemStack(bucketItem, 1);
                CompoundTag fluidTag = new CompoundTag();
                fluidTag.putString("FluidName", "minecraft:milk");
                fluidTag.putInt("Amount", 1000);
                CompoundTag mainTag = new CompoundTag();
                mainTag.put("fluid", fluidTag);
                stack.setTag(mainTag);
                player.setItemInHand(InteractionHand.MAIN_HAND, stack);
                this.replenishMilkCounter = 0;
                this.setMilked(true);
            }
            cir.setReturnValue(InteractionResult.sidedSuccess(this.level().isClientSide));
        }
    }
}
