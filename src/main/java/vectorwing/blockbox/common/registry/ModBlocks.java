package vectorwing.blockbox.common.registry;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.common.block.*;

import javax.annotation.Nullable;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks
{
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BlockBox.MODID);

	public static final BlockBehaviour.Properties PROPERTIES_PACKED_SNOW = BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(0.6F).sound(SoundType.SNOW);
	public static final BlockBehaviour.Properties PROPERTIES_PACKED_ICE = BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE).strength(0.4F).requiresCorrectToolForDrops();
	public static final BlockBehaviour.Properties PROPERTIES_IRON_PLATE = BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(4.0F, 6.0F).sound(SoundType.NETHERITE_BLOCK);
	public static final BlockBehaviour.Properties PROPERTIES_PALISADE = BlockBehaviour.Properties.of().strength(2.0F).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava();
	public static final BlockBehaviour.Properties PROPERTIES_SKY_LANTERN = BlockBehaviour.Properties.of().strength(0.2F).instrument(NoteBlockInstrument.GUITAR).noOcclusion().lightLevel((state) -> 15).ignitedByLava().sound(SoundType.WOOL);

	public static final Supplier<Block> GRANITE_BRICKS = BLOCKS.registerSimpleBlock("granite_bricks", () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE));
	public static final Supplier<Block> GRANITE_BRICK_STAIRS = BLOCKS.registerBlock("granite_brick_stairs", props -> stair(ModBlocks.GRANITE_BRICKS.get(), props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE));
	public static final Supplier<Block> GRANITE_BRICK_SLAB = BLOCKS.registerBlock("granite_brick_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE));
	public static final Supplier<Block> GRANITE_BRICK_WALL = BLOCKS.registerBlock("granite_brick_wall", WallBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE).forceSolidOn());
	public static final Supplier<Block> DIORITE_BRICKS = BLOCKS.registerSimpleBlock("diorite_bricks", () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE));
	public static final Supplier<Block> DIORITE_BRICK_STAIRS = BLOCKS.registerBlock("diorite_brick_stairs", props -> stair(ModBlocks.DIORITE_BRICKS.get(), props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE));
	public static final Supplier<Block> DIORITE_BRICK_SLAB = BLOCKS.registerBlock("diorite_brick_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE));
	public static final Supplier<Block> DIORITE_BRICK_WALL = BLOCKS.registerBlock("diorite_brick_wall", WallBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE).forceSolidOn());
	public static final Supplier<Block> ANDESITE_BRICKS = BLOCKS.registerSimpleBlock("andesite_bricks", () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE));
	public static final Supplier<Block> ANDESITE_BRICK_STAIRS = BLOCKS.registerBlock("andesite_brick_stairs", props -> stair(ModBlocks.ANDESITE_BRICKS.get(), props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE));
	public static final Supplier<Block> ANDESITE_BRICK_SLAB = BLOCKS.registerBlock("andesite_brick_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE));
	public static final Supplier<Block> ANDESITE_BRICK_WALL = BLOCKS.registerBlock("andesite_brick_wall", WallBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE).forceSolidOn());

	public static final Supplier<Block> SANDSTONE_BRICKS = BLOCKS.registerSimpleBlock("sandstone_bricks", () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE));
	public static final Supplier<Block> SANDSTONE_BRICK_STAIRS = BLOCKS.registerBlock("sandstone_brick_stairs", props -> stair(ModBlocks.SANDSTONE_BRICKS.get(), props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE));
	public static final Supplier<Block> SANDSTONE_BRICK_SLAB = BLOCKS.registerBlock("sandstone_brick_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(ModBlocks.SANDSTONE_BRICKS.get()));
	public static final Supplier<Block> RED_SANDSTONE_BRICKS = BLOCKS.registerSimpleBlock("red_sandstone_bricks", () -> BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE));
	public static final Supplier<Block> RED_SANDSTONE_BRICK_STAIRS = BLOCKS.registerBlock("red_sandstone_brick_stairs", props -> stair(ModBlocks.RED_SANDSTONE_BRICKS.get(), props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE));
	public static final Supplier<Block> RED_SANDSTONE_BRICK_SLAB = BLOCKS.registerBlock("red_sandstone_brick_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(ModBlocks.RED_SANDSTONE_BRICKS.get()));

	public static final Supplier<Block> TILES = BLOCKS.registerSimpleBlock("tiles", () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS));
	public static final Supplier<Block> TILE_STAIRS = BLOCKS.registerBlock("tile_stairs", props -> stair(ModBlocks.TILES.get(), props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS));
	public static final Supplier<Block> TILE_SLAB = BLOCKS.registerBlock("tile_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS));
	public static final Supplier<Block> BROKEN_TILE_MOSAIC = BLOCKS.registerSimpleBlock("broken_tile_mosaic", () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS));

	public static final Supplier<Block> PACKED_SNOW = BLOCKS.registerBlock("packed_snow", PackedSnowBlock::new, () -> PROPERTIES_PACKED_SNOW);
	public static final Supplier<Block> CARVED_SNOW = BLOCKS.registerBlock("carved_snow", CarvedSnowBlock::new, () -> PROPERTIES_PACKED_SNOW);
	public static final Supplier<Block> SNOW_BRICKS = BLOCKS.registerSimpleBlock("snow_bricks", () -> PROPERTIES_PACKED_SNOW);
	public static final Supplier<Block> SNOW_BRICK_STAIRS = BLOCKS.registerBlock("snow_brick_stairs", props -> stair(ModBlocks.SNOW_BRICKS.get(), props), () -> PROPERTIES_PACKED_SNOW);
	public static final Supplier<Block> SNOW_BRICK_SLAB = BLOCKS.registerBlock("snow_brick_slab", SlabBlock::new, () -> PROPERTIES_PACKED_SNOW);
	public static final Supplier<Block> SNOW_BRICK_WALL = BLOCKS.registerBlock("snow_brick_wall", WallBlock::new, () -> PROPERTIES_PACKED_SNOW.forceSolidOn());
	public static final Supplier<Block> POLISHED_PACKED_ICE = BLOCKS.registerSimpleBlock("polished_packed_ice", () -> PROPERTIES_PACKED_ICE);
	public static final Supplier<Block> PACKED_ICE_BRICKS = BLOCKS.registerSimpleBlock("packed_ice_bricks", () -> PROPERTIES_PACKED_ICE);
	public static final Supplier<Block> PACKED_ICE_BRICK_STAIRS = BLOCKS.registerBlock("packed_ice_brick_stairs", props -> stair(ModBlocks.PACKED_ICE_BRICKS.get(), props), () -> PROPERTIES_PACKED_ICE);
	public static final Supplier<Block> PACKED_ICE_BRICK_SLAB = BLOCKS.registerBlock("packed_ice_brick_slab", SlabBlock::new, () -> PROPERTIES_PACKED_ICE);
	public static final Supplier<Block> PACKED_ICE_BRICK_WALL = BLOCKS.registerBlock("packed_ice_brick_wall", WallBlock::new, () -> PROPERTIES_PACKED_ICE.forceSolidOn());

	public static final Supplier<Block> POLISHED_OBSIDIAN = BLOCKS.registerBlock("polished_obsidian", PortalFrameBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN));

	public static final Supplier<Block> ROUGH_GLASS = BLOCKS.registerBlock("rough_glass", TransparentBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
	public static final Supplier<Block> ROUGH_GLASS_PANE = BLOCKS.registerBlock("rough_glass_pane", IronBarsBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE));

	public static final Supplier<Block> COPPER_CHAIN_LINKS = BLOCKS.registerBlock("copper_chain_links", props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.UNAFFECTED, props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BARS.unaffected()));
	public static final Supplier<Block> EXPOSED_COPPER_CHAIN_LINKS = BLOCKS.registerBlock("exposed_copper_chain_links", props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.EXPOSED, props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BARS.exposed()));
	public static final Supplier<Block> WEATHERED_COPPER_CHAIN_LINKS = BLOCKS.registerBlock("weathered_copper_chain_links", props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.WEATHERED, props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BARS.weathered()));
	public static final Supplier<Block> OXIDIZED_COPPER_CHAIN_LINKS = BLOCKS.registerBlock("oxidized_copper_chain_links", props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.OXIDIZED, props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BARS.oxidized()));
	public static final Supplier<Block> WAXED_COPPER_CHAIN_LINKS = BLOCKS.registerBlock("waxed_copper_chain_links", IronBarsBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BARS.waxed()));
	public static final Supplier<Block> WAXED_EXPOSED_COPPER_CHAIN_LINKS = BLOCKS.registerBlock("waxed_exposed_copper_chain_links", IronBarsBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BARS.waxedExposed()));
	public static final Supplier<Block> WAXED_WEATHERED_COPPER_CHAIN_LINKS = BLOCKS.registerBlock("waxed_weathered_copper_chain_links", IronBarsBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BARS.waxedWeathered()));
	public static final Supplier<Block> WAXED_OXIDIZED_COPPER_CHAIN_LINKS = BLOCKS.registerBlock("waxed_oxidized_copper_chain_links", IronBarsBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BARS.waxedOxidized()));

	public static final Supplier<Block> COPPER_PILLAR = BLOCKS.registerBlock("copper_pillar", props -> new WeatheringCopperPillarBlock(WeatheringCopper.WeatherState.UNAFFECTED, props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK));
	public static final Supplier<Block> EXPOSED_COPPER_PILLAR = BLOCKS.registerBlock("exposed_copper_pillar", props -> new WeatheringCopperPillarBlock(WeatheringCopper.WeatherState.EXPOSED, props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_COPPER));
	public static final Supplier<Block> WEATHERED_COPPER_PILLAR = BLOCKS.registerBlock("weathered_copper_pillar", props -> new WeatheringCopperPillarBlock(WeatheringCopper.WeatherState.WEATHERED, props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_COPPER));
	public static final Supplier<Block> OXIDIZED_COPPER_PILLAR = BLOCKS.registerBlock("oxidized_copper_pillar", props -> new WeatheringCopperPillarBlock(WeatheringCopper.WeatherState.OXIDIZED, props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_COPPER));
	public static final Supplier<Block> WAXED_COPPER_PILLAR = BLOCKS.registerBlock("waxed_copper_pillar", RotatedPillarBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK));
	public static final Supplier<Block> WAXED_EXPOSED_COPPER_PILLAR = BLOCKS.registerBlock("waxed_exposed_copper_pillar", RotatedPillarBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_COPPER));
	public static final Supplier<Block> WAXED_WEATHERED_COPPER_PILLAR = BLOCKS.registerBlock("waxed_weathered_copper_pillar", RotatedPillarBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_COPPER));
	public static final Supplier<Block> WAXED_OXIDIZED_COPPER_PILLAR = BLOCKS.registerBlock("waxed_oxidized_copper_pillar", RotatedPillarBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_COPPER));

	public static final Supplier<Block> IRON_PLATE = BLOCKS.registerSimpleBlock("iron_plate", () -> PROPERTIES_IRON_PLATE);
	public static final Supplier<Block> IRON_TREAD_PLATE = BLOCKS.registerSimpleBlock("iron_tread_plate", () -> PROPERTIES_IRON_PLATE);
	public static final Supplier<Block> IRON_TREAD_PLATE_STAIRS = BLOCKS.registerBlock("iron_tread_plate_stairs", props -> stair(ModBlocks.IRON_TREAD_PLATE.get(), props), () -> PROPERTIES_IRON_PLATE);
	public static final Supplier<Block> IRON_TREAD_PLATE_SLAB = BLOCKS.registerBlock("iron_tread_plate_slab", SlabBlock::new, () -> PROPERTIES_IRON_PLATE);
	public static final Supplier<Block> CORRUGATED_IRON_PLATE = BLOCKS.registerSimpleBlock("corrugated_iron_plate", () -> PROPERTIES_IRON_PLATE);
	public static final Supplier<Block> CORRUGATED_IRON_PLATE_STAIRS = BLOCKS.registerBlock("corrugated_iron_plate_stairs", props -> stair(ModBlocks.CORRUGATED_IRON_PLATE.get(), props), () -> PROPERTIES_IRON_PLATE);
	public static final Supplier<Block> CORRUGATED_IRON_PLATE_SLAB = BLOCKS.registerBlock("corrugated_iron_plate_slab", SlabBlock::new, () -> PROPERTIES_IRON_PLATE);
	public static final Supplier<Block> IRON_PLATE_PILLAR = BLOCKS.registerBlock("iron_plate_pillar", RotatedPillarBlock::new, () -> PROPERTIES_IRON_PLATE);
	public static final Supplier<Block> IRON_PLATE_DOOR = BLOCKS.registerBlock("iron_plate_door",
			props -> new DoorBlock(ModBlockSets.IRON_PLATE.get(), props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR));
	public static final Supplier<Block> IRON_PLATE_TRAPDOOR = BLOCKS.registerBlock("iron_plate_trapdoor",
			props -> new TrapDoorBlock(ModBlockSets.IRON_PLATE.get(), props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_TRAPDOOR));

	public static final Supplier<Block> CHISELED_GOLD = BLOCKS.registerSimpleBlock("chiseled_gold", () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK));
	public static final Supplier<Block> GOLDEN_TILES = BLOCKS.registerSimpleBlock("golden_tiles", () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK));
	public static final Supplier<Block> GOLDEN_BRICKS = BLOCKS.registerSimpleBlock("golden_bricks", () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK));
	public static final Supplier<Block> GOLDEN_BRICK_STAIRS = BLOCKS.registerBlock("golden_brick_stairs", props -> stair(ModBlocks.GOLDEN_BRICKS.get(), props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK));
	public static final Supplier<Block> GOLDEN_BRICK_SLAB = BLOCKS.registerBlock("golden_brick_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK));
	public static final Supplier<Block> GOLDEN_PILLAR = BLOCKS.registerBlock("golden_pillar",
			RotatedPillarBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK));
	public static final Supplier<Block> GOLDEN_DOOR = BLOCKS.registerBlock("golden_door",
			props -> new DoorBlock(ModBlockSets.GOLD.get(), props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR));
	public static final Supplier<Block> GOLDEN_TRAPDOOR = BLOCKS.registerBlock("golden_trapdoor",
			props -> new TrapDoorBlock(ModBlockSets.GOLD.get(), props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_TRAPDOOR));
	public static final Supplier<Block> GOLDEN_BARS = BLOCKS.registerBlock("golden_bars",
			IronBarsBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK));

	public static final Supplier<Block> POLISHED_AMETHYST = BLOCKS.registerSimpleBlock("polished_amethyst", () -> BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK));
	public static final Supplier<Block> CUT_AMETHYST = BLOCKS.registerSimpleBlock("cut_amethyst", () -> BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK));
	public static final Supplier<Block> CUT_AMETHYST_STAIRS = BLOCKS.registerBlock("cut_amethyst_stairs", props -> stair(ModBlocks.CUT_AMETHYST.get(), props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK));
	public static final Supplier<Block> CUT_AMETHYST_SLAB = BLOCKS.registerBlock("cut_amethyst_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK));
	public static final Supplier<Block> AMETHYST_MOSAIC = BLOCKS.registerSimpleBlock("amethyst_mosaic", () -> BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK));
	public static final Supplier<Block> AMETHYST_MOSAIC_STAIRS = BLOCKS.registerBlock("amethyst_mosaic_stairs", props -> stair(ModBlocks.AMETHYST_MOSAIC.get(), props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK));
	public static final Supplier<Block> AMETHYST_MOSAIC_SLAB = BLOCKS.registerBlock("amethyst_mosaic_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK));

	public static final Supplier<Block> LAPIS_LAZULI_BRICKS = BLOCKS.registerSimpleBlock("lapis_lazuli_bricks", () -> BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK));
	public static final Supplier<Block> LAPIS_LAZULI_BRICK_STAIRS = BLOCKS.registerBlock("lapis_lazuli_brick_stairs", props -> stair(ModBlocks.LAPIS_LAZULI_BRICKS.get(), props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK));
	public static final Supplier<Block> LAPIS_LAZULI_BRICK_SLAB = BLOCKS.registerBlock("lapis_lazuli_brick_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK));
	public static final Supplier<Block> LAPIS_LAZULI_MOSAIC = BLOCKS.registerSimpleBlock("lapis_lazuli_mosaic", () -> BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK));
	public static final Supplier<Block> LAPIS_LAZULI_MOSAIC_STAIRS = BLOCKS.registerBlock("lapis_lazuli_mosaic_stairs", props -> stair(ModBlocks.LAPIS_LAZULI_MOSAIC.get(), props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK));
	public static final Supplier<Block> LAPIS_LAZULI_MOSAIC_SLAB = BLOCKS.registerBlock("lapis_lazuli_mosaic_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK));

	public static final Supplier<Block> OAK_SEAT = BLOCKS.registerBlock("oak_seat", SeatBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));
	public static final Supplier<Block> SPRUCE_SEAT = BLOCKS.registerBlock("spruce_seat", SeatBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS));
	public static final Supplier<Block> BIRCH_SEAT = BLOCKS.registerBlock("birch_seat", SeatBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS));
	public static final Supplier<Block> JUNGLE_SEAT = BLOCKS.registerBlock("jungle_seat", SeatBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS));
	public static final Supplier<Block> ACACIA_SEAT = BLOCKS.registerBlock("acacia_seat", SeatBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS));
	public static final Supplier<Block> DARK_OAK_SEAT = BLOCKS.registerBlock("dark_oak_seat", SeatBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS));
	public static final Supplier<Block> MANGROVE_SEAT = BLOCKS.registerBlock("mangrove_seat", SeatBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS));
	public static final Supplier<Block> CHERRY_SEAT = BLOCKS.registerBlock("cherry_seat", SeatBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS));
	public static final Supplier<Block> PALE_OAK_SEAT = BLOCKS.registerBlock("pale_oak_seat", SeatBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS));
	public static final Supplier<Block> BAMBOO_SEAT = BLOCKS.registerBlock("bamboo_seat", SeatBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS));
	public static final Supplier<Block> CRIMSON_SEAT = BLOCKS.registerBlock("crimson_seat", SeatBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS));
	public static final Supplier<Block> WARPED_SEAT = BLOCKS.registerBlock("warped_seat", SeatBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS));

	public static final Supplier<Block> OAK_PALISADE = BLOCKS.registerBlock("oak_palisade", props -> palisade(ModBlocks.SPIKED_OAK_PALISADE, ModBlocks.STRIPPED_OAK_PALISADE, MapColor.WOOD, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> SPIKED_OAK_PALISADE = BLOCKS.registerBlock("spiked_oak_palisade", props -> spikedPalisade(ModBlocks.STRIPPED_SPIKED_OAK_PALISADE, MapColor.WOOD, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> SPRUCE_PALISADE = BLOCKS.registerBlock("spruce_palisade", props -> palisade(ModBlocks.SPIKED_SPRUCE_PALISADE, ModBlocks.STRIPPED_SPRUCE_PALISADE, MapColor.PODZOL, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> SPIKED_SPRUCE_PALISADE = BLOCKS.registerBlock("spiked_spruce_palisade", props -> spikedPalisade(ModBlocks.STRIPPED_SPIKED_SPRUCE_PALISADE, MapColor.PODZOL, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> BIRCH_PALISADE = BLOCKS.registerBlock("birch_palisade", props -> palisade(ModBlocks.SPIKED_BIRCH_PALISADE, ModBlocks.STRIPPED_BIRCH_PALISADE, MapColor.SAND, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> SPIKED_BIRCH_PALISADE = BLOCKS.registerBlock("spiked_birch_palisade", props -> spikedPalisade(ModBlocks.STRIPPED_SPIKED_BIRCH_PALISADE, MapColor.SAND, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> JUNGLE_PALISADE = BLOCKS.registerBlock("jungle_palisade", props -> palisade(ModBlocks.SPIKED_JUNGLE_PALISADE, ModBlocks.STRIPPED_JUNGLE_PALISADE, MapColor.DIRT, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> SPIKED_JUNGLE_PALISADE = BLOCKS.registerBlock("spiked_jungle_palisade", props -> spikedPalisade(ModBlocks.STRIPPED_SPIKED_JUNGLE_PALISADE, MapColor.DIRT, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> ACACIA_PALISADE = BLOCKS.registerBlock("acacia_palisade", props -> palisade(ModBlocks.SPIKED_ACACIA_PALISADE, ModBlocks.STRIPPED_ACACIA_PALISADE, MapColor.COLOR_ORANGE, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> SPIKED_ACACIA_PALISADE = BLOCKS.registerBlock("spiked_acacia_palisade", props -> spikedPalisade(ModBlocks.STRIPPED_SPIKED_ACACIA_PALISADE, MapColor.COLOR_ORANGE, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> DARK_OAK_PALISADE = BLOCKS.registerBlock("dark_oak_palisade", props -> palisade(ModBlocks.SPIKED_DARK_OAK_PALISADE, ModBlocks.STRIPPED_DARK_OAK_PALISADE, MapColor.COLOR_BROWN, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> SPIKED_DARK_OAK_PALISADE = BLOCKS.registerBlock("spiked_dark_oak_palisade", props -> spikedPalisade(ModBlocks.STRIPPED_SPIKED_DARK_OAK_PALISADE, MapColor.COLOR_BROWN, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> MANGROVE_PALISADE = BLOCKS.registerBlock("mangrove_palisade", props -> palisade(ModBlocks.SPIKED_MANGROVE_PALISADE, ModBlocks.STRIPPED_MANGROVE_PALISADE, MapColor.COLOR_RED, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> SPIKED_MANGROVE_PALISADE = BLOCKS.registerBlock("spiked_mangrove_palisade", props -> spikedPalisade(ModBlocks.STRIPPED_SPIKED_MANGROVE_PALISADE, MapColor.COLOR_RED, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> CHERRY_PALISADE = BLOCKS.registerBlock("cherry_palisade", props -> palisade(ModBlocks.SPIKED_CHERRY_PALISADE, ModBlocks.STRIPPED_CHERRY_PALISADE, MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> SPIKED_CHERRY_PALISADE = BLOCKS.registerBlock("spiked_cherry_palisade", props -> spikedPalisade(ModBlocks.STRIPPED_SPIKED_CHERRY_PALISADE, MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> PALE_OAK_PALISADE = BLOCKS.registerBlock("pale_oak_palisade", props -> palisade(ModBlocks.SPIKED_PALE_OAK_PALISADE, ModBlocks.STRIPPED_PALE_OAK_PALISADE, MapColor.TERRACOTTA_WHITE, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> SPIKED_PALE_OAK_PALISADE = BLOCKS.registerBlock("spiked_pale_oak_palisade", props -> spikedPalisade(ModBlocks.STRIPPED_SPIKED_PALE_OAK_PALISADE, MapColor.TERRACOTTA_WHITE, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> CRIMSON_PALISADE = BLOCKS.registerBlock("crimson_palisade", props -> netherPalisade(ModBlocks.SPIKED_CRIMSON_PALISADE, ModBlocks.STRIPPED_CRIMSON_PALISADE, MapColor.CRIMSON_STEM, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> SPIKED_CRIMSON_PALISADE = BLOCKS.registerBlock("spiked_crimson_palisade", props -> netherSpikedPalisade(ModBlocks.STRIPPED_SPIKED_CRIMSON_PALISADE, MapColor.CRIMSON_STEM, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> WARPED_PALISADE = BLOCKS.registerBlock("warped_palisade", props -> netherPalisade(ModBlocks.SPIKED_WARPED_PALISADE, ModBlocks.STRIPPED_WARPED_PALISADE, MapColor.WARPED_STEM, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> SPIKED_WARPED_PALISADE = BLOCKS.registerBlock("spiked_warped_palisade", props -> netherSpikedPalisade(ModBlocks.STRIPPED_SPIKED_WARPED_PALISADE, MapColor.WARPED_STEM, props), () -> PROPERTIES_PALISADE);

	public static final Supplier<Block> STRIPPED_OAK_PALISADE = BLOCKS.registerBlock("stripped_oak_palisade", props -> palisade(ModBlocks.STRIPPED_SPIKED_OAK_PALISADE, null, MapColor.WOOD, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_SPIKED_OAK_PALISADE = BLOCKS.registerBlock("stripped_spiked_oak_palisade", props -> spikedPalisade(null, MapColor.WOOD, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_SPRUCE_PALISADE = BLOCKS.registerBlock("stripped_spruce_palisade", props -> palisade(ModBlocks.STRIPPED_SPIKED_SPRUCE_PALISADE, null, MapColor.PODZOL, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_SPIKED_SPRUCE_PALISADE = BLOCKS.registerBlock("stripped_spiked_spruce_palisade", props -> spikedPalisade(null, MapColor.PODZOL, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_BIRCH_PALISADE = BLOCKS.registerBlock("stripped_birch_palisade", props -> palisade(ModBlocks.STRIPPED_SPIKED_BIRCH_PALISADE, null, MapColor.SAND, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_SPIKED_BIRCH_PALISADE = BLOCKS.registerBlock("stripped_spiked_birch_palisade", props -> spikedPalisade(null, MapColor.SAND, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_JUNGLE_PALISADE = BLOCKS.registerBlock("stripped_jungle_palisade", props -> palisade(ModBlocks.STRIPPED_SPIKED_JUNGLE_PALISADE, null, MapColor.DIRT, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_SPIKED_JUNGLE_PALISADE = BLOCKS.registerBlock("stripped_spiked_jungle_palisade", props -> spikedPalisade(null, MapColor.DIRT, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_ACACIA_PALISADE = BLOCKS.registerBlock("stripped_acacia_palisade", props -> palisade(ModBlocks.STRIPPED_SPIKED_ACACIA_PALISADE, null, MapColor.COLOR_ORANGE, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_SPIKED_ACACIA_PALISADE = BLOCKS.registerBlock("stripped_spiked_acacia_palisade", props -> spikedPalisade(null, MapColor.COLOR_ORANGE, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_DARK_OAK_PALISADE = BLOCKS.registerBlock("stripped_dark_oak_palisade", props -> palisade(ModBlocks.STRIPPED_SPIKED_DARK_OAK_PALISADE, null, MapColor.COLOR_BROWN, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_SPIKED_DARK_OAK_PALISADE = BLOCKS.registerBlock("stripped_spiked_dark_oak_palisade", props -> spikedPalisade(null, MapColor.COLOR_BROWN, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_MANGROVE_PALISADE = BLOCKS.registerBlock("stripped_mangrove_palisade", props -> palisade(ModBlocks.STRIPPED_SPIKED_MANGROVE_PALISADE, null, MapColor.COLOR_RED, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_SPIKED_MANGROVE_PALISADE = BLOCKS.registerBlock("stripped_spiked_mangrove_palisade", props -> spikedPalisade(null, MapColor.COLOR_RED, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_CHERRY_PALISADE = BLOCKS.registerBlock("stripped_cherry_palisade", props -> palisade(ModBlocks.STRIPPED_SPIKED_CHERRY_PALISADE, null, MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_SPIKED_CHERRY_PALISADE = BLOCKS.registerBlock("stripped_spiked_cherry_palisade", props -> spikedPalisade(null, MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_PALE_OAK_PALISADE = BLOCKS.registerBlock("stripped_pale_oak_palisade", props -> palisade(ModBlocks.STRIPPED_SPIKED_PALE_OAK_PALISADE, null, MapColor.WOOD, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_SPIKED_PALE_OAK_PALISADE = BLOCKS.registerBlock("stripped_spiked_pale_oak_palisade", props -> spikedPalisade(null, MapColor.WOOD, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_CRIMSON_PALISADE = BLOCKS.registerBlock("stripped_crimson_palisade", props -> netherPalisade(ModBlocks.STRIPPED_SPIKED_CRIMSON_PALISADE, null, MapColor.CRIMSON_STEM, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_SPIKED_CRIMSON_PALISADE = BLOCKS.registerBlock("stripped_spiked_crimson_palisade", props -> netherSpikedPalisade(null, MapColor.CRIMSON_STEM, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_WARPED_PALISADE = BLOCKS.registerBlock("stripped_warped_palisade", props -> netherPalisade(ModBlocks.STRIPPED_SPIKED_WARPED_PALISADE, null, MapColor.WARPED_STEM, props), () -> PROPERTIES_PALISADE);
	public static final Supplier<Block> STRIPPED_SPIKED_WARPED_PALISADE = BLOCKS.registerBlock("stripped_spiked_warped_palisade", props -> netherSpikedPalisade(null, MapColor.WARPED_STEM, props), () -> PROPERTIES_PALISADE);


	public static final Supplier<Block> BRAZIER = BLOCKS.registerBlock("brazier", props -> new BrazierBlock(1, props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN)
			.lightLevel(litBlockEmission(15))
	);
	public static final Supplier<Block> SOUL_BRAZIER = BLOCKS.registerBlock("soul_brazier", props -> new BrazierBlock(2, props), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_LANTERN)
			.lightLevel(litBlockEmission(10))
	);

	public static final Supplier<Block> WHITE_SKY_LANTERN = BLOCKS.registerBlock("white_sky_lantern", SkyLanternBlock::new, () -> PROPERTIES_SKY_LANTERN.mapColor(MapColor.SNOW));
	public static final Supplier<Block> LIGHT_GRAY_SKY_LANTERN = BLOCKS.registerBlock("light_gray_sky_lantern", SkyLanternBlock::new, () -> PROPERTIES_SKY_LANTERN.mapColor(MapColor.COLOR_LIGHT_GRAY));
	public static final Supplier<Block> GRAY_SKY_LANTERN = BLOCKS.registerBlock("gray_sky_lantern", SkyLanternBlock::new, () -> PROPERTIES_SKY_LANTERN.mapColor(MapColor.COLOR_GRAY));
	public static final Supplier<Block> BLACK_SKY_LANTERN = BLOCKS.registerBlock("black_sky_lantern", SkyLanternBlock::new, () -> PROPERTIES_SKY_LANTERN.mapColor(MapColor.COLOR_BLACK));
	public static final Supplier<Block> BROWN_SKY_LANTERN = BLOCKS.registerBlock("brown_sky_lantern", SkyLanternBlock::new, () -> PROPERTIES_SKY_LANTERN.mapColor(MapColor.COLOR_BROWN));
	public static final Supplier<Block> RED_SKY_LANTERN = BLOCKS.registerBlock("red_sky_lantern", SkyLanternBlock::new, () -> PROPERTIES_SKY_LANTERN.mapColor(MapColor.COLOR_RED));
	public static final Supplier<Block> ORANGE_SKY_LANTERN = BLOCKS.registerBlock("orange_sky_lantern", SkyLanternBlock::new, () -> PROPERTIES_SKY_LANTERN.mapColor(MapColor.COLOR_ORANGE));
	public static final Supplier<Block> YELLOW_SKY_LANTERN = BLOCKS.registerBlock("yellow_sky_lantern", SkyLanternBlock::new, () -> PROPERTIES_SKY_LANTERN.mapColor(MapColor.COLOR_YELLOW));
	public static final Supplier<Block> LIME_SKY_LANTERN = BLOCKS.registerBlock("lime_sky_lantern", SkyLanternBlock::new, () -> PROPERTIES_SKY_LANTERN.mapColor(MapColor.COLOR_LIGHT_GREEN));
	public static final Supplier<Block> GREEN_SKY_LANTERN = BLOCKS.registerBlock("green_sky_lantern", SkyLanternBlock::new, () -> PROPERTIES_SKY_LANTERN.mapColor(MapColor.COLOR_GREEN));
	public static final Supplier<Block> CYAN_SKY_LANTERN = BLOCKS.registerBlock("cyan_sky_lantern", SkyLanternBlock::new, () -> PROPERTIES_SKY_LANTERN.mapColor(MapColor.COLOR_CYAN));
	public static final Supplier<Block> LIGHT_BLUE_SKY_LANTERN = BLOCKS.registerBlock("light_blue_sky_lantern", SkyLanternBlock::new, () -> PROPERTIES_SKY_LANTERN.mapColor(MapColor.COLOR_LIGHT_BLUE));
	public static final Supplier<Block> BLUE_SKY_LANTERN = BLOCKS.registerBlock("blue_sky_lantern", SkyLanternBlock::new, () -> PROPERTIES_SKY_LANTERN.mapColor(MapColor.COLOR_BLUE));
	public static final Supplier<Block> PURPLE_SKY_LANTERN = BLOCKS.registerBlock("purple_sky_lantern", SkyLanternBlock::new, () -> PROPERTIES_SKY_LANTERN.mapColor(MapColor.COLOR_PURPLE));
	public static final Supplier<Block> MAGENTA_SKY_LANTERN = BLOCKS.registerBlock("magenta_sky_lantern", SkyLanternBlock::new, () -> PROPERTIES_SKY_LANTERN.mapColor(MapColor.COLOR_MAGENTA));
	public static final Supplier<Block> PINK_SKY_LANTERN = BLOCKS.registerBlock("pink_sky_lantern", SkyLanternBlock::new, () -> PROPERTIES_SKY_LANTERN.mapColor(MapColor.COLOR_PINK));

	private static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
		return state -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
	}

	private static Block stair(Block baseBlock, BlockBehaviour.Properties properties) {
		return new StairBlock(baseBlock.defaultBlockState(), properties);
	}

	private static Block palisade(Supplier<Block> spikedForm, @Nullable Supplier<Block> strippedForm, MapColor mapColor, BlockBehaviour.Properties properties) {
		return palisade(spikedForm, strippedForm, mapColor, SoundType.WOOD, properties);
	}

	private static Block palisade(Supplier<Block> spikedForm, @Nullable Supplier<Block> strippedForm, MapColor mapColor, SoundType soundType, BlockBehaviour.Properties properties) {
		return new PalisadeBlock(spikedForm, strippedForm, properties.mapColor(mapColor).sound(soundType).ignitedByLava());
	}

	private static Block netherPalisade(Supplier<Block> spikedForm, @Nullable Supplier<Block> strippedForm, MapColor mapColor, BlockBehaviour.Properties properties) {
		return new PalisadeBlock(spikedForm, strippedForm, properties.mapColor(mapColor).sound(SoundType.STEM));
	}

	private static Block spikedPalisade(@Nullable Supplier<Block> strippedForm, MapColor mapColor, BlockBehaviour.Properties properties) {
		return spikedPalisade(strippedForm, mapColor, SoundType.WOOD, properties);
	}

	private static Block spikedPalisade(@Nullable Supplier<Block> strippedForm, MapColor mapColor, SoundType soundType, BlockBehaviour.Properties properties) {
		return new SpikedPalisadeBlock(strippedForm, properties.mapColor(mapColor).sound(soundType).ignitedByLava());
	}

	private static Block netherSpikedPalisade(@Nullable Supplier<Block> strippedForm, MapColor mapColor, BlockBehaviour.Properties properties) {
		return new SpikedPalisadeBlock(strippedForm, properties.mapColor(mapColor).sound(SoundType.STEM));
	}
}
