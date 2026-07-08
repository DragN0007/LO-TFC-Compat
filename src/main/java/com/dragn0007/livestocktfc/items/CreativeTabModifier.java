package com.dragn0007.livestocktfc.items;

import com.dragn0007.livestocktfc.LivestockTFC;
import net.dries007.tfc.common.TFCCreativeTabs;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;

@Mod.EventBusSubscriber(modid = LivestockTFC.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreativeTabModifier {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LivestockTFC.MODID);

       @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
           if(event.getTabKey() == TFCCreativeTabs.MISC.tab().getKey()) {
               event.accept(LOTFCItems.CARIBOU_FUR);
               event.accept(LOTFCItems.DIREWOLF_FUR);
               event.accept(LOTFCItems.HORSE_HAIR);

               event.accept(LOTFCItems.CARIBOU_HIDE_HELMET);
               event.accept(LOTFCItems.CARIBOU_HIDE_CHESTPLATE);
               event.accept(LOTFCItems.CARIBOU_HIDE_LEGGINGS);
               event.accept(LOTFCItems.CARIBOU_HIDE_BOOTS);

               event.accept(LOTFCItems.DIREWOLF_HIDE_HELMET);
               event.accept(LOTFCItems.DIREWOLF_HIDE_CHESTPLATE);
               event.accept(LOTFCItems.DIREWOLF_HIDE_LEGGINGS);
               event.accept(LOTFCItems.DIREWOLF_HIDE_BOOTS);

               event.accept(LOTFCItems.HORSE_HIDE_HELMET);
               event.accept(LOTFCItems.HORSE_HIDE_CHESTPLATE);
               event.accept(LOTFCItems.HORSE_HIDE_LEGGINGS);
               event.accept(LOTFCItems.HORSE_HIDE_BOOTS);

               event.accept(LOTFCItems.SHEEP_HIDE_HELMET);
               event.accept(LOTFCItems.SHEEP_HIDE_CHESTPLATE);
               event.accept(LOTFCItems.SHEEP_HIDE_LEGGINGS);
               event.accept(LOTFCItems.SHEEP_HIDE_BOOTS);
           }
       }

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
