package vectorwing.blockbox.data.recipe;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.common.registry.ModItems;

public class StonecuttingRecipes
{
	public static void register(RecipeOutput output) {
		stonecutting(output, Items.SANDSTONE, ModItems.SANDSTONE_BRICKS.get());
		stonecutting(output, Items.SANDSTONE, ModItems.SANDSTONE_BRICK_STAIRS.get());
		stonecutting(output, Items.SANDSTONE, ModItems.SANDSTONE_BRICK_SLAB.get(), 2);
		stonecutting(output, ModItems.SANDSTONE_BRICKS.get(), ModItems.SANDSTONE_BRICK_STAIRS.get());
		stonecutting(output, ModItems.SANDSTONE_BRICKS.get(), ModItems.SANDSTONE_BRICK_SLAB.get(), 2);

		stonecutting(output, Items.RED_SANDSTONE, ModItems.RED_SANDSTONE_BRICKS.get());
		stonecutting(output, Items.RED_SANDSTONE, ModItems.RED_SANDSTONE_BRICK_STAIRS.get());
		stonecutting(output, Items.RED_SANDSTONE, ModItems.RED_SANDSTONE_BRICK_SLAB.get(), 2);
		stonecutting(output, ModItems.RED_SANDSTONE_BRICKS.get(), ModItems.RED_SANDSTONE_BRICK_STAIRS.get());
		stonecutting(output, ModItems.RED_SANDSTONE_BRICKS.get(), ModItems.RED_SANDSTONE_BRICK_SLAB.get(), 2);

		stonecutting(output, Items.TERRACOTTA, ModItems.CLAY_TILES.get());
		stonecutting(output, Items.TERRACOTTA, ModItems.CLAY_TILE_STAIRS.get());
		stonecutting(output, Items.TERRACOTTA, ModItems.CLAY_TILE_SLAB.get(), 2);
		stonecutting(output, ModItems.CLAY_TILES.get(), ModItems.CLAY_TILE_STAIRS.get());
		stonecutting(output, ModItems.CLAY_TILES.get(), ModItems.CLAY_TILE_SLAB.get(), 2);

		stonecutting(output, Items.PACKED_ICE, ModItems.POLISHED_PACKED_ICE.get());
		stonecutting(output, Items.PACKED_ICE, ModItems.PACKED_ICE_BRICKS.get());
		stonecutting(output, Items.PACKED_ICE, ModItems.PACKED_ICE_BRICKS_STAIRS.get());
		stonecutting(output, Items.PACKED_ICE, ModItems.PACKED_ICE_BRICKS_SLAB.get(), 2);
		stonecutting(output, ModItems.POLISHED_PACKED_ICE.get(), Items.PACKED_ICE);
		stonecutting(output, ModItems.POLISHED_PACKED_ICE.get(), ModItems.PACKED_ICE_BRICKS.get());
		stonecutting(output, ModItems.POLISHED_PACKED_ICE.get(), ModItems.PACKED_ICE_BRICKS_STAIRS.get());
		stonecutting(output, ModItems.POLISHED_PACKED_ICE.get(), ModItems.PACKED_ICE_BRICKS_SLAB.get(), 2);
		stonecutting(output, ModItems.PACKED_ICE_BRICKS.get(), Items.PACKED_ICE);
		stonecutting(output, ModItems.PACKED_ICE_BRICKS.get(), ModItems.POLISHED_PACKED_ICE.get());
		stonecutting(output, ModItems.PACKED_ICE_BRICKS.get(), ModItems.PACKED_ICE_BRICKS_STAIRS.get());
		stonecutting(output, ModItems.PACKED_ICE_BRICKS.get(), ModItems.PACKED_ICE_BRICKS_SLAB.get(), 2);

		stonecutting(output, Items.OBSIDIAN, ModItems.POLISHED_OBSIDIAN.get());
		stonecutting(output, ModItems.POLISHED_OBSIDIAN.get(), Items.OBSIDIAN);

		stonecutting(output, Items.COPPER_BLOCK, ModItems.COPPER_PILLAR.get(), 4);
		stonecutting(output, Items.EXPOSED_COPPER, ModItems.EXPOSED_COPPER_PILLAR.get(), 4);
		stonecutting(output, Items.WEATHERED_COPPER, ModItems.WEATHERED_COPPER_PILLAR.get(), 4);
		stonecutting(output, Items.OXIDIZED_COPPER, ModItems.OXIDIZED_COPPER_PILLAR.get(), 4);
		stonecutting(output, Items.CUT_COPPER, ModItems.COPPER_PILLAR.get());
		stonecutting(output, Items.EXPOSED_CUT_COPPER, ModItems.EXPOSED_COPPER_PILLAR.get());
		stonecutting(output, Items.WEATHERED_CUT_COPPER, ModItems.WEATHERED_COPPER_PILLAR.get());
		stonecutting(output, Items.OXIDIZED_CUT_COPPER, ModItems.OXIDIZED_COPPER_PILLAR.get());
		stonecutting(output, Items.WAXED_COPPER_BLOCK, ModItems.WAXED_COPPER_PILLAR.get(), 4);
		stonecutting(output, Items.WAXED_EXPOSED_COPPER, ModItems.WAXED_EXPOSED_COPPER_PILLAR.get(), 4);
		stonecutting(output, Items.WAXED_WEATHERED_COPPER, ModItems.WAXED_WEATHERED_COPPER_PILLAR.get(), 4);
		stonecutting(output, Items.WAXED_OXIDIZED_COPPER, ModItems.WAXED_OXIDIZED_COPPER_PILLAR.get(), 4);
		stonecutting(output, Items.WAXED_CUT_COPPER, ModItems.WAXED_COPPER_PILLAR.get());
		stonecutting(output, Items.WAXED_EXPOSED_CUT_COPPER, ModItems.WAXED_EXPOSED_COPPER_PILLAR.get());
		stonecutting(output, Items.WAXED_WEATHERED_CUT_COPPER, ModItems.WAXED_WEATHERED_COPPER_PILLAR.get());
		stonecutting(output, Items.WAXED_OXIDIZED_CUT_COPPER, ModItems.WAXED_OXIDIZED_COPPER_PILLAR.get());

		stonecutting(output, ModItems.IRON_PLATE.get(), ModItems.IRON_TREAD_PLATE.get());
		stonecutting(output, ModItems.IRON_PLATE.get(), ModItems.IRON_TREAD_PLATE_STAIRS.get());
		stonecutting(output, ModItems.IRON_PLATE.get(), ModItems.IRON_TREAD_PLATE_SLAB.get(), 2);
		stonecutting(output, ModItems.IRON_PLATE.get(), ModItems.CORRUGATED_IRON_PLATE.get());
		stonecutting(output, ModItems.IRON_PLATE.get(), ModItems.IRON_PLATE_PILLAR.get());
		stonecutting(output, ModItems.IRON_TREAD_PLATE.get(), ModItems.IRON_PLATE.get());
		stonecutting(output, ModItems.IRON_TREAD_PLATE.get(), ModItems.IRON_TREAD_PLATE_STAIRS.get());
		stonecutting(output, ModItems.IRON_TREAD_PLATE.get(), ModItems.IRON_TREAD_PLATE_SLAB.get(), 2);
		stonecutting(output, ModItems.IRON_TREAD_PLATE.get(), ModItems.CORRUGATED_IRON_PLATE.get());
		stonecutting(output, ModItems.IRON_TREAD_PLATE.get(), ModItems.IRON_PLATE_PILLAR.get());
		stonecutting(output, ModItems.CORRUGATED_IRON_PLATE.get(), ModItems.IRON_PLATE.get());
		stonecutting(output, ModItems.CORRUGATED_IRON_PLATE.get(), ModItems.IRON_TREAD_PLATE.get());
		stonecutting(output, ModItems.CORRUGATED_IRON_PLATE.get(), ModItems.IRON_TREAD_PLATE_STAIRS.get());
		stonecutting(output, ModItems.CORRUGATED_IRON_PLATE.get(), ModItems.IRON_TREAD_PLATE_SLAB.get(), 2);
		stonecutting(output, ModItems.CORRUGATED_IRON_PLATE.get(), ModItems.IRON_PLATE_PILLAR.get());
		stonecutting(output, ModItems.IRON_PLATE_PILLAR.get(), ModItems.IRON_PLATE.get());
		stonecutting(output, ModItems.IRON_PLATE_PILLAR.get(), ModItems.IRON_TREAD_PLATE.get());
		stonecutting(output, ModItems.IRON_PLATE_PILLAR.get(), ModItems.IRON_TREAD_PLATE_STAIRS.get());
		stonecutting(output, ModItems.IRON_PLATE_PILLAR.get(), ModItems.IRON_TREAD_PLATE_SLAB.get(), 2);
		stonecutting(output, ModItems.IRON_PLATE_PILLAR.get(), ModItems.CORRUGATED_IRON_PLATE.get());

		stonecutting(output, ModItems.CHISELED_GOLD.get(), ModItems.GOLDEN_TILES.get());
		stonecutting(output, ModItems.CHISELED_GOLD.get(), ModItems.GOLDEN_BRICKS.get());
		stonecutting(output, ModItems.CHISELED_GOLD.get(), ModItems.GOLDEN_BRICK_STAIRS.get());
		stonecutting(output, ModItems.CHISELED_GOLD.get(), ModItems.GOLDEN_BRICK_SLAB.get(), 2);
		stonecutting(output, ModItems.CHISELED_GOLD.get(), ModItems.GOLDEN_PILLAR.get());
		stonecutting(output, ModItems.GOLDEN_TILES.get(), ModItems.CHISELED_GOLD.get());
		stonecutting(output, ModItems.GOLDEN_TILES.get(), ModItems.GOLDEN_BRICKS.get());
		stonecutting(output, ModItems.GOLDEN_TILES.get(), ModItems.GOLDEN_BRICK_STAIRS.get());
		stonecutting(output, ModItems.GOLDEN_TILES.get(), ModItems.GOLDEN_BRICK_SLAB.get(), 2);
		stonecutting(output, ModItems.GOLDEN_TILES.get(), ModItems.GOLDEN_PILLAR.get());
		stonecutting(output, ModItems.GOLDEN_BRICKS.get(), ModItems.CHISELED_GOLD.get());
		stonecutting(output, ModItems.GOLDEN_BRICKS.get(), ModItems.GOLDEN_TILES.get());
		stonecutting(output, ModItems.GOLDEN_BRICKS.get(), ModItems.GOLDEN_BRICK_STAIRS.get());
		stonecutting(output, ModItems.GOLDEN_BRICKS.get(), ModItems.GOLDEN_BRICK_SLAB.get(), 2);
		stonecutting(output, ModItems.GOLDEN_BRICKS.get(), ModItems.GOLDEN_PILLAR.get());
		stonecutting(output, ModItems.GOLDEN_PILLAR.get(), ModItems.CHISELED_GOLD.get());
		stonecutting(output, ModItems.GOLDEN_PILLAR.get(), ModItems.GOLDEN_TILES.get());
		stonecutting(output, ModItems.GOLDEN_PILLAR.get(), ModItems.GOLDEN_BRICKS.get());
		stonecutting(output, ModItems.GOLDEN_PILLAR.get(), ModItems.GOLDEN_BRICK_STAIRS.get());
		stonecutting(output, ModItems.GOLDEN_PILLAR.get(), ModItems.GOLDEN_BRICK_SLAB.get(), 2);

		stonecutting(output, Items.AMETHYST_BLOCK, ModItems.POLISHED_AMETHYST.get());
		stonecutting(output, Items.AMETHYST_BLOCK, ModItems.CUT_AMETHYST.get());
		stonecutting(output, Items.AMETHYST_BLOCK, ModItems.CUT_AMETHYST_STAIRS.get());
		stonecutting(output, Items.AMETHYST_BLOCK, ModItems.CUT_AMETHYST_SLAB.get(), 2);
		stonecutting(output, Items.AMETHYST_BLOCK, ModItems.CHISELED_AMETHYST.get());
		stonecutting(output, Items.AMETHYST_BLOCK, ModItems.CHISELED_AMETHYST_STAIRS.get());
		stonecutting(output, Items.AMETHYST_BLOCK, ModItems.CHISELED_AMETHYST_SLAB.get(), 2);

		stonecutting(output, ModItems.POLISHED_AMETHYST.get(), Items.AMETHYST_BLOCK);
		stonecutting(output, ModItems.POLISHED_AMETHYST.get(), ModItems.CUT_AMETHYST.get());
		stonecutting(output, ModItems.POLISHED_AMETHYST.get(), ModItems.CUT_AMETHYST_STAIRS.get());
		stonecutting(output, ModItems.POLISHED_AMETHYST.get(), ModItems.CUT_AMETHYST_SLAB.get(), 2);
		stonecutting(output, ModItems.POLISHED_AMETHYST.get(), ModItems.CHISELED_AMETHYST.get());
		stonecutting(output, ModItems.POLISHED_AMETHYST.get(), ModItems.CHISELED_AMETHYST_STAIRS.get());
		stonecutting(output, ModItems.POLISHED_AMETHYST.get(), ModItems.CHISELED_AMETHYST_SLAB.get(), 2);

		stonecutting(output, ModItems.CUT_AMETHYST.get(), Items.AMETHYST_BLOCK);
		stonecutting(output, ModItems.CUT_AMETHYST.get(), ModItems.POLISHED_AMETHYST.get());
		stonecutting(output, ModItems.CUT_AMETHYST.get(), ModItems.CUT_AMETHYST_STAIRS.get());
		stonecutting(output, ModItems.CUT_AMETHYST.get(), ModItems.CUT_AMETHYST_SLAB.get(), 2);
		stonecutting(output, ModItems.CUT_AMETHYST.get(), ModItems.CHISELED_AMETHYST.get());
		stonecutting(output, ModItems.CUT_AMETHYST.get(), ModItems.CHISELED_AMETHYST_STAIRS.get());
		stonecutting(output, ModItems.CUT_AMETHYST.get(), ModItems.CHISELED_AMETHYST_SLAB.get(), 2);

		stonecutting(output, ModItems.CHISELED_AMETHYST.get(), Items.AMETHYST_BLOCK);
		stonecutting(output, ModItems.CHISELED_AMETHYST.get(), ModItems.POLISHED_AMETHYST.get());
		stonecutting(output, ModItems.CHISELED_AMETHYST.get(), ModItems.CUT_AMETHYST.get());
		stonecutting(output, ModItems.CHISELED_AMETHYST.get(), ModItems.CUT_AMETHYST_STAIRS.get(), 2);
		stonecutting(output, ModItems.CHISELED_AMETHYST.get(), ModItems.CUT_AMETHYST_SLAB.get());
		stonecutting(output, ModItems.CHISELED_AMETHYST.get(), ModItems.CHISELED_AMETHYST_STAIRS.get());
		stonecutting(output, ModItems.CHISELED_AMETHYST.get(), ModItems.CHISELED_AMETHYST_SLAB.get(), 2);
	}

	private static void stonecutting(RecipeOutput output, ItemLike input, ItemLike result) {
		stonecutting(output, input, result, 1);
	}

	private static void stonecutting(RecipeOutput output, ItemLike input, ItemLike result, int count) {
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, result, count)
				.unlockedBy("has_" + name(input), InventoryChangeTrigger.TriggerInstance.hasItems(input))
				.save(output, recipeName(result, input));
	}

	private static ResourceLocation recipeName(ItemLike result, ItemLike ingredient) {
		return ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, name(result) + "_from_" + name(ingredient) + "_stonecutting");
	}

	private static ResourceLocation key(Item item) {
		return BuiltInRegistries.ITEM.getKey(item);
	}

	private static String name(ItemLike item) {
		return key(item.asItem()).getPath();
	}

}
