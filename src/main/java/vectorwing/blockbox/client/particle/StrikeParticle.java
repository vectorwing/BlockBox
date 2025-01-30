package vectorwing.blockbox.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class StrikeParticle extends TextureSheetParticle
{
	private final SpriteSet sprites;

	protected StrikeParticle(ClientLevel level, double x, double y, double z, SpriteSet sprites, float gravity) {
		super(level, x, y, z, 0.0, 0.0, 0.0);
		this.lifetime = 4;
		this.quadSize = 0.5F;
		this.sprites = sprites;
		this.setSpriteFromAge(sprites);
	}

	public int getLightColor(float partialTick) {
		return 15728880;
	}

	public void tick() {
		this.xo = this.x;
		this.yo = this.y;
		this.zo = this.z;
		if (this.age++ >= this.lifetime) {
			this.remove();
		} else {
			this.setSpriteFromAge(this.sprites);
		}
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_LIT;
	}

	public static class Provider implements ParticleProvider<SimpleParticleType>
	{
		private final SpriteSet sprites;

		public Provider(SpriteSet sprites) {
			this.sprites = sprites;
		}

		public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new StrikeParticle(level, x, y, z, this.sprites, 0.0F);
		}
	}
}
