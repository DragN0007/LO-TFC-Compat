package com.dragn0007.livestocktfc.items;

import com.dragn0007.livestocktfc.LivestockTFC;
import com.dragn0007.livestocktfc.items.armor.CaribouArmorItem;
import com.dragn0007.livestocktfc.items.armor.DirewolfArmorItem;
import com.dragn0007.livestocktfc.items.armor.HorseArmorItem;
import com.dragn0007.livestocktfc.items.armor.SheepArmorItem;
import com.dragn0007.livestocktfc.util.HideArmorTypes;
import com.dragn0007.livestocktfc.util.LOTFCArmorMaterials;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.EnumMap;
import java.util.Map;

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
    public static final Map<HideArmorTypes, RegistryObject<Item>> METAL_CARIBOU_HELMETS = new EnumMap<>(HideArmorTypes.class);
    static {
        for (HideArmorTypes type : HideArmorTypes.values()) {
            String name =  "caribou_hide_" + type.getName() + "_helmet";
            RegistryObject<Item> item = ITEMS.register(name,
                    () -> new CaribouArmorItem(type.type, ArmorItem.Type.HELMET, new Item.Properties()));
            METAL_CARIBOU_HELMETS.put(type, item);
        }
    }
    public static final Map<HideArmorTypes, RegistryObject<Item>> METAL_CARIBOU_CHESTPLATES = new EnumMap<>(HideArmorTypes.class);
    static {
        for (HideArmorTypes type : HideArmorTypes.values()) {
            String name =  "caribou_hide_" + type.getName() + "_chestplate";
            RegistryObject<Item> item = ITEMS.register(name,
                    () -> new CaribouArmorItem(type.type, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
            METAL_CARIBOU_CHESTPLATES.put(type, item);
        }
    }
    public static final Map<HideArmorTypes, RegistryObject<Item>> METAL_CARIBOU_LEGGINGS = new EnumMap<>(HideArmorTypes.class);
    static {
        for (HideArmorTypes type : HideArmorTypes.values()) {
            String name =  "caribou_hide_" + type.getName() + "_leggings";
            RegistryObject<Item> item = ITEMS.register(name,
                    () -> new CaribouArmorItem(type.type, ArmorItem.Type.LEGGINGS, new Item.Properties()));
            METAL_CARIBOU_LEGGINGS.put(type, item);
        }
    }
    public static final Map<HideArmorTypes, RegistryObject<Item>> METAL_CARIBOU_BOOTS = new EnumMap<>(HideArmorTypes.class);
    static {
        for (HideArmorTypes type : HideArmorTypes.values()) {
            String name =  "caribou_hide_" + type.getName() + "_boots";
            RegistryObject<Item> item = ITEMS.register(name,
                    () -> new CaribouArmorItem(type.type, ArmorItem.Type.BOOTS, new Item.Properties()));
            METAL_CARIBOU_BOOTS.put(type, item);
        }
    }

    public static final RegistryObject<Item> DIREWOLF_HIDE_HELMET = ITEMS.register("direwolf_hide_helmet",
            () -> new DirewolfArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> DIREWOLF_HIDE_CHESTPLATE = ITEMS.register("direwolf_hide_chestplate",
            () -> new DirewolfArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> DIREWOLF_HIDE_LEGGINGS = ITEMS.register("direwolf_hide_leggings",
            () -> new DirewolfArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> DIREWOLF_HIDE_BOOTS = ITEMS.register("direwolf_hide_boots",
            () -> new DirewolfArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final Map<HideArmorTypes, RegistryObject<Item>> METAL_DIREWOLF_HELMETS = new EnumMap<>(HideArmorTypes.class);
    static {
        for (HideArmorTypes type : HideArmorTypes.values()) {
            String name =  "direwolf_hide_" + type.getName() + "_helmet";
            RegistryObject<Item> item = ITEMS.register(name,
                    () -> new DirewolfArmorItem(type.type, ArmorItem.Type.HELMET, new Item.Properties()));
            METAL_DIREWOLF_HELMETS.put(type, item);
        }
    }
    public static final Map<HideArmorTypes, RegistryObject<Item>> METAL_DIREWOLF_CHESTPLATES = new EnumMap<>(HideArmorTypes.class);
    static {
        for (HideArmorTypes type : HideArmorTypes.values()) {
            String name =  "direwolf_hide_" + type.getName() + "_chestplate";
            RegistryObject<Item> item = ITEMS.register(name,
                    () -> new DirewolfArmorItem(type.type, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
            METAL_DIREWOLF_CHESTPLATES.put(type, item);
        }
    }
    public static final Map<HideArmorTypes, RegistryObject<Item>> METAL_DIREWOLF_LEGGINGS = new EnumMap<>(HideArmorTypes.class);
    static {
        for (HideArmorTypes type : HideArmorTypes.values()) {
            String name =  "direwolf_hide_" + type.getName() + "_leggings";
            RegistryObject<Item> item = ITEMS.register(name,
                    () -> new DirewolfArmorItem(type.type, ArmorItem.Type.LEGGINGS, new Item.Properties()));
            METAL_DIREWOLF_LEGGINGS.put(type, item);
        }
    }
    public static final Map<HideArmorTypes, RegistryObject<Item>> METAL_DIREWOLF_BOOTS = new EnumMap<>(HideArmorTypes.class);
    static {
        for (HideArmorTypes type : HideArmorTypes.values()) {
            String name =  "direwolf_hide_" + type.getName() + "_boots";
            RegistryObject<Item> item = ITEMS.register(name,
                    () -> new DirewolfArmorItem(type.type, ArmorItem.Type.BOOTS, new Item.Properties()));
            METAL_DIREWOLF_BOOTS.put(type, item);
        }
    }

    public static final RegistryObject<Item> HORSE_HIDE_HELMET = ITEMS.register("horse_hide_helmet",
            () -> new HorseArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> HORSE_HIDE_CHESTPLATE = ITEMS.register("horse_hide_chestplate",
            () -> new HorseArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> HORSE_HIDE_LEGGINGS = ITEMS.register("horse_hide_leggings",
            () -> new HorseArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> HORSE_HIDE_BOOTS = ITEMS.register("horse_hide_boots",
            () -> new HorseArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final Map<HideArmorTypes, RegistryObject<Item>> METAL_HORSE_HELMETS = new EnumMap<>(HideArmorTypes.class);
    static {
        for (HideArmorTypes type : HideArmorTypes.values()) {
            String name =  "horse_hide_" + type.getName() + "_helmet";
            RegistryObject<Item> item = ITEMS.register(name,
                    () -> new HorseArmorItem(type.type, ArmorItem.Type.HELMET, new Item.Properties()));
            METAL_HORSE_HELMETS.put(type, item);
        }
    }
    public static final Map<HideArmorTypes, RegistryObject<Item>> METAL_HORSE_CHESTPLATES = new EnumMap<>(HideArmorTypes.class);
    static {
        for (HideArmorTypes type : HideArmorTypes.values()) {
            String name =  "horse_hide_" + type.getName() + "_chestplate";
            RegistryObject<Item> item = ITEMS.register(name,
                    () -> new HorseArmorItem(type.type, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
            METAL_HORSE_CHESTPLATES.put(type, item);
        }
    }
    public static final Map<HideArmorTypes, RegistryObject<Item>> METAL_HORSE_LEGGINGS = new EnumMap<>(HideArmorTypes.class);
    static {
        for (HideArmorTypes type : HideArmorTypes.values()) {
            String name =  "horse_hide_" + type.getName() + "_leggings";
            RegistryObject<Item> item = ITEMS.register(name,
                    () -> new HorseArmorItem(type.type, ArmorItem.Type.LEGGINGS, new Item.Properties()));
            METAL_HORSE_LEGGINGS.put(type, item);
        }
    }
    public static final Map<HideArmorTypes, RegistryObject<Item>> METAL_HORSE_BOOTS = new EnumMap<>(HideArmorTypes.class);
    static {
        for (HideArmorTypes type : HideArmorTypes.values()) {
            String name =  "horse_hide_" + type.getName() + "_boots";
            RegistryObject<Item> item = ITEMS.register(name,
                    () -> new HorseArmorItem(type.type, ArmorItem.Type.BOOTS, new Item.Properties()));
            METAL_HORSE_BOOTS.put(type, item);
        }
    }


    public static final RegistryObject<Item> SHEEP_HIDE_HELMET = ITEMS.register("sheep_hide_helmet",
            () -> new SheepArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SHEEP_HIDE_CHESTPLATE = ITEMS.register("sheep_hide_chestplate",
            () -> new SheepArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SHEEP_HIDE_LEGGINGS = ITEMS.register("sheep_hide_leggings",
            () -> new SheepArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SHEEP_HIDE_BOOTS = ITEMS.register("sheep_hide_boots",
            () -> new SheepArmorItem(LOTFCArmorMaterials.HIDE, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final Map<HideArmorTypes, RegistryObject<Item>> METAL_SHEEP_HELMETS = new EnumMap<>(HideArmorTypes.class);
    static {
        for (HideArmorTypes type : HideArmorTypes.values()) {
            String name =  "sheep_hide_" + type.getName() + "_helmet";
            RegistryObject<Item> item = ITEMS.register(name,
                    () -> new SheepArmorItem(type.type, ArmorItem.Type.HELMET, new Item.Properties()));
            METAL_SHEEP_HELMETS.put(type, item);
        }
    }
    public static final Map<HideArmorTypes, RegistryObject<Item>> METAL_SHEEP_CHESTPLATES = new EnumMap<>(HideArmorTypes.class);
    static {
        for (HideArmorTypes type : HideArmorTypes.values()) {
            String name =  "sheep_hide_" + type.getName() + "_chestplate";
            RegistryObject<Item> item = ITEMS.register(name,
                    () -> new SheepArmorItem(type.type, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
            METAL_SHEEP_CHESTPLATES.put(type, item);
        }
    }
    public static final Map<HideArmorTypes, RegistryObject<Item>> METAL_SHEEP_LEGGINGS = new EnumMap<>(HideArmorTypes.class);
    static {
        for (HideArmorTypes type : HideArmorTypes.values()) {
            String name =  "sheep_hide_" + type.getName() + "_leggings";
            RegistryObject<Item> item = ITEMS.register(name,
                    () -> new SheepArmorItem(type.type, ArmorItem.Type.LEGGINGS, new Item.Properties()));
            METAL_SHEEP_LEGGINGS.put(type, item);
        }
    }
    public static final Map<HideArmorTypes, RegistryObject<Item>> METAL_SHEEP_BOOTS = new EnumMap<>(HideArmorTypes.class);
    static {
        for (HideArmorTypes type : HideArmorTypes.values()) {
            String name =  "sheep_hide_" + type.getName() + "_boots";
            RegistryObject<Item> item = ITEMS.register(name,
                    () -> new SheepArmorItem(type.type, ArmorItem.Type.BOOTS, new Item.Properties()));
            METAL_SHEEP_BOOTS.put(type, item);
        }
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}