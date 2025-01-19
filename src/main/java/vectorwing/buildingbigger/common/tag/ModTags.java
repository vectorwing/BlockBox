package vectorwing.buildingbigger.common.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import vectorwing.buildingbigger.BuildingBigger;

public class ModTags
{
	// Blocks that are palisades.
	public static final TagKey<Block> PALISADES = modBlockTag("palisades");

	// Blocks that are spiked palisades.
	public static final TagKey<Block> SPIKED_PALISADES = modBlockTag("spiked_palisades");

	// Blocks that are made out of Amethyst.
	public static final TagKey<Block> AMETHYST_BLOCKS = modBlockTag("amethyst_blocks");

	private static TagKey<Block> modBlockTag(String path) {
		return BlockTags.create(ResourceLocation.fromNamespaceAndPath(BuildingBigger.MODID, path));
	}

	private static TagKey<Item> modItemTag(String path) {
		return ItemTags.create(ResourceLocation.fromNamespaceAndPath(BuildingBigger.MODID, path));
	}
}
