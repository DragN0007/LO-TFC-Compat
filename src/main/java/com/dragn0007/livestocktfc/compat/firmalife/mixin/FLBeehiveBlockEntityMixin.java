package com.dragn0007.livestocktfc.compat.firmalife.mixin;

import com.dragn0007.livestocktfc.compat.firmalife.IWax;
import com.eerussianguy.firmalife.common.blockentities.FLBeehiveBlockEntity;
import net.dries007.tfc.common.blockentities.TickableInventoryBlockEntity;
import net.dries007.tfc.util.calendar.ICalendarTickable;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(FLBeehiveBlockEntity.class)
public abstract class FLBeehiveBlockEntityMixin extends TickableInventoryBlockEntity<ItemStackHandler> implements ICalendarTickable, IWax {
//    @Shadow protected abstract boolean hasBees();
//
//    @Shadow public abstract @NotNull List<IBee> getUsableBees(float temp);
//
//    @Shadow public abstract int getFlowers(List<IBee> bees, boolean tick);
//
//    @Shadow public abstract int getBreedTickChanceInverted(List<IBee> bees, int flowers);
//
//    @Unique public boolean wax = false;
//    @Unique public boolean hasWax() {return this.wax;}
//    @Unique public void setHasWax(boolean wax) {this.wax = wax;}
//
    protected FLBeehiveBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state, InventoryFactory<ItemStackHandler> inventory, Component defaultName) {
        super(type, pos, state, inventory, defaultName);
    }
//
//    @Inject(method = "updateTick", at = @At("HEAD"))
//    private void updateTick(CallbackInfo ci) {
//        assert this.level != null;
//        Direction direction = this.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
//        BlockPos posInFront = this.worldPosition.relative(direction);
//        if (this.level.getBlockState(posInFront).getCollisionShape(this.level, posInFront).isEmpty()) {
//            float temp = Climate.getTemperature(this.level, this.worldPosition);
//            List<IBee> usableBees = this.getUsableBees(temp);
//            int flowers = this.getFlowers(usableBees, true);
//            int breedTickChanceInverted = this.getBreedTickChanceInverted(usableBees, flowers);
//            if (flowers > 10 && (breedTickChanceInverted == 0 || this.level.random.nextInt(breedTickChanceInverted) == 0)) {
//                for(int i = 0; i < 4; ++i) {
//                    IBee bee = this.inventory.getStackInSlot(i).getCapability(BeeCapability.CAPABILITY).resolve().orElse(null);
//                    if (bee != null) {
//                        if (bee.hasQueen()) {
//                            bee.setHasWax(true);
//                        }
//                    }
//                }
//            }
//        }
//    }
}
