package com.dragn0007.livestocktfc.compat.firmalife;

import org.spongepowered.asm.mixin.Unique;

public interface IWax {
    @Unique void setHasWax(boolean wax);
    @Unique boolean hasWax();
}
