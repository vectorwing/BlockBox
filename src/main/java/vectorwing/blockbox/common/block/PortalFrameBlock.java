package vectorwing.blockbox.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class PortalFrameBlock extends Block
{
	public PortalFrameBlock(Properties properties) {
		super(properties);
	}

	//? neoforge {
	@Override
	public boolean isPortalFrame(BlockState state, BlockGetter level, BlockPos pos) {
		return true;
	}
	//?}
}
