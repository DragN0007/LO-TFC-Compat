package com.dragn0007.livestocktfc.goal;

import com.dragn0007.dragnlivestock.entities.cow.OCow;
import com.dragn0007.dragnlivestock.entities.util.AbstractOMount;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import net.minecraft.world.level.block.Block;

import java.util.EnumSet;

public class PullQuernGoal extends Goal {
    private final AbstractOMount mob;
    private final Block block;
    private final double orbitRadius;
    private final double speedModifier;

    private BlockPos centerBlockPos = null;
    private int scanCooldown = 0;

    public PullQuernGoal(AbstractOMount mob, double orbitRadius, double speedModifier) {
        this.mob = mob;
        this.block = TFCBlocks.QUERN.get();
        this.orbitRadius = orbitRadius;
        this.speedModifier = speedModifier;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
//        if (this.scanCooldown > 0) {
//            this.scanCooldown--;
//            return this.centerBlockPos != null;
//        }

        this.scanCooldown = 20;
        this.centerBlockPos = findNearbyBlock();

        if (this.centerBlockPos == null) {
            return false;
        } else if (!mob.isLeashed()) {
            return false;
        } else if (!(mob.getLeashHolder() instanceof LeashFenceKnotEntity)) {
            return false;
//        } else if (!mob.isWearingPullingHarness() && !(mob instanceof OCow)) {
//            return false;
//        } else if (mob instanceof OCow cow && cow.getBreed() != 10 && !cow.isSaddled()) {
//            return false;
        } else if (!mob.isTamed()) {
            return false;
        } else if (mob.isVehicle()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean canContinueToUse() {
        if (this.centerBlockPos == null) return false;

        boolean blockStillExists = this.mob.level().getBlockState(this.centerBlockPos).is(this.block);
        boolean closeEnough = this.mob.distanceToSqr(this.centerBlockPos.getX(), this.mob.getY(), this.centerBlockPos.getZ()) < 8.0D;

        return blockStillExists && closeEnough && canUse();
    }

    @Override
    public void stop() {
        this.centerBlockPos = null;
    }

    @Override
    public void tick() {
        if (this.centerBlockPos == null || !this.canUse()) return;

        double centerX = this.centerBlockPos.getX() + 0.5D;
        double centerZ = this.centerBlockPos.getZ() + 0.5D;
        double dX = this.mob.getX() - centerX;
        double dZ = this.mob.getZ() - centerZ;
        double currentDistance = Math.sqrt(dX * dX + dZ * dZ);

        if (currentDistance < 0.1D) currentDistance = 0.1D;
        double dirX = dX / currentDistance;
        double dirZ = dZ / currentDistance;
        double tangentX = dirZ;
        double tangentZ = -dirX;
        double radiusCorrection = 0.2D * (this.orbitRadius - currentDistance);
        double moveX = (tangentX * (this.speedModifier * 0.25D)) + (dirX * radiusCorrection);
        double moveZ = (tangentZ * (this.speedModifier * 0.25D)) + (dirZ * radiusCorrection);

        this.mob.setDeltaMovement(moveX, this.mob.getDeltaMovement().y, moveZ);

        float targetYaw = (float) (Math.atan2(moveZ, moveX) * (180D / Math.PI)) - 90.0F;
        this.mob.setYRot(targetYaw);
        this.mob.yRotO = targetYaw;
        this.mob.setYHeadRot(targetYaw);
        this.mob.setYBodyRot(targetYaw);
    }

    private BlockPos findNearbyBlock() {
        BlockPos origin = this.mob.blockPosition();
        for (BlockPos pos : BlockPos.withinManhattan(origin, 8, 3, 8)) {
            if (this.mob.level().getBlockState(pos).is(this.block)) {
                return pos.immutable();
            }
        }
        return null;
    }
}
