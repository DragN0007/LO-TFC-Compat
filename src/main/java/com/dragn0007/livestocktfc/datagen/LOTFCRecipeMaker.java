package com.dragn0007.livestocktfc.datagen;

import com.dragn0007.livestocktfc.items.LOTFCItems;
import com.dragn0007.livestocktfc.util.HideArmorTypes;
import net.dries007.tfc.common.items.HideItemType;
import net.dries007.tfc.common.items.TFCItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class LOTFCRecipeMaker extends RecipeProvider implements IConditionBuilder {
    public LOTFCRecipeMaker(PackOutput pOutput) {
        super(pOutput);
    }

    public void buildRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        buildCommonRecipes(pFinishedRecipeConsumer);
    }

    public void buildCommonRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {

        for (HideArmorTypes type : HideArmorTypes.values()) {
            Item unfinishedHelmetItem = BuiltInRegistries.ITEM.get(new ResourceLocation("tfc", "metal/unfinished_helmet/" + type.getName()));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, LOTFCItems.METAL_CARIBOU_HELMETS.get(type).get())
                    .requires(LOTFCItems.CARIBOU_HIDE_HELMET.get())
                    .requires(unfinishedHelmetItem)
                    .unlockedBy("has_caribou_hide_helmet", inventoryTrigger(ItemPredicate.Builder.item()
                            .of(LOTFCItems.CARIBOU_HIDE_HELMET.get()).build()))
                    .save(pFinishedRecipeConsumer);
        }

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LOTFCItems.CARIBOU_HIDE_HELMET.get())
                .define('A', LOTFCItems.CARIBOU_FUR.get())
                .define('B', TFCItems.TREATED_HIDE.get())
                .pattern("AAA")
                .pattern("ABA")
                .unlockedBy("has_treated_hide", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(TFCItems.TREATED_HIDE.get()).build()))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LOTFCItems.CARIBOU_HIDE_CHESTPLATE.get())
                .define('A', LOTFCItems.CARIBOU_FUR.get())
                .define('B', TFCItems.TREATED_HIDE.get())
                .pattern("A A")
                .pattern("ABA")
                .pattern("AAA")
                .unlockedBy("has_treated_hide", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(TFCItems.TREATED_HIDE.get()).build()))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LOTFCItems.CARIBOU_HIDE_LEGGINGS.get())
                .define('A', LOTFCItems.CARIBOU_FUR.get())
                .define('B', TFCItems.TREATED_HIDE.get())
                .pattern("ABA")
                .pattern("A A")
                .pattern("A A")
                .unlockedBy("has_treated_hide", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(TFCItems.TREATED_HIDE.get()).build()))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LOTFCItems.CARIBOU_HIDE_BOOTS.get())
                .define('A', LOTFCItems.CARIBOU_FUR.get())
                .define('B', TFCItems.TREATED_HIDE.get())
                .pattern("A A")
                .pattern("B B")
                .unlockedBy("has_treated_hide", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(TFCItems.TREATED_HIDE.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LOTFCItems.DIREWOLF_HIDE_HELMET.get())
                .define('A', LOTFCItems.DIREWOLF_FUR.get())
                .define('B', TFCItems.TREATED_HIDE.get())
                .pattern("AAA")
                .pattern("ABA")
                .unlockedBy("has_treated_hide", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(TFCItems.TREATED_HIDE.get()).build()))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LOTFCItems.DIREWOLF_HIDE_CHESTPLATE.get())
                .define('A', LOTFCItems.DIREWOLF_FUR.get())
                .define('B', TFCItems.TREATED_HIDE.get())
                .pattern("A A")
                .pattern("ABA")
                .pattern("AAA")
                .unlockedBy("has_treated_hide", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(TFCItems.TREATED_HIDE.get()).build()))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LOTFCItems.DIREWOLF_HIDE_LEGGINGS.get())
                .define('A', LOTFCItems.DIREWOLF_FUR.get())
                .define('B', TFCItems.TREATED_HIDE.get())
                .pattern("ABA")
                .pattern("A A")
                .pattern("A A")
                .unlockedBy("has_treated_hide", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(TFCItems.TREATED_HIDE.get()).build()))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LOTFCItems.DIREWOLF_HIDE_BOOTS.get())
                .define('A', LOTFCItems.DIREWOLF_FUR.get())
                .define('B', TFCItems.TREATED_HIDE.get())
                .pattern("A A")
                .pattern("B B")
                .unlockedBy("has_treated_hide", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(TFCItems.TREATED_HIDE.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LOTFCItems.HORSE_HIDE_HELMET.get())
                .define('A', LOTFCItems.HORSE_HAIR.get())
                .define('B', TFCItems.TREATED_HIDE.get())
                .pattern("AAA")
                .pattern("ABA")
                .unlockedBy("has_treated_hide", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(TFCItems.TREATED_HIDE.get()).build()))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LOTFCItems.HORSE_HIDE_CHESTPLATE.get())
                .define('A', LOTFCItems.HORSE_HAIR.get())
                .define('B', TFCItems.TREATED_HIDE.get())
                .pattern("A A")
                .pattern("ABA")
                .pattern("AAA")
                .unlockedBy("has_treated_hide", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(TFCItems.TREATED_HIDE.get()).build()))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LOTFCItems.HORSE_HIDE_LEGGINGS.get())
                .define('A', LOTFCItems.HORSE_HAIR.get())
                .define('B', TFCItems.TREATED_HIDE.get())
                .pattern("ABA")
                .pattern("A A")
                .pattern("A A")
                .unlockedBy("has_treated_hide", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(TFCItems.TREATED_HIDE.get()).build()))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LOTFCItems.HORSE_HIDE_BOOTS.get())
                .define('A', LOTFCItems.HORSE_HAIR.get())
                .define('B', TFCItems.TREATED_HIDE.get())
                .pattern("A A")
                .pattern("B B")
                .unlockedBy("has_treated_hide", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(TFCItems.TREATED_HIDE.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LOTFCItems.SHEEP_HIDE_HELMET.get())
                .define('A', TFCItems.WOOL.get())
                .define('B', TFCItems.HIDES.get(HideItemType.SHEEPSKIN).get(HideItemType.Size.MEDIUM).get())
                .pattern("AAA")
                .pattern("ABA")
                .unlockedBy("has_treated_hide", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(TFCItems.HIDES.get(HideItemType.SHEEPSKIN).get(HideItemType.Size.MEDIUM).get()).build()))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LOTFCItems.SHEEP_HIDE_CHESTPLATE.get())
                .define('A', TFCItems.WOOL.get())
                .define('B', TFCItems.HIDES.get(HideItemType.SHEEPSKIN).get(HideItemType.Size.MEDIUM).get())
                .pattern("A A")
                .pattern("ABA")
                .pattern("AAA")
                .unlockedBy("has_treated_hide", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(TFCItems.HIDES.get(HideItemType.SHEEPSKIN).get(HideItemType.Size.MEDIUM).get()).build()))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LOTFCItems.SHEEP_HIDE_LEGGINGS.get())
                .define('A', TFCItems.WOOL.get())
                .define('B', TFCItems.HIDES.get(HideItemType.SHEEPSKIN).get(HideItemType.Size.MEDIUM).get())
                .pattern("ABA")
                .pattern("A A")
                .pattern("A A")
                .unlockedBy("has_treated_hide", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(TFCItems.HIDES.get(HideItemType.SHEEPSKIN).get(HideItemType.Size.MEDIUM).get()).build()))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LOTFCItems.SHEEP_HIDE_BOOTS.get())
                .define('A', TFCItems.WOOL.get())
                .define('B', TFCItems.HIDES.get(HideItemType.SHEEPSKIN).get(HideItemType.Size.MEDIUM).get())
                .pattern("A A")
                .pattern("B B")
                .unlockedBy("has_treated_hide", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(TFCItems.HIDES.get(HideItemType.SHEEPSKIN).get(HideItemType.Size.MEDIUM).get()).build()))
                .save(pFinishedRecipeConsumer);
    }

}