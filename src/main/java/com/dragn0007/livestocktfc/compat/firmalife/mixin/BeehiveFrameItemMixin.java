package com.dragn0007.livestocktfc.compat.firmalife.mixin;

import com.dragn0007.livestocktfc.compat.firmalife.IWax;
import com.eerussianguy.firmalife.common.items.BeehiveFrameItem;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BeehiveFrameItem.class)
public abstract class BeehiveFrameItemMixin extends Item implements IWax {
//    @Unique public boolean wax = false;
//    @Unique public boolean hasWax() {return this.wax;}
//    @Unique public void setHasWax(boolean wax) {this.wax = wax;}
//
    public BeehiveFrameItemMixin(Properties p_41383_) {
        super(p_41383_);
    }
//
//    /**
//     * @author eerussianguy (original author), DragN0007 (modifying author)
//     * @reason changes wax scraping to keep the queen bee intact, and allows destruction of the queen in an empty frame instead.
//     * wax is now tagged separately from the queen so that they can both exist independently on a frame.
//     */
//    @Overwrite
//    public boolean overrideOtherStackedOnMe(ItemStack stack, ItemStack knifeStack, Slot slot, ClickAction action, Player player, SlotAccess access) {
//        if (action == ClickAction.SECONDARY && Helpers.isItem(knifeStack, TFCTags.Items.KNIVES)) {
//            return stack.getCapability(BeeCapability.CAPABILITY).map(bee -> {
//                if (bee.hasQueen() && !this.hasWax()) {
//                    slot.set(new ItemStack(this));
//                    knifeStack.hurtAndBreak(1, player, p -> {});
//                    return true;
//                } else if (this.hasWax()) {
////                    slot.set(new ItemStack(stack.copy().getItem()));
//                    ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(FLItems.BEESWAX.get()));
//                    knifeStack.hurtAndBreak(1, player, p -> {});
//                    return true;
//                }
//                return false;
//            }).orElse(false);
//        }
//        return false;
//    }
//
//    @Inject(method = "appendHoverText", at = @At("HEAD"))
//    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag advanced, CallbackInfo ci) {
//        super.appendHoverText(stack, level, tooltip, advanced);
//        if (this.hasWax()) {
//            tooltip.add(Component.translatable("firmalife.bee.has_wax"));
//        }
//    }
}
