package vectorwing.blockbox.common.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CompatibilityTags
{
	// Farmer's Delight
	public static final String FARMERS_DELIGHT = "farmersdelight";
	public static final TagKey<Block> FARMERS_DELIGHT_TRAY_HEAT_SOURCES = externalBlockTag(FARMERS_DELIGHT, "tray_heat_sources");

	private static TagKey<Block> externalBlockTag(String modId, String path) {
		return BlockTags.create(ResourceLocation.fromNamespaceAndPath(modId, path));
	}

	private static TagKey<Item> externalItemTag(String modId, String path) {
		return ItemTags.create(ResourceLocation.fromNamespaceAndPath(modId, path));
	}
}
