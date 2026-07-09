package com.dragn0007.livestocktfc;

import com.dragn0007.livestocktfc.items.CreativeTabModifier;
import com.dragn0007.livestocktfc.items.LOTFCItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib.GeckoLib;


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