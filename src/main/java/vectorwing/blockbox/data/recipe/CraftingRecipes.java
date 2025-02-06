package vectorwing.blockbox.data.recipe;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.common.registry.ModBlocks;
import vectorwing.blockbox.common.registry.ModItems;
import vectorwing.blockbox.common.tag.ModTags;

public class CraftingRecipes
{
	public static void register(RecipeOutput output) {
		// TODO: Move this to its own class.
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.CLAY_TILES.get()), RecipeCategory.BUILDING_BLOCKS, ModItems.JAGGED_CLAY_TILES.get(), 0.1F, 200)
				.unlockedBy("has_clay_tiles", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CLAY_TILES.get()))
				.save(output);

		craftBasicBlocks(output);
		craftTools(output);
		craftPalisades(output);
		craftIronPlateBlocks(output);
		craftGoldBlocks(output);
		craftCopperBlocks(output);
		craftFurniture(output);
		craftSkyLanterns(output);
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

	private static void craftSkyLanterns(RecipeOutput output) {
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_SKY_LANTERN.get())
				.pattern("ppp")
				.pattern("p p")
				.pattern("/c/")
				.define('p', Items.PAPER)
				.define('/', Items.STRING)
				.define('c', ItemTags.CANDLES)
				.unlockedBy("has_candle", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CANDLE))
				.save(output);
		dyeItem(output, ModItems.WHITE_SKY_LANTERN.get(), Items.WHITE_DYE, ModTags.SKY_LANTERNS, Tags.Items.DYES_WHITE);
		dyeItem(output, ModItems.LIGHT_GRAY_SKY_LANTERN.get(), Items.LIGHT_GRAY_DYE, ModTags.SKY_LANTERNS, Tags.Items.DYES_LIGHT_GRAY);
		dyeItem(output, ModItems.GRAY_SKY_LANTERN.get(), Items.GRAY_DYE, ModTags.SKY_LANTERNS, Tags.Items.DYES_GRAY);
		dyeItem(output, ModItems.BLACK_SKY_LANTERN.get(), Items.BLACK_DYE, ModTags.SKY_LANTERNS, Tags.Items.DYES_BLACK);
		dyeItem(output, ModItems.BROWN_SKY_LANTERN.get(), Items.BROWN_DYE, ModTags.SKY_LANTERNS, Tags.Items.DYES_BROWN);
		dyeItem(output, ModItems.RED_SKY_LANTERN.get(), Items.RED_DYE, ModTags.SKY_LANTERNS, Tags.Items.DYES_RED);
		dyeItem(output, ModItems.ORANGE_SKY_LANTERN.get(), Items.ORANGE_DYE, ModTags.SKY_LANTERNS, Tags.Items.DYES_ORANGE);
		dyeItem(output, ModItems.YELLOW_SKY_LANTERN.get(), Items.YELLOW_DYE, ModTags.SKY_LANTERNS, Tags.Items.DYES_YELLOW);
		dyeItem(output, ModItems.LIME_SKY_LANTERN.get(), Items.LIME_DYE, ModTags.SKY_LANTERNS, Tags.Items.DYES_LIME);
		dyeItem(output, ModItems.GREEN_SKY_LANTERN.get(), Items.GREEN_DYE, ModTags.SKY_LANTERNS, Tags.Items.DYES_GREEN);
		dyeItem(output, ModItems.CYAN_SKY_LANTERN.get(), Items.CYAN_DYE, ModTags.SKY_LANTERNS, Tags.Items.DYES_CYAN);
		dyeItem(output, ModItems.LIGHT_BLUE_SKY_LANTERN.get(), Items.LIGHT_BLUE_DYE, ModTags.SKY_LANTERNS, Tags.Items.DYES_LIGHT_BLUE);
		dyeItem(output, ModItems.BLUE_SKY_LANTERN.get(), Items.BLUE_DYE, ModTags.SKY_LANTERNS, Tags.Items.DYES_BLUE);
		dyeItem(output, ModItems.PURPLE_SKY_LANTERN.get(), Items.PURPLE_DYE, ModTags.SKY_LANTERNS, Tags.Items.DYES_PURPLE);
		dyeItem(output, ModItems.MAGENTA_SKY_LANTERN.get(), Items.MAGENTA_DYE, ModTags.SKY_LANTERNS, Tags.Items.DYES_MAGENTA);
		dyeItem(output, ModItems.PINK_SKY_LANTERN.get(), Items.PINK_DYE, ModTags.SKY_LANTERNS, Tags.Items.DYES_PINK);
	}

	private static void craftFurniture(RecipeOutput output) {
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.BRAZIER.get())
				.pattern("c c")
				.pattern("iNi")
				.pattern(" i ")
				.define('c', Items.CHAIN)
				.define('N', Items.NETHERRACK)
				.define('i', Tags.Items.INGOTS_IRON)
				.unlockedBy("has_netherrack", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERRACK))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.SOUL_BRAZIER.get())
				.pattern("c c")
				.pattern("iSi")
				.pattern(" i ")
				.define('c', Items.CHAIN)
				.define('S', ItemTags.SOUL_FIRE_BASE_BLOCKS)
				.define('i', Tags.Items.INGOTS_IRON)
				.unlockedBy("has_soul_sand", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SOUL_SAND, Items.SOUL_SOIL))
				.save(output);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.BRAZIER.get())
				.requires(ModItems.SOUL_BRAZIER.get())
				.requires(Items.NETHERRACK)
				.unlockedBy("has_netherrack", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERRACK))
				.save(output, nameWithSuffix(itemName(ModItems.BRAZIER.get()), "from_swap"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.SOUL_BRAZIER.get())
				.requires(ModItems.BRAZIER.get())
				.requires(ItemTags.SOUL_FIRE_BASE_BLOCKS)
				.unlockedBy("has_soul_sand", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SOUL_SAND, Items.SOUL_SOIL))
				.save(output, nameWithSuffix(itemName(ModItems.SOUL_BRAZIER.get()), "from_swap"));
		chair(output, ModBlocks.OAK_SEAT.get(), Blocks.OAK_PLANKS);
		chair(output, ModBlocks.SPRUCE_SEAT.get(), Blocks.SPRUCE_PLANKS);
		chair(output, ModBlocks.BIRCH_SEAT.get(), Blocks.BIRCH_PLANKS);
		chair(output, ModBlocks.JUNGLE_SEAT.get(), Blocks.JUNGLE_PLANKS);
		chair(output, ModBlocks.ACACIA_SEAT.get(), Blocks.ACACIA_PLANKS);
		chair(output, ModBlocks.DARK_OAK_SEAT.get(), Blocks.DARK_OAK_PLANKS);
		chair(output, ModBlocks.MANGROVE_SEAT.get(), Blocks.MANGROVE_PLANKS);
		chair(output, ModBlocks.CHERRY_SEAT.get(), Blocks.CHERRY_PLANKS);
		chair(output, ModBlocks.CRIMSON_SEAT.get(), Blocks.CRIMSON_PLANKS);
		chair(output, ModBlocks.WARPED_SEAT.get(), Blocks.WARPED_PLANKS);
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
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_PLATE.get(), 4)
				.pattern("iI")
				.pattern("Ii")
				.define('i', Items.IRON_NUGGET)
				.define('I', Items.IRON_INGOT)
				.unlockedBy("has_iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_TREAD_PLATE.get(), 4)
				.pattern("ii")
				.pattern("ii")
				.define('i', ModBlocks.IRON_PLATE.get())
				.unlockedBy("has_iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_PLATE.get()))
				.save(output);
		stairAndSlab(output, ModBlocks.IRON_TREAD_PLATE_STAIRS.get(), ModBlocks.IRON_TREAD_PLATE_SLAB.get(), ModBlocks.IRON_TREAD_PLATE.get());

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORRUGATED_IRON_PLATE.get(), 4)
				.pattern("ii")
				.pattern("ii")
				.define('i', ModBlocks.IRON_TREAD_PLATE.get())
				.unlockedBy("has_iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_PLATE.get()))
				.save(output);
		stairAndSlab(output, ModBlocks.CORRUGATED_IRON_PLATE_STAIRS.get(), ModBlocks.CORRUGATED_IRON_PLATE_SLAB.get(), ModBlocks.CORRUGATED_IRON_PLATE.get());

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_PLATE_PILLAR.get(), 2)
				.pattern("i")
				.pattern("i")
				.define('i', ModBlocks.IRON_PLATE.get())
				.unlockedBy("has_iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_PLATE.get()))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_PLATE_DOOR.get(), 3)
				.pattern("ii")
				.pattern("ii")
				.pattern("ii")
				.define('i', ModBlocks.IRON_PLATE.get())
				.unlockedBy("has_iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_PLATE.get()))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_PLATE_TRAPDOOR.get(), 2)
				.pattern("iii")
				.pattern("iii")
				.define('i', ModBlocks.IRON_PLATE.get())
				.unlockedBy("has_iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_PLATE.get()))
				.save(output);
	}

	private static void craftGoldBlocks(RecipeOutput output) {
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_GOLD.get(), 4)
				.pattern(" g ")
				.pattern("g g")
				.pattern(" g ")
				.define('g', Items.GOLD_INGOT)
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLDEN_TILES.get(), 4)
				.pattern("gg")
				.pattern("gg")
				.define('g', ModBlocks.CHISELED_GOLD.get())
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLDEN_BRICKS.get(), 4)
				.pattern("gg")
				.pattern("gg")
				.define('g', ModBlocks.GOLDEN_TILES.get())
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
		stairAndSlab(output, ModBlocks.GOLDEN_BRICK_STAIRS.get(), ModBlocks.GOLDEN_BRICK_SLAB.get(), ModBlocks.GOLDEN_BRICKS.get());
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLDEN_PILLAR.get(), 2)
				.pattern("g")
				.pattern("g")
				.define('g', ModBlocks.CHISELED_GOLD.get())
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLDEN_DOOR.get(), 3)
				.pattern("gg")
				.pattern("gg")
				.pattern("gg")
				.define('g', Items.GOLD_INGOT)
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLDEN_TRAPDOOR.get(), 2)
				.pattern("gg")
				.pattern("gg")
				.define('g', Items.GOLD_INGOT)
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLDEN_BARS.get(), 16)
				.pattern("ggg")
				.pattern("ggg")
				.define('g', Items.GOLD_INGOT)
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
	}

	private static void craftCopperBlocks(RecipeOutput output) {
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COPPER_BARS.get(), 4)
				.pattern(" # ")
				.pattern("# #")
				.pattern(" # ")
				.define('#', Tags.Items.INGOTS_COPPER)
				.unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
				.save(output);
		waxing(output, ModBlocks.WAXED_COPPER_BARS.get(), ModBlocks.COPPER_BARS.get());
		waxing(output, ModBlocks.WAXED_EXPOSED_COPPER_BARS.get(), ModBlocks.EXPOSED_COPPER_BARS.get());
		waxing(output, ModBlocks.WAXED_WEATHERED_COPPER_BARS.get(), ModBlocks.WEATHERED_COPPER_BARS.get());
		waxing(output, ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get(), ModBlocks.OXIDIZED_COPPER_BARS.get());
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COPPER_PILLAR.get(), 2)
				.pattern("#")
				.pattern("#")
				.define('#', Blocks.CUT_COPPER)
				.unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.COPPER_BLOCK))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EXPOSED_COPPER_PILLAR.get(), 2)
				.pattern("#")
				.pattern("#")
				.define('#', Blocks.EXPOSED_CUT_COPPER)
				.unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.EXPOSED_COPPER))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WEATHERED_COPPER_PILLAR.get(), 2)
				.pattern("#")
				.pattern("#")
				.define('#', Blocks.WEATHERED_CUT_COPPER)
				.unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.WEATHERED_COPPER))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OXIDIZED_COPPER_PILLAR.get(), 2)
				.pattern("#")
				.pattern("#")
				.define('#', Blocks.OXIDIZED_CUT_COPPER)
				.unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.OXIDIZED_COPPER))
				.save(output);

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_COPPER_PILLAR.get(), 2)
				.pattern("#")
				.pattern("#")
				.define('#', Blocks.WAXED_CUT_COPPER)
				.unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.COPPER_BLOCK))
				.group("waxed_copper_pillar")
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_EXPOSED_COPPER_PILLAR.get(), 2)
				.pattern("#")
				.pattern("#")
				.define('#', Blocks.WAXED_EXPOSED_CUT_COPPER)
				.unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.EXPOSED_COPPER))
				.group("waxed_exposed_copper_pillar")
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_WEATHERED_COPPER_PILLAR.get(), 2)
				.pattern("#")
				.pattern("#")
				.define('#', Blocks.WAXED_WEATHERED_CUT_COPPER)
				.unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.WEATHERED_COPPER))
				.group("waxed_weathered_copper_pillar")
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get(), 2)
				.pattern("#")
				.pattern("#")
				.define('#', Blocks.WAXED_OXIDIZED_CUT_COPPER)
				.unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.OXIDIZED_COPPER))
				.group("waxed_oxidized_copper_pillar")
				.save(output);
		waxing(output, ModBlocks.WAXED_COPPER_PILLAR.get(), ModBlocks.COPPER_PILLAR.get(), "waxed_copper_pillar");
		waxing(output, ModBlocks.WAXED_EXPOSED_COPPER_PILLAR.get(), ModBlocks.EXPOSED_COPPER_PILLAR.get(), "waxed_exposed_copper_pillar");
		waxing(output, ModBlocks.WAXED_WEATHERED_COPPER_PILLAR.get(), ModBlocks.WEATHERED_COPPER_PILLAR.get(), "waxed_weathered_copper_pillar");
		waxing(output, ModBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get(), ModBlocks.OXIDIZED_COPPER_PILLAR.get(), "waxed_oxidized_copper_pillar");
	}

	private static void craftBasicBlocks(RecipeOutput output) {
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICKS.get(), 4)
				.pattern("ss")
				.pattern("ss")
				.define('s', Blocks.CUT_SANDSTONE)
				.unlockedBy("has_sandstone", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.SANDSTONE))
				.save(output);
		stairAndSlab(output, ModBlocks.SANDSTONE_BRICK_STAIRS.get(), ModBlocks.SANDSTONE_BRICK_SLAB.get(), ModBlocks.SANDSTONE_BRICKS.get());

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_SANDSTONE_BRICKS.get(), 4)
				.pattern("ss")
				.pattern("ss")
				.define('s', Blocks.CUT_RED_SANDSTONE)
				.unlockedBy("has_red_sandstone", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.RED_SANDSTONE))
				.save(output);
		stairAndSlab(output, ModBlocks.RED_SANDSTONE_BRICK_STAIRS.get(), ModBlocks.RED_SANDSTONE_BRICK_SLAB.get(), ModBlocks.RED_SANDSTONE_BRICKS.get());

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CLAY_TILES.get(), 4)
				.pattern("ss")
				.pattern("ss")
				.define('s', Blocks.TERRACOTTA)
				.unlockedBy("has_terracotta", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TERRACOTTA))
				.save(output);
		stairAndSlab(output, ModBlocks.CLAY_TILE_STAIRS.get(), ModBlocks.CLAY_TILE_SLAB.get(), ModBlocks.CLAY_TILES.get());

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_SNOW.get(), 4)
				.pattern("ss")
				.pattern("ss")
				.define('s', Blocks.SNOW_BLOCK)
				.unlockedBy("has_snow", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.SNOW_BLOCK))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_SNOW_BRICKS.get(), 4)
				.pattern("pp")
				.pattern("pp")
				.define('p', ModBlocks.PACKED_SNOW.get())
				.unlockedBy("has_snow", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.SNOW_BLOCK))
				.save(output);
		stairAndSlab(output, ModBlocks.PACKED_SNOW_BRICK_STAIRS.get(), ModBlocks.PACKED_SNOW_BRICK_SLAB.get(), ModBlocks.PACKED_SNOW_BRICKS.get());

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_SNOW_BRICK_WALL.get(), 6)
				.pattern("ppp")
				.pattern("ppp")
				.define('p', ModBlocks.PACKED_SNOW_BRICKS.get())
				.unlockedBy("has_snow_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.PACKED_SNOW_BRICKS.get()))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_PACKED_ICE.get(), 4)
				.pattern("ss")
				.pattern("ss")
				.define('s', Blocks.PACKED_ICE)
				.unlockedBy("has_packed_ice", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.PACKED_ICE))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_BRICKS.get(), 4)
				.pattern("ss")
				.pattern("ss")
				.define('s', ModBlocks.POLISHED_PACKED_ICE.get())
				.unlockedBy("has_packed_ice", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.PACKED_ICE))
				.save(output);
		stairAndSlab(output, ModBlocks.PACKED_ICE_BRICKS_STAIRS.get(), ModBlocks.PACKED_ICE_BRICKS_SLAB.get(), ModBlocks.PACKED_ICE_BRICKS.get());

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OBSIDIAN.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', Blocks.OBSIDIAN)
				.unlockedBy("has_obsidian", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.OBSIDIAN))
				.save(output);

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_AMETHYST.get(), 4)
				.pattern("ss")
				.pattern("ss")
				.define('s', Blocks.AMETHYST_BLOCK)
				.unlockedBy("has_amethyst_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.AMETHYST_BLOCK))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_AMETHYST.get(), 4)
				.pattern("ss")
				.pattern("ss")
				.define('s', ModBlocks.POLISHED_AMETHYST.get())
				.unlockedBy("has_amethyst_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.AMETHYST_BLOCK))
				.save(output);
		stairAndSlab(output, ModBlocks.CUT_AMETHYST_STAIRS.get(), ModBlocks.CUT_AMETHYST_SLAB.get(), ModBlocks.CUT_AMETHYST.get());

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_AMETHYST.get(), 4)
				.pattern("ss")
				.pattern("ss")
				.define('s', ModBlocks.CUT_AMETHYST.get())
				.unlockedBy("has_amethyst_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.AMETHYST_BLOCK))
				.save(output);
		stairAndSlab(output, ModBlocks.CHISELED_AMETHYST_STAIRS.get(), ModBlocks.CHISELED_AMETHYST_SLAB.get(), ModBlocks.CHISELED_AMETHYST.get());

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAPIS_LAZULI_BRICKS.get(), 4)
				.pattern("ss")
				.pattern("ss")
				.define('s', Items.LAPIS_LAZULI)
				.unlockedBy("has_lapis_lazuli", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LAPIS_LAZULI))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAPIS_LAZULI_MOSAIC.get(), 4)
				.pattern("ss")
				.pattern("ss")
				.define('s', ModBlocks.LAPIS_LAZULI_BRICKS.get())
				.unlockedBy("has_lapis_lazuli", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LAPIS_LAZULI))
				.save(output);
	}

	// HELPER METHODS

	public static void waxing(RecipeOutput output, ItemLike waxedBlock, ItemLike block) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, waxedBlock)
				.requires(block)
				.requires(Items.HONEYCOMB)
				.unlockedBy("has_copper_block", InventoryChangeTrigger.TriggerInstance.hasItems(block))
				.save(output, nameWithSuffix(itemName(waxedBlock), "from_honeycomb"));
	}

	public static void waxing(RecipeOutput output, ItemLike waxedBlock, ItemLike block, String group) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, waxedBlock)
				.requires(block)
				.requires(Items.HONEYCOMB)
				.unlockedBy("has_copper_block", InventoryChangeTrigger.TriggerInstance.hasItems(block))
				.group(group)
				.save(output, nameWithSuffix(itemName(waxedBlock), "from_honeycomb"));
	}

	public static void stairAndSlab(RecipeOutput output, ItemLike stair, ItemLike slab, ItemLike block) {
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stair, 4)
				.pattern("#  ")
				.pattern("## ")
				.pattern("###")
				.define('#', block)
				.unlockedBy("has_matching_block", InventoryChangeTrigger.TriggerInstance.hasItems(block))
				.save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, slab, 6)
				.pattern("###")
				.define('#', block)
				.unlockedBy("has_matching_block", InventoryChangeTrigger.TriggerInstance.hasItems(block))
				.save(output);
	}

	public static void palisade(RecipeOutput output, ItemLike palisade, ItemLike spikedPalisade, ItemLike log) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, palisade, 12)
				.pattern("ooo")
				.pattern("ooo")
				.define('o', log)
				.group("bb_palisades")
				.unlockedBy("has_matching_log", InventoryChangeTrigger.TriggerInstance.hasItems(log))
				.save(output);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, palisade, 1)
				.requires(spikedPalisade)
				.group("bb_palisades")
				.unlockedBy("has_matching_log", InventoryChangeTrigger.TriggerInstance.hasItems(log))
				.save(output, nameWithSuffix(itemName(palisade), "from_spiked"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, spikedPalisade, 1)
				.requires(palisade)
				.group("bb_spiked_palisades")
				.unlockedBy("has_matching_palisade", InventoryChangeTrigger.TriggerInstance.hasItems(palisade))
				.save(output);
	}

	public static void chair(RecipeOutput output, ItemLike chair, ItemLike plank) {
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, chair)
				.pattern("###")
				.pattern("/ /")
				.define('#', plank)
				.define('/', Items.STICK)
				.group("bb_chairs")
				.unlockedBy("has_matching_plank", InventoryChangeTrigger.TriggerInstance.hasItems(plank))
				.save(output);
	}

	private static void dyeItem(RecipeOutput output, ItemLike result, ItemLike mainDye, TagKey<Item> itemTag, TagKey<Item> dyeTag) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, result)
				.requires(dyeTag)
				.requires(itemTag)
				.unlockedBy("has_needed_dye", InventoryChangeTrigger.TriggerInstance.hasItems(mainDye))
				.save(output, nameDye(result));
	}

	private static ResourceLocation nameDye(ItemLike item) {
		return ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "dye_" + itemName(item));
	}

	private static ResourceLocation customName(String name) {
		return ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, name);
	}

	private static ResourceLocation nameWithSuffix(String name, String suffix) {
		return ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, name + "_" + suffix);
	}

	private static String itemName(ItemLike itemLike) {
		return BuiltInRegistries.ITEM.getKey(itemLike.asItem()).getPath();
	}
}
