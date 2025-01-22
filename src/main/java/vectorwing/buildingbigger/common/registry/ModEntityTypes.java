package vectorwing.buildingbigger.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.buildingbigger.BuildingBigger;
import vectorwing.buildingbigger.common.entity.SeatEntity;

import java.util.function.Supplier;

public class ModEntityTypes
{
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, BuildingBigger.MODID);

	public static final Supplier<EntityType<SeatEntity>> SEAT = ENTITY_TYPES.register("seat", () ->
			EntityType.Builder.<SeatEntity>of(SeatEntity::new, MobCategory.MISC)
					.sized(0.25f, 0.35f)
					.clientTrackingRange(3)
					.updateInterval(Integer.MAX_VALUE)
					.build("seat"));
}
