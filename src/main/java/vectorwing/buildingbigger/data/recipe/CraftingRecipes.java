package vectorwing.buildingbigger.data.recipe;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import vectorwing.buildingbigger.common.registry.ModBlocks;

public class CraftingRecipes
{
	public static void register(RecipeOutput output) {
		recipesBlocks(output);
	}

	private static void recipesBlocks(RecipeOutput output) {
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.PACKED_SNOW.get())
				.pattern("ss")
				.pattern("ss")
				.define('s', Blocks.SNOW_BLOCK)
				.unlockedBy("has_snow", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.SNOW_BLOCK))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.PACKED_SNOW_BRICKS.get())
				.pattern("pp")
				.pattern("pp")
				.define('p', ModBlocks.PACKED_SNOW.get())
				.unlockedBy("has_snow", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.SNOW_BLOCK))
				.save(output);
	}
}
