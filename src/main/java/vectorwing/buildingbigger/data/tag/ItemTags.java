package vectorwing.buildingbigger.data.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.buildingbigger.common.registry.ModBlocks;
import vectorwing.buildingbigger.common.registry.ModItems;
import vectorwing.buildingbigger.common.tag.ModTags;

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
		tag(net.minecraft.tags.ItemTags.DOORS)
				.add(ModItems.IRON_PLATE_DOOR.get())
				.add(ModItems.GOLDEN_DOOR.get());
		tag(net.minecraft.tags.ItemTags.TRAPDOORS)
				.add(ModItems.IRON_PLATE_TRAPDOOR.get())
				.add(ModItems.GOLDEN_TRAPDOOR.get());
		tag(net.minecraft.tags.ItemTags.PIGLIN_LOVED).addTag(ModTags.GOLDEN_BLOCK_ITEMS);
	}
}
