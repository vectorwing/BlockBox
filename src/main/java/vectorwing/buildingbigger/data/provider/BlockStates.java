package vectorwing.buildingbigger.data.provider;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.buildingbigger.BuildingBigger;
import vectorwing.buildingbigger.common.registry.ModBlocks;

public class BlockStates extends BlockStateProvider
{
	public BlockStates(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, BuildingBigger.MODID, existingFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		simpleBlock(ModBlocks.SANDSTONE_BRICKS.get());
		simpleBlock(ModBlocks.RED_SANDSTONE_BRICKS.get());

		simpleBlock(ModBlocks.CLAY_TILES.get());

		simpleBlock(ModBlocks.POLISHED_PACKED_ICE.get());
		simpleBlock(ModBlocks.PACKED_ICE_BRICKS.get());
		simpleBlock(ModBlocks.PACKED_SNOW.get());
		simpleBlock(ModBlocks.PACKED_SNOW_BRICKS.get());

		simpleBlock(ModBlocks.IRON_PLATE.get());
		simpleBlock(ModBlocks.IRON_TREAD_PLATE.get());
		simpleBlock(ModBlocks.CORRUGATED_IRON_PLATE.get());
		axisBlock((RotatedPillarBlock) ModBlocks.IRON_PLATE_PILLAR.get());

		simpleBlock(ModBlocks.GOLDEN_TILES.get());
		simpleBlock(ModBlocks.GOLDEN_BRICKS.get());
		axisBlock((RotatedPillarBlock) ModBlocks.GOLDEN_PILLAR.get());

		simpleBlock(ModBlocks.POLISHED_AMETHYST.get());
		simpleBlock(ModBlocks.AMETHYST_TILES.get());
		simpleBlock(ModBlocks.CHISELED_AMETHYST.get());
	}
}
