//? fabric {
/*package vectorwing.blockbox.fabric.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.PortalShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import vectorwing.blockbox.common.block.PortalFrameBlock;
import vectorwing.blockbox.common.registry.ModBlocks;

@Mixin(PortalShape.class)
public class PortalShapeMixin {
	@WrapOperation(
			method = "lambda$static$0",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Ljava/lang/Object;)Z")
	)
	private static boolean addToFrame(BlockState instance, Object block, Operation<Boolean> original) {
		return original.call(instance, block) || instance.getBlock() instanceof PortalFrameBlock;
	}
}
*///?}