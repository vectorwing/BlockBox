package vectorwing.buildingbigger.data.provider;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.properties.Half;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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
		doorBlockWithRenderType((DoorBlock) ModBlocks.IRON_PLATE_DOOR.get(), resourceBlock("iron_plate_door_bottom"), resourceBlock("iron_plate_door_top"), RenderType.CUTOUT.name);
		ironPlateTrapdoor((TrapDoorBlock) ModBlocks.IRON_PLATE_TRAPDOOR.get(), key(ModBlocks.IRON_PLATE_TRAPDOOR.get()).toString(), resourceBlock("iron_plate_trapdoor"), ResourceLocation.tryParse(RenderType.CUTOUT.name));

		simpleBlock(ModBlocks.CHISELED_GOLD.get());
		simpleBlock(ModBlocks.GOLDEN_TILES.get());
		simpleBlock(ModBlocks.GOLDEN_BRICKS.get());
		axisBlock((RotatedPillarBlock) ModBlocks.GOLDEN_PILLAR.get());
		doorBlockWithRenderType((DoorBlock) ModBlocks.GOLDEN_DOOR.get(), resourceBlock("golden_door_bottom"), resourceBlock("golden_door_top"), RenderType.CUTOUT.name);
		trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.GOLDEN_TRAPDOOR.get(), resourceBlock("golden_trapdoor"), false, RenderType.CUTOUT.name);

		simpleBlock(ModBlocks.POLISHED_AMETHYST.get());
		simpleBlock(ModBlocks.AMETHYST_TILES.get());
		simpleBlock(ModBlocks.CHISELED_AMETHYST.get());
	}

	private void ironPlateTrapdoor(TrapDoorBlock block, String baseName, ResourceLocation texture, ResourceLocation renderType) {
		ModelFile bottom = models().trapdoorOrientableBottom(baseName + "_bottom", texture).renderType(renderType);
		ModelFile top = models().trapdoorOrientableTop(baseName + "_top", texture).renderType(renderType);
		ModelFile open = models().trapdoorOpen(baseName + "_open", texture).renderType(renderType);

		getVariantBuilder(block).forAllStatesExcept(state -> {
			int xRot = 0;
			int yRot = ((int) state.getValue(TrapDoorBlock.FACING).toYRot()) + 180;
			boolean isOpen = state.getValue(TrapDoorBlock.OPEN);
			yRot %= 360;
			return ConfiguredModel.builder().modelFile(isOpen ? open : state.getValue(TrapDoorBlock.HALF) == Half.TOP ? top : bottom)
					.rotationX(xRot)
					.rotationY(yRot)
					.build();
		}, TrapDoorBlock.POWERED, TrapDoorBlock.WATERLOGGED);
	}

	public static ResourceLocation resourceBlock(String name) {
		return ResourceLocation.fromNamespaceAndPath(BuildingBigger.MODID, "block/" + name);
	}

	private ResourceLocation key(Block block) {
		return BuiltInRegistries.BLOCK.getKey(block);
	}
}
