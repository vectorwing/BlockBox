package vectorwing.blockbox.data.recipe;

import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.blockbox.common.helper.RecipeHelper;
import vectorwing.blockbox.common.registry.ModBlocks;
import vectorwing.blockbox.common.registry.ModItems;

public class SmeltingRecipes
{
	public static void register(RecipeOutput output) {
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.TILES.get()), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, ModItems.BROKEN_TILE_MOSAIC.get(), 0.1F, 200)
				.unlockedBy("has_tiles", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TILES.get()))
				.save(output);
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.ROUGH_GLASS.get()), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, Items.GLASS, 0.1F, 200)
				.unlockedBy("has_rough_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ROUGH_GLASS.get()))
				.save(output, RecipeHelper.itemName(Items.GLASS) + "_from_smelting_rough_glass");
	}
}
