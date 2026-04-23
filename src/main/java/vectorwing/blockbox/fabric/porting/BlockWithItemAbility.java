package vectorwing.blockbox.fabric.porting;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;

public interface BlockWithItemAbility {
	//? fabric
	BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate);

}
