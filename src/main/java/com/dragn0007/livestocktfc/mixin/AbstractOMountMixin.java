package com.dragn0007.livestocktfc.mixin;

import com.dragn0007.dragnlivestock.entities.util.AbstractOMount;
import com.dragn0007.livestocktfc.goal.PullQuernGoal;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.horse.AbstractChestedHorse;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractOMount.class)
public abstract class AbstractOMountMixin extends AbstractChestedHorse {

    public AbstractOMountMixin(EntityType<? extends AbstractOMount> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "registerGoals", at = @At("HEAD"))
    public void registerGoals(CallbackInfo ci) {
        super.registerGoals();
        AbstractOMount self = (AbstractOMount) (Object) this;
        this.goalSelector.addGoal(0, new PullQuernGoal(self, 2.0D, 0.5F));
    }
}