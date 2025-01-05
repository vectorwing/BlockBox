package vectorwing.buildingbigger.data.recipe;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import vectorwing.buildingbigger.common.registry.ModBlocks;

public class CraftingRecipes
{
	public static void register(RecipeOutput output) {
		recipesBlocks(output);
	}

	private static void recipesBlocks(RecipeOutput output) {
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.SANDSTONE_BRICKS.get(), 4)
				.pattern("ss")
				.pattern("ss")
				.define('s', Blocks.CUT_SANDSTONE)
				.unlockedBy("has_sandstone", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.SANDSTONE))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.RED_SANDSTONE_BRICKS.get(), 4)
				.pattern("ss")
				.pattern("ss")
				.define('s', Blocks.CUT_RED_SANDSTONE)
				.unlockedBy("has_red_sandstone", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.RED_SANDSTONE))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CLAY_TILES.get(), 4)
				.pattern("ss")
				.pattern("ss")
				.define('s', Blocks.TERRACOTTA)
				.unlockedBy("has_terracotta", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TERRACOTTA))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.PACKED_SNOW.get(), 4)
				.pattern("ss")
				.pattern("ss")
				.define('s', Blocks.SNOW_BLOCK)
				.unlockedBy("has_snow", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.SNOW_BLOCK))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.PACKED_SNOW_BRICKS.get(), 4)
				.pattern("pp")
				.pattern("pp")
				.define('p', ModBlocks.PACKED_SNOW.get())
				.unlockedBy("has_snow", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.SNOW_BLOCK))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_PACKED_ICE.get(), 4)
				.pattern("ss")
				.pattern("ss")
				.define('s', Blocks.PACKED_ICE)
				.unlockedBy("has_packed_ice", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.PACKED_ICE))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.PACKED_ICE_BRICKS.get(), 4)
				.pattern("ss")
				.pattern("ss")
				.define('s', ModBlocks.POLISHED_PACKED_ICE.get())
				.unlockedBy("has_packed_ice", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.PACKED_ICE))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.IRON_PLATE.get(), 4)
				.pattern("iI")
				.pattern("Ii")
				.define('i', Items.IRON_NUGGET)
				.define('I', Items.IRON_INGOT)
				.unlockedBy("has_iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.IRON_TREAD_PLATE.get(), 4)
				.pattern("ii")
				.pattern("ii")
				.define('i', ModBlocks.IRON_PLATE.get())
				.unlockedBy("has_iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_PLATE.get()))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CORRUGATED_IRON_PLATE.get(), 4)
				.pattern("ii")
				.pattern("ii")
				.define('i', ModBlocks.IRON_TREAD_PLATE.get())
				.unlockedBy("has_iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_PLATE.get()))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.IRON_PLATE_PILLAR.get(), 2)
				.pattern("i")
				.pattern("i")
				.define('i', ModBlocks.IRON_PLATE.get())
				.unlockedBy("has_iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_PLATE.get()))
				.save(output);
	}
}
