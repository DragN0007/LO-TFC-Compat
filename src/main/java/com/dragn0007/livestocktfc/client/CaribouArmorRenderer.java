package com.dragn0007.livestocktfc.client;

import com.dragn0007.livestocktfc.LivestockTFC;
import com.dragn0007.livestocktfc.items.armor.CaribouArmorItem;
import com.dragn0007.livestocktfc.util.HideArmorTypes;
import com.electronwill.nightconfig.core.UnmodifiableConfig;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.model.CoreGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.GeoRenderer;

public final class CaribouArmorRenderer extends GeoArmorRenderer<CaribouArmorItem> {
    public static ItemStack currentRenderingStack = ItemStack.EMPTY;

    @Override
    public void prepForRender(@Nullable Entity entity, ItemStack stack, @Nullable EquipmentSlot slot, @Nullable HumanoidModel<?> baseModel) {
        currentRenderingStack = stack;
        super.prepForRender(entity, stack, slot, baseModel);
    }

	public CaribouArmorRenderer() {
		super(new GeoModel<>() {
            @Override
            public ResourceLocation getModelResource(CaribouArmorItem animatable) {
                return new ResourceLocation(LivestockTFC.MODID, "geo/caribou_hide_armor.geo.json");
            }

            @Override
            public ResourceLocation getTextureResource(CaribouArmorItem animatable) {
                ItemStack renderStack = CaribouArmorRenderer.currentRenderingStack;

                if (!renderStack.isEmpty() && renderStack.getItem() instanceof CaribouArmorItem armorItem) {
                    String itemPath = ForgeRegistries.ITEMS.getKey(armorItem).getPath();
                    String noHelmet = itemPath.replaceAll("_helmet", "");
                    String noChest = noHelmet.replaceAll("_chestplate", "");
                    String noLeggings = noChest.replaceAll("_leggings", "");
                    String finalName = noLeggings.replaceAll("_boots", "");
                    return new ResourceLocation(LivestockTFC.MODID, "textures/armor/" + finalName + "_armor.png");
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
