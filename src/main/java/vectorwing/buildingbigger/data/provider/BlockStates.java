package vectorwing.buildingbigger.data.provider;

import com.google.common.collect.ImmutableMap;
import net.minecraft.Util;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.buildingbigger.BuildingBigger;
import vectorwing.buildingbigger.common.block.PalisadeBlock;
import vectorwing.buildingbigger.common.block.SpikedPalisadeBlock;
import vectorwing.buildingbigger.common.block.state.PalisadeConnection;
import vectorwing.buildingbigger.common.registry.ModBlocks;

import java.util.Map;

public class BlockStates extends BlockStateProvider
{
	public static final ResourceLocation CUTOUT = ResourceLocation.parse(RenderType.CUTOUT.name);

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

		palisadeBlock((PalisadeBlock) ModBlocks.OAK_PALISADE.get());
		spikedPalisadeBlock((SpikedPalisadeBlock) ModBlocks.SPIKED_OAK_PALISADE.get(), name(ModBlocks.OAK_PALISADE.get()));
		palisadeBlock((PalisadeBlock) ModBlocks.SPRUCE_PALISADE.get());
		spikedPalisadeBlock((SpikedPalisadeBlock) ModBlocks.SPIKED_SPRUCE_PALISADE.get(), name(ModBlocks.SPRUCE_PALISADE.get()));
		palisadeBlock((PalisadeBlock) ModBlocks.BIRCH_PALISADE.get());
		spikedPalisadeBlock((SpikedPalisadeBlock) ModBlocks.SPIKED_BIRCH_PALISADE.get(), name(ModBlocks.BIRCH_PALISADE.get()));
		palisadeBlock((PalisadeBlock) ModBlocks.JUNGLE_PALISADE.get());
		spikedPalisadeBlock((SpikedPalisadeBlock) ModBlocks.SPIKED_JUNGLE_PALISADE.get(), name(ModBlocks.JUNGLE_PALISADE.get()));
		palisadeBlock((PalisadeBlock) ModBlocks.ACACIA_PALISADE.get());
		spikedPalisadeBlock((SpikedPalisadeBlock) ModBlocks.SPIKED_ACACIA_PALISADE.get(), name(ModBlocks.ACACIA_PALISADE.get()));
		palisadeBlock((PalisadeBlock) ModBlocks.DARK_OAK_PALISADE.get());
		spikedPalisadeBlock((SpikedPalisadeBlock) ModBlocks.SPIKED_DARK_OAK_PALISADE.get(), name(ModBlocks.DARK_OAK_PALISADE.get()));
		palisadeBlock((PalisadeBlock) ModBlocks.MANGROVE_PALISADE.get());
		spikedPalisadeBlock((SpikedPalisadeBlock) ModBlocks.SPIKED_MANGROVE_PALISADE.get(), name(ModBlocks.MANGROVE_PALISADE.get()));
		palisadeBlock((PalisadeBlock) ModBlocks.CHERRY_PALISADE.get());
		spikedPalisadeBlock((SpikedPalisadeBlock) ModBlocks.SPIKED_CHERRY_PALISADE.get(), name(ModBlocks.CHERRY_PALISADE.get()));
		palisadeBlock((PalisadeBlock) ModBlocks.CRIMSON_PALISADE.get());
		spikedPalisadeBlock((SpikedPalisadeBlock) ModBlocks.SPIKED_CRIMSON_PALISADE.get(), name(ModBlocks.CRIMSON_PALISADE.get()));
		palisadeBlock((PalisadeBlock) ModBlocks.WARPED_PALISADE.get());
		spikedPalisadeBlock((SpikedPalisadeBlock) ModBlocks.SPIKED_WARPED_PALISADE.get(), name(ModBlocks.WARPED_PALISADE.get()));
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

	public static final ImmutableMap<Direction, Property<PalisadeConnection>> PALISADE_PROPS = ImmutableMap.<Direction, Property<PalisadeConnection>>builder()
			.put(Direction.EAST, PalisadeBlock.TYPE_EAST)
			.put(Direction.NORTH, PalisadeBlock.TYPE_NORTH)
			.put(Direction.SOUTH, PalisadeBlock.TYPE_SOUTH)
			.put(Direction.WEST, PalisadeBlock.TYPE_WEST)
			.build();

	public void palisadeBlock(PalisadeBlock block) {
		String baseName = name(block);

		MultiPartBlockStateBuilder builder = getMultipartBuilder(block)
				.part().modelFile(modelPalisadePost(baseName, baseName)).addModel().end();
		PALISADE_PROPS.entrySet().stream()
				.filter(e -> e.getKey().getAxisDirection().equals(Direction.AxisDirection.NEGATIVE))
				.forEach(e -> {
					boolean isRotated = e.getKey().getAxis().equals(Direction.Axis.X);
					palisadeSidePart(builder, modelPalisadeSide(baseName, baseName, true, false), e, PalisadeConnection.FULL, isRotated);
					palisadeSidePart(builder, modelPalisadeSide(baseName, baseName, true, true), e, PalisadeConnection.SPIKED, isRotated);
				});
		PALISADE_PROPS.entrySet().stream()
				.filter(e -> e.getKey().getAxisDirection().equals(Direction.AxisDirection.POSITIVE))
				.forEach(e -> {
					boolean isRotated = e.getKey().getAxis().equals(Direction.Axis.X);
					palisadeSidePart(builder, modelPalisadeSide(baseName, baseName, false, false), e, PalisadeConnection.FULL, isRotated);
					palisadeSidePart(builder, modelPalisadeSide(baseName, baseName, false, true), e, PalisadeConnection.SPIKED, isRotated);
				});
	}

	protected static final Map<Direction, BooleanProperty> SPIKED_PALISADE_PROPS = PipeBlock.PROPERTY_BY_DIRECTION
			.entrySet()
			.stream()
			.filter(p_52346_ -> p_52346_.getKey().getAxis().isHorizontal())
			.collect(Util.toMap());

	public void spikedPalisadeBlock(SpikedPalisadeBlock block, String textureName) {
		String baseName = name(block);

		MultiPartBlockStateBuilder builder = getMultipartBuilder(block)
				.part().modelFile(modelSpikedPalisadePost(baseName, textureName)).addModel().end();

		SPIKED_PALISADE_PROPS.entrySet().stream()
				.filter(e -> e.getKey().getAxisDirection().equals(Direction.AxisDirection.NEGATIVE))
				.forEach(e -> {
					boolean isRotated = e.getKey().getAxis().equals(Direction.Axis.X);
					spikedPalisadeSidePart(builder, modelPalisadeSide(textureName, textureName, true, true), e, isRotated);
				});
		SPIKED_PALISADE_PROPS.entrySet().stream()
				.filter(e -> e.getKey().getAxisDirection().equals(Direction.AxisDirection.POSITIVE))
				.forEach(e -> {
					boolean isRotated = e.getKey().getAxis().equals(Direction.Axis.X);
					spikedPalisadeSidePart(builder, modelPalisadeSide(textureName, textureName, false, true), e, isRotated);
				});
	}

	private void palisadeSidePart(MultiPartBlockStateBuilder builder, ModelFile model, Map.Entry<Direction, Property<PalisadeConnection>> entry, PalisadeConnection connection, boolean rotated) {
		builder.part()
				.modelFile(model)
				.rotationY(rotated ? 270 : 0)
				.uvLock(!rotated)
				.addModel()
				.condition(entry.getValue(), connection);
	}

	private void spikedPalisadeSidePart(MultiPartBlockStateBuilder builder, ModelFile model, Map.Entry<Direction, BooleanProperty> entry, boolean rotated) {
		builder.part()
				.modelFile(model)
				.rotationY(rotated ? 270 : 0)
				.uvLock(!rotated)
				.addModel()
				.condition(entry.getValue(), true);
	}

	private ModelFile modelPalisadePost(String baseName, String textureName) {
		return models().withExistingParent(baseName + "_post", resourceBlock("template_palisade_post"))
				.texture("top", resourceBlock(textureName + "_top"))
				.texture("side", resourceBlock(textureName + "_side"));
	}

	private ModelFile modelSpikedPalisadePost(String baseName, String textureName) {
		return models().withExistingParent(baseName + "_post", resourceBlock("template_spiked_palisade_post"))
				.texture("top", resourceBlock(textureName + "_top")).renderType(CUTOUT)
				.texture("side", resourceBlock(textureName + "_side"));
	}

	private ModelFile modelPalisadeSide(String baseName, String textureName, boolean isFront, boolean isSpiked) {
		String suffix = isFront ? "_front" : "_back";
		String spiked = isSpiked ? "spiked_" : "";
		return models().withExistingParent(spiked + baseName + suffix, resourceBlock("template_" + spiked + "palisade" + suffix))
				.texture("top", resourceBlock(textureName + "_top")).renderType(CUTOUT)
				.texture("side", resourceBlock(textureName + "_side"))
				.texture("core", resourceBlock(textureName + "_core"));
	}

	public static ResourceLocation resourceBlock(String name) {
		return ResourceLocation.fromNamespaceAndPath(BuildingBigger.MODID, ModelProvider.BLOCK_FOLDER + "/" + name);
	}

	private static ResourceLocation key(Block block) {
		return BuiltInRegistries.BLOCK.getKey(block);
	}

	private String name(Block block) {
		return key(block).getPath();
	}

	private ResourceLocation blockTexture(String name) {
		return ResourceLocation.fromNamespaceAndPath(BuildingBigger.MODID, name);
	}
}
