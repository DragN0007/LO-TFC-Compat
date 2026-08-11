package com.dragn0007.livestocktfc.compat.firmalife;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

//allows the FirmaLife mixins to run when installed
public class FirmaLifeMixinPlugin implements IMixinConfigPlugin {

    @Override
    public void onLoad(String mixinPackage) {}

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
//        if (LOTFCCommonConfig.QUEEN_BEE_SCRAPE.get()) {
//            try {
//                Class.forName("com.eerussianguy.firmalife.FirmaLife", false, this.getClass().getClassLoader());
//                return true;
//            } catch (ClassNotFoundException e) {
//                return false;
//            }
//        } else {
            return false;
//        }
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
}