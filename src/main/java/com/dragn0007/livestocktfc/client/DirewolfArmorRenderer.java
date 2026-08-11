package com.dragn0007.livestocktfc.client;

import com.dragn0007.livestocktfc.LivestockTFC;
import com.dragn0007.livestocktfc.items.armor.DirewolfArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;


public final class DirewolfArmorRenderer extends GeoArmorRenderer<DirewolfArmorItem> {
	public DirewolfArmorRenderer() {
		super(new GeoModel<>() {
			@Override
			public ResourceLocation getModelResource(DirewolfArmorItem animatable) {
				return new ResourceLocation(LivestockTFC.MODID, "geo/direwolf_hide_armor.geo.json");
			}

			@Override
			public ResourceLocation getTextureResource(DirewolfArmorItem animatable) {
				return new ResourceLocation(LivestockTFC.MODID, "textures/armor/direwolf_hide_armor.png");
			}

			@Override
			public ResourceLocation getAnimationResource(DirewolfArmorItem animatable) {
				return null;
			}
		});
	}
}
