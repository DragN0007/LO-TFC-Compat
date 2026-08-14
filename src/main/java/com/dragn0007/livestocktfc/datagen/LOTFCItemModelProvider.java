package com.dragn0007.livestocktfc.datagen;

import com.dragn0007.livestocktfc.LivestockTFC;
import com.dragn0007.livestocktfc.items.LOTFCItems;
import com.dragn0007.livestocktfc.util.HideArmorTypes;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class LOTFCItemModelProvider extends ItemModelProvider {
    public LOTFCItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LivestockTFC.MODID, existingFileHelper);
    }

    @Override
    public void registerModels() {
        simpleItem(LOTFCItems.CARIBOU_FUR);
        simpleItem(LOTFCItems.DIREWOLF_FUR);
        simpleItem(LOTFCItems.HORSE_HAIR);

        for (HideArmorTypes type : HideArmorTypes.values()) {
            advancedItem(LOTFCItems.METAL_CARIBOU_HELMETS.get(type), "caribou_hide_helmet");
            advancedItem(LOTFCItems.METAL_CARIBOU_CHESTPLATES.get(type), "caribou_hide_chestplate");
            advancedItem(LOTFCItems.METAL_CARIBOU_LEGGINGS.get(type), "caribou_hide_leggings");
            advancedItem(LOTFCItems.METAL_CARIBOU_BOOTS.get(type), "caribou_hide_boots");
        }
        simpleItem(LOTFCItems.CARIBOU_HIDE_HELMET);
        simpleItem(LOTFCItems.CARIBOU_HIDE_CHESTPLATE);
        simpleItem(LOTFCItems.CARIBOU_HIDE_LEGGINGS);
        simpleItem(LOTFCItems.CARIBOU_HIDE_BOOTS);

        simpleItem(LOTFCItems.DIREWOLF_HIDE_HELMET);
        simpleItem(LOTFCItems.DIREWOLF_HIDE_CHESTPLATE);
        simpleItem(LOTFCItems.DIREWOLF_HIDE_LEGGINGS);
        simpleItem(LOTFCItems.DIREWOLF_HIDE_BOOTS);

        simpleItem(LOTFCItems.HORSE_HIDE_HELMET);
        simpleItem(LOTFCItems.HORSE_HIDE_CHESTPLATE);
        simpleItem(LOTFCItems.HORSE_HIDE_LEGGINGS);
        simpleItem(LOTFCItems.HORSE_HIDE_BOOTS);

        simpleItem(LOTFCItems.SHEEP_HIDE_HELMET);
        simpleItem(LOTFCItems.SHEEP_HIDE_CHESTPLATE);
        simpleItem(LOTFCItems.SHEEP_HIDE_LEGGINGS);
        simpleItem(LOTFCItems.SHEEP_HIDE_BOOTS);
    }

    public ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(LivestockTFC.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder advancedItem(RegistryObject<Item> item, String getTextureName) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(LivestockTFC.MODID,"item/" + getTextureName));
    }
}