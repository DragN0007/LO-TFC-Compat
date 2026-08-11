package com.dragn0007.livestocktfc.client;

import com.dragn0007.livestocktfc.LivestockTFC;
import com.dragn0007.livestocktfc.items.armor.SheepArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;


public final class SheepArmorRenderer extends GeoArmorRenderer<SheepArmorItem> {
	public SheepArmorRenderer() {
		super(new GeoModel<>() {
			@Override
			public ResourceLocation getModelResource(SheepArmorItem animatable) {
				return new ResourceLocation(LivestockTFC.MODID, "geo/sheep_hide_armor.geo.json");
			}

			@Override
			public ResourceLocation getTextureResource(SheepArmorItem animatable) {
				return new ResourceLocation(LivestockTFC.MODID, "textures/armor/sheep_hide_armor.png");
			}

			@Override
			public ResourceLocation getAnimationResource(SheepArmorItem animatable) {
				return null;
			}
		});
	}
}
