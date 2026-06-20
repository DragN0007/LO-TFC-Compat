package com.dragn0007.livestocktfc.mixin;

import com.dragn0007.dragnlivestock.entities.util.AbstractOMount;
import com.dragn0007.livestocktfc.goal.PullQuernGoal;
import net.dries007.tfc.client.IHighlightHandler;
import net.dries007.tfc.common.blockentities.QuernBlockEntity;
import net.dries007.tfc.common.blockentities.TickableInventoryBlockEntity;
import net.dries007.tfc.common.blockentities.rotation.RotationSinkBlockEntity;
import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.devices.DeviceBlock;
import net.dries007.tfc.common.blocks.devices.QuernBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.LeadItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.items.ItemStackHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(QuernBlockEntity.class)
public abstract class QuernEntityMixin extends TickableInventoryBlockEntity<ItemStackHandler> implements RotationSinkBlockEntity {

    protected QuernEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state, InventoryFactory<ItemStackHandler> inventory, Component defaultName) {
        super(type, pos, state, inventory, defaultName);
    }

    @Inject(method = "serverTick", at = @At("HEAD"), remap = false)
    private static void tickAnimal(Level level, BlockPos pos, BlockState state, QuernBlockEntity quern, CallbackInfo ci) {
        double range = 10.0;
        AABB searchBox = new AABB(pos).inflate(range);
        List<AbstractOMount> nearbyPullers = level.getEntitiesOfClass(AbstractOMount.class, searchBox);

        for (AbstractOMount animal : nearbyPullers) {
            if (
//                    animal.isLeashed() &&
//                    animal.getLeashHolder() instanceof LeashFenceKnotEntity &&
                    animal.goalSelector.getRunningGoals().anyMatch(goal -> goal.getGoal() instanceof PullQuernGoal) &&
                    !quern.isGrinding()) {
                quern.startGrinding();
//                return;
            }
        }
    }
}
