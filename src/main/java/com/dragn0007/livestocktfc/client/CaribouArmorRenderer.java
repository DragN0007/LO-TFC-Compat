package com.dragn0007.livestocktfc.client;

import com.dragn0007.livestocktfc.LivestockTFC;
import com.dragn0007.livestocktfc.items.armor.CaribouArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;


public final class CaribouArmorRenderer extends GeoArmorRenderer<CaribouArmorItem> {

	public CaribouArmorRenderer() {

		super(new GeoModel<>() {
			@Override
			public ResourceLocation getModelResource(CaribouArmorItem animatable) {
				return new ResourceLocation(LivestockTFC.MODID, "geo/caribou_hide_armor.geo.json");
			}

			@Override
			public ResourceLocation getTextureResource(CaribouArmorItem animatable) {
				return new ResourceLocation(LivestockTFC.MODID, "textures/armor/caribou_hide_armor.png");
			}

			@Override
			public ResourceLocation getAnimationResource(CaribouArmorItem animatable) {
				return null;
			}
		});
	}
}
