package vectorwing.blockbox.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import vectorwing.blockbox.BlockBox;

import java.util.List;

public class SkyLanternItem extends BlockItem
{
	public SkyLanternItem(Block block, Properties properties) {
		super(block, properties);
	}

	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
		BlockHitResult playerPOVHitResult = getPlayerAimHitResult(level, player, ClipContext.Fluid.ANY);
		InteractionResult interactionresult = super.useOn(new UseOnContext(player, usedHand, playerPOVHitResult));
		return new InteractionResultHolder<>(interactionresult, player.getItemInHand(usedHand));
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag isAdvanced) {
		MutableComponent textEmpty = Component.translatable(BlockBox.MODID + ".tooltip.sky_lantern");
		tooltip.add(textEmpty.withStyle(ChatFormatting.GRAY));
	}

	public static BlockHitResult getPlayerAimHitResult(Level level, Player player, ClipContext.Fluid fluidMode) {
		double blockReach = player.blockInteractionRange();

		Vec3 vec3 = player.getEyePosition();
		Vec3 vec31 = vec3.add(player.calculateViewVector(player.getXRot(), player.getYRot()).scale(player.isSecondaryUseActive() ? blockReach / 2 : blockReach));
		return level.clip(new ClipContext(vec3, vec31, ClipContext.Block.OUTLINE, fluidMode, player));
	}
}
