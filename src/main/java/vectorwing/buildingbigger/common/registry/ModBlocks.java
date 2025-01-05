package vectorwing.buildingbigger.common.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.buildingbigger.BuildingBigger;

import java.util.function.Supplier;

public class ModBlocks
{
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BuildingBigger.MODID);

	public static final BlockBehaviour.Properties PROPERTIES_PACKED_SNOW = BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(0.6F).sound(SoundType.SNOW);

	public static final Supplier<Block> SANDSTONE_BRICKS = BLOCKS.registerSimpleBlock("sandstone_bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE));
	public static final Supplier<Block> RED_SANDSTONE_BRICKS = BLOCKS.registerSimpleBlock("red_sandstone_bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE));

	public static final Supplier<Block> CLAY_TILES = BLOCKS.registerSimpleBlock("clay_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS));

	public static final Supplier<Block> PACKED_SNOW = BLOCKS.registerSimpleBlock("packed_snow", PROPERTIES_PACKED_SNOW);
	public static final Supplier<Block> PACKED_SNOW_BRICKS = BLOCKS.registerSimpleBlock("packed_snow_bricks", PROPERTIES_PACKED_SNOW);
	public static final Supplier<Block> POLISHED_PACKED_ICE = BLOCKS.registerSimpleBlock("polished_packed_ice", BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE));
	public static final Supplier<Block> PACKED_ICE_BRICKS = BLOCKS.registerSimpleBlock("packed_ice_bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE));

	public static final Supplier<Block> IRON_PLATE = BLOCKS.registerSimpleBlock("iron_plate", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
	public static final Supplier<Block> IRON_TREAD_PLATE = BLOCKS.registerSimpleBlock("iron_tread_plate", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
	public static final Supplier<Block> CORRUGATED_IRON_PLATE = BLOCKS.registerSimpleBlock("corrugated_iron_plate", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
	public static final Supplier<Block> IRON_PLATE_PILLAR = BLOCKS.register("iron_plate_pillar",
			() -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

	public static final Supplier<Block> GOLDEN_TILES = BLOCKS.registerSimpleBlock("golden_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK));
	public static final Supplier<Block> GOLDEN_BRICKS = BLOCKS.registerSimpleBlock("golden_bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK));
	public static final Supplier<Block> GOLDEN_PILLAR = BLOCKS.register("golden_pillar",
			() -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
}
