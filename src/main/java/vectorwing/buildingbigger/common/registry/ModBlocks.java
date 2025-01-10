package vectorwing.buildingbigger.common.registry;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.buildingbigger.BuildingBigger;
import vectorwing.buildingbigger.common.block.PalisadeBlock;
import vectorwing.buildingbigger.common.block.SpikedPalisadeBlock;

import java.util.function.Supplier;

public class ModBlocks
{
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BuildingBigger.MODID);

	public static final BlockBehaviour.Properties PROPERTIES_PACKED_SNOW = BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(0.6F).sound(SoundType.SNOW);
	public static final BlockBehaviour.Properties PROPERTIES_PALISADE = BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F).sound(SoundType.WOOD).ignitedByLava();

	public static final Supplier<Block> OAK_PALISADE = BLOCKS.register("oak_palisade", () -> new PalisadeBlock(PROPERTIES_PALISADE));
	public static final Supplier<Block> SPIKED_OAK_PALISADE = BLOCKS.register("spiked_oak_palisade", () -> new SpikedPalisadeBlock(PROPERTIES_PALISADE));

	public static final Supplier<Block> SANDSTONE_BRICKS = BLOCKS.registerSimpleBlock("sandstone_bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE));
	public static final Supplier<Block> RED_SANDSTONE_BRICKS = BLOCKS.registerSimpleBlock("red_sandstone_bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE));

	public static final Supplier<Block> CLAY_TILES = BLOCKS.registerSimpleBlock("clay_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS));
	public static final Supplier<Block> JAGGED_CLAY_TILES = BLOCKS.registerSimpleBlock("jagged_clay_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS));

	public static final Supplier<Block> PACKED_SNOW = BLOCKS.registerSimpleBlock("packed_snow", PROPERTIES_PACKED_SNOW);
	public static final Supplier<Block> PACKED_SNOW_BRICKS = BLOCKS.registerSimpleBlock("packed_snow_bricks", PROPERTIES_PACKED_SNOW);
	public static final Supplier<Block> POLISHED_PACKED_ICE = BLOCKS.registerSimpleBlock("polished_packed_ice", BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE));
	public static final Supplier<Block> PACKED_ICE_BRICKS = BLOCKS.registerSimpleBlock("packed_ice_bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE));

	public static final Supplier<Block> IRON_PLATE = BLOCKS.registerSimpleBlock("iron_plate", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
	public static final Supplier<Block> IRON_TREAD_PLATE = BLOCKS.registerSimpleBlock("iron_tread_plate", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
	public static final Supplier<Block> CORRUGATED_IRON_PLATE = BLOCKS.registerSimpleBlock("corrugated_iron_plate", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
	public static final Supplier<Block> IRON_PLATE_PILLAR = BLOCKS.register("iron_plate_pillar",
			() -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
	public static final Supplier<Block> IRON_PLATE_DOOR = BLOCKS.register("iron_plate_door",
			() -> new DoorBlock(ModBlockSets.IRON_PLATE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR)));
	public static final Supplier<Block> IRON_PLATE_TRAPDOOR = BLOCKS.register("iron_plate_trapdoor",
			() -> new TrapDoorBlock(ModBlockSets.IRON_PLATE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_TRAPDOOR)));

	public static final Supplier<Block> CHISELED_GOLD = BLOCKS.registerSimpleBlock("chiseled_gold", BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK));
	public static final Supplier<Block> GOLDEN_TILES = BLOCKS.registerSimpleBlock("golden_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK));
	public static final Supplier<Block> GOLDEN_BRICKS = BLOCKS.registerSimpleBlock("golden_bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK));
	public static final Supplier<Block> GOLDEN_PILLAR = BLOCKS.register("golden_pillar",
			() -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
	public static final Supplier<Block> GOLDEN_DOOR = BLOCKS.register("golden_door",
			() -> new DoorBlock(ModBlockSets.GOLD.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR)));
	public static final Supplier<Block> GOLDEN_TRAPDOOR = BLOCKS.register("golden_trapdoor",
			() -> new TrapDoorBlock(ModBlockSets.GOLD.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_TRAPDOOR)));

	public static final Supplier<Block> POLISHED_AMETHYST = BLOCKS.registerSimpleBlock("polished_amethyst", BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK));
	public static final Supplier<Block> AMETHYST_TILES = BLOCKS.registerSimpleBlock("amethyst_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK));
	public static final Supplier<Block> CHISELED_AMETHYST = BLOCKS.registerSimpleBlock("chiseled_amethyst", BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK));
}
