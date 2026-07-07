package com.dragn0007.livestocktfc.mixin;

import net.dries007.tfc.client.IHighlightHandler;
import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.devices.DeviceBlock;
import net.dries007.tfc.common.blocks.devices.QuernBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.LeadItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(QuernBlock.class)
public abstract class QuernMixin extends DeviceBlock implements IHighlightHandler {

    public QuernMixin(ExtendedProperties properties, InventoryRemoveBehavior removeBehavior) {
        super(properties, removeBehavior);
    }

    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    private void allowLeashAttachment(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit, CallbackInfoReturnable<InteractionResult> cir) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!state.is(TFCBlocks.QUERN.get())) {
            return;
        }

        ItemStack leadStack = player.getItemInHand(hand);
        LeadItem.bindPlayerMobs(player, level, pos);

        LeashFenceKnotEntity leashfenceknotentity = null;
        boolean flag = false;
        int i = pos.getX();
        int j = pos.getY();
        int k = pos.getZ();

        for(Mob mob : level.getEntitiesOfClass(Mob.class, new AABB((double)i - 7.0D, (double)j - 7.0D, (double)k - 7.0D, (double)i + 7.0D, (double)j + 7.0D, (double)k + 7.0D))) {
            if (mob.getLeashHolder() == player) {
                if (leashfenceknotentity == null) {
                    leashfenceknotentity = LeashFenceKnotEntity.getOrCreateKnot(level, pos);
                    leashfenceknotentity.playPlacementSound();
                }

                mob.setLeashedTo(leashfenceknotentity, true);
                flag = true;
            }
        }

        if (flag) {
            player.gameEvent(GameEvent.BLOCK_ATTACH);
        }

//        cir.setReturnValue(leadStack.is(Items.LEAD) ? InteractionResult.SUCCESS : InteractionResult.PASS);
    }
}
