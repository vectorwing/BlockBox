package vectorwing.blockbox.common.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.common.entity.SeatEntity;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class ModEntityTypes
{

	public static final Supplier<EntityType<SeatEntity>> SEAT = registerEntityType("seat",
			SeatEntity::new, MobCategory.MISC, builder -> builder
					.sized(0.25f, 0.35f)
					.clientTrackingRange(3)
					.updateInterval(Integer.MAX_VALUE));

	public static <T extends Entity> Supplier<EntityType<T>> registerEntityType(String name, EntityType.EntityFactory<T> factory, MobCategory category, UnaryOperator<EntityType.Builder<T>> builder) {
		return register(name, key -> builder.apply(EntityType.Builder.of(factory, category)).build(ResourceKey.create(Registries.ENTITY_TYPE, key)));
	}

	public static  <T extends EntityType<?>> Supplier<T> register(final String name, final Function<Identifier, ? extends T> func) {
		ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(BlockBox.MODID, name));
		T apply = Registry.register(BuiltInRegistries.ENTITY_TYPE, key, func.apply(key.identifier()));
		return ()-> apply;
	}

	public static void register() {
	}
}
