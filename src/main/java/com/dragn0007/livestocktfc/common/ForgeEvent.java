package com.dragn0007.livestocktfc.common;

import com.dragn0007.livestocktfc.items.LOTFCItems;
import com.dragn0007.livestocktfc.util.LOTFCTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvent {
    @SubscribeEvent
    public static void dropOnDeath(LivingDeathEvent event) {
        //tfc keeps RESISTING my fuckin loot table for direwolves so i had to take extreme measures
        LivingEntity entity = event.getEntity();
        Random random = new Random();
        if (entity.getType().is(LOTFCTags.Entity_Types.DIREWOLF)) {
            entity.spawnAtLocation(new ItemStack(LOTFCItems.DIREWOLF_FUR.get(), random.nextInt(8)), 0F);
        }
    }
}