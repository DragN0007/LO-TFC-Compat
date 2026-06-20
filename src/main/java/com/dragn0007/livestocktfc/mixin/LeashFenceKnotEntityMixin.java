package com.dragn0007.livestocktfc.mixin;

import net.dries007.tfc.common.blocks.TFCBlocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(LeashFenceKnotEntity.class)
public abstract class LeashFenceKnotEntityMixin extends HangingEntity {

    protected LeashFenceKnotEntityMixin(EntityType<? extends HangingEntity> p_31703_, Level p_31704_) {
        super(p_31703_, p_31704_);
    }

    @Overwrite
    public boolean survives() {
        return this.level().getBlockState(this.pos).is(BlockTags.FENCES) || this.level().getBlockState(this.pos).is(TFCBlocks.QUERN.get());
    }
}
