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
		this.registerMinecraftTags();
		this.registerModTags();
		this.registerBlockMineables();
	}

	private void registerMinecraftTags() {
		tag(net.minecraft.tags.BlockTags.DOORS)
				.add(ModBlocks.IRON_PLATE_DOOR.get())
				.add(ModBlocks.GOLDEN_DOOR.get());
		tag(net.minecraft.tags.BlockTags.TRAPDOORS)
				.add(ModBlocks.IRON_PLATE_TRAPDOOR.get())
				.add(ModBlocks.GOLDEN_TRAPDOOR.get());
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
				ModBlocks.IRON_PLATE_DOOR.get(),
				ModBlocks.IRON_PLATE_TRAPDOOR.get(),
				ModBlocks.CHISELED_GOLD.get(),
				ModBlocks.GOLDEN_TILES.get(),
				ModBlocks.GOLDEN_BRICKS.get(),
				ModBlocks.GOLDEN_PILLAR.get(),
				ModBlocks.GOLDEN_DOOR.get(),
				ModBlocks.GOLDEN_TRAPDOOR.get(),
				ModBlocks.POLISHED_AMETHYST.get(),
				ModBlocks.AMETHYST_TILES.get(),
				ModBlocks.CHISELED_AMETHYST.get()
		);
		tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE)
				.addTag(ModTags.PALISADES)
				.addTag(ModTags.SPIKED_PALISADES);
		tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_SHOVEL).add(
				ModBlocks.PACKED_SNOW.get(),
				ModBlocks.PACKED_SNOW_BRICKS.get()
		);
	}
}
