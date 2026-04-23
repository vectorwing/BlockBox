package vectorwing.blockbox.fabric.event.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import vectorwing.blockbox.common.entity.SeatEntity;

import java.util.function.Supplier;

public class EntityRenderersEvent {
	public static class RegisterRenderers {
		public <T extends Entity> void registerEntityRenderer(EntityType<T> entityType, EntityRendererProvider<T> provider) {
			EntityRenderers.register(entityType, provider);
		}
	}
}
