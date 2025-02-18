package vectorwing.blockbox.common.block;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.blockbox.common.registry.ModBlocks;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class FlyingSkyLanternSourceBlock extends Block
{
	public FlyingSkyLanternSourceBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}

	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.INVISIBLE;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
		BlockState aboveState = level.getBlockState(pos.above());
		if (!aboveState.is(ModBlocks.FLYING_SKY_LANTERN.get())) {
			level.setBlock(pos, Blocks.AIR.defaultBlockState(),
					Block.UPDATE_ALL | Block.UPDATE_MOVE_BY_PISTON);
		}
	}
}
