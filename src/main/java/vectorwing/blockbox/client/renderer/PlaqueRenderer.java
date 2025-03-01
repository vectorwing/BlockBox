package vectorwing.blockbox.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.util.FastColor;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.SignText;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import vectorwing.blockbox.common.block.PlaqueBlock;
import vectorwing.blockbox.common.block.state.PlaqueBlockEntity;

import java.util.List;

public class PlaqueRenderer implements BlockEntityRenderer<PlaqueBlockEntity>
{
	private static final Vec3 TEXT_OFFSET = new Vec3(0.0, 0.32F, 0.075F);
	private static final Vector3f SHADOW_OFFSET = new Vector3f(0.0F, 0.03F, 0.03F);
	private final Font font;

	public PlaqueRenderer(BlockEntityRendererProvider.Context context) {
		this.font = context.getFont();
	}

	@Override
	public void render(PlaqueBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
		BlockState state = blockEntity.getBlockState();
		PlaqueBlock plaqueBlock = (PlaqueBlock) state.getBlock();

		this.translateSign(poseStack, -plaqueBlock.getYRotationDegrees(state), state);
		this.renderSignText(blockEntity.getBlockPos(), blockEntity.getFrontText(), poseStack, bufferSource, packedLight, blockEntity.getTextLineHeight(), blockEntity.getMaxTextLineWidth());
	}

	public float getSignTextRenderScale() {
		return 0.6666667F;
	}

	void translateSign(PoseStack poseStack, float yRot, BlockState state) {
		poseStack.translate(0.5F, 0.75F * this.getSignTextRenderScale(), 0.5F);
		poseStack.mulPose(Axis.YP.rotationDegrees(yRot));
		if (!(state.getBlock() instanceof StandingSignBlock)) {
			poseStack.translate(0.0F, -0.3125F, -0.4375F);
		}
	}

	private void renderSignText(BlockPos pos, SignText text, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int lineHeight, int maxWidth) {
		poseStack.pushPose();

		this.translateSignText(poseStack, new Vec3(0.0, 0.32F, 0.075F));
		int i = getDarkColor(text);
		int j = 4 * lineHeight / 2;
		FormattedCharSequence[] aformattedcharsequence = text.getRenderMessages(Minecraft.getInstance().isTextFilteringEnabled(), p_277227_ -> {
			List<FormattedCharSequence> list = this.font.split(p_277227_, maxWidth);
			return list.isEmpty() ? FormattedCharSequence.EMPTY : list.get(0);
		});
		int k;
		int l;
		if (text.hasGlowingText()) {
			k = text.getColor().getTextColor();
			l = 15728880;
		} else {
			k = i;
			l = packedLight;
		}

		for (int i1 = 0; i1 < 4; i1++) {
			FormattedCharSequence formattedcharsequence = aformattedcharsequence[i1];
			float f = (float) (-this.font.width(formattedcharsequence) / 2);

			Matrix4f matrix4f = new Matrix4f(poseStack.last().pose());
			matrix4f.translate(new Vector3f(1F, 1F, -0.03F));
			this.font.drawInBatch(formattedcharsequence, f, (float) (i1 * lineHeight - j), PlaqueBlock.textColor, false, poseStack.last().pose(), buffer, Font.DisplayMode.POLYGON_OFFSET, 0, l);
			this.font.drawInBatch(formattedcharsequence, f, (float) (i1 * lineHeight - j), 11184810, false, matrix4f, buffer, Font.DisplayMode.POLYGON_OFFSET, 0, l);
		}

		poseStack.popPose();
	}

	private void translateSignText(PoseStack poseStack, Vec3 offset) {
		float f = 0.015625F * this.getSignTextRenderScale();
		poseStack.translate(offset.x, offset.y, offset.z);
		poseStack.scale(f, -f, f);
	}

	public static int getDarkColor(SignText signText) {
		int i = signText.getColor().getTextColor();
		if (i == DyeColor.BLACK.getTextColor() && signText.hasGlowingText()) {
			return -988212;
		} else {
			double d0 = 0.4;
			int j = (int) ((double) FastColor.ARGB32.red(i) * 0.4);
			int k = (int) ((double) FastColor.ARGB32.green(i) * 0.4);
			int l = (int) ((double) FastColor.ARGB32.blue(i) * 0.4);
			return FastColor.ARGB32.color(0, j, k, l);
		}
	}
}
