package vectorwing.buildingbigger.data.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.buildingbigger.BuildingBigger;
import vectorwing.buildingbigger.common.registry.ModBlocks;
import vectorwing.buildingbigger.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class BlockTags extends BlockTagsProvider
{
	public BlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, BuildingBigger.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.@NotNull Provider provider) {
		this.registerMinecraftTags();
		this.registerModTags();
		this.registerCommonTags();
		this.registerBlockMineables();
	}

	private void registerMinecraftTags() {
		tag(net.minecraft.tags.BlockTags.STAIRS).add(
				ModBlocks.SANDSTONE_BRICK_STAIRS.get(),
				ModBlocks.RED_SANDSTONE_BRICK_STAIRS.get(),
				ModBlocks.CLAY_TILE_STAIRS.get(),
				ModBlocks.IRON_TREAD_PLATE_STAIRS.get(),
				ModBlocks.GOLDEN_BRICK_STAIRS.get(),
				ModBlocks.CUT_AMETHYST_STAIRS.get(),
				ModBlocks.CHISELED_AMETHYST_STAIRS.get()
		);
		tag(net.minecraft.tags.BlockTags.SLABS).add(
				ModBlocks.SANDSTONE_BRICK_SLAB.get(),
				ModBlocks.RED_SANDSTONE_BRICK_SLAB.get(),
				ModBlocks.CLAY_TILE_SLAB.get(),
				ModBlocks.IRON_TREAD_PLATE_SLAB.get(),
				ModBlocks.GOLDEN_BRICK_SLAB.get(),
				ModBlocks.CUT_AMETHYST_SLAB.get(),
				ModBlocks.CHISELED_AMETHYST_SLAB.get()
		);
		tag(net.minecraft.tags.BlockTags.DOORS).add(
				ModBlocks.IRON_PLATE_DOOR.get(),
				ModBlocks.GOLDEN_DOOR.get()
		);
		tag(net.minecraft.tags.BlockTags.TRAPDOORS).add(
				ModBlocks.IRON_PLATE_TRAPDOOR.get(),
				ModBlocks.GOLDEN_TRAPDOOR.get()
		);
		tag(net.minecraft.tags.BlockTags.WALLS).add(ModBlocks.PACKED_SNOW_BRICK_WALL.get());
		tag(net.minecraft.tags.BlockTags.GUARDED_BY_PIGLINS).addTag(ModTags.GOLDEN_BLOCKS);
		tag(net.minecraft.tags.BlockTags.CRYSTAL_SOUND_BLOCKS).addTag(ModTags.AMETHYST_BLOCKS);
		tag(net.minecraft.tags.BlockTags.VIBRATION_RESONATORS).addTag(ModTags.AMETHYST_BLOCKS);
		tag(net.minecraft.tags.BlockTags.DRAGON_IMMUNE).add(ModBlocks.POLISHED_OBSIDIAN.get());
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
				ModBlocks.WARPED_PALISADE.get()
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
				ModBlocks.SPIKED_WARPED_PALISADE.get()
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
				ModBlocks.CRIMSON_SEAT.get(),
				ModBlocks.WARPED_SEAT.get()
		);
		tag(ModTags.AMETHYST_BLOCKS).add(
				ModBlocks.POLISHED_AMETHYST.get(),
				ModBlocks.CUT_AMETHYST.get(),
				ModBlocks.CUT_AMETHYST_STAIRS.get(),
				ModBlocks.CUT_AMETHYST_SLAB.get(),
				ModBlocks.CHISELED_AMETHYST.get(),
				ModBlocks.CHISELED_AMETHYST_STAIRS.get(),
				ModBlocks.CHISELED_AMETHYST_SLAB.get()
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
	}

	protected void registerCommonTags() {
		tag(Tags.Blocks.SANDSTONE_BLOCKS).add(
				ModBlocks.SANDSTONE_BRICKS.get(),
				ModBlocks.SANDSTONE_BRICK_STAIRS.get(),
				ModBlocks.SANDSTONE_BRICK_SLAB.get(),
				ModBlocks.RED_SANDSTONE_BRICKS.get(),
				ModBlocks.RED_SANDSTONE_BRICK_STAIRS.get(),
				ModBlocks.RED_SANDSTONE_BRICK_SLAB.get()
		);
	}

	protected void registerBlockMineables() {
		tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(
				ModBlocks.SANDSTONE_BRICKS.get(),
				ModBlocks.SANDSTONE_BRICK_STAIRS.get(),
				ModBlocks.SANDSTONE_BRICK_SLAB.get(),
				ModBlocks.RED_SANDSTONE_BRICKS.get(),
				ModBlocks.RED_SANDSTONE_BRICK_STAIRS.get(),
				ModBlocks.RED_SANDSTONE_BRICK_SLAB.get(),
				ModBlocks.CLAY_TILES.get(),
				ModBlocks.CLAY_TILE_STAIRS.get(),
				ModBlocks.CLAY_TILE_SLAB.get(),
				ModBlocks.JAGGED_CLAY_TILES.get(),
				ModBlocks.POLISHED_PACKED_ICE.get(),
				ModBlocks.PACKED_ICE_BRICKS.get(),
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
				ModBlocks.POLISHED_AMETHYST.get(),
				ModBlocks.CUT_AMETHYST.get(),
				ModBlocks.CUT_AMETHYST_STAIRS.get(),
				ModBlocks.CUT_AMETHYST_SLAB.get(),
				ModBlocks.CHISELED_AMETHYST_STAIRS.get(),
				ModBlocks.CHISELED_AMETHYST_SLAB.get(),
				ModBlocks.CHISELED_AMETHYST.get()
		);
		tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE)
				.addTag(ModTags.PALISADES)
				.addTag(ModTags.SPIKED_PALISADES)
				.addTag(ModTags.WOODEN_SEATS)
				.add(ModBlocks.OAK_SEAT.get());
		tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_SHOVEL).add(
				ModBlocks.PACKED_SNOW.get(),
				ModBlocks.PACKED_SNOW_BRICKS.get(),
				ModBlocks.PACKED_SNOW_BRICK_STAIRS.get(),
				ModBlocks.PACKED_SNOW_BRICK_SLAB.get(),
				ModBlocks.PACKED_SNOW_BRICK_WALL.get()
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
				ModBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get()
		);
		tag(net.minecraft.tags.BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.POLISHED_OBSIDIAN.get());
	}
}
