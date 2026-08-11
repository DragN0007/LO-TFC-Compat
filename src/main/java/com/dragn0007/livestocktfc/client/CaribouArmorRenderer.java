package com.dragn0007.livestocktfc.client;

import com.dragn0007.livestocktfc.LivestockTFC;
import com.dragn0007.livestocktfc.items.armor.CaribouArmorItem;
import com.dragn0007.livestocktfc.util.HideArmorTypes;
import com.electronwill.nightconfig.core.UnmodifiableConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.model.CoreGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

import javax.annotation.Nullable;

public final class CaribouArmorRenderer extends GeoArmorRenderer<CaribouArmorItem> {
	public CaribouArmorRenderer() {
		super(new GeoModel<>() {
            @Override
            public ResourceLocation getModelResource(CaribouArmorItem animatable) {
                return new ResourceLocation(LivestockTFC.MODID, "geo/caribou_hide_armor.geo.json");
            }

            @Override
            public ResourceLocation getTextureResource(CaribouArmorItem animatable) {
                ItemStack renderStack = ItemStack.EMPTY;
                if (!renderStack.isEmpty() && renderStack.getItem() instanceof CaribouArmorItem armorItem) { //todo
                    String item = ForgeRegistries.ITEMS.getKey(armorItem).getPath();
                    System.out.println("textures/armor/" + item + ".png");
                    return new ResourceLocation(LivestockTFC.MODID, "textures/armor/" + item + ".png");
                } else {
                    return new ResourceLocation(LivestockTFC.MODID, "textures/armor/caribou_hide_armor.png");
                }
            }

            @Override
            public ResourceLocation getAnimationResource(CaribouArmorItem animatable) {
                return null;
            }
        });
	}
}
