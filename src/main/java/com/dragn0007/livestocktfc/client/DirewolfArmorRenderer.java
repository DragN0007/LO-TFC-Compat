package com.dragn0007.livestocktfc.client;

import com.dragn0007.livestocktfc.LivestockTFC;
import com.dragn0007.livestocktfc.items.armor.CaribouArmorItem;
import com.dragn0007.livestocktfc.items.armor.DirewolfArmorItem;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;


public final class DirewolfArmorRenderer extends GeoArmorRenderer<DirewolfArmorItem> {
	public static ItemStack currentRenderingStack = ItemStack.EMPTY;

	@Override
	public void prepForRender(@Nullable Entity entity, ItemStack stack, @Nullable EquipmentSlot slot, @Nullable HumanoidModel<?> baseModel) {
		currentRenderingStack = stack;
		super.prepForRender(entity, stack, slot, baseModel);
	}

	public DirewolfArmorRenderer() {
		super(new GeoModel<>() {
			@Override
			public ResourceLocation getModelResource(DirewolfArmorItem animatable) {
				return new ResourceLocation(LivestockTFC.MODID, "geo/direwolf_hide_armor.geo.json");
			}

			@Override
			public ResourceLocation getTextureResource(DirewolfArmorItem animatable) {
				ItemStack renderStack = DirewolfArmorRenderer.currentRenderingStack;

				if (!renderStack.isEmpty() && renderStack.getItem() instanceof DirewolfArmorItem armorItem) {
					String itemPath = ForgeRegistries.ITEMS.getKey(armorItem).getPath();
					String noHelmet = itemPath.replaceAll("_helmet", "");
					String noChest = noHelmet.replaceAll("_chestplate", "");
					String noLeggings = noChest.replaceAll("_leggings", "");
					String finalName = noLeggings.replaceAll("_boots", "");
					return new ResourceLocation(LivestockTFC.MODID, "textures/armor/" + finalName + "_armor.png");
				} else {
					return new ResourceLocation(LivestockTFC.MODID, "textures/armor/direwolf_hide_armor.png");
				}
			}

			@Override
			public ResourceLocation getAnimationResource(DirewolfArmorItem animatable) {
				return null;
			}
		});
	}
}
