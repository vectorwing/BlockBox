package vectorwing.blockbox.data.recipe;

import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.common.helper.RecipeHelper;
import vectorwing.blockbox.common.registry.ModBlocks;
import vectorwing.blockbox.common.registry.ModItems;
import vectorwing.blockbox.common.tag.ModTags;

public class CraftingRecipes
{
	public static void register(HolderGetter<Item> items, RecipeOutput output) {
		craftBasicBlocks(items, output);
		craftPalisades(items, output);
		craftIronPlateBlocks(items, output);
		craftGoldBlocks(items, output);
		craftCopperBlocks(items, output);
		craftFurniture(items, output);
		craftSkyLanterns(items, output);
	}

	private static void craftSkyLanterns(HolderGetter<Item> items, RecipeOutput output) {
		ShapedRecipeBuilder.shaped(items, RecipeCategory.DECORATIONS, ModBlocks.WHITE_SKY_LANTERN.get())
				.pattern("ppp")
				.pattern("p p")
				.pattern("/c/")
				.define('p', Items.PAPER)
				.define('/', Items.STRING)
				.define('c', ItemTags.CANDLES)
				.unlockedBy("has_candle", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CANDLE))
				.save(output);
		dyeItem(items, output, ModItems.WHITE_SKY_LANTERN.get(), Items.WHITE_DYE, ModTags.SKY_LANTERN_ITEMS, Tags.Items.DYES_WHITE);
		dyeItem(items, output, ModItems.LIGHT_GRAY_SKY_LANTERN.get(), Items.LIGHT_GRAY_DYE, ModTags.SKY_LANTERN_ITEMS, Tags.Items.DYES_LIGHT_GRAY);
		dyeItem(items, output, ModItems.GRAY_SKY_LANTERN.get(), Items.GRAY_DYE, ModTags.SKY_LANTERN_ITEMS, Tags.Items.DYES_GRAY);
		dyeItem(items, output, ModItems.BLACK_SKY_LANTERN.get(), Items.BLACK_DYE, ModTags.SKY_LANTERN_ITEMS, Tags.Items.DYES_BLACK);
		dyeItem(items, output, ModItems.BROWN_SKY_LANTERN.get(), Items.BROWN_DYE, ModTags.SKY_LANTERN_ITEMS, Tags.Items.DYES_BROWN);
		dyeItem(items, output, ModItems.RED_SKY_LANTERN.get(), Items.RED_DYE, ModTags.SKY_LANTERN_ITEMS, Tags.Items.DYES_RED);
		dyeItem(items, output, ModItems.ORANGE_SKY_LANTERN.get(), Items.ORANGE_DYE, ModTags.SKY_LANTERN_ITEMS, Tags.Items.DYES_ORANGE);
		dyeItem(items, output, ModItems.YELLOW_SKY_LANTERN.get(), Items.YELLOW_DYE, ModTags.SKY_LANTERN_ITEMS, Tags.Items.DYES_YELLOW);
		dyeItem(items, output, ModItems.LIME_SKY_LANTERN.get(), Items.LIME_DYE, ModTags.SKY_LANTERN_ITEMS, Tags.Items.DYES_LIME);
		dyeItem(items, output, ModItems.GREEN_SKY_LANTERN.get(), Items.GREEN_DYE, ModTags.SKY_LANTERN_ITEMS, Tags.Items.DYES_GREEN);
		dyeItem(items, output, ModItems.CYAN_SKY_LANTERN.get(), Items.CYAN_DYE, ModTags.SKY_LANTERN_ITEMS, Tags.Items.DYES_CYAN);
		dyeItem(items, output, ModItems.LIGHT_BLUE_SKY_LANTERN.get(), Items.LIGHT_BLUE_DYE, ModTags.SKY_LANTERN_ITEMS, Tags.Items.DYES_LIGHT_BLUE);
		dyeItem(items, output, ModItems.BLUE_SKY_LANTERN.get(), Items.BLUE_DYE, ModTags.SKY_LANTERN_ITEMS, Tags.Items.DYES_BLUE);
		dyeItem(items, output, ModItems.PURPLE_SKY_LANTERN.get(), Items.PURPLE_DYE, ModTags.SKY_LANTERN_ITEMS, Tags.Items.DYES_PURPLE);
		dyeItem(items, output, ModItems.MAGENTA_SKY_LANTERN.get(), Items.MAGENTA_DYE, ModTags.SKY_LANTERN_ITEMS, Tags.Items.DYES_MAGENTA);
		dyeItem(items, output, ModItems.PINK_SKY_LANTERN.get(), Items.PINK_DYE, ModTags.SKY_LANTERN_ITEMS, Tags.Items.DYES_PINK);
	}

	private static void craftFurniture(HolderGetter<Item> items, RecipeOutput output) {
		ShapedRecipeBuilder.shaped(items, RecipeCategory.DECORATIONS, ModBlocks.BRAZIER.get())
				.pattern("c c")
				.pattern("iNi")
				.pattern(" i ")
				.define('c', Items.IRON_CHAIN)
				.define('N', Items.NETHERRACK)
				.define('i', Tags.Items.INGOTS_IRON)
				.unlockedBy("has_netherrack", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERRACK))
				.save(output);
		ShapedRecipeBuilder.shaped(items, RecipeCategory.DECORATIONS, ModBlocks.SOUL_BRAZIER.get())
				.pattern("c c")
				.pattern("iSi")
				.pattern(" i ")
				.define('c', Items.IRON_CHAIN)
				.define('S', ItemTags.SOUL_FIRE_BASE_BLOCKS)
				.define('i', Tags.Items.INGOTS_IRON)
				.unlockedBy("has_soul_sand", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SOUL_SAND, Items.SOUL_SOIL))
				.save(output);
		ShapelessRecipeBuilder.shapeless(items, RecipeCategory.DECORATIONS, ModBlocks.BRAZIER.get())
				.requires(ModItems.SOUL_BRAZIER.get())
				.requires(Items.NETHERRACK)
				.unlockedBy("has_netherrack", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERRACK))
				.save(output, nameWithSuffix(RecipeHelper.itemName(ModItems.BRAZIER.get()), "from_swap"));
		ShapelessRecipeBuilder.shapeless(items, RecipeCategory.DECORATIONS, ModBlocks.SOUL_BRAZIER.get())
				.requires(ModItems.BRAZIER.get())
				.requires(ItemTags.SOUL_FIRE_BASE_BLOCKS)
				.unlockedBy("has_soul_sand", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SOUL_SAND, Items.SOUL_SOIL))
				.save(output, nameWithSuffix(RecipeHelper.itemName(ModItems.SOUL_BRAZIER.get()), "from_swap"));
		chair(items, output, ModBlocks.OAK_SEAT.get(), Blocks.OAK_PLANKS);
		chair(items, output, ModBlocks.SPRUCE_SEAT.get(), Blocks.SPRUCE_PLANKS);
		chair(items, output, ModBlocks.BIRCH_SEAT.get(), Blocks.BIRCH_PLANKS);
		chair(items, output, ModBlocks.JUNGLE_SEAT.get(), Blocks.JUNGLE_PLANKS);
		chair(items, output, ModBlocks.ACACIA_SEAT.get(), Blocks.ACACIA_PLANKS);
		chair(items, output, ModBlocks.DARK_OAK_SEAT.get(), Blocks.DARK_OAK_PLANKS);
		chair(items, output, ModBlocks.MANGROVE_SEAT.get(), Blocks.MANGROVE_PLANKS);
		chair(items, output, ModBlocks.CHERRY_SEAT.get(), Blocks.CHERRY_PLANKS);
		chair(items, output, ModBlocks.BAMBOO_SEAT.get(), Blocks.BAMBOO_PLANKS);
		chair(items, output, ModBlocks.CRIMSON_SEAT.get(), Blocks.CRIMSON_PLANKS);
		chair(items, output, ModBlocks.WARPED_SEAT.get(), Blocks.WARPED_PLANKS);
	}

	private static void craftPalisades(HolderGetter<Item> items, RecipeOutput output) {
		palisade(items, output, ModBlocks.OAK_PALISADE.get(), ModBlocks.SPIKED_OAK_PALISADE.get(), Blocks.OAK_LOG);
		palisade(items, output, ModBlocks.SPRUCE_PALISADE.get(), ModBlocks.SPIKED_SPRUCE_PALISADE.get(), Blocks.SPRUCE_LOG);
		palisade(items, output, ModBlocks.BIRCH_PALISADE.get(), ModBlocks.SPIKED_BIRCH_PALISADE.get(), Blocks.BIRCH_LOG);
		palisade(items, output, ModBlocks.JUNGLE_PALISADE.get(), ModBlocks.SPIKED_JUNGLE_PALISADE.get(), Blocks.JUNGLE_LOG);
		palisade(items, output, ModBlocks.ACACIA_PALISADE.get(), ModBlocks.SPIKED_ACACIA_PALISADE.get(), Blocks.ACACIA_LOG);
		palisade(items, output, ModBlocks.DARK_OAK_PALISADE.get(), ModBlocks.SPIKED_DARK_OAK_PALISADE.get(), Blocks.DARK_OAK_LOG);
		palisade(items, output, ModBlocks.MANGROVE_PALISADE.get(), ModBlocks.SPIKED_MANGROVE_PALISADE.get(), Blocks.MANGROVE_LOG);
		palisade(items, output, ModBlocks.CHERRY_PALISADE.get(), ModBlocks.SPIKED_CHERRY_PALISADE.get(), Blocks.CHERRY_LOG);
		palisade(items, output, ModBlocks.CRIMSON_PALISADE.get(), ModBlocks.SPIKED_CRIMSON_PALISADE.get(), Blocks.CRIMSON_STEM);
		palisade(items, output, ModBlocks.WARPED_PALISADE.get(), ModBlocks.SPIKED_WARPED_PALISADE.get(), Blocks.WARPED_STEM);

		palisade(items, output, ModBlocks.STRIPPED_OAK_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_OAK_PALISADE.get(), Blocks.STRIPPED_OAK_LOG);
		palisade(items, output, ModBlocks.STRIPPED_SPRUCE_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_SPRUCE_PALISADE.get(), Blocks.STRIPPED_SPRUCE_LOG);
		palisade(items, output, ModBlocks.STRIPPED_BIRCH_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_BIRCH_PALISADE.get(), Blocks.STRIPPED_BIRCH_LOG);
		palisade(items, output, ModBlocks.STRIPPED_JUNGLE_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_JUNGLE_PALISADE.get(), Blocks.STRIPPED_JUNGLE_LOG);
		palisade(items, output, ModBlocks.STRIPPED_ACACIA_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_ACACIA_PALISADE.get(), Blocks.STRIPPED_ACACIA_LOG);
		palisade(items, output, ModBlocks.STRIPPED_DARK_OAK_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_DARK_OAK_PALISADE.get(), Blocks.STRIPPED_DARK_OAK_LOG);
		palisade(items, output, ModBlocks.STRIPPED_MANGROVE_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_MANGROVE_PALISADE.get(), Blocks.STRIPPED_MANGROVE_LOG);
		palisade(items, output, ModBlocks.STRIPPED_CHERRY_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_CHERRY_PALISADE.get(), Blocks.STRIPPED_CHERRY_LOG);
		palisade(items, output, ModBlocks.STRIPPED_CRIMSON_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_CRIMSON_PALISADE.get(), Blocks.STRIPPED_CRIMSON_STEM);
		palisade(items, output, ModBlocks.STRIPPED_WARPED_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_WARPED_PALISADE.get(), Blocks.STRIPPED_WARPED_STEM);
	}

	private static void craftIronPlateBlocks(HolderGetter<Item> items, RecipeOutput output) {
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_PLATE.get(), 4)
				.pattern("IN")
				.pattern("NI")
				.define('I', Items.IRON_INGOT)
				.define('N', Items.IRON_NUGGET)
				.unlockedBy("has_iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
				.save(output);
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_TREAD_PLATE.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', ModBlocks.IRON_PLATE.get())
				.unlockedBy("has_iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_PLATE.get()))
				.save(output);
		stairAndSlab(items, output, ModBlocks.IRON_TREAD_PLATE_STAIRS.get(), ModBlocks.IRON_TREAD_PLATE_SLAB.get(), ModBlocks.IRON_TREAD_PLATE.get());

		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORRUGATED_IRON_PLATE.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', ModBlocks.IRON_TREAD_PLATE.get())
				.unlockedBy("has_iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_PLATE.get()))
				.save(output);
		stairAndSlab(items, output, ModBlocks.CORRUGATED_IRON_PLATE_STAIRS.get(), ModBlocks.CORRUGATED_IRON_PLATE_SLAB.get(), ModBlocks.CORRUGATED_IRON_PLATE.get());

		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_PLATE_PILLAR.get(), 2)
				.pattern("#")
				.pattern("#")
				.define('#', ModBlocks.IRON_PLATE.get())
				.unlockedBy("has_iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_PLATE.get()))
				.save(output);
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_PLATE_DOOR.get(), 3)
				.pattern("##")
				.pattern("##")
				.pattern("##")
				.define('#', ModBlocks.IRON_PLATE.get())
				.unlockedBy("has_iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_PLATE.get()))
				.save(output);
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_PLATE_TRAPDOOR.get(), 2)
				.pattern("###")
				.pattern("###")
				.define('#', ModBlocks.IRON_PLATE.get())
				.unlockedBy("has_iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_PLATE.get()))
				.save(output);
	}

	private static void craftGoldBlocks(HolderGetter<Item> items, RecipeOutput output) {
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_GOLD.get(), 4)
				.pattern(" # ")
				.pattern("# #")
				.pattern(" # ")
				.define('#', Items.GOLD_INGOT)
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLDEN_TILES.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', ModBlocks.CHISELED_GOLD.get())
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLDEN_BRICKS.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', ModBlocks.GOLDEN_TILES.get())
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
		stairAndSlab(items, output, ModBlocks.GOLDEN_BRICK_STAIRS.get(), ModBlocks.GOLDEN_BRICK_SLAB.get(), ModBlocks.GOLDEN_BRICKS.get());
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLDEN_PILLAR.get(), 2)
				.pattern("#")
				.pattern("#")
				.define('#', ModBlocks.CHISELED_GOLD.get())
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLDEN_DOOR.get(), 3)
				.pattern("##")
				.pattern("##")
				.pattern("##")
				.define('#', Items.GOLD_INGOT)
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLDEN_TRAPDOOR.get(), 2)
				.pattern("##")
				.pattern("##")
				.define('#', Items.GOLD_INGOT)
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLDEN_BARS.get(), 16)
				.pattern("###")
				.pattern("###")
				.define('#', Items.GOLD_INGOT)
				.unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
				.save(output);
	}

	private static void craftCopperBlocks(HolderGetter<Item> items, RecipeOutput output) {
		copperChainLink(items, output, ModBlocks.COPPER_CHAIN_LINKS.get(), Items.COPPER_CHAIN.unaffected());
		copperChainLink(items, output, ModBlocks.EXPOSED_COPPER_CHAIN_LINKS.get(), Items.COPPER_CHAIN.exposed());
		copperChainLink(items, output, ModBlocks.WEATHERED_COPPER_CHAIN_LINKS.get(), Items.COPPER_CHAIN.weathered());
		copperChainLink(items, output, ModBlocks.OXIDIZED_COPPER_CHAIN_LINKS.get(), Items.COPPER_CHAIN.oxidized());
		waxedCopperChainLink(items, output, ModBlocks.WAXED_COPPER_CHAIN_LINKS.get(), Items.COPPER_CHAIN.waxed());
		waxedCopperChainLink(items, output, ModBlocks.WAXED_EXPOSED_COPPER_CHAIN_LINKS.get(), Items.COPPER_CHAIN.waxedExposed());
		waxedCopperChainLink(items, output, ModBlocks.WAXED_WEATHERED_COPPER_CHAIN_LINKS.get(), Items.COPPER_CHAIN.waxedWeathered());
		waxedCopperChainLink(items, output, ModBlocks.WAXED_OXIDIZED_COPPER_CHAIN_LINKS.get(), Items.COPPER_CHAIN.waxedOxidized());

		copperPillar(items, output, ModBlocks.COPPER_PILLAR.get(), Items.CUT_COPPER);
		copperPillar(items, output, ModBlocks.EXPOSED_COPPER_PILLAR.get(), Items.EXPOSED_CUT_COPPER);
		copperPillar(items, output, ModBlocks.WEATHERED_COPPER_PILLAR.get(), Items.WEATHERED_CUT_COPPER);
		copperPillar(items, output, ModBlocks.OXIDIZED_COPPER_PILLAR.get(), Items.OXIDIZED_CUT_COPPER);
		waxedCopperPillar(items, output, ModBlocks.WAXED_COPPER_PILLAR.get(), Items.WAXED_CUT_COPPER);
		waxedCopperPillar(items, output, ModBlocks.WAXED_EXPOSED_COPPER_PILLAR.get(), Items.WAXED_EXPOSED_CUT_COPPER);
		waxedCopperPillar(items, output, ModBlocks.WAXED_WEATHERED_COPPER_PILLAR.get(), Items.WAXED_WEATHERED_CUT_COPPER);
		waxedCopperPillar(items, output, ModBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get(), Items.WAXED_OXIDIZED_CUT_COPPER);

		waxing(items, output, ModBlocks.WAXED_COPPER_CHAIN_LINKS.get(), ModBlocks.COPPER_CHAIN_LINKS.get());
		waxing(items, output, ModBlocks.WAXED_EXPOSED_COPPER_CHAIN_LINKS.get(), ModBlocks.EXPOSED_COPPER_CHAIN_LINKS.get());
		waxing(items, output, ModBlocks.WAXED_WEATHERED_COPPER_CHAIN_LINKS.get(), ModBlocks.WEATHERED_COPPER_CHAIN_LINKS.get());
		waxing(items, output, ModBlocks.WAXED_OXIDIZED_COPPER_CHAIN_LINKS.get(), ModBlocks.OXIDIZED_COPPER_CHAIN_LINKS.get());
		waxing(items, output, ModBlocks.WAXED_COPPER_PILLAR.get(), ModBlocks.COPPER_PILLAR.get());
		waxing(items, output, ModBlocks.WAXED_EXPOSED_COPPER_PILLAR.get(), ModBlocks.EXPOSED_COPPER_PILLAR.get());
		waxing(items, output, ModBlocks.WAXED_WEATHERED_COPPER_PILLAR.get(), ModBlocks.WEATHERED_COPPER_PILLAR.get());
		waxing(items, output, ModBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get(), ModBlocks.OXIDIZED_COPPER_PILLAR.get());
	}

	private static void craftBasicBlocks(HolderGetter<Item> items, RecipeOutput output) {
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANITE_BRICKS.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', Blocks.POLISHED_GRANITE)
				.unlockedBy("has_granite", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.GRANITE))
				.save(output);
		stairSlabWall(items, output, ModBlocks.GRANITE_BRICK_STAIRS.get(), ModBlocks.GRANITE_BRICK_SLAB.get(), ModBlocks.GRANITE_BRICKS.get(), ModBlocks.GRANITE_BRICK_WALL.get());
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIORITE_BRICKS.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', Blocks.POLISHED_DIORITE)
				.unlockedBy("has_granite", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.DIORITE))
				.save(output);
		stairSlabWall(items, output, ModBlocks.DIORITE_BRICK_STAIRS.get(), ModBlocks.DIORITE_BRICK_SLAB.get(), ModBlocks.DIORITE_BRICKS.get(), ModBlocks.DIORITE_BRICK_WALL.get());
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANDESITE_BRICKS.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', Blocks.POLISHED_ANDESITE)
				.unlockedBy("has_granite", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.ANDESITE))
				.save(output);
		stairSlabWall(items, output, ModBlocks.ANDESITE_BRICK_STAIRS.get(), ModBlocks.ANDESITE_BRICK_SLAB.get(), ModBlocks.ANDESITE_BRICKS.get(), ModBlocks.ANDESITE_BRICK_WALL.get());

		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICKS.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', Blocks.CUT_SANDSTONE)
				.unlockedBy("has_sandstone", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.SANDSTONE))
				.save(output);
		stairAndSlab(items, output, ModBlocks.SANDSTONE_BRICK_STAIRS.get(), ModBlocks.SANDSTONE_BRICK_SLAB.get(), ModBlocks.SANDSTONE_BRICKS.get());

		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_SANDSTONE_BRICKS.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', Blocks.CUT_RED_SANDSTONE)
				.unlockedBy("has_red_sandstone", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.RED_SANDSTONE))
				.save(output);
		stairAndSlab(items, output, ModBlocks.RED_SANDSTONE_BRICK_STAIRS.get(), ModBlocks.RED_SANDSTONE_BRICK_SLAB.get(), ModBlocks.RED_SANDSTONE_BRICKS.get());

		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TILES.get())
				.pattern("#")
				.pattern("#")
				.define('#', Items.BRICK)
				.unlockedBy("has_brick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BRICK))
				.save(output);
		stairAndSlab(items, output, ModBlocks.TILE_STAIRS.get(), ModBlocks.TILE_SLAB.get(), ModBlocks.TILES.get());

		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_SNOW.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', Blocks.SNOW_BLOCK)
				.unlockedBy("has_snow", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.SNOW_BLOCK))
				.save(output);
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_BRICKS.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', ModBlocks.PACKED_SNOW.get())
				.unlockedBy("has_snow", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.SNOW_BLOCK))
				.save(output);
		stairSlabWall(items, output, ModBlocks.SNOW_BRICK_STAIRS.get(), ModBlocks.SNOW_BRICK_SLAB.get(), ModBlocks.SNOW_BRICKS.get(), ModBlocks.SNOW_BRICK_WALL.get());

		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_PACKED_ICE.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', Blocks.PACKED_ICE)
				.unlockedBy("has_packed_ice", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.PACKED_ICE))
				.save(output);
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_BRICKS.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', ModBlocks.POLISHED_PACKED_ICE.get())
				.unlockedBy("has_packed_ice", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.PACKED_ICE))
				.save(output);
		stairSlabWall(items, output, ModBlocks.PACKED_ICE_BRICK_STAIRS.get(), ModBlocks.PACKED_ICE_BRICK_SLAB.get(), ModBlocks.PACKED_ICE_BRICKS.get(), ModBlocks.PACKED_ICE_BRICK_WALL.get());

		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OBSIDIAN.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', Blocks.OBSIDIAN)
				.unlockedBy("has_obsidian", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.OBSIDIAN))
				.save(output);

		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROUGH_GLASS_PANE.get(), 16)
				.pattern("###")
				.pattern("###")
				.define('#', ModBlocks.ROUGH_GLASS.get())
				.unlockedBy("has_rough_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.ROUGH_GLASS.get()))
				.save(output);

		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_AMETHYST.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', Blocks.AMETHYST_BLOCK)
				.unlockedBy("has_amethyst_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.AMETHYST_BLOCK))
				.save(output);
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_AMETHYST.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', ModBlocks.POLISHED_AMETHYST.get())
				.unlockedBy("has_amethyst_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.AMETHYST_BLOCK))
				.save(output);
		stairAndSlab(items, output, ModBlocks.CUT_AMETHYST_STAIRS.get(), ModBlocks.CUT_AMETHYST_SLAB.get(), ModBlocks.CUT_AMETHYST.get());

		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_MOSAIC.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', ModBlocks.CUT_AMETHYST.get())
				.unlockedBy("has_amethyst_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.AMETHYST_BLOCK))
				.save(output);
		stairAndSlab(items, output, ModBlocks.AMETHYST_MOSAIC_STAIRS.get(), ModBlocks.AMETHYST_MOSAIC_SLAB.get(), ModBlocks.AMETHYST_MOSAIC.get());

		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAPIS_LAZULI_BRICKS.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', Items.LAPIS_LAZULI)
				.unlockedBy("has_lapis_lazuli", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LAPIS_LAZULI))
				.save(output);
		stairAndSlab(items, output, ModBlocks.LAPIS_LAZULI_BRICK_STAIRS.get(), ModBlocks.LAPIS_LAZULI_BRICK_SLAB.get(), ModBlocks.LAPIS_LAZULI_BRICKS.get());
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAPIS_LAZULI_MOSAIC.get(), 4)
				.pattern("##")
				.pattern("##")
				.define('#', ModBlocks.LAPIS_LAZULI_BRICKS.get())
				.unlockedBy("has_lapis_lazuli", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LAPIS_LAZULI))
				.save(output);
		stairAndSlab(items, output, ModBlocks.LAPIS_LAZULI_MOSAIC_STAIRS.get(), ModBlocks.LAPIS_LAZULI_MOSAIC_SLAB.get(), ModBlocks.LAPIS_LAZULI_MOSAIC.get());
	}

	// HELPER METHODS

	public static void copperChainLink(HolderGetter<Item> items, RecipeOutput output, ItemLike chainLink, ItemLike chain) {
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, chainLink, 8)
				.pattern(" # ")
				.pattern("# #")
				.pattern(" # ")
				.define('#', chain)
				.unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
				.save(output);
	}

	public static void waxedCopperChainLink(HolderGetter<Item> items, RecipeOutput output, ItemLike chainLink, ItemLike chain) {
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, chainLink, 8)
				.pattern(" # ")
				.pattern("# #")
				.pattern(" # ")
				.define('#', chain)
				.unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
				.group(RecipeHelper.itemName(chainLink))
				.save(output);
	}

	public static void copperPillar(HolderGetter<Item> items, RecipeOutput output, ItemLike pillar, ItemLike cutCopper) {
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, pillar, 2)
				.pattern("#")
				.pattern("#")
				.define('#', cutCopper)
				.unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.COPPER_BLOCK))
				.save(output);
	}

	public static void waxedCopperPillar(HolderGetter<Item> items, RecipeOutput output, ItemLike pillar, ItemLike cutCopper) {
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, pillar, 2)
				.pattern("#")
				.pattern("#")
				.define('#', cutCopper)
				.unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.COPPER_BLOCK))
				.group(RecipeHelper.itemName(pillar))
				.save(output);
	}

	public static void waxing(HolderGetter<Item> items, RecipeOutput output, ItemLike waxedBlock, ItemLike block) {
		ShapelessRecipeBuilder.shapeless(items, RecipeCategory.BUILDING_BLOCKS, waxedBlock)
				.requires(block)
				.requires(Items.HONEYCOMB)
				.unlockedBy("has_copper_block", InventoryChangeTrigger.TriggerInstance.hasItems(block))
				.group(RecipeHelper.itemName(waxedBlock))
				.save(output, nameWithSuffix(RecipeHelper.itemName(waxedBlock), "from_honeycomb"));
	}

	public static void stairAndSlab(HolderGetter<Item> items, RecipeOutput output, ItemLike stair, ItemLike slab, ItemLike block) {
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, stair, 4)
				.pattern("#  ")
				.pattern("## ")
				.pattern("###")
				.define('#', block)
				.unlockedBy("has_matching_block", InventoryChangeTrigger.TriggerInstance.hasItems(block))
				.save(output);
		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, slab, 6)
				.pattern("###")
				.define('#', block)
				.unlockedBy("has_matching_block", InventoryChangeTrigger.TriggerInstance.hasItems(block))
				.save(output);
	}

	public static void stairSlabWall(HolderGetter<Item> items, RecipeOutput output, ItemLike stair, ItemLike slab, ItemLike block, ItemLike wall) {
		stairAndSlab(items, output, stair, slab, block);
		ShapedRecipeBuilder.shaped(items, RecipeCategory.DECORATIONS, wall, 6)
				.pattern("###")
				.pattern("###")
				.define('#', block)
				.unlockedBy("has_matching_block", InventoryChangeTrigger.TriggerInstance.hasItems(block))
				.save(output);
	}

	public static void palisade(HolderGetter<Item> items, RecipeOutput output, ItemLike palisade, ItemLike spikedPalisade, ItemLike log) {
		ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, palisade, 12)
				.pattern("###")
				.pattern("###")
				.define('#', log)
				.group("bb_palisades")
				.unlockedBy("has_matching_log", InventoryChangeTrigger.TriggerInstance.hasItems(log))
				.save(output);
		ShapelessRecipeBuilder.shapeless(items, RecipeCategory.MISC, palisade, 1)
				.requires(spikedPalisade)
				.group("bb_palisades")
				.unlockedBy("has_matching_log", InventoryChangeTrigger.TriggerInstance.hasItems(log))
				.save(output, nameWithSuffix(RecipeHelper.itemName(palisade), "from_spiked"));
		ShapelessRecipeBuilder.shapeless(items, RecipeCategory.MISC, spikedPalisade, 1)
				.requires(palisade)
				.group("bb_spiked_palisades")
				.unlockedBy("has_matching_palisade", InventoryChangeTrigger.TriggerInstance.hasItems(palisade))
				.save(output);
	}

	public static void chair(HolderGetter<Item> items, RecipeOutput output, ItemLike chair, ItemLike plank) {
		ShapedRecipeBuilder.shaped(items, RecipeCategory.DECORATIONS, chair)
				.pattern("###")
				.pattern("/ /")
				.define('#', plank)
				.define('/', Items.STICK)
				.group("bb_chairs")
				.unlockedBy("has_matching_plank", InventoryChangeTrigger.TriggerInstance.hasItems(plank))
				.save(output);
	}

	private static void dyeItem(HolderGetter<Item> items, RecipeOutput output, ItemLike result, ItemLike mainDye, TagKey<Item> itemTag, TagKey<Item> dyeTag) {
		ShapelessRecipeBuilder.shapeless(items, RecipeCategory.DECORATIONS, result)
				.requires(dyeTag)
				.requires(itemTag)
				.unlockedBy("has_needed_dye", InventoryChangeTrigger.TriggerInstance.hasItems(mainDye))
				.save(output, nameDye(result));
	}

	private static ResourceKey<Recipe<?>> nameDye(ItemLike item) {
		return ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(BlockBox.MODID, "dye_" + RecipeHelper.itemName(item)));
	}

	private static ResourceKey<Recipe<?>> nameWithSuffix(String name, String suffix) {
		return ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(BlockBox.MODID, name + "_" + suffix));
	}
}
