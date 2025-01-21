package vectorwing.buildingbigger.common.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class WeatheringCopperPillarBlock extends RotatedPillarBlock implements WeatheringCopper
{
	public static final MapCodec<WeatheringCopperPillarBlock> CODEC = RecordCodecBuilder.mapCodec(
			builder -> builder.group(WeatheringCopper.WeatherState.CODEC.fieldOf("weathering_state").forGetter(ChangeOverTimeBlock::getAge), propertiesCodec())
					.apply(builder, WeatheringCopperPillarBlock::new));

	private final WeatheringCopper.WeatherState weatherState;

	public WeatheringCopperPillarBlock(WeatheringCopper.WeatherState weatherState, Properties properties) {
		super(properties);
		this.weatherState = weatherState;
	}

	@Override
	protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		this.changeOverTime(state, level, pos, random);
	}

	@Override
	protected boolean isRandomlyTicking(BlockState state) {
		return WeatheringCopper.getNext(state.getBlock()).isPresent();
	}

	public WeatheringCopper.WeatherState getAge() {
		return this.weatherState;
	}

	@Override
	public MapCodec<WeatheringCopperPillarBlock> codec() {
		return CODEC;
	}
}
