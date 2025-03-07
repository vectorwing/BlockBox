package vectorwing.blockbox.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.blockbox.common.block.PlaqueBlock;
import vectorwing.blockbox.common.block.state.PlaqueBlockEntity;

import javax.annotation.Nullable;

public class PlaqueItem extends BlockItem
{
	public PlaqueItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	protected boolean updateCustomBlockEntityTag(BlockPos pos, Level level, @Nullable Player player, ItemStack stack, BlockState state) {
		boolean hasCustomData = super.updateCustomBlockEntityTag(pos, level, player, stack, state);
		if (!level.isClientSide
				&& !hasCustomData
				&& player != null
				&& level.getBlockEntity(pos) instanceof PlaqueBlockEntity plaqueBlockEntity
				&& level.getBlockState(pos).getBlock() instanceof PlaqueBlock plaque) {
			plaque.openTextEdit(player, plaqueBlockEntity, true);
		}

		return hasCustomData;
	}
}
