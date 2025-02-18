package vectorwing.blockbox.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.common.block.entity.FlyingSkyLanternBlockEntity;

import java.util.function.Supplier;

public class ModBlockEntities
{
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, BlockBox.MODID);

	public static final Supplier<BlockEntityType<FlyingSkyLanternBlockEntity>> FLYING_SKY_LANTERN = BLOCK_ENTITIES.register("flying_sky_lantern",
			() -> BlockEntityType.Builder.of(FlyingSkyLanternBlockEntity::new,
					ModBlocks.FLYING_SKY_LANTERN.get()
			).build(null));
}
