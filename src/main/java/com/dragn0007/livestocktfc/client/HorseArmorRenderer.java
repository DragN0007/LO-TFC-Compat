package com.dragn0007.livestocktfc.client;

import com.dragn0007.livestocktfc.LivestockTFC;
import com.dragn0007.livestocktfc.items.armor.HorseArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;


public final class HorseArmorRenderer extends GeoArmorRenderer<HorseArmorItem> {

	public HorseArmorRenderer() {

		super(new GeoModel<>() {
			@Override
			public ResourceLocation getModelResource(HorseArmorItem animatable) {
				return new ResourceLocation(LivestockTFC.MODID, "geo/horse_hide_armor.geo.json");
			}

			@Override
			public ResourceLocation getTextureResource(HorseArmorItem animatable) {
				return new ResourceLocation(LivestockTFC.MODID, "textures/armor/horse_hide_armor.png");
			}

			@Override
			public ResourceLocation getAnimationResource(HorseArmorItem animatable) {
				return null;
			}
		});
	}
}
