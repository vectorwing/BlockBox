package vectorwing.buildingbigger.common.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.buildingbigger.BuildingBigger;

import java.util.function.Supplier;

public class ModBlocks
{
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BuildingBigger.MODID);

	public static final Supplier<Block> PACKED_SNOW = BLOCKS.registerSimpleBlock("packed_snow", BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(0.4F).sound(SoundType.SNOW));
	public static final Supplier<Block> PACKED_SNOW_BRICKS = BLOCKS.registerSimpleBlock("packed_snow_bricks", BlockBehaviour.Properties.ofFullCopy(ModBlocks.PACKED_SNOW.get()));
}
