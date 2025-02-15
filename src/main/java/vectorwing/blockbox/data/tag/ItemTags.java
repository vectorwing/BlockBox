package vectorwing.blockbox.data.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import vectorwing.blockbox.common.registry.ModBlocks;
import vectorwing.blockbox.common.registry.ModItems;
import vectorwing.blockbox.common.tag.ModTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ItemTags extends ItemTagsProvider
{
	public ItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, blockTags);
	}

	@Override
	protected void addTags(HolderLookup.@NotNull Provider provider) {
		registerMinecraftTags();
		registerModTags();
	}

	private void registerModTags() {
		tag(ModTags.PALISADE_ITEMS).add(
				ModItems.OAK_PALISADE.get(),
				ModItems.SPRUCE_PALISADE.get(),
				ModItems.BIRCH_PALISADE.get(),
				ModItems.JUNGLE_PALISADE.get(),
				ModItems.ACACIA_PALISADE.get(),
				ModItems.DARK_OAK_PALISADE.get(),
				ModItems.MANGROVE_PALISADE.get(),
				ModItems.CHERRY_PALISADE.get(),
				ModItems.CRIMSON_PALISADE.get(),
				ModItems.WARPED_PALISADE.get(),
				ModItems.STRIPPED_OAK_PALISADE.get(),
				ModItems.STRIPPED_SPRUCE_PALISADE.get(),
				ModItems.STRIPPED_BIRCH_PALISADE.get(),
				ModItems.STRIPPED_JUNGLE_PALISADE.get(),
				ModItems.STRIPPED_ACACIA_PALISADE.get(),
				ModItems.STRIPPED_DARK_OAK_PALISADE.get(),
				ModItems.STRIPPED_MANGROVE_PALISADE.get(),
				ModItems.STRIPPED_CHERRY_PALISADE.get(),
				ModItems.STRIPPED_CRIMSON_PALISADE.get(),
				ModItems.STRIPPED_WARPED_PALISADE.get()
		);
		tag(ModTags.SPIKED_PALISADE_ITEMS).add(
				ModItems.SPIKED_OAK_PALISADE.get(),
				ModItems.SPIKED_SPRUCE_PALISADE.get(),
				ModItems.SPIKED_BIRCH_PALISADE.get(),
				ModItems.SPIKED_JUNGLE_PALISADE.get(),
				ModItems.SPIKED_ACACIA_PALISADE.get(),
				ModItems.SPIKED_DARK_OAK_PALISADE.get(),
				ModItems.SPIKED_MANGROVE_PALISADE.get(),
				ModItems.SPIKED_CHERRY_PALISADE.get(),
				ModItems.SPIKED_CRIMSON_PALISADE.get(),
				ModItems.SPIKED_WARPED_PALISADE.get(),
				ModItems.STRIPPED_SPIKED_OAK_PALISADE.get(),
				ModItems.STRIPPED_SPIKED_SPRUCE_PALISADE.get(),
				ModItems.STRIPPED_SPIKED_BIRCH_PALISADE.get(),
				ModItems.STRIPPED_SPIKED_JUNGLE_PALISADE.get(),
				ModItems.STRIPPED_SPIKED_ACACIA_PALISADE.get(),
				ModItems.STRIPPED_SPIKED_DARK_OAK_PALISADE.get(),
				ModItems.STRIPPED_SPIKED_MANGROVE_PALISADE.get(),
				ModItems.STRIPPED_SPIKED_CHERRY_PALISADE.get(),
				ModItems.STRIPPED_SPIKED_CRIMSON_PALISADE.get(),
				ModItems.STRIPPED_SPIKED_WARPED_PALISADE.get()
		);
		tag(ModTags.WOODEN_SEAT_ITEMS).add(
				ModItems.OAK_SEAT.get(),
				ModItems.SPRUCE_SEAT.get(),
				ModItems.BIRCH_SEAT.get(),
				ModItems.JUNGLE_SEAT.get(),
				ModItems.ACACIA_SEAT.get(),
				ModItems.DARK_OAK_SEAT.get(),
				ModItems.MANGROVE_SEAT.get(),
				ModItems.CHERRY_SEAT.get(),
				ModItems.BAMBOO_SEAT.get(),
				ModItems.CRIMSON_SEAT.get(),
				ModItems.WARPED_SEAT.get()
		);
		tag(ModTags.GOLDEN_BLOCK_ITEMS).add(
				ModItems.CHISELED_GOLD.get(),
				ModItems.GOLDEN_TILES.get(),
				ModItems.GOLDEN_BRICKS.get(),
				ModItems.GOLDEN_BRICK_STAIRS.get(),
				ModItems.GOLDEN_BRICK_SLAB.get(),
				ModItems.GOLDEN_PILLAR.get(),
				ModItems.GOLDEN_DOOR.get(),
				ModItems.GOLDEN_TRAPDOOR.get(),
				ModItems.GOLDEN_BARS.get()
		);
		tag(ModTags.SKY_LANTERNS).add(
				ModItems.WHITE_SKY_LANTERN.get(),
				ModItems.LIGHT_GRAY_SKY_LANTERN.get(),
				ModItems.GRAY_SKY_LANTERN.get(),
				ModItems.BLACK_SKY_LANTERN.get(),
				ModItems.BROWN_SKY_LANTERN.get(),
				ModItems.RED_SKY_LANTERN.get(),
				ModItems.ORANGE_SKY_LANTERN.get(),
				ModItems.YELLOW_SKY_LANTERN.get(),
				ModItems.LIME_SKY_LANTERN.get(),
				ModItems.GREEN_SKY_LANTERN.get(),
				ModItems.CYAN_SKY_LANTERN.get(),
				ModItems.LIGHT_BLUE_SKY_LANTERN.get(),
				ModItems.BLUE_SKY_LANTERN.get(),
				ModItems.PURPLE_SKY_LANTERN.get(),
				ModItems.MAGENTA_SKY_LANTERN.get(),
				ModItems.PINK_SKY_LANTERN.get()
		);
	}

	private void registerMinecraftTags() {
		tag(net.minecraft.tags.ItemTags.STAIRS).add(
				ModItems.GRANITE_BRICK_STAIRS.get(),
				ModItems.DIORITE_BRICK_STAIRS.get(),
				ModItems.ANDESITE_BRICK_STAIRS.get(),
				ModItems.SANDSTONE_BRICK_STAIRS.get(),
				ModItems.RED_SANDSTONE_BRICK_STAIRS.get(),
				ModItems.TILE_STAIRS.get(),
				ModItems.PACKED_ICE_BRICK_STAIRS.get(),
				ModItems.SNOW_BRICK_STAIRS.get(),
				ModItems.IRON_TREAD_PLATE_STAIRS.get(),
				ModItems.CORRUGATED_IRON_PLATE_STAIRS.get(),
				ModItems.GOLDEN_BRICK_STAIRS.get(),
				ModItems.CUT_AMETHYST_STAIRS.get(),
				ModItems.AMETHYST_MOSAIC_STAIRS.get(),
				ModItems.LAPIS_LAZULI_BRICK_STAIRS.get(),
				ModItems.LAPIS_LAZULI_MOSAIC_STAIRS.get()
		);
		tag(net.minecraft.tags.ItemTags.SLABS).add(
				ModItems.GRANITE_BRICK_SLAB.get(),
				ModItems.DIORITE_BRICK_SLAB.get(),
				ModItems.ANDESITE_BRICK_SLAB.get(),
				ModItems.SANDSTONE_BRICK_SLAB.get(),
				ModItems.RED_SANDSTONE_BRICK_SLAB.get(),
				ModItems.TILE_SLAB.get(),
				ModItems.PACKED_ICE_BRICK_SLAB.get(),
				ModItems.SNOW_BRICK_SLAB.get(),
				ModItems.IRON_TREAD_PLATE_SLAB.get(),
				ModItems.CORRUGATED_IRON_PLATE_SLAB.get(),
				ModItems.GOLDEN_BRICK_SLAB.get(),
				ModItems.CUT_AMETHYST_SLAB.get(),
				ModItems.AMETHYST_MOSAIC_SLAB.get(),
				ModItems.LAPIS_LAZULI_BRICK_SLAB.get(),
				ModItems.LAPIS_LAZULI_MOSAIC_SLAB.get()
		);
		tag(net.minecraft.tags.ItemTags.DOORS).add(
				ModItems.IRON_PLATE_DOOR.get(),
				ModItems.GOLDEN_DOOR.get()
		);
		tag(net.minecraft.tags.ItemTags.TRAPDOORS).add(
				ModItems.IRON_PLATE_TRAPDOOR.get(),
				ModItems.GOLDEN_TRAPDOOR.get()
		);
		tag(net.minecraft.tags.ItemTags.WALLS).add(
				ModItems.GRANITE_BRICK_WALL.get(),
				ModItems.DIORITE_BRICK_WALL.get(),
				ModItems.ANDESITE_BRICK_WALL.get(),
				ModItems.SNOW_BRICK_WALL.get(),
				ModItems.PACKED_ICE_BRICK_WALL.get()
		);
		tag(net.minecraft.tags.ItemTags.PIGLIN_LOVED).addTag(ModTags.GOLDEN_BLOCK_ITEMS);
	}
}
