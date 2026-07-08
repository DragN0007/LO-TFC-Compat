package com.dragn0007.livestocktfc.items;

import com.dragn0007.livestocktfc.LivestockTFC;
import com.dragn0007.livestocktfc.items.armor.CaribouArmorItem;
import com.dragn0007.livestocktfc.items.armor.DirewolfArmorItem;
import com.dragn0007.livestocktfc.items.armor.HorseArmorItem;
import com.dragn0007.livestocktfc.items.armor.SheepArmorItem;
import com.dragn0007.livestocktfc.util.LOTFCArmorMaterials;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LOTFCItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LivestockTFC.MODID);

    public static final RegistryObject<Item> CARIBOU_FUR = ITEMS.register("caribou_fur",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIREWOLF_FUR = ITEMS.register("direwolf_fur",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HORSE_HAIR = ITEMS.register("horse_hair",
                () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> CARIBOU_HIDE_HELMET = ITEMS.register("caribou_hide_helmet",
            () -> new CaribouArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> CARIBOU_HIDE_CHESTPLATE = ITEMS.register("caribou_hide_chestplate",
            () -> new CaribouArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> CARIBOU_HIDE_LEGGINGS = ITEMS.register("caribou_hide_leggings",
            () -> new CaribouArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> CARIBOU_HIDE_BOOTS = ITEMS.register("caribou_hide_boots",
            () -> new CaribouArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> DIREWOLF_HIDE_HELMET = ITEMS.register("direwolf_hide_helmet",
            () -> new DirewolfArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> DIREWOLF_HIDE_CHESTPLATE = ITEMS.register("direwolf_hide_chestplate",
            () -> new DirewolfArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> DIREWOLF_HIDE_LEGGINGS = ITEMS.register("direwolf_hide_leggings",
            () -> new DirewolfArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> DIREWOLF_HIDE_BOOTS = ITEMS.register("direwolf_hide_boots",
            () -> new DirewolfArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> HORSE_HIDE_HELMET = ITEMS.register("horse_hide_helmet",
            () -> new HorseArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> HORSE_HIDE_CHESTPLATE = ITEMS.register("horse_hide_chestplate",
            () -> new HorseArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> HORSE_HIDE_LEGGINGS = ITEMS.register("horse_hide_leggings",
            () -> new HorseArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> HORSE_HIDE_BOOTS = ITEMS.register("horse_hide_boots",
            () -> new HorseArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> SHEEP_HIDE_HELMET = ITEMS.register("sheep_hide_helmet",
            () -> new SheepArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SHEEP_HIDE_CHESTPLATE = ITEMS.register("sheep_hide_chestplate",
            () -> new SheepArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SHEEP_HIDE_LEGGINGS = ITEMS.register("sheep_hide_leggings",
            () -> new SheepArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SHEEP_HIDE_BOOTS = ITEMS.register("sheep_hide_boots",
            () -> new SheepArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}