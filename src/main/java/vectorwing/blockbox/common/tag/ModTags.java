package vectorwing.blockbox.common.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import vectorwing.blockbox.BlockBox;

public class ModTags
{
	// Blocks that are palisades.
	public static final TagKey<Block> PALISADES = modBlockTag("palisades");

	// Blocks that are spiked palisades.
	public static final TagKey<Block> SPIKED_PALISADES = modBlockTag("spiked_palisades");

	// Blocks that are wooden seats.
	public static final TagKey<Block> WOODEN_SEATS = modBlockTag("wooden_seats");

	// Blocks that are made out of Amethyst.
	public static final TagKey<Block> AMETHYST_BLOCKS = modBlockTag("amethyst_blocks");

	// Blocks that are made out of Iron Plate.
	public static final TagKey<Block> IRON_PLATE_BLOCKS = modBlockTag("iron_plate_blocks");

	// Blocks that are braziers.
	public static final TagKey<Block> BRAZIERS = modBlockTag("braziers");

	// Blocks that are made out of Gold.
	public static final TagKey<Block> GOLDEN_BLOCKS = modBlockTag("golden_blocks");

	// Item forms of blocks made out of Gold.
	public static final TagKey<Item> GOLDEN_BLOCK_ITEMS = modItemTag("golden_blocks");

	// Item forms of sky lanterns.
	public static final TagKey<Item> SKY_LANTERNS = modItemTag("sky_lanterns");

	private static TagKey<Block> modBlockTag(String path) {
		return BlockTags.create(ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, path));
	}

	private static TagKey<Item> modItemTag(String path) {
		return ItemTags.create(ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, path));
	}
}
