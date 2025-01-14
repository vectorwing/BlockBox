package vectorwing.buildingbigger.data.recipe;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import vectorwing.buildingbigger.common.registry.ModBlocks;
import vectorwing.buildingbigger.common.registry.ModItems;

public class CraftingRecipes
{
	public static void register(RecipeOutput output) {
		recipesBlocks(output);
		craftTools(output);
		craftPalisades(output);
		craftIronPlateBlocks(output);
		craftGoldBlocks(output);
	}

	private static void craftTools(RecipeOutput output) {
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.MALLET.get())
				.pattern("cIc")
				.pattern(" s ")
				.pattern(" s ")
				.define('c', Tags.Items.INGOTS_COPPER)
				.define('I', Blocks.IRON_BLOCK)
				.define('s', Tags.Items.RODS_WOODEN)
				.unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
				.unlockedBy("has_iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
				.save(output);
	}

	private static void craftPalisades(RecipeOutput output) {
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.OAK_PALISADE.get(), 12)
				.pattern("ooo")
				.pattern("ooo")
				.define('o', Blocks.OAK_LOG)
				.unlockedBy("has_oak", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.OAK_LOG))
				.save(output);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.SPIKED_OAK_PALISADE.get(), 1)
				.requires(ModItems.OAK_PALISADE.get())
				.unlockedBy("has_palisade", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.OAK_PALISADE.get()))
				.save(output);
	}

	private static void craftIronPlateBlocks(RecipeOutput output) {
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
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.IRON_PLATE_DOOR.get(), 3)
				.pattern("ii")
				.pattern("ii")
				.pattern("ii")
				.define('i', ModBlocks.IRON_PLATE.get())
				.unlockedBy("has_iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_PLATE.get()))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.IRON_PLATE_TRAPDOOR.get(), 2)
				.pattern("iii")
				.pattern("iii")
				.define('i', ModBlocks.IRON_PLATE.get())
				.unlockedBy("has_iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_PLATE.get()))
				.save(output);
	}

	private static void craftGoldBlocks(RecipeOutput output) {
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CHISELED_GOLD.get(), 4)
				.pattern("gg")
				.pattern("gg")
				.define('g', Items.GOLD_INGOT)
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.GOLDEN_TILES.get(), 4)
				.pattern("gg")
				.pattern("gg")
				.define('g', ModBlocks.CHISELED_GOLD.get())
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.GOLDEN_BRICKS.get(), 4)
				.pattern("gg")
				.pattern("gg")
				.define('g', ModBlocks.GOLDEN_TILES.get())
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.GOLDEN_PILLAR.get(), 2)
				.pattern("g")
				.pattern("g")
				.define('g', ModBlocks.GOLDEN_TILES.get())
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.GOLDEN_DOOR.get(), 3)
				.pattern("gg")
				.pattern("gg")
				.pattern("gg")
				.define('g', Items.GOLD_INGOT)
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.GOLDEN_TRAPDOOR.get(), 2)
				.pattern("ggg")
				.pattern("ggg")
				.define('g', Items.GOLD_INGOT)
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
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
	}
}
