package vectorwing.buildingbigger.data.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
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
		this.registerBlockMineables();
		this.registerModTags();
	}

	private void registerModTags() {
		tag(ModTags.PALISADES).add(ModBlocks.OAK_PALISADE.get());
		tag(ModTags.SPIKED_PALISADES).add(ModBlocks.SPIKED_OAK_PALISADE.get());
	}

	protected void registerBlockMineables() {
		tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(
				ModBlocks.SANDSTONE_BRICKS.get(),
				ModBlocks.RED_SANDSTONE_BRICKS.get(),
				ModBlocks.CLAY_TILES.get(),
				ModBlocks.JAGGED_CLAY_TILES.get(),
				ModBlocks.POLISHED_PACKED_ICE.get(),
				ModBlocks.PACKED_ICE_BRICKS.get(),
				ModBlocks.IRON_PLATE.get(),
				ModBlocks.IRON_TREAD_PLATE.get(),
				ModBlocks.CORRUGATED_IRON_PLATE.get(),
				ModBlocks.IRON_PLATE_PILLAR.get(),
				ModBlocks.GOLDEN_TILES.get(),
				ModBlocks.GOLDEN_BRICKS.get(),
				ModBlocks.GOLDEN_PILLAR.get(),
				ModBlocks.POLISHED_AMETHYST.get(),
				ModBlocks.AMETHYST_TILES.get(),
				ModBlocks.CHISELED_AMETHYST.get()
		);
		tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE).add(
				ModBlocks.OAK_PALISADE.get(),
				ModBlocks.SPIKED_OAK_PALISADE.get()
		);
		tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_SHOVEL).add(
				ModBlocks.PACKED_SNOW.get(),
				ModBlocks.PACKED_SNOW_BRICKS.get()
		);
	}
}
