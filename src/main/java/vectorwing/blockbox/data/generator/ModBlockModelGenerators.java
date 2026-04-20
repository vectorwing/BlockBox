package vectorwing.blockbox.data.generator;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import vectorwing.blockbox.common.block.BrazierBlock;
import vectorwing.blockbox.common.block.PalisadeBlock;
import vectorwing.blockbox.common.block.SpikedPalisadeBlock;
import vectorwing.blockbox.common.block.state.PalisadeConnection;
import vectorwing.blockbox.common.registry.ModBlocks;
import vectorwing.blockbox.data.ModBlockFamilies;
import vectorwing.blockbox.data.model.ModModelTemplates;
import vectorwing.blockbox.data.model.ModTextureMappings;

import java.util.Optional;

public class ModBlockModelGenerators extends BlockModelGenerators
{
	public ModBlockModelGenerators(BlockModelGenerators generators) {
		super(generators.blockStateOutput, generators.itemModelOutput, generators.modelOutput);
	}

	@Override
	public void run() {
		ModBlockFamilies.getAllFamilies()
				.filter(BlockFamily::shouldGenerateModel)
				.forEach(blockFamily -> family(blockFamily.getBaseBlock()).generateFor(blockFamily));
		createTrivialCube(ModBlocks.BROKEN_TILE_MOSAIC.get());
		createTrivialCube(ModBlocks.PACKED_SNOW.get());
		createPumpkinVariant(ModBlocks.CARVED_SNOW.get(), TextureMapping.cube(ModBlocks.PACKED_SNOW.get()));
		createTrivialCube(ModBlocks.POLISHED_PACKED_ICE.get());
		createTrivialCube(ModBlocks.POLISHED_OBSIDIAN.get());
		createModGlassBlocks(ModBlocks.ROUGH_GLASS.get(), ModBlocks.ROUGH_GLASS_PANE.get());
		createPillar(ModBlocks.IRON_PLATE_PILLAR.get());
		createTrivialCube(ModBlocks.CHISELED_GOLD.get());
		createTrivialCube(ModBlocks.GOLDEN_TILES.get());
		createPillar(ModBlocks.GOLDEN_PILLAR.get());
		createDoor(ModBlocks.GOLDEN_DOOR.get());
		createTrapdoor(ModBlocks.GOLDEN_TRAPDOOR.get());
		createModBarsAndItem(ModBlocks.GOLDEN_BARS.get());
		createCopperLattices();
		createCopperPillars();
		createTrivialCube(ModBlocks.POLISHED_AMETHYST.get());
		createPalisades();
		createSeats();
		createBrazier(ModBlocks.BRAZIER.get(), Blocks.CAMPFIRE);
		createBrazier(ModBlocks.SOUL_BRAZIER.get(), Blocks.SOUL_CAMPFIRE);
		createSkyLanterns();
	}

	public void createCopperLattices() {
		createFlatBarsAndItem(ModBlocks.COPPER_LATTICE.get(), ModBlocks.WAXED_COPPER_LATTICE.get());
		createFlatBarsAndItem(ModBlocks.EXPOSED_COPPER_LATTICE.get(), ModBlocks.WAXED_EXPOSED_COPPER_LATTICE.get());
		createFlatBarsAndItem(ModBlocks.WEATHERED_COPPER_LATTICE.get(), ModBlocks.WAXED_WEATHERED_COPPER_LATTICE.get());
		createFlatBarsAndItem(ModBlocks.OXIDIZED_COPPER_LATTICE.get(), ModBlocks.WAXED_OXIDIZED_COPPER_LATTICE.get());
	}

	public void createCopperPillars() {
		createWaxablePillar(ModBlocks.COPPER_PILLAR.get(), ModBlocks.WAXED_COPPER_PILLAR.get());
		createWaxablePillar(ModBlocks.EXPOSED_COPPER_PILLAR.get(), ModBlocks.WAXED_EXPOSED_COPPER_PILLAR.get());
		createWaxablePillar(ModBlocks.WEATHERED_COPPER_PILLAR.get(), ModBlocks.WAXED_WEATHERED_COPPER_PILLAR.get());
		createWaxablePillar(ModBlocks.OXIDIZED_COPPER_PILLAR.get(), ModBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get());
	}

	public void createPalisades() {
		createPalisadeAndSpikedPalisade(ModBlocks.OAK_PALISADE.get(), ModBlocks.SPIKED_OAK_PALISADE.get());
		createPalisadeAndSpikedPalisade(ModBlocks.SPRUCE_PALISADE.get(), ModBlocks.SPIKED_SPRUCE_PALISADE.get());
		createPalisadeAndSpikedPalisade(ModBlocks.BIRCH_PALISADE.get(), ModBlocks.SPIKED_BIRCH_PALISADE.get());
		createPalisadeAndSpikedPalisade(ModBlocks.JUNGLE_PALISADE.get(), ModBlocks.SPIKED_JUNGLE_PALISADE.get());
		createPalisadeAndSpikedPalisade(ModBlocks.ACACIA_PALISADE.get(), ModBlocks.SPIKED_ACACIA_PALISADE.get());
		createPalisadeAndSpikedPalisade(ModBlocks.DARK_OAK_PALISADE.get(), ModBlocks.SPIKED_DARK_OAK_PALISADE.get());
		createPalisadeAndSpikedPalisade(ModBlocks.MANGROVE_PALISADE.get(), ModBlocks.SPIKED_MANGROVE_PALISADE.get());
		createPalisadeAndSpikedPalisade(ModBlocks.CHERRY_PALISADE.get(), ModBlocks.SPIKED_CHERRY_PALISADE.get());
		createPalisadeAndSpikedPalisade(ModBlocks.CRIMSON_PALISADE.get(), ModBlocks.SPIKED_CRIMSON_PALISADE.get());
		createPalisadeAndSpikedPalisade(ModBlocks.WARPED_PALISADE.get(), ModBlocks.SPIKED_WARPED_PALISADE.get());
		createPalisadeAndSpikedPalisade(ModBlocks.STRIPPED_OAK_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_OAK_PALISADE.get());
		createPalisadeAndSpikedPalisade(ModBlocks.STRIPPED_SPRUCE_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_SPRUCE_PALISADE.get());
		createPalisadeAndSpikedPalisade(ModBlocks.STRIPPED_BIRCH_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_BIRCH_PALISADE.get());
		createPalisadeAndSpikedPalisade(ModBlocks.STRIPPED_JUNGLE_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_JUNGLE_PALISADE.get());
		createPalisadeAndSpikedPalisade(ModBlocks.STRIPPED_ACACIA_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_ACACIA_PALISADE.get());
		createPalisadeAndSpikedPalisade(ModBlocks.STRIPPED_DARK_OAK_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_DARK_OAK_PALISADE.get());
		createPalisadeAndSpikedPalisade(ModBlocks.STRIPPED_MANGROVE_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_MANGROVE_PALISADE.get());
		createPalisadeAndSpikedPalisade(ModBlocks.STRIPPED_CHERRY_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_CHERRY_PALISADE.get());
		createPalisadeAndSpikedPalisade(ModBlocks.STRIPPED_CRIMSON_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_CRIMSON_PALISADE.get());
		createPalisadeAndSpikedPalisade(ModBlocks.STRIPPED_WARPED_PALISADE.get(), ModBlocks.STRIPPED_SPIKED_WARPED_PALISADE.get());
	}

	public void createSeats() {
		createSeat(ModBlocks.OAK_SEAT.get());
		createSeat(ModBlocks.SPRUCE_SEAT.get());
		createSeat(ModBlocks.BIRCH_SEAT.get());
		createSeat(ModBlocks.JUNGLE_SEAT.get());
		createSeat(ModBlocks.ACACIA_SEAT.get());
		createSeat(ModBlocks.DARK_OAK_SEAT.get());
		createSeat(ModBlocks.MANGROVE_SEAT.get());
		createSeat(ModBlocks.CHERRY_SEAT.get());
		createSeat(ModBlocks.BAMBOO_SEAT.get());
		createSeat(ModBlocks.CRIMSON_SEAT.get());
		createSeat(ModBlocks.WARPED_SEAT.get());
	}

	public void createSkyLanterns() {
		createSkyLantern(ModBlocks.WHITE_SKY_LANTERN.get(), Blocks.WHITE_CANDLE);
		createSkyLantern(ModBlocks.LIGHT_GRAY_SKY_LANTERN.get(), Blocks.LIGHT_GRAY_CANDLE);
		createSkyLantern(ModBlocks.GRAY_SKY_LANTERN.get(), Blocks.GRAY_CANDLE);
		createSkyLantern(ModBlocks.BLACK_SKY_LANTERN.get(), Blocks.BLACK_CANDLE);
		createSkyLantern(ModBlocks.BROWN_SKY_LANTERN.get(), Blocks.BROWN_CANDLE);
		createSkyLantern(ModBlocks.RED_SKY_LANTERN.get(), Blocks.RED_CANDLE);
		createSkyLantern(ModBlocks.ORANGE_SKY_LANTERN.get(), Blocks.ORANGE_CANDLE);
		createSkyLantern(ModBlocks.YELLOW_SKY_LANTERN.get(), Blocks.YELLOW_CANDLE);
		createSkyLantern(ModBlocks.LIME_SKY_LANTERN.get(), Blocks.LIME_CANDLE);
		createSkyLantern(ModBlocks.GREEN_SKY_LANTERN.get(), Blocks.GREEN_CANDLE);
		createSkyLantern(ModBlocks.CYAN_SKY_LANTERN.get(), Blocks.CYAN_CANDLE);
		createSkyLantern(ModBlocks.LIGHT_BLUE_SKY_LANTERN.get(), Blocks.LIGHT_BLUE_CANDLE);
		createSkyLantern(ModBlocks.BLUE_SKY_LANTERN.get(), Blocks.BLUE_CANDLE);
		createSkyLantern(ModBlocks.PURPLE_SKY_LANTERN.get(), Blocks.PURPLE_CANDLE);
		createSkyLantern(ModBlocks.MAGENTA_SKY_LANTERN.get(), Blocks.MAGENTA_CANDLE);
		createSkyLantern(ModBlocks.PINK_SKY_LANTERN.get(), Blocks.PINK_CANDLE);
	}

	public void createModGlassBlocks(Block block, Block pane) {
		createTrivialBlock(block, TexturedModel.CUBE.updateTexture(TextureMapping::forceAllTranslucent));
		TextureMapping paneMapping = TextureMapping.pane(block, Blocks.GLASS_PANE).forceAllTranslucent();
		MultiVariant post = plainVariant(ModelTemplates.STAINED_GLASS_PANE_POST.create(pane, paneMapping, modelOutput));
		MultiVariant side = plainVariant(ModelTemplates.STAINED_GLASS_PANE_SIDE.create(pane, paneMapping, modelOutput));
		MultiVariant sideAlt = plainVariant(ModelTemplates.STAINED_GLASS_PANE_SIDE_ALT.create(pane, paneMapping, modelOutput));
		MultiVariant noSide = plainVariant(ModelTemplates.STAINED_GLASS_PANE_NOSIDE.create(pane, paneMapping, modelOutput));
		MultiVariant noSideAlt = plainVariant(ModelTemplates.STAINED_GLASS_PANE_NOSIDE_ALT.create(pane, paneMapping, modelOutput));
		Item paneItem = pane.asItem();
		registerSimpleItemModel(paneItem, createFlatItemModelWithBlockTexture(paneItem, block));
		blockStateOutput.accept(MultiPartGenerator.multiPart(pane)
				.with(post)
				.with(condition().term(BlockStateProperties.NORTH, true), side)
				.with(condition().term(BlockStateProperties.EAST, true), side.with(Y_ROT_90))
				.with(condition().term(BlockStateProperties.SOUTH, true), sideAlt)
				.with(condition().term(BlockStateProperties.WEST, true), sideAlt.with(Y_ROT_90))
				.with(condition().term(BlockStateProperties.NORTH, false), noSide)
				.with(condition().term(BlockStateProperties.EAST, false), noSideAlt)
				.with(condition().term(BlockStateProperties.SOUTH, false), noSideAlt.with(Y_ROT_90))
				.with(condition().term(BlockStateProperties.WEST, false), noSide.with(Y_ROT_270)));
	}

	public void createPillar(Block block) {
		MultiVariant model = plainVariant(ModelTemplates.CUBE_COLUMN.create(block, ModTextureMappings.pillar(block), modelOutput));
		MultiVariant horizontalModel = plainVariant(ModelTemplates.CUBE_COLUMN_HORIZONTAL.create(block, ModTextureMappings.pillar(block), modelOutput));
		blockStateOutput.accept(createRotatedPillarWithHorizontalVariant(block, model, horizontalModel));
	}

	public void createModBarsAndItem(Block block) {
		TextureMapping mapping = ModTextureMappings.modBars(block);
		TextureMapping altMapping = ModTextureMappings.modBarsAlt(block);
		createModBars(block,
				ModModelTemplates.BARS_POST_ENDS.create(block, mapping, modelOutput),
				ModModelTemplates.BARS_POST.create(block, altMapping, modelOutput),
				ModModelTemplates.BARS_SIDE.create(block, mapping, modelOutput),
				ModModelTemplates.BARS_SIDE_ALT.create(block, mapping, modelOutput));
		registerSimpleFlatItemModel(block);
	}

	public void createModBars(Block block, Identifier postEndResource, Identifier postResource, Identifier sideResource, Identifier sideAltResource) {
		MultiVariant postEnds = plainVariant(postEndResource);
		MultiVariant post = plainVariant(postResource);
		MultiVariant side = plainVariant(sideResource);
		MultiVariant sideAlt = plainVariant(sideAltResource);
		blockStateOutput.accept(MultiPartGenerator.multiPart(block)
				.with(postEnds)
				.with(condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, false).term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, false), post)
				.with(condition().term(BlockStateProperties.NORTH, true), side)
				.with(condition().term(BlockStateProperties.EAST, true), side.with(Y_ROT_90))
				.with(condition().term(BlockStateProperties.SOUTH, true), sideAlt)
				.with(condition().term(BlockStateProperties.WEST, true), sideAlt.with(Y_ROT_90)));
	}

	public void createFlatBarsAndItem(Block unwaxed, Block waxed) {
		TextureMapping mapping = ModTextureMappings.modBars(unwaxed);
		TextureMapping altMapping = ModTextureMappings.modBarsAlt(unwaxed);
		MultiVariant post = plainVariant(ModModelTemplates.BARS_POST.create(unwaxed, altMapping, modelOutput));
		MultiVariant postEnds = plainVariant(ModModelTemplates.BARS_POST_ENDS.create(unwaxed, altMapping, modelOutput));
		MultiVariant cap = plainVariant(ModModelTemplates.BARS_CAP.create(unwaxed, mapping, modelOutput));
		MultiVariant capAlt = plainVariant(ModModelTemplates.BARS_CAP_ALT.create(unwaxed, mapping, modelOutput));
		MultiVariant side = plainVariant(ModModelTemplates.BARS_SIDE_FLAT.create(unwaxed, mapping, modelOutput));
		MultiVariant sideAlt = plainVariant(ModModelTemplates.BARS_SIDE_FLAT_ALT.create(unwaxed, mapping, modelOutput));
		blockStateOutput.accept(createFlatBars(unwaxed, post, postEnds, cap, capAlt, side, sideAlt));
		blockStateOutput.accept(createFlatBars(waxed, post, postEnds, cap, capAlt, side, sideAlt));
		registerSimpleFlatItemModel(unwaxed);
		itemModelOutput.copy(unwaxed.asItem(), waxed.asItem());
	}

	public void createWaxablePillar(Block unwaxed, Block waxed) {
		MultiVariant model = plainVariant(ModelTemplates.CUBE_COLUMN.create(unwaxed, ModTextureMappings.pillar(unwaxed), modelOutput));
		MultiVariant horizontalModel = plainVariant(ModelTemplates.CUBE_COLUMN_HORIZONTAL.create(unwaxed, ModTextureMappings.pillar(unwaxed), modelOutput));
		blockStateOutput.accept(createRotatedPillarWithHorizontalVariant(unwaxed, model, horizontalModel));
		blockStateOutput.accept(createRotatedPillarWithHorizontalVariant(waxed, model, horizontalModel));
		itemModelOutput.copy(unwaxed.asItem(), waxed.asItem());
	}

	public void createPalisadeAndSpikedPalisade(Block block, Block spiked) {

		TextureMapping mapping = ModTextureMappings.palisade(block);
		Identifier spikedPostModel = ModModelTemplates.SPIKED_PALISADE_POST.create(spiked, mapping, modelOutput);
		MultiVariant spikedPost = BlockModelGenerators.plainVariant(spikedPostModel);
		MultiVariant spikedFront = BlockModelGenerators.plainVariant(ModModelTemplates.SPIKED_PALISADE_FRONT.create(spiked, mapping, modelOutput));
		MultiVariant spikedBack = BlockModelGenerators.plainVariant(ModModelTemplates.SPIKED_PALISADE_BACK.create(spiked, mapping, modelOutput));
		blockStateOutput.accept(createSpikedPalisade(spiked, spikedPost, spikedFront, spikedBack));

		Identifier spikedItem = frontLight(spikedPostModel).create(spiked.asItem(), new TextureMapping(), modelOutput);
		registerSimpleItemModel(spiked, spikedItem);

		Identifier postModel = ModModelTemplates.PALISADE_POST.create(block, mapping, modelOutput);
		MultiVariant post = BlockModelGenerators.plainVariant(postModel);
		MultiVariant front = BlockModelGenerators.plainVariant(ModModelTemplates.PALISADE_FRONT.create(block, mapping, modelOutput));
		MultiVariant back = BlockModelGenerators.plainVariant(ModModelTemplates.PALISADE_BACK.create(block, mapping, modelOutput));
		blockStateOutput.accept(createPalisade(block, post, front, spikedFront, back, spikedBack));

		Identifier item = frontLight(postModel).create(block.asItem(), new TextureMapping(), modelOutput);
		registerSimpleItemModel(block, item);
	}

	public void createSeat(Block block) {
		MultiVariant model = plainVariant(ModModelTemplates.SEAT.create(block, ModTextureMappings.seat(block), modelOutput));
		blockStateOutput.accept(MultiVariantGenerator.dispatch(block, model).with(ROTATION_HORIZONTAL_FACING));
	}

	public void createBrazier(Block block, Block campfire) {
		MultiVariant standing = BlockModelGenerators.plainVariant(ModModelTemplates.BRAZIER.create(block, ModTextureMappings.brazier(block), modelOutput));
		MultiVariant hanging = BlockModelGenerators.plainVariant(ModModelTemplates.BRAZIER_HANGING.create(block, ModTextureMappings.brazierHanging(block), modelOutput));
		MultiVariant standingLit = BlockModelGenerators.plainVariant(ModModelTemplates.BRAZIER_LIT.create(block, ModTextureMappings.brazierLit(block, campfire), modelOutput));
		MultiVariant hangingLit = BlockModelGenerators.plainVariant(ModModelTemplates.BRAZIER_HANGING_LIT.create(block, ModTextureMappings.brazierHangingLit(block, campfire), modelOutput));
		blockStateOutput.accept(createBrazier(block, standing, standingLit, hanging, hangingLit));
		registerSimpleFlatItemModel(block.asItem());
	}

	public void createSkyLantern(Block block, Block candle) {
		TextureMapping mapping = ModTextureMappings.skyLantern(block, candle);
		blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, BlockModelGenerators.plainVariant(ModModelTemplates.SKY_LANTERN.create(block, mapping, modelOutput))));
		registerSimpleFlatItemModel(block.asItem());
	}

	private static ExtendedModelTemplate frontLight(Identifier model) {
		return new ModelTemplate(Optional.of(model), Optional.empty()).extend().guiLight(UnbakedModel.GuiLight.FRONT).build();
	}

	public static MultiPartGenerator createFlatBars(Block block, MultiVariant post, MultiVariant postEnds, MultiVariant cap, MultiVariant capAlt, MultiVariant side, MultiVariant sideAlt) {
		return MultiPartGenerator.multiPart(block)
				.with(condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, false).term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, false), post)
				.with(condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, false).term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, false), postEnds)
				.with(condition().term(BlockStateProperties.NORTH, true).term(BlockStateProperties.EAST, false).term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, false), cap)
				.with(condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, false).term(BlockStateProperties.SOUTH, true).term(BlockStateProperties.WEST, false), capAlt)
				.with(condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, false).term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, true), capAlt.with(Y_ROT_90))
				.with(condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, true).term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, false), cap.with(Y_ROT_90))
				.with(condition().term(BlockStateProperties.NORTH, true), side)
				.with(condition().term(BlockStateProperties.EAST, true), side.with(Y_ROT_90))
				.with(condition().term(BlockStateProperties.SOUTH, true), sideAlt)
				.with(condition().term(BlockStateProperties.WEST, true), sideAlt.with(Y_ROT_90));
	}

	public static MultiPartGenerator createPalisade(Block block, MultiVariant post, MultiVariant front, MultiVariant spikedFront, MultiVariant back, MultiVariant spikedBack) {
		return MultiPartGenerator.multiPart(block)
				.with(post)
				.with(condition(PalisadeBlock.TYPE_NORTH, PalisadeConnection.FULL), front.with(UV_LOCK))
				.with(condition(PalisadeBlock.TYPE_NORTH, PalisadeConnection.SPIKED), spikedFront.with(UV_LOCK))
				.with(condition(PalisadeBlock.TYPE_WEST, PalisadeConnection.FULL), front.with(Y_ROT_270))
				.with(condition(PalisadeBlock.TYPE_WEST, PalisadeConnection.SPIKED), spikedFront.with(Y_ROT_270))
				.with(condition(PalisadeBlock.TYPE_EAST, PalisadeConnection.FULL), back.with(Y_ROT_270))
				.with(condition(PalisadeBlock.TYPE_EAST, PalisadeConnection.SPIKED), spikedBack.with(Y_ROT_270))
				.with(condition(PalisadeBlock.TYPE_SOUTH, PalisadeConnection.FULL), back.with(UV_LOCK))
				.with(condition(PalisadeBlock.TYPE_SOUTH, PalisadeConnection.SPIKED), spikedBack.with(UV_LOCK));
	}

	public static MultiPartGenerator createSpikedPalisade(Block block, MultiVariant spikedPost, MultiVariant spikedFront, MultiVariant spikedBack) {
		return MultiPartGenerator.multiPart(block)
				.with(spikedPost)
				.with(condition(SpikedPalisadeBlock.NORTH, true), spikedFront.with(UV_LOCK))
				.with(condition(SpikedPalisadeBlock.WEST, true), spikedFront.with(Y_ROT_270))
				.with(condition(SpikedPalisadeBlock.EAST, true), spikedBack.with(Y_ROT_270))
				.with(condition(SpikedPalisadeBlock.SOUTH, true), spikedBack.with(UV_LOCK));
	}

	public static MultiVariantGenerator createBrazier(Block block, MultiVariant standing, MultiVariant standingLit, MultiVariant hanging, MultiVariant hangingLit) {
		return MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BrazierBlock.HANGING, BrazierBlock.LIT)
				.select(false, false, standing)
				.select(false, true, standingLit)
				.select(true, false, hanging)
				.select(true, true, hangingLit));
	}
}
