package com.dragn0007.livestocktfc.patch;

import com.dragn0007.dragnlivestock.util.LivestockOverhaulCommonConfig;
import com.dragn0007.livestocktfc.LivestockTFC;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = LivestockTFC.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModCompatSpawnReplacer {

    //patches the base LO chicken replacement issue

    @SubscribeEvent
    public static void onModdedSpawn(EntityJoinLevelEvent event) {
        // TerraFirmaCraft Chicken -> Vanilla (so it can be converted into an O-Variant)
        if (LivestockOverhaulCommonConfig.REPLACE_CHICKENS.get() &&
                ForgeRegistries.ENTITY_TYPES.getKey(event.getEntity().getType()).equals(new ResourceLocation("tfc", "chicken"))) {
            Entity tfc = event.getEntity();
            if (event.getLevel().isClientSide) {
                return;
            }
            Chicken chicken = EntityType.CHICKEN.create(event.getLevel());
            if (chicken != null) {
                chicken.copyPosition(tfc);
                chicken.setCustomName(tfc.getCustomName());
                if (event.getLevel().isClientSide) {
                    tfc.remove(Entity.RemovalReason.DISCARDED);
                }
                event.getLevel().addFreshEntity(chicken);
                tfc.remove(Entity.RemovalReason.DISCARDED);
                event.setCanceled(true);
            }
        }
    }
}