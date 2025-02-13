package vectorwing.blockbox.data.recipe;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.blockbox.common.registry.ModBlocks;
import vectorwing.blockbox.common.registry.ModItems;
import vectorwing.blockbox.data.provider.Recipes;

public class SmeltingRecipes
{
	public static void register(RecipeOutput output) {
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.TILES.get()), RecipeCategory.BUILDING_BLOCKS, ModItems.BROKEN_TILE_MOSAIC.get(), 0.1F, 200)
				.unlockedBy("has_tiles", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TILES.get()))
				.save(output);
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.ROUGH_GLASS.get()), RecipeCategory.BUILDING_BLOCKS, Items.GLASS, 0.1F, 200)
				.unlockedBy("has_rough_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ROUGH_GLASS.get()))
				.save(output, Recipes.itemName(Items.GLASS) + "_from_smelting_rough_glass");
	}
}
