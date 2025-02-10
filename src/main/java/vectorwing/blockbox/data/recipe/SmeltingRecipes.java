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
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.CLAY_TILES.get()), RecipeCategory.BUILDING_BLOCKS, ModItems.JAGGED_CLAY_TILES.get(), 0.1F, 200)
				.unlockedBy("has_clay_tiles", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CLAY_TILES.get()))
				.save(output);
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.ROUGH_GLASS.get()), RecipeCategory.BUILDING_BLOCKS, Items.GLASS, 0.1F, 200)
				.unlockedBy("has_clay_tiles", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CLAY_TILES.get()))
				.save(output, Recipes.itemName(Items.GLASS) + "_from_smelting_rough_glass");
	}
}
