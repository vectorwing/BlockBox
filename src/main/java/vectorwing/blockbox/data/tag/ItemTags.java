package vectorwing.blockbox.data.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
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
	protected void addTags(HolderLookup.Provider provider) {
		registerMinecraftTags();
		registerModTags();
	}

	private void registerModTags() {
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
				ModItems.CLAY_TILE_STAIRS.get(),
				ModItems.PACKED_ICE_BRICK_STAIRS.get(),
				ModItems.SNOW_BRICK_STAIRS.get(),
				ModItems.IRON_TREAD_PLATE_STAIRS.get(),
				ModItems.CORRUGATED_IRON_PLATE_STAIRS.get(),
				ModItems.GOLDEN_BRICK_STAIRS.get(),
				ModItems.CUT_AMETHYST_STAIRS.get(),
				ModItems.CHISELED_AMETHYST_STAIRS.get(),
				ModItems.LAPIS_LAZULI_BRICK_STAIRS.get(),
				ModItems.LAPIS_LAZULI_MOSAIC_STAIRS.get()
		);
		tag(net.minecraft.tags.ItemTags.SLABS).add(
				ModItems.GRANITE_BRICK_SLAB.get(),
				ModItems.DIORITE_BRICK_SLAB.get(),
				ModItems.ANDESITE_BRICK_SLAB.get(),
				ModItems.SANDSTONE_BRICK_SLAB.get(),
				ModItems.RED_SANDSTONE_BRICK_SLAB.get(),
				ModItems.CLAY_TILE_SLAB.get(),
				ModItems.PACKED_ICE_BRICK_SLAB.get(),
				ModItems.SNOW_BRICK_SLAB.get(),
				ModItems.IRON_TREAD_PLATE_SLAB.get(),
				ModItems.CORRUGATED_IRON_PLATE_SLAB.get(),
				ModItems.GOLDEN_BRICK_SLAB.get(),
				ModItems.CUT_AMETHYST_SLAB.get(),
				ModItems.CHISELED_AMETHYST_SLAB.get(),
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
