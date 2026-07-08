package com.dragn0007.livestocktfc.mixin;

import com.dragn0007.dragnlivestock.entities.horse.OHorse;
import com.dragn0007.dragnlivestock.entities.util.AbstractOMount;
import com.dragn0007.livestocktfc.items.LOTFCItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(OHorse.class)
public abstract class OHorseMixin extends AbstractOMount {

    public OHorseMixin(EntityType<? extends OHorseMixin> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "dropCustomDeathLoot", at = @At("HEAD"))
    public void dropCustomDeathLoot(DamageSource p_33574_, int p_33575_, boolean p_33576_, CallbackInfo ci) {
        super.dropCustomDeathLoot(p_33574_, p_33575_, p_33576_);
        Random random = new Random();
        this.spawnAtLocation(new ItemStack(LOTFCItems.HORSE_HAIR.get(), random.nextInt(5)), 0F);
    }
}
