package com.dragn0007.livestocktfc;

import com.dragn0007.livestocktfc.items.CreativeTabModifier;
import com.dragn0007.livestocktfc.items.LOTFCItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import software.bernie.geckolib.GeckoLib;

import java.util.Map;


@Mod(LivestockTFC.MODID)
public class LivestockTFC
{
    public static final String MODID = "livestocktfc";

    public LivestockTFC() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        LOTFCItems.register(eventBus);
        CreativeTabModifier.register(eventBus);
        GeckoLib.initialize();
        MinecraftForge.EVENT_BUS.register(this);

        System.out.println("[DragN Livestock x TFC Compat] Registered DragN Livestock x TFC Compat.");
    }
}