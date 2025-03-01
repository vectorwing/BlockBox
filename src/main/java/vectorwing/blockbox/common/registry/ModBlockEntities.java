package vectorwing.blockbox.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.common.block.state.PlaqueBlockEntity;

import java.util.function.Supplier;

public class ModBlockEntities
{
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, BlockBox.MODID);

	public static final Supplier<BlockEntityType<PlaqueBlockEntity>> PLAQUE = BLOCK_ENTITIES.register("plaque",
			() -> BlockEntityType.Builder.of(PlaqueBlockEntity::new,
							ModBlocks.COPPER_PLAQUE.get(),
							ModBlocks.IRON_PLAQUE.get(),
							ModBlocks.GOLD_PLAQUE.get())
					.build(null));
}
