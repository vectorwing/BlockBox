package vectorwing.buildingbigger.common.block;

import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.WeatheringCopper;

public class WeatheringCopperPillarBlock extends RotatedPillarBlock implements WeatheringCopper
{
	public WeatheringCopperPillarBlock(Properties properties) {
		super(properties);
	}

	@Override
	public WeatherState getAge() {
		return null;
	}
}
