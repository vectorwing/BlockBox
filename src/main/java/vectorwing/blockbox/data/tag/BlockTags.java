package vectorwing.blockbox.data.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.common.registry.ModBlocks;
import vectorwing.blockbox.common.tag.CompatibilityTags;
import vectorwing.blockbox.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class BlockTags extends BlockTagsProvider
{
	public BlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, BlockBox.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.@NotNull Provider provider) {
		this.registerMinecraftTags();
		this.registerModTags();
		this.registerCommonTags();
		this.registerCompatibilityTags();
		this.registerBlockMineables();
	}

	private void registerCompatibilityTags() {
		tag(CompatibilityTags.FARMERS_DELIGHT_TRAY_HEAT_SOURCES).addTag(ModTags.BRAZIERS);
	}

	private void registerMinecraftTags() {
		tag(net.minecraft.tags.BlockTags.STAIRS).add(
				ModBlocks.GRANITE_BRICK_STAIRS.get(),
				ModBlocks.DIORITE_BRICK_STAIRS.get(),
				ModBlocks.ANDESITE_BRICK_STAIRS.get(),
				ModBlocks.SANDSTONE_BRICK_STAIRS.get(),
				ModBlocks.RED_SANDSTONE_BRICK_STAIRS.get(),
				ModBlocks.TILE_STAIRS.get(),
				ModBlocks.PACKED_ICE_BRICK_STAIRS.get(),
				ModBlocks.SNOW_BRICK_STAIRS.get(),
				ModBlocks.IRON_TREAD_PLATE_STAIRS.get(),
				ModBlocks.CORRUGATED_IRON_PLATE_STAIRS.get(),
				ModBlocks.GOLDEN_BRICK_STAIRS.get(),
				ModBlocks.CUT_AMETHYST_STAIRS.get(),
				ModBlocks.AMETHYST_MOSAIC_STAIRS.get(),
				ModBlocks.LAPIS_LAZULI_BRICK_STAIRS.get(),
				ModBlocks.LAPIS_LAZULI_MOSAIC_STAIRS.get()
		);
		tag(net.minecraft.tags.BlockTags.SLABS).add(
				ModBlocks.GRANITE_BRICK_SLAB.get(),
				ModBlocks.DIORITE_BRICK_SLAB.get(),
				ModBlocks.ANDESITE_BRICK_SLAB.get(),
				ModBlocks.SANDSTONE_BRICK_SLAB.get(),
				ModBlocks.RED_SANDSTONE_BRICK_SLAB.get(),
				ModBlocks.TILE_SLAB.get(),
				ModBlocks.PACKED_ICE_BRICK_SLAB.get(),
				ModBlocks.SNOW_BRICK_SLAB.get(),
				ModBlocks.IRON_TREAD_PLATE_SLAB.get(),
				ModBlocks.CORRUGATED_IRON_PLATE_SLAB.get(),
				ModBlocks.GOLDEN_BRICK_SLAB.get(),
				ModBlocks.CUT_AMETHYST_SLAB.get(),
				ModBlocks.AMETHYST_MOSAIC_SLAB.get(),
				ModBlocks.LAPIS_LAZULI_BRICK_SLAB.get(),
				ModBlocks.LAPIS_LAZULI_MOSAIC_SLAB.get()
		);
		tag(net.minecraft.tags.BlockTags.DOORS).add(
				ModBlocks.IRON_PLATE_DOOR.get(),
				ModBlocks.GOLDEN_DOOR.get()
		);
		tag(net.minecraft.tags.BlockTags.TRAPDOORS).add(
				ModBlocks.IRON_PLATE_TRAPDOOR.get(),
				ModBlocks.GOLDEN_TRAPDOOR.get()
		);
		tag(net.minecraft.tags.BlockTags.WALLS).add(
						ModBlocks.GRANITE_BRICK_WALL.get(),
						ModBlocks.DIORITE_BRICK_WALL.get(),
						ModBlocks.ANDESITE_BRICK_WALL.get(),
						ModBlocks.SNOW_BRICK_WALL.get(),
						ModBlocks.PACKED_ICE_BRICK_WALL.get())
				.addTag(ModTags.PALISADES)
				.addTag(ModTags.SPIKED_PALISADES);
		tag(net.minecraft.tags.BlockTags.GUARDED_BY_PIGLINS).addTag(ModTags.GOLDEN_BLOCKS);
		tag(net.minecraft.tags.BlockTags.CRYSTAL_SOUND_BLOCKS).addTag(ModTags.AMETHYST_BLOCKS);
		tag(net.minecraft.tags.BlockTags.VIBRATION_RESONATORS).addTag(ModTags.AMETHYST_BLOCKS);
		tag(net.minecraft.tags.BlockTags.DRAGON_IMMUNE).add(ModBlocks.POLISHED_OBSIDIAN.get());
		tag(net.minecraft.tags.BlockTags.IMPERMEABLE).add(ModBlocks.ROUGH_GLASS.get());
	}

	private void registerModTags() {
		tag(ModTags.PALISADES).add(
				ModBlocks.OAK_PALISADE.get(),
				ModBlocks.SPRUCE_PALISADE.get(),
				ModBlocks.BIRCH_PALISADE.get(),
				ModBlocks.JUNGLE_PALISADE.get(),
				ModBlocks.ACACIA_PALISADE.get(),
				ModBlocks.DARK_OAK_PALISADE.get(),
				ModBlocks.MANGROVE_PALISADE.get(),
				ModBlocks.CHERRY_PALISADE.get(),
				ModBlocks.CRIMSON_PALISADE.get(),
				ModBlocks.WARPED_PALISADE.get(),
				ModBlocks.STRIPPED_OAK_PALISADE.get(),
				ModBlocks.STRIPPED_SPRUCE_PALISADE.get(),
				ModBlocks.STRIPPED_BIRCH_PALISADE.get(),
				ModBlocks.STRIPPED_JUNGLE_PALISADE.get(),
				ModBlocks.STRIPPED_ACACIA_PALISADE.get(),
				ModBlocks.STRIPPED_DARK_OAK_PALISADE.get(),
				ModBlocks.STRIPPED_MANGROVE_PALISADE.get(),
				ModBlocks.STRIPPED_CHERRY_PALISADE.get(),
				ModBlocks.STRIPPED_CRIMSON_PALISADE.get(),
				ModBlocks.STRIPPED_WARPED_PALISADE.get()
		);
		tag(ModTags.SPIKED_PALISADES).add(
				ModBlocks.SPIKED_OAK_PALISADE.get(),
				ModBlocks.SPIKED_SPRUCE_PALISADE.get(),
				ModBlocks.SPIKED_BIRCH_PALISADE.get(),
				ModBlocks.SPIKED_JUNGLE_PALISADE.get(),
				ModBlocks.SPIKED_ACACIA_PALISADE.get(),
				ModBlocks.SPIKED_DARK_OAK_PALISADE.get(),
				ModBlocks.SPIKED_MANGROVE_PALISADE.get(),
				ModBlocks.SPIKED_CHERRY_PALISADE.get(),
				ModBlocks.SPIKED_CRIMSON_PALISADE.get(),
				ModBlocks.SPIKED_WARPED_PALISADE.get(),
				ModBlocks.STRIPPED_SPIKED_OAK_PALISADE.get(),
				ModBlocks.STRIPPED_SPIKED_SPRUCE_PALISADE.get(),
				ModBlocks.STRIPPED_SPIKED_BIRCH_PALISADE.get(),
				ModBlocks.STRIPPED_SPIKED_JUNGLE_PALISADE.get(),
				ModBlocks.STRIPPED_SPIKED_ACACIA_PALISADE.get(),
				ModBlocks.STRIPPED_SPIKED_DARK_OAK_PALISADE.get(),
				ModBlocks.STRIPPED_SPIKED_MANGROVE_PALISADE.get(),
				ModBlocks.STRIPPED_SPIKED_CHERRY_PALISADE.get(),
				ModBlocks.STRIPPED_SPIKED_CRIMSON_PALISADE.get(),
				ModBlocks.STRIPPED_SPIKED_WARPED_PALISADE.get()
		);
		tag(ModTags.WOODEN_SEATS).add(
				ModBlocks.OAK_SEAT.get(),
				ModBlocks.SPRUCE_SEAT.get(),
				ModBlocks.BIRCH_SEAT.get(),
				ModBlocks.JUNGLE_SEAT.get(),
				ModBlocks.ACACIA_SEAT.get(),
				ModBlocks.DARK_OAK_SEAT.get(),
				ModBlocks.MANGROVE_SEAT.get(),
				ModBlocks.CHERRY_SEAT.get(),
				ModBlocks.BAMBOO_SEAT.get(),
				ModBlocks.CRIMSON_SEAT.get(),
				ModBlocks.WARPED_SEAT.get()
		);
		tag(ModTags.AMETHYST_BLOCKS).add(
				ModBlocks.POLISHED_AMETHYST.get(),
				ModBlocks.CUT_AMETHYST.get(),
				ModBlocks.CUT_AMETHYST_STAIRS.get(),
				ModBlocks.CUT_AMETHYST_SLAB.get(),
				ModBlocks.AMETHYST_MOSAIC.get(),
				ModBlocks.AMETHYST_MOSAIC_STAIRS.get(),
				ModBlocks.AMETHYST_MOSAIC_SLAB.get()
		);

		tag(ModTags.IRON_PLATE_BLOCKS).add(
				ModBlocks.IRON_PLATE.get(),
				ModBlocks.IRON_TREAD_PLATE.get(),
				ModBlocks.IRON_TREAD_PLATE_STAIRS.get(),
				ModBlocks.IRON_TREAD_PLATE_SLAB.get(),
				ModBlocks.CORRUGATED_IRON_PLATE.get(),
				ModBlocks.CORRUGATED_IRON_PLATE_STAIRS.get(),
				ModBlocks.CORRUGATED_IRON_PLATE_SLAB.get(),
				ModBlocks.IRON_PLATE_PILLAR.get(),
				ModBlocks.IRON_PLATE_DOOR.get(),
				ModBlocks.IRON_PLATE_TRAPDOOR.get()
		);

		tag(ModTags.GOLDEN_BLOCKS).add(
				ModBlocks.CHISELED_GOLD.get(),
				ModBlocks.GOLDEN_TILES.get(),
				ModBlocks.GOLDEN_BRICKS.get(),
				ModBlocks.GOLDEN_BRICK_STAIRS.get(),
				ModBlocks.GOLDEN_BRICK_SLAB.get(),
				ModBlocks.GOLDEN_PILLAR.get(),
				ModBlocks.GOLDEN_DOOR.get(),
				ModBlocks.GOLDEN_TRAPDOOR.get(),
				ModBlocks.GOLDEN_BARS.get()
		);

		tag(ModTags.BRAZIERS).add(
				ModBlocks.BRAZIER.get(),
				ModBlocks.SOUL_BRAZIER.get()
		);
	}

	private void registerCommonTags() {
		tag(Tags.Blocks.SANDSTONE_UNCOLORED_BLOCKS).add(
				ModBlocks.SANDSTONE_BRICKS.get()
		);
		tag(Tags.Blocks.SANDSTONE_UNCOLORED_STAIRS).add(
				ModBlocks.SANDSTONE_BRICK_STAIRS.get()
		);
		tag(Tags.Blocks.SANDSTONE_UNCOLORED_SLABS).add(
				ModBlocks.SANDSTONE_BRICK_SLAB.get()
		);
		tag(Tags.Blocks.SANDSTONE_RED_BLOCKS).add(
				ModBlocks.RED_SANDSTONE_BRICKS.get()
		);
		tag(Tags.Blocks.SANDSTONE_RED_STAIRS).add(
				ModBlocks.RED_SANDSTONE_BRICK_STAIRS.get()
		);
		tag(Tags.Blocks.SANDSTONE_RED_SLABS).add(
				ModBlocks.RED_SANDSTONE_BRICK_SLAB.get()
		);
		tag(Tags.Blocks.GLASS_BLOCKS_CHEAP).add(
				ModBlocks.ROUGH_GLASS.get()
		);
		tag(Tags.Blocks.GLASS_BLOCKS_COLORLESS).add(
				ModBlocks.ROUGH_GLASS.get()
		);
		tag(Tags.Blocks.GLASS_PANES_COLORLESS).add(
				ModBlocks.ROUGH_GLASS_PANE.get()
		);
	}

	private void registerBlockMineables() {
		tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(
				ModBlocks.GRANITE_BRICKS.get(),
				ModBlocks.GRANITE_BRICK_STAIRS.get(),
				ModBlocks.GRANITE_BRICK_SLAB.get(),
				ModBlocks.GRANITE_BRICK_WALL.get(),
				ModBlocks.DIORITE_BRICKS.get(),
				ModBlocks.DIORITE_BRICK_STAIRS.get(),
				ModBlocks.DIORITE_BRICK_SLAB.get(),
				ModBlocks.DIORITE_BRICK_WALL.get(),
				ModBlocks.ANDESITE_BRICKS.get(),
				ModBlocks.ANDESITE_BRICK_STAIRS.get(),
				ModBlocks.ANDESITE_BRICK_SLAB.get(),
				ModBlocks.ANDESITE_BRICK_WALL.get(),
				ModBlocks.SANDSTONE_BRICKS.get(),
				ModBlocks.SANDSTONE_BRICK_STAIRS.get(),
				ModBlocks.SANDSTONE_BRICK_SLAB.get(),
				ModBlocks.RED_SANDSTONE_BRICKS.get(),
				ModBlocks.RED_SANDSTONE_BRICK_STAIRS.get(),
				ModBlocks.RED_SANDSTONE_BRICK_SLAB.get(),
				ModBlocks.TILES.get(),
				ModBlocks.TILE_STAIRS.get(),
				ModBlocks.TILE_SLAB.get(),
				ModBlocks.BROKEN_TILE_MOSAIC.get(),
				ModBlocks.POLISHED_PACKED_ICE.get(),
				ModBlocks.PACKED_ICE_BRICKS.get(),
				ModBlocks.PACKED_ICE_BRICK_STAIRS.get(),
				ModBlocks.PACKED_ICE_BRICK_SLAB.get(),
				ModBlocks.PACKED_ICE_BRICK_WALL.get(),
				ModBlocks.POLISHED_OBSIDIAN.get(),
				ModBlocks.COPPER_BARS.get(),
				ModBlocks.EXPOSED_COPPER_BARS.get(),
				ModBlocks.WEATHERED_COPPER_BARS.get(),
				ModBlocks.OXIDIZED_COPPER_BARS.get(),
				ModBlocks.WAXED_COPPER_BARS.get(),
				ModBlocks.WAXED_EXPOSED_COPPER_BARS.get(),
				ModBlocks.WAXED_WEATHERED_COPPER_BARS.get(),
				ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get(),
				ModBlocks.COPPER_PILLAR.get(),
				ModBlocks.EXPOSED_COPPER_PILLAR.get(),
				ModBlocks.WEATHERED_COPPER_PILLAR.get(),
				ModBlocks.OXIDIZED_COPPER_PILLAR.get(),
				ModBlocks.WAXED_COPPER_PILLAR.get(),
				ModBlocks.WAXED_EXPOSED_COPPER_PILLAR.get(),
				ModBlocks.WAXED_WEATHERED_COPPER_PILLAR.get(),
				ModBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get(),
				ModBlocks.IRON_PLATE.get(),
				ModBlocks.IRON_TREAD_PLATE.get(),
				ModBlocks.IRON_TREAD_PLATE_STAIRS.get(),
				ModBlocks.IRON_TREAD_PLATE_SLAB.get(),
				ModBlocks.CORRUGATED_IRON_PLATE.get(),
				ModBlocks.CORRUGATED_IRON_PLATE_STAIRS.get(),
				ModBlocks.CORRUGATED_IRON_PLATE_SLAB.get(),
				ModBlocks.IRON_PLATE_PILLAR.get(),
				ModBlocks.IRON_PLATE_DOOR.get(),
				ModBlocks.IRON_PLATE_TRAPDOOR.get(),
				ModBlocks.CHISELED_GOLD.get(),
				ModBlocks.GOLDEN_TILES.get(),
				ModBlocks.GOLDEN_BRICKS.get(),
				ModBlocks.GOLDEN_BRICK_STAIRS.get(),
				ModBlocks.GOLDEN_BRICK_SLAB.get(),
				ModBlocks.GOLDEN_PILLAR.get(),
				ModBlocks.GOLDEN_DOOR.get(),
				ModBlocks.GOLDEN_TRAPDOOR.get(),
				ModBlocks.GOLDEN_BARS.get(),
				ModBlocks.POLISHED_AMETHYST.get(),
				ModBlocks.CUT_AMETHYST.get(),
				ModBlocks.CUT_AMETHYST_STAIRS.get(),
				ModBlocks.CUT_AMETHYST_SLAB.get(),
				ModBlocks.AMETHYST_MOSAIC_STAIRS.get(),
				ModBlocks.AMETHYST_MOSAIC_SLAB.get(),
				ModBlocks.AMETHYST_MOSAIC.get(),
				ModBlocks.LAPIS_LAZULI_BRICKS.get(),
				ModBlocks.LAPIS_LAZULI_MOSAIC.get(),
				ModBlocks.BRAZIER.get(),
				ModBlocks.SOUL_BRAZIER.get()
		).remove(ModTags.PALISADES).remove(ModTags.SPIKED_PALISADES);
		tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE)
				.addTag(ModTags.PALISADES)
				.addTag(ModTags.SPIKED_PALISADES)
				.addTag(ModTags.WOODEN_SEATS);
		tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_SHOVEL).add(
				ModBlocks.PACKED_SNOW.get(),
				ModBlocks.CARVED_SNOW.get(),
				ModBlocks.SNOW_BRICKS.get(),
				ModBlocks.SNOW_BRICK_STAIRS.get(),
				ModBlocks.SNOW_BRICK_SLAB.get(),
				ModBlocks.SNOW_BRICK_WALL.get()
		);
		tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(
						ModBlocks.COPPER_BARS.get(),
						ModBlocks.EXPOSED_COPPER_BARS.get(),
						ModBlocks.WEATHERED_COPPER_BARS.get(),
						ModBlocks.OXIDIZED_COPPER_BARS.get(),
						ModBlocks.WAXED_COPPER_BARS.get(),
						ModBlocks.WAXED_EXPOSED_COPPER_BARS.get(),
						ModBlocks.WAXED_WEATHERED_COPPER_BARS.get(),
						ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get(),
						ModBlocks.COPPER_PILLAR.get(),
						ModBlocks.EXPOSED_COPPER_PILLAR.get(),
						ModBlocks.WEATHERED_COPPER_PILLAR.get(),
						ModBlocks.OXIDIZED_COPPER_PILLAR.get(),
						ModBlocks.WAXED_COPPER_PILLAR.get(),
						ModBlocks.WAXED_EXPOSED_COPPER_PILLAR.get(),
						ModBlocks.WAXED_WEATHERED_COPPER_PILLAR.get(),
						ModBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get(),
						ModBlocks.LAPIS_LAZULI_BRICKS.get(),
						ModBlocks.LAPIS_LAZULI_BRICK_STAIRS.get(),
						ModBlocks.LAPIS_LAZULI_BRICK_SLAB.get(),
						ModBlocks.LAPIS_LAZULI_MOSAIC.get(),
						ModBlocks.LAPIS_LAZULI_MOSAIC_STAIRS.get(),
						ModBlocks.LAPIS_LAZULI_MOSAIC_SLAB.get(),
						ModBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get()
				)
				.addTag(ModTags.IRON_PLATE_BLOCKS);
		tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).addTag(ModTags.GOLDEN_BLOCKS);
		tag(net.minecraft.tags.BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.POLISHED_OBSIDIAN.get());
	}
}
