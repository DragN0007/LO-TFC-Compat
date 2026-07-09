package com.dragn0007.livestocktfc.mixin;

import com.dragn0007.dragnlivestock.entities.caribou.Caribou;
import com.dragn0007.dragnlivestock.entities.util.AbstractOMount;
import com.dragn0007.livestocktfc.items.LOTFCItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin(Caribou.class)
public abstract class CaribouMixin extends AbstractOMount {

    public CaribouMixin(EntityType<? extends CaribouMixin> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void dropCustomDeathLoot(DamageSource p_33574_, int p_33575_, boolean p_33576_) {
        super.dropCustomDeathLoot(p_33574_, p_33575_, p_33576_);
        Random random = new Random();
        this.spawnAtLocation(new ItemStack(LOTFCItems.CARIBOU_FUR.get(), random.nextInt(5)), 0F);
    }
}
