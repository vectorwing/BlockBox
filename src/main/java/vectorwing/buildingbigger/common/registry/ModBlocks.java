package vectorwing.buildingbigger.common.registry;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.buildingbigger.BuildingBigger;
import vectorwing.buildingbigger.common.block.*;

import java.util.function.Supplier;

public class ModBlocks
{
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BuildingBigger.MODID);

	public static final BlockBehaviour.Properties PROPERTIES_PACKED_SNOW = BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(0.6F).sound(SoundType.SNOW);
	public static final BlockBehaviour.Properties PROPERTIES_IRON_PLATE = BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(4.0F, 6.0F).sound(SoundType.NETHERITE_BLOCK);
	public static final BlockBehaviour.Properties PROPERTIES_PALISADE = BlockBehaviour.Properties.of().strength(2.0F).instrument(NoteBlockInstrument.BASS);

	public static final Supplier<Block> OAK_PALISADE = BLOCKS.register("oak_palisade", () -> palisade(MapColor.WOOD));
	public static final Supplier<Block> SPIKED_OAK_PALISADE = BLOCKS.register("spiked_oak_palisade", () -> spikedPalisade(MapColor.WOOD));
	public static final Supplier<Block> SPRUCE_PALISADE = BLOCKS.register("spruce_palisade", () -> palisade(MapColor.PODZOL));
	public static final Supplier<Block> SPIKED_SPRUCE_PALISADE = BLOCKS.register("spiked_spruce_palisade", () -> spikedPalisade(MapColor.PODZOL));
	public static final Supplier<Block> BIRCH_PALISADE = BLOCKS.register("birch_palisade", () -> palisade(MapColor.SAND));
	public static final Supplier<Block> SPIKED_BIRCH_PALISADE = BLOCKS.register("spiked_birch_palisade", () -> spikedPalisade(MapColor.SAND));
	public static final Supplier<Block> JUNGLE_PALISADE = BLOCKS.register("jungle_palisade", () -> palisade(MapColor.DIRT));
	public static final Supplier<Block> SPIKED_JUNGLE_PALISADE = BLOCKS.register("spiked_jungle_palisade", () -> spikedPalisade(MapColor.DIRT));
	public static final Supplier<Block> ACACIA_PALISADE = BLOCKS.register("acacia_palisade", () -> palisade(MapColor.COLOR_ORANGE));
	public static final Supplier<Block> SPIKED_ACACIA_PALISADE = BLOCKS.register("spiked_acacia_palisade", () -> spikedPalisade(MapColor.COLOR_ORANGE));
	public static final Supplier<Block> DARK_OAK_PALISADE = BLOCKS.register("dark_oak_palisade", () -> palisade(MapColor.COLOR_BROWN));
	public static final Supplier<Block> SPIKED_DARK_OAK_PALISADE = BLOCKS.register("spiked_dark_oak_palisade", () -> spikedPalisade(MapColor.COLOR_BROWN));
	public static final Supplier<Block> MANGROVE_PALISADE = BLOCKS.register("mangrove_palisade", () -> palisade(MapColor.COLOR_RED));
	public static final Supplier<Block> SPIKED_MANGROVE_PALISADE = BLOCKS.register("spiked_mangrove_palisade", () -> spikedPalisade(MapColor.COLOR_RED));
	public static final Supplier<Block> CHERRY_PALISADE = BLOCKS.register("cherry_palisade", () -> palisade(MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD));
	public static final Supplier<Block> SPIKED_CHERRY_PALISADE = BLOCKS.register("spiked_cherry_palisade", () -> spikedPalisade(MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD));
	public static final Supplier<Block> CRIMSON_PALISADE = BLOCKS.register("crimson_palisade", () -> netherPalisade(MapColor.CRIMSON_STEM));
	public static final Supplier<Block> SPIKED_CRIMSON_PALISADE = BLOCKS.register("spiked_crimson_palisade", () -> netherSpikedPalisade(MapColor.CRIMSON_STEM));
	public static final Supplier<Block> WARPED_PALISADE = BLOCKS.register("warped_palisade", () -> netherPalisade(MapColor.WARPED_STEM));
	public static final Supplier<Block> SPIKED_WARPED_PALISADE = BLOCKS.register("spiked_warped_palisade", () -> netherSpikedPalisade(MapColor.WARPED_STEM));

	public static final Supplier<Block> SANDSTONE_BRICKS = BLOCKS.registerSimpleBlock("sandstone_bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE));
	public static final Supplier<Block> SANDSTONE_BRICK_STAIRS = BLOCKS.register("sandstone_brick_stairs", () -> stair(ModBlocks.SANDSTONE_BRICKS.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
	public static final Supplier<Block> SANDSTONE_BRICK_SLAB = BLOCKS.register("sandstone_brick_slab", () -> slab(BlockBehaviour.Properties.ofFullCopy(ModBlocks.SANDSTONE_BRICKS.get())));
	public static final Supplier<Block> RED_SANDSTONE_BRICKS = BLOCKS.registerSimpleBlock("red_sandstone_bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE));
	public static final Supplier<Block> RED_SANDSTONE_BRICK_STAIRS = BLOCKS.register("red_sandstone_brick_stairs", () -> stair(ModBlocks.RED_SANDSTONE_BRICKS.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
	public static final Supplier<Block> RED_SANDSTONE_BRICK_SLAB = BLOCKS.register("red_sandstone_brick_slab", () -> slab(BlockBehaviour.Properties.ofFullCopy(ModBlocks.RED_SANDSTONE_BRICKS.get())));

	public static final Supplier<Block> CLAY_TILES = BLOCKS.registerSimpleBlock("clay_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS));
	public static final Supplier<Block> CLAY_TILE_STAIRS = BLOCKS.register("clay_tile_stairs", () -> stair(ModBlocks.CLAY_TILES.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
	public static final Supplier<Block> CLAY_TILE_SLAB = BLOCKS.register("clay_tile_slab", () -> slab(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
	public static final Supplier<Block> JAGGED_CLAY_TILES = BLOCKS.registerSimpleBlock("jagged_clay_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS));

	public static final Supplier<Block> PACKED_SNOW = BLOCKS.registerSimpleBlock("packed_snow", PROPERTIES_PACKED_SNOW);
	public static final Supplier<Block> PACKED_SNOW_BRICKS = BLOCKS.registerSimpleBlock("packed_snow_bricks", PROPERTIES_PACKED_SNOW);
	public static final Supplier<Block> PACKED_SNOW_BRICK_STAIRS = BLOCKS.register("packed_snow_brick_stairs", () -> stair(ModBlocks.PACKED_SNOW_BRICKS.get(), PROPERTIES_PACKED_SNOW));
	public static final Supplier<Block> PACKED_SNOW_BRICK_SLAB = BLOCKS.register("packed_snow_brick_slab", () -> slab(PROPERTIES_PACKED_SNOW));
	public static final Supplier<Block> POLISHED_PACKED_ICE = BLOCKS.registerSimpleBlock("polished_packed_ice", BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE));
	public static final Supplier<Block> PACKED_ICE_BRICKS = BLOCKS.registerSimpleBlock("packed_ice_bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE));
	public static final Supplier<Block> PACKED_ICE_BRICKS_STAIRS = BLOCKS.register("packed_ice_brick_stairs", () -> stair(ModBlocks.PACKED_ICE_BRICKS.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
	public static final Supplier<Block> PACKED_ICE_BRICKS_SLAB = BLOCKS.register("packed_ice_brick_slab", () -> slab(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));

	public static final Supplier<Block> COPPER_BARS = BLOCKS.register("copper_bars", () -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE)));
	public static final Supplier<Block> EXPOSED_COPPER_BARS = BLOCKS.register("exposed_copper_bars", () -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_COPPER_GRATE)));
	public static final Supplier<Block> WEATHERED_COPPER_BARS = BLOCKS.register("weathered_copper_bars", () -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_COPPER_GRATE)));
	public static final Supplier<Block> OXIDIZED_COPPER_BARS = BLOCKS.register("oxidized_copper_bars", () -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_COPPER_GRATE)));
	public static final Supplier<Block> WAXED_COPPER_BARS = BLOCKS.register("waxed_copper_bars", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE)));
	public static final Supplier<Block> WAXED_EXPOSED_COPPER_BARS = BLOCKS.register("waxed_exposed_copper_bars", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_COPPER_GRATE)));
	public static final Supplier<Block> WAXED_WEATHERED_COPPER_BARS = BLOCKS.register("waxed_weathered_copper_bars", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_COPPER_GRATE)));
	public static final Supplier<Block> WAXED_OXIDIZED_COPPER_BARS = BLOCKS.register("waxed_oxidized_copper_bars", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_COPPER_GRATE)));

	public static final Supplier<Block> COPPER_PILLAR = BLOCKS.register("copper_pillar", () -> new WeatheringCopperPillarBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK)));
	public static final Supplier<Block> EXPOSED_COPPER_PILLAR = BLOCKS.register("exposed_copper_pillar", () -> new WeatheringCopperPillarBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_COPPER_GRATE)));
	public static final Supplier<Block> WEATHERED_COPPER_PILLAR = BLOCKS.register("weathered_copper_pillar", () -> new WeatheringCopperPillarBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_COPPER_GRATE)));
	public static final Supplier<Block> OXIDIZED_COPPER_PILLAR = BLOCKS.register("oxidized_copper_pillar", () -> new WeatheringCopperPillarBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_COPPER_GRATE)));
	public static final Supplier<Block> WAXED_COPPER_PILLAR = BLOCKS.register("waxed_copper_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK)));
	public static final Supplier<Block> WAXED_EXPOSED_COPPER_PILLAR = BLOCKS.register("waxed_exposed_copper_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_COPPER_GRATE)));
	public static final Supplier<Block> WAXED_WEATHERED_COPPER_PILLAR = BLOCKS.register("waxed_weathered_copper_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_COPPER_GRATE)));
	public static final Supplier<Block> WAXED_OXIDIZED_COPPER_PILLAR = BLOCKS.register("waxed_oxidized_copper_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_COPPER_GRATE)));

	public static final Supplier<Block> IRON_PLATE = BLOCKS.registerSimpleBlock("iron_plate", PROPERTIES_IRON_PLATE);
	public static final Supplier<Block> IRON_TREAD_PLATE = BLOCKS.registerSimpleBlock("iron_tread_plate", PROPERTIES_IRON_PLATE);
	public static final Supplier<Block> IRON_TREAD_PLATE_STAIRS = BLOCKS.register("iron_tread_plate_stairs", () -> stair(ModBlocks.IRON_TREAD_PLATE.get(), PROPERTIES_IRON_PLATE));
	public static final Supplier<Block> IRON_TREAD_PLATE_SLAB = BLOCKS.register("iron_tread_plate_slab", () -> slab(PROPERTIES_IRON_PLATE));
	public static final Supplier<Block> CORRUGATED_IRON_PLATE = BLOCKS.registerSimpleBlock("corrugated_iron_plate", PROPERTIES_IRON_PLATE);
	public static final Supplier<Block> IRON_PLATE_PILLAR = BLOCKS.register("iron_plate_pillar",
			() -> new RotatedPillarBlock(PROPERTIES_IRON_PLATE));
	public static final Supplier<Block> IRON_PLATE_DOOR = BLOCKS.register("iron_plate_door",
			() -> new DoorBlock(ModBlockSets.IRON_PLATE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR)));
	public static final Supplier<Block> IRON_PLATE_TRAPDOOR = BLOCKS.register("iron_plate_trapdoor",
			() -> new TrapDoorBlock(ModBlockSets.IRON_PLATE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_TRAPDOOR)));

	public static final Supplier<Block> CHISELED_GOLD = BLOCKS.registerSimpleBlock("chiseled_gold", BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK));
	public static final Supplier<Block> GOLDEN_TILES = BLOCKS.registerSimpleBlock("golden_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK));
	public static final Supplier<Block> GOLDEN_BRICKS = BLOCKS.registerSimpleBlock("golden_bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK));
	public static final Supplier<Block> GOLDEN_BRICK_STAIRS = BLOCKS.register("golden_brick_stairs", () -> stair(ModBlocks.GOLDEN_BRICKS.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
	public static final Supplier<Block> GOLDEN_BRICK_SLAB = BLOCKS.register("golden_brick_slab", () -> slab(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
	public static final Supplier<Block> GOLDEN_PILLAR = BLOCKS.register("golden_pillar",
			() -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
	public static final Supplier<Block> GOLDEN_DOOR = BLOCKS.register("golden_door",
			() -> new DoorBlock(ModBlockSets.GOLD.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR)));
	public static final Supplier<Block> GOLDEN_TRAPDOOR = BLOCKS.register("golden_trapdoor",
			() -> new TrapDoorBlock(ModBlockSets.GOLD.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_TRAPDOOR)));

	public static final Supplier<Block> POLISHED_AMETHYST = BLOCKS.registerSimpleBlock("polished_amethyst", BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK));
	public static final Supplier<Block> CUT_AMETHYST = BLOCKS.registerSimpleBlock("cut_amethyst", BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK));
	public static final Supplier<Block> CUT_AMETHYST_STAIRS = BLOCKS.register("cut_amethyst_stairs", () -> stair(ModBlocks.CUT_AMETHYST.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
	public static final Supplier<Block> CUT_AMETHYST_SLAB = BLOCKS.register("cut_amethyst_slab", () -> slab(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
	public static final Supplier<Block> CHISELED_AMETHYST = BLOCKS.registerSimpleBlock("chiseled_amethyst", BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK));
	public static final Supplier<Block> CHISELED_AMETHYST_STAIRS = BLOCKS.register("chiseled_amethyst_stairs", () -> stair(ModBlocks.CHISELED_AMETHYST.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
	public static final Supplier<Block> CHISELED_AMETHYST_SLAB = BLOCKS.register("chiseled_amethyst_slab", () -> slab(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));

	public static final Supplier<Block> OAK_SEAT = BLOCKS.register("oak_seat", () -> new SeatBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
	public static final Supplier<Block> SPRUCE_SEAT = BLOCKS.register("spruce_seat", () -> new SeatBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
	public static final Supplier<Block> BIRCH_SEAT = BLOCKS.register("birch_seat", () -> new SeatBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
	public static final Supplier<Block> JUNGLE_SEAT = BLOCKS.register("jungle_seat", () -> new SeatBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
	public static final Supplier<Block> ACACIA_SEAT = BLOCKS.register("acacia_seat", () -> new SeatBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
	public static final Supplier<Block> DARK_OAK_SEAT = BLOCKS.register("dark_oak_seat", () -> new SeatBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
	public static final Supplier<Block> MANGROVE_SEAT = BLOCKS.register("mangrove_seat", () -> new SeatBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
	public static final Supplier<Block> CHERRY_SEAT = BLOCKS.register("cherry_seat", () -> new SeatBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
	public static final Supplier<Block> CRIMSON_SEAT = BLOCKS.register("crimson_seat", () -> new SeatBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
	public static final Supplier<Block> WARPED_SEAT = BLOCKS.register("warped_seat", () -> new SeatBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));

	private static Block stair(Block baseBlock, BlockBehaviour.Properties properties) {
		return new StairBlock(baseBlock.defaultBlockState(), properties);
	}

	private static Block slab(BlockBehaviour.Properties properties) {
		return new SlabBlock(properties);
	}

	private static Block palisade(MapColor mapColor) {
		return palisade(mapColor, SoundType.WOOD);
	}

	private static Block palisade(MapColor mapColor, SoundType soundType) {
		return new PalisadeBlock(PROPERTIES_PALISADE.mapColor(mapColor).sound(soundType).ignitedByLava());
	}

	private static Block netherPalisade(MapColor mapColor) {
		return new PalisadeBlock(PROPERTIES_PALISADE.mapColor(mapColor).sound(SoundType.NETHER_WOOD));
	}

	private static Block spikedPalisade(MapColor mapColor) {
		return spikedPalisade(mapColor, SoundType.WOOD);
	}

	private static Block spikedPalisade(MapColor mapColor, SoundType soundType) {
		return new SpikedPalisadeBlock(PROPERTIES_PALISADE.mapColor(mapColor).sound(soundType).ignitedByLava());
	}

	private static Block netherSpikedPalisade(MapColor mapColor) {
		return new SpikedPalisadeBlock(PROPERTIES_PALISADE.mapColor(mapColor).sound(SoundType.NETHER_WOOD));
	}
}
