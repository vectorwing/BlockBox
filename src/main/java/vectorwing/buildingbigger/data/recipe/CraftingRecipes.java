package vectorwing.buildingbigger.data.recipe;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import vectorwing.buildingbigger.BuildingBigger;
import vectorwing.buildingbigger.common.registry.ModBlocks;
import vectorwing.buildingbigger.common.registry.ModItems;

public class CraftingRecipes
{
	public static void register(RecipeOutput output) {
		recipesBlocks(output);
		craftPalisades(output);
		craftIronPlateBlocks(output);
		craftGoldBlocks(output);
	}

	private static void craftPalisades(RecipeOutput output) {
		palisade(output, ModBlocks.OAK_PALISADE.get(), ModBlocks.SPIKED_OAK_PALISADE.get(), Blocks.OAK_LOG);
		palisade(output, ModBlocks.SPRUCE_PALISADE.get(), ModBlocks.SPIKED_SPRUCE_PALISADE.get(), Blocks.SPRUCE_LOG);
		palisade(output, ModBlocks.BIRCH_PALISADE.get(), ModBlocks.SPIKED_BIRCH_PALISADE.get(), Blocks.BIRCH_LOG);
		palisade(output, ModBlocks.JUNGLE_PALISADE.get(), ModBlocks.SPIKED_JUNGLE_PALISADE.get(), Blocks.JUNGLE_LOG);
		palisade(output, ModBlocks.ACACIA_PALISADE.get(), ModBlocks.SPIKED_ACACIA_PALISADE.get(), Blocks.ACACIA_LOG);
		palisade(output, ModBlocks.DARK_OAK_PALISADE.get(), ModBlocks.SPIKED_DARK_OAK_PALISADE.get(), Blocks.DARK_OAK_LOG);
		palisade(output, ModBlocks.MANGROVE_PALISADE.get(), ModBlocks.SPIKED_MANGROVE_PALISADE.get(), Blocks.MANGROVE_LOG);
		palisade(output, ModBlocks.CHERRY_PALISADE.get(), ModBlocks.SPIKED_CHERRY_PALISADE.get(), Blocks.CHERRY_LOG);
		palisade(output, ModBlocks.CRIMSON_PALISADE.get(), ModBlocks.SPIKED_CRIMSON_PALISADE.get(), Blocks.CRIMSON_STEM);
		palisade(output, ModBlocks.WARPED_PALISADE.get(), ModBlocks.SPIKED_WARPED_PALISADE.get(), Blocks.WARPED_STEM);
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

	public static void palisade(RecipeOutput output, ItemLike palisade, ItemLike spikedPalisade, ItemLike log) {
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, palisade, 12)
				.pattern("ooo")
				.pattern("ooo")
				.define('o', log)
				.group("bb_palisades")
				.unlockedBy("has_matching_log", InventoryChangeTrigger.TriggerInstance.hasItems(log))
				.save(output);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, palisade, 1)
				.requires(spikedPalisade)
				.group("bb_palisades")
				.unlockedBy("has_matching_log", InventoryChangeTrigger.TriggerInstance.hasItems(log))
				.save(output, nameWithSuffix(itemName(palisade), "_from_spiked"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, spikedPalisade, 1)
				.requires(palisade)
				.group("bb_spiked_palisades")
				.unlockedBy("has_matching_palisade", InventoryChangeTrigger.TriggerInstance.hasItems(palisade))
				.save(output);
	}

	private static ResourceLocation customName(String name) {
		return ResourceLocation.fromNamespaceAndPath(BuildingBigger.MODID, name);
	}

	private static ResourceLocation nameWithSuffix(String name, String suffix) {
		return ResourceLocation.fromNamespaceAndPath(BuildingBigger.MODID, name + suffix);
	}

	private static String itemName(ItemLike itemLike) {
		return BuiltInRegistries.ITEM.getKey(itemLike.asItem()).getPath();
	}
}
