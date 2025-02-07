package vectorwing.blockbox.data.provider;

import com.google.common.collect.ImmutableMap;
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
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.common.block.BrazierBlock;
import vectorwing.blockbox.common.block.PalisadeBlock;
import vectorwing.blockbox.common.block.SpikedPalisadeBlock;
import vectorwing.blockbox.common.block.state.PalisadeConnection;
import vectorwing.blockbox.common.registry.ModBlocks;

import java.util.List;
import java.util.Map;

public class BlockStates extends BlockStateProvider
{
	public static final ResourceLocation CUTOUT = ResourceLocation.parse(RenderType.CUTOUT.name);

	public BlockStates(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, BlockBox.MODID, existingFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		blockWithStairAndSlab(ModBlocks.SANDSTONE_BRICKS.get(), ModBlocks.SANDSTONE_BRICK_STAIRS.get(), ModBlocks.SANDSTONE_BRICK_SLAB.get());
		blockWithStairAndSlab(ModBlocks.RED_SANDSTONE_BRICKS.get(), ModBlocks.RED_SANDSTONE_BRICK_STAIRS.get(), ModBlocks.RED_SANDSTONE_BRICK_SLAB.get());

		blockWithStairAndSlab(ModBlocks.CLAY_TILES.get(), ModBlocks.CLAY_TILE_STAIRS.get(), ModBlocks.CLAY_TILE_SLAB.get());

		blockWithVariations(ModBlocks.JAGGED_CLAY_TILES.get(), List.of("a", "b", "c"));

		simpleBlock(ModBlocks.POLISHED_PACKED_ICE.get());
		blockWithStairAndSlab(ModBlocks.SNOW_BRICKS.get(), ModBlocks.SNOW_BRICK_STAIRS.get(), ModBlocks.SNOW_BRICK_SLAB.get());
		wallBlock((WallBlock) ModBlocks.SNOW_BRICK_WALL.get(), resourceBlock(name(ModBlocks.SNOW_BRICKS.get())));
		simpleBlock(ModBlocks.PACKED_SNOW.get());
		blockWithStairAndSlab(ModBlocks.PACKED_ICE_BRICKS.get(), ModBlocks.PACKED_ICE_BRICK_STAIRS.get(), ModBlocks.PACKED_ICE_BRICK_SLAB.get());
		wallBlock((WallBlock) ModBlocks.PACKED_ICE_BRICK_WALL.get(), resourceBlock(name(ModBlocks.PACKED_ICE_BRICKS.get())));

		simpleBlock(ModBlocks.POLISHED_OBSIDIAN.get());

		simpleBlock(ModBlocks.IRON_PLATE.get());
		blockWithStairAndSlab(ModBlocks.IRON_TREAD_PLATE.get(), ModBlocks.IRON_TREAD_PLATE_STAIRS.get(), ModBlocks.IRON_TREAD_PLATE_SLAB.get());
		blockWithStairAndSlab(ModBlocks.CORRUGATED_IRON_PLATE.get(), ModBlocks.CORRUGATED_IRON_PLATE_STAIRS.get(), ModBlocks.CORRUGATED_IRON_PLATE_SLAB.get());
		axisBlock((RotatedPillarBlock) ModBlocks.IRON_PLATE_PILLAR.get());
		doorBlockWithRenderType((DoorBlock) ModBlocks.IRON_PLATE_DOOR.get(), resourceBlock("iron_plate_door_bottom"), resourceBlock("iron_plate_door_top"), RenderType.CUTOUT.name);
		ironPlateTrapdoor((TrapDoorBlock) ModBlocks.IRON_PLATE_TRAPDOOR.get(), key(ModBlocks.IRON_PLATE_TRAPDOOR.get()).toString(), resourceBlock("iron_plate_trapdoor"), ResourceLocation.tryParse(RenderType.CUTOUT.name));

		simpleBlock(ModBlocks.CHISELED_GOLD.get());
		simpleBlock(ModBlocks.GOLDEN_TILES.get());
		blockWithStairAndSlab(ModBlocks.GOLDEN_BRICKS.get(), ModBlocks.GOLDEN_BRICK_STAIRS.get(), ModBlocks.GOLDEN_BRICK_SLAB.get());
		axisBlock((RotatedPillarBlock) ModBlocks.GOLDEN_PILLAR.get());
		doorBlockWithRenderType((DoorBlock) ModBlocks.GOLDEN_DOOR.get(), resourceBlock("golden_door_bottom"), resourceBlock("golden_door_top"), RenderType.CUTOUT.name);
		trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.GOLDEN_TRAPDOOR.get(), resourceBlock("golden_trapdoor"), false, RenderType.CUTOUT.name);

		goldenBars(ModBlocks.GOLDEN_BARS.get(), name(ModBlocks.GOLDEN_BARS.get()));

		copperBars(ModBlocks.COPPER_BARS.get(), ModBlocks.WAXED_COPPER_BARS.get());
		copperBars(ModBlocks.EXPOSED_COPPER_BARS.get(), ModBlocks.WAXED_EXPOSED_COPPER_BARS.get());
		copperBars(ModBlocks.WEATHERED_COPPER_BARS.get(), ModBlocks.WAXED_WEATHERED_COPPER_BARS.get());
		copperBars(ModBlocks.OXIDIZED_COPPER_BARS.get(), ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get());

		copperPillar(ModBlocks.COPPER_PILLAR.get(), ModBlocks.WAXED_COPPER_PILLAR.get());
		copperPillar(ModBlocks.EXPOSED_COPPER_PILLAR.get(), ModBlocks.WAXED_EXPOSED_COPPER_PILLAR.get());
		copperPillar(ModBlocks.WEATHERED_COPPER_PILLAR.get(), ModBlocks.WAXED_WEATHERED_COPPER_PILLAR.get());
		copperPillar(ModBlocks.OXIDIZED_COPPER_PILLAR.get(), ModBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get());

		simpleBlock(ModBlocks.POLISHED_AMETHYST.get());
		blockWithStairAndSlab(ModBlocks.CUT_AMETHYST.get(), ModBlocks.CUT_AMETHYST_STAIRS.get(), ModBlocks.CUT_AMETHYST_SLAB.get());
		blockWithStairAndSlab(ModBlocks.CHISELED_AMETHYST.get(), ModBlocks.CHISELED_AMETHYST_STAIRS.get(), ModBlocks.CHISELED_AMETHYST_SLAB.get());

		blockWithStairAndSlab(ModBlocks.LAPIS_LAZULI_BRICKS.get(), ModBlocks.LAPIS_LAZULI_BRICK_STAIRS.get(), ModBlocks.LAPIS_LAZULI_BRICK_SLAB.get());
		blockWithStairAndSlab(ModBlocks.LAPIS_LAZULI_MOSAIC.get(), ModBlocks.LAPIS_LAZULI_MOSAIC_STAIRS.get(), ModBlocks.LAPIS_LAZULI_MOSAIC_SLAB.get());

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

		seatBlock(ModBlocks.OAK_SEAT.get());
		seatBlock(ModBlocks.SPRUCE_SEAT.get());
		seatBlock(ModBlocks.BIRCH_SEAT.get());
		seatBlock(ModBlocks.JUNGLE_SEAT.get());
		seatBlock(ModBlocks.ACACIA_SEAT.get());
		seatBlock(ModBlocks.DARK_OAK_SEAT.get());
		seatBlock(ModBlocks.MANGROVE_SEAT.get());
		seatBlock(ModBlocks.CHERRY_SEAT.get());
		seatBlock(ModBlocks.BAMBOO_SEAT.get());
		seatBlock(ModBlocks.CRIMSON_SEAT.get());
		seatBlock(ModBlocks.WARPED_SEAT.get());

		brazierBlock(ModBlocks.BRAZIER.get(), Blocks.CAMPFIRE);
		brazierBlock(ModBlocks.SOUL_BRAZIER.get(), Blocks.SOUL_CAMPFIRE);

		skyLanternBlock(ModBlocks.WHITE_SKY_LANTERN.get(), Blocks.WHITE_CANDLE);
		skyLanternBlock(ModBlocks.LIGHT_GRAY_SKY_LANTERN.get(), Blocks.LIGHT_GRAY_CANDLE);
		skyLanternBlock(ModBlocks.GRAY_SKY_LANTERN.get(), Blocks.GRAY_CANDLE);
		skyLanternBlock(ModBlocks.BLACK_SKY_LANTERN.get(), Blocks.BLACK_CANDLE);
		skyLanternBlock(ModBlocks.BROWN_SKY_LANTERN.get(), Blocks.BROWN_CANDLE);
		skyLanternBlock(ModBlocks.RED_SKY_LANTERN.get(), Blocks.RED_CANDLE);
		skyLanternBlock(ModBlocks.ORANGE_SKY_LANTERN.get(), Blocks.ORANGE_CANDLE);
		skyLanternBlock(ModBlocks.YELLOW_SKY_LANTERN.get(), Blocks.YELLOW_CANDLE);
		skyLanternBlock(ModBlocks.LIME_SKY_LANTERN.get(), Blocks.LIME_CANDLE);
		skyLanternBlock(ModBlocks.GREEN_SKY_LANTERN.get(), Blocks.GREEN_CANDLE);
		skyLanternBlock(ModBlocks.CYAN_SKY_LANTERN.get(), Blocks.CYAN_CANDLE);
		skyLanternBlock(ModBlocks.LIGHT_BLUE_SKY_LANTERN.get(), Blocks.LIGHT_BLUE_CANDLE);
		skyLanternBlock(ModBlocks.BLUE_SKY_LANTERN.get(), Blocks.BLUE_CANDLE);
		skyLanternBlock(ModBlocks.PURPLE_SKY_LANTERN.get(), Blocks.PURPLE_CANDLE);
		skyLanternBlock(ModBlocks.MAGENTA_SKY_LANTERN.get(), Blocks.MAGENTA_CANDLE);
		skyLanternBlock(ModBlocks.PINK_SKY_LANTERN.get(), Blocks.PINK_CANDLE);
	}

	/**
	 * Creates a simple blockstate with random variations based on a list of suffixes. The first element is always the base name with no suffix.
	 */
	private void blockWithVariations(Block block, List<String> variationSuffixes) {
		VariantBlockStateBuilder.PartialBlockstate partialBlockstate = getVariantBuilder(block).partialState();

		String baseName = name(block);
		partialBlockstate.addModels(new ConfiguredModel(models().cubeAll(baseName, resourceBlock(baseName))));

		for (String suffix : variationSuffixes) {
			String variantName = baseName + "_" + suffix;
			partialBlockstate.addModels(new ConfiguredModel(models().cubeAll(variantName, resourceBlock(variantName))));
		}
	}

	private void seatBlock(Block block) {
		String baseName = name(block);
		horizontalBlock(block, models().withExistingParent(baseName, resourceBlock("template_seat"))
				.texture("top", resourceBlock(baseName + "_top"))
				.texture("side", resourceBlock(baseName + "_side")));
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

	private void copperPillar(Block block, Block waxedBlock) {
		axisBlock((RotatedPillarBlock) block);
		axisBlock((RotatedPillarBlock) waxedBlock, resourceBlock(name(block)));
	}

	private void copperBars(Block block, Block waxedBlock) {
		String textureName = name(block);
		flatBarsBlock(block, textureName);
		flatBarsBlock(waxedBlock, textureName);
	}

	private void flatBarsBlock(Block block, String textureName) {
		ResourceLocation textureSide = resourceBlock(textureName);
		ResourceLocation textureSingle = resourceBlock(textureName + "_single");

		ModelFile cap = models().singleTexture(textureName + "_cap", resourceBlock("template_bars_cap"), "bars", textureSide);
		ModelFile capAlt = models().singleTexture(textureName + "_cap_alt", resourceBlock("template_bars_cap_alt"), "bars", textureSide);
		ModelFile post = models().singleTexture(textureName + "_post", resourceBlock("template_bars_post"), "bars", textureSingle);
		ModelFile postEnds = models().singleTexture(textureName + "_post_ends", resourceBlock("template_bars_post_ends"), "edge", textureSide);
		ModelFile side = models().singleTexture(textureName + "_side", resourceBlock("template_bars_side_flat"), "bars", textureSide);
		ModelFile sideAlt = models().singleTexture(textureName + "_side_alt", resourceBlock("template_bars_side_flat_alt"), "bars", textureSide);

		MultiPartBlockStateBuilder builder = getMultipartBuilder(block);

		builder.part().modelFile(post).addModel()
				.condition(PipeBlock.NORTH, false)
				.condition(PipeBlock.EAST, false)
				.condition(PipeBlock.SOUTH, false)
				.condition(PipeBlock.WEST, false);
		builder.part().modelFile(postEnds).addModel()
				.condition(PipeBlock.NORTH, false)
				.condition(PipeBlock.EAST, false)
				.condition(PipeBlock.SOUTH, false)
				.condition(PipeBlock.WEST, false);

		PipeBlock.PROPERTY_BY_DIRECTION.forEach((dir, value) -> {
			if (dir.getAxis().isHorizontal()) {
				boolean isNorthEast = dir == Direction.NORTH || dir == Direction.EAST;

				builder.part().modelFile(isNorthEast ? cap : capAlt).rotationY(dir.getAxis() == Direction.Axis.X ? 90 : 0).addModel()
						.condition(PipeBlock.NORTH, dir.equals(Direction.NORTH))
						.condition(PipeBlock.EAST, dir.equals(Direction.EAST))
						.condition(PipeBlock.SOUTH, dir.equals(Direction.SOUTH))
						.condition(PipeBlock.WEST, dir.equals(Direction.WEST));
			}
		});

		PipeBlock.PROPERTY_BY_DIRECTION.forEach((dir, value) -> {
			if (dir.getAxis().isHorizontal()) {
				boolean isNorthEast = dir == Direction.NORTH || dir == Direction.EAST;

				builder.part().modelFile(isNorthEast ? side : sideAlt).rotationY(dir.getAxis() == Direction.Axis.X ? 90 : 0).addModel()
						.condition(value, true);
			}
		});
	}

	private void goldenBars(Block block, String textureName) {
		ResourceLocation textureSide = resourceBlock(textureName);
		ResourceLocation textureSingle = resourceBlock(textureName + "_single");

		ModelFile post = models().singleTexture(textureName + "_post", resourceBlock("template_bars_post"), "bars", textureSingle);
		ModelFile postEnds = models().singleTexture(textureName + "_post_ends", resourceBlock("template_bars_post_ends"), "edge", textureSingle);
		ModelFile side = models().withExistingParent(textureName + "_side", resourceBlock("template_bars_side"))
				.texture("bars", textureSide)
				.texture("edge", textureSingle);
		ModelFile sideAlt = models().withExistingParent(textureName + "_side_alt", resourceBlock("template_bars_side_alt"))
				.texture("bars", textureSide)
				.texture("edge", textureSingle);

		MultiPartBlockStateBuilder builder = getMultipartBuilder(block);

		builder.part().modelFile(postEnds).addModel();
		builder.part().modelFile(post).addModel()
				.condition(PipeBlock.NORTH, false)
				.condition(PipeBlock.EAST, false)
				.condition(PipeBlock.SOUTH, false)
				.condition(PipeBlock.WEST, false);

		PipeBlock.PROPERTY_BY_DIRECTION.forEach((dir, value) -> {
			if (dir.getAxis().isHorizontal()) {
				boolean isNorthEast = dir == Direction.NORTH || dir == Direction.EAST;

				builder.part().modelFile(isNorthEast ? side : sideAlt).rotationY(dir.getAxis() == Direction.Axis.X ? 90 : 0).addModel()
						.condition(value, true);
			}
		});
	}

	// HELPER METHODS

	public void blockWithStairAndSlab(Block block, Block stair, Block slab) {
		simpleBlock(block);

		ResourceLocation texture = resourceBlock(name(block));
		stairsBlock((StairBlock) stair, texture);
		slabBlock((SlabBlock) slab, texture, texture);
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

	protected static final ImmutableMap<Direction, BooleanProperty> SPIKED_PALISADE_PROPS = ImmutableMap.<Direction, BooleanProperty>builder()
			.put(Direction.EAST, CrossCollisionBlock.EAST)
			.put(Direction.NORTH, CrossCollisionBlock.NORTH)
			.put(Direction.SOUTH, CrossCollisionBlock.SOUTH)
			.put(Direction.WEST, CrossCollisionBlock.WEST)
			.build();

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

	private void skyLanternBlock(Block block, Block candle) {
		String baseName = name(block);
		simpleBlock(block, models().withExistingParent(baseName, resourceBlock("template_sky_lantern"))
				.texture("top", resourceBlock(baseName + "_top"))
				.texture("side", resourceBlock(baseName + "_side"))
				.texture("inner_top", resourceBlock(baseName + "_inner_top"))
				.texture("inner_side", resourceBlock(baseName + "_inner_side"))
				.texture("bottom", resourceBlock("sky_lantern_bottom"))
				.texture("candle", resourceMcBlock(name(candle) + "_lit"))
		);
	}

	private void brazierBlock(Block block, Block campfire) {
		String baseName = name(block);
		String campfireName = name(campfire);
		ModelFile standing = models().withExistingParent(baseName, resourceBlock("template_brazier"))
				.texture("top", resourceBlock(baseName + "_top"))
				.texture("side", resourceBlock("brazier_side"))
				.texture("bottom", resourceBlock("brazier_bottom"));
		ModelFile standingLit = models().withExistingParent(baseName + "_lit", resourceBlock("template_brazier_lit"))
				.texture("top", resourceBlock(baseName + "_top_lit"))
				.texture("side", resourceBlock(baseName + "_side_lit"))
				.texture("bottom", resourceBlock("brazier_bottom"))
				.texture("fire", resourceMcBlock(campfireName + "_fire"));
		ModelFile hanging = models().withExistingParent("hanging_" + baseName, resourceBlock("template_hanging_brazier"))
				.texture("top", resourceBlock(baseName + "_top"))
				.texture("side", resourceBlock("hanging_brazier_side"))
				.texture("bottom", resourceBlock("brazier_bottom"));
		ModelFile hangingLit = models().withExistingParent("hanging_" + baseName + "_lit", resourceBlock("template_hanging_brazier_lit"))
				.texture("top", resourceBlock(baseName + "_top_lit"))
				.texture("side", resourceBlock("hanging_" + baseName + "_side_lit"))
				.texture("bottom", resourceBlock("brazier_bottom"))
				.texture("fire", resourceMcBlock(campfireName + "_fire"));
		getVariantBuilder(block)
				.partialState().with(BrazierBlock.HANGING, false).with(BrazierBlock.LIT, false)
				.modelForState().modelFile(standing).addModel()
				.partialState().with(BrazierBlock.HANGING, false).with(BrazierBlock.LIT, true)
				.modelForState().modelFile(standingLit).addModel()
				.partialState().with(BrazierBlock.HANGING, true).with(BrazierBlock.LIT, false)
				.modelForState().modelFile(hanging).addModel()
				.partialState().with(BrazierBlock.HANGING, true).with(BrazierBlock.LIT, true)
				.modelForState().modelFile(hangingLit).addModel();
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
		return ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, ModelProvider.BLOCK_FOLDER + "/" + name);
	}

	public static ResourceLocation resourceMcBlock(String name) {
		return ResourceLocation.parse(ModelProvider.BLOCK_FOLDER + "/" + name);
	}

	private static ResourceLocation key(Block block) {
		return BuiltInRegistries.BLOCK.getKey(block);
	}

	private String name(Block block) {
		return key(block).getPath();
	}

	public ModelFile existingModel(Block block) {
		return new ModelFile.ExistingModelFile(resourceBlock(name(block)), models().existingFileHelper);
	}
}
