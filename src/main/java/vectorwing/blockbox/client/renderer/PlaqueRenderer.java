package vectorwing.blockbox.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.util.FastColor;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.level.Level;
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
		this.renderSignText(plaqueBlock, state, blockEntity.getLevel(), blockEntity.getFrontText(), poseStack, bufferSource, packedLight, blockEntity.getTextLineHeight(), blockEntity.getMaxTextLineWidth());
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

	private void renderSignText(PlaqueBlock block, BlockState state, Level level, SignText text, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int lineHeight, int maxWidth) {
		poseStack.pushPose();

		this.translateSignText(poseStack, new Vec3(0.0, 0.32F, 0.075F));
		int lineHeightOffset = 4 * lineHeight / 2;
		FormattedCharSequence[] aformattedcharsequence = text.getRenderMessages(Minecraft.getInstance().isTextFilteringEnabled(), component -> {
			List<FormattedCharSequence> list = this.font.split(component, maxWidth);
			return list.isEmpty() ? FormattedCharSequence.EMPTY : list.getFirst();
		});

		int textColor = block.getTextColor();
		int highlightColor = block.getHighlightColor();

		if (level != null) {
			float shade = level.getShade(state.getValue(PlaqueBlock.FACING), true);
			textColor = getShadedColor(block.getTextColor(), shade);
			highlightColor = getShadedColor(block.getHighlightColor(), shade);
		}

		for (int lineIndex = 0; lineIndex < 4; lineIndex++) {
			FormattedCharSequence formattedcharsequence = aformattedcharsequence[lineIndex];
			float f = (float) (-this.font.width(formattedcharsequence) / 2);

			Matrix4f textOffset = new Matrix4f(poseStack.last().pose());
			this.font.drawInBatch(formattedcharsequence, f, (float) (lineIndex * lineHeight - lineHeightOffset), textColor, false, textOffset, buffer, Font.DisplayMode.POLYGON_OFFSET, 0, packedLight);

			textOffset.translate(1.0F, 1.0F, -0.03F);
			this.font.drawInBatch(formattedcharsequence, f, (float) (lineIndex * lineHeight - lineHeightOffset), highlightColor, false, textOffset, buffer, Font.DisplayMode.POLYGON_OFFSET, 0, packedLight);
		}

		poseStack.popPose();
	}

	private void translateSignText(PoseStack poseStack, Vec3 offset) {
		float f = 0.015625F * this.getSignTextRenderScale();
		poseStack.translate(offset.x, offset.y, offset.z);
		poseStack.scale(f, -f, f);
	}

	public static int getShadedColor(int color, float shade) {
		int red = (int) ((double) FastColor.ARGB32.red(color) * shade);
		int green = (int) ((double) FastColor.ARGB32.green(color) * shade);
		int blue = (int) ((double) FastColor.ARGB32.blue(color) * shade);
		return FastColor.ARGB32.color(0, red, green, blue);
	}
}
