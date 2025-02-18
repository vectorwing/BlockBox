package vectorwing.blockbox.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.RenderTypeHelper;
import vectorwing.blockbox.common.block.entity.FlyingSkyLanternBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

//@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault
public class FlyingSkyLanternRenderer implements BlockEntityRenderer<FlyingSkyLanternBlockEntity>
{
	private final BlockRenderDispatcher blockRenderer;

	public FlyingSkyLanternRenderer(BlockEntityRendererProvider.Context context) {
		this.blockRenderer = context.getBlockRenderDispatcher();
	}

	@Override
	public void render(FlyingSkyLanternBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
		Level level = blockEntity.getLevel();
		if (level != null && blockEntity.getDirection() != null) {
			BlockPos blockPos = blockEntity.getBlockPos().relative(blockEntity.getMovementDirection().getOpposite());
			BlockState blockState = blockEntity.getMovedState();
			if (!blockState.isAir()) {
				// ModelBlockRenderer.enableCaching();
				poseStack.pushPose();
				poseStack.translate(blockEntity.getXOff(partialTick), blockEntity.getYOff(partialTick), blockEntity.getZOff(partialTick));

				this.renderBlock(blockPos, blockState, poseStack, bufferSource, level, false, packedOverlay);

				poseStack.popPose();
				// ModelBlockRenderer.clearCache();
			}
		}
	}

	private void renderBlock(BlockPos pos, BlockState state, PoseStack poseStack, MultiBufferSource bufferSource, Level level, boolean extended, int packedOverlay) {
//		RenderType renderType = ItemBlockRenderTypes.getMovingBlockRenderType(state);
//		RenderType renderType = RenderTypeHelper.getMovingBlockRenderType();
		VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.cutout());
		this.blockRenderer.getModelRenderer().tesselateBlock(level, this.blockRenderer.getBlockModel(state), state, pos, poseStack, vertexConsumer, extended, RandomSource.create(), state.getSeed(pos), packedOverlay);
	}

	@Override
	public int getViewDistance() {
		return 68;
	}
}
