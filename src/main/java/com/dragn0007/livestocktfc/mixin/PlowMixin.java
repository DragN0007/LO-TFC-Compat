package com.dragn0007.livestocktfc.mixin;

import com.dragn0007.dragnlivestock.entities.wagon.Plow;
import com.dragn0007.dragnlivestock.entities.wagon.base.AbstractInventoryWagon;
import com.dragn0007.dragnlivestock.entities.wagon.base.AbstractWagon;
import com.dragn0007.dragnlivestock.util.LOTags;
import com.dragn0007.livestocktfc.util.LOTFCTags;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.soil.SoilBlockType;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Plow.class)
public abstract class PlowMixin extends AbstractInventoryWagon {

    public PlowMixin(EntityType<? extends AbstractWagon> type, Level level, double maxSpeed, double acceleration, float turnRate, int maxHealth, int capacity, Vec3[] draughtAnimalPositions, double wheelWidth, double wheelLength, Vec3[] riders) {
        super(type, level, maxSpeed, acceleration, turnRate, maxHealth, capacity, draughtAnimalPositions, wheelWidth, wheelLength, riders);
    }

    @Overwrite(remap = false)
    protected void tillNewFarmland(BlockPos pos) {
        pos = pos.below();
        BlockState blockState = this.level().getBlockState(pos);
        if (!ModList.get().isLoaded("tfc")) {
            if (blockState.is(LOTags.Blocks.GRASS_BLOCKS) || blockState.is(BlockTags.DIRT)) {
                this.level().setBlockAndUpdate(pos, Blocks.FARMLAND.defaultBlockState());
            }
        } else {
            if (blockState.is(LOTFCTags.Blocks.LOAM)) {
                this.level().setBlockAndUpdate(pos, TFCBlocks.SOIL.get(SoilBlockType.FARMLAND).get(SoilBlockType.Variant.LOAM).get().defaultBlockState());
            } else if (blockState.is(LOTFCTags.Blocks.SILT)) {
                this.level().setBlockAndUpdate(pos, TFCBlocks.SOIL.get(SoilBlockType.FARMLAND).get(SoilBlockType.Variant.SILT).get().defaultBlockState());
            } else if (blockState.is(LOTFCTags.Blocks.SILTY_LOAM)) {
                this.level().setBlockAndUpdate(pos, TFCBlocks.SOIL.get(SoilBlockType.FARMLAND).get(SoilBlockType.Variant.SILTY_LOAM).get().defaultBlockState());
            } else if (blockState.is(LOTFCTags.Blocks.SANDY_LOAM)) {
                this.level().setBlockAndUpdate(pos, TFCBlocks.SOIL.get(SoilBlockType.FARMLAND).get(SoilBlockType.Variant.SANDY_LOAM).get().defaultBlockState());
            }
        }
    }
}
