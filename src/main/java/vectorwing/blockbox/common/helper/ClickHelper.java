package vectorwing.blockbox.common.helper;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;

/**
 * Helper for measuring click regions.
 * <p>
 * Credits to XFactHD for some of the methods here!
 */
public class ClickHelper
{
	public static Direction getDirectionByCross(Direction face, Vec3 hitVec) {
		hitVec = fraction(hitVec);

		if (isY(face)) {
			double x = hitVec.x() - .5;
			double z = hitVec.z() - .5;
			if (Math.max(Math.abs(x), Math.abs(z)) == Math.abs(x)) {
				return x > 0 ? Direction.EAST : Direction.WEST;
			} else {
				return z > 0 ? Direction.SOUTH : Direction.NORTH;
			}
		} else {
			double xz = (isX(face) ? hitVec.z() : hitVec.x()) - .5;
			double y = hitVec.y() - .5;

			if (Math.max(Math.abs(xz), Math.abs(y)) == Math.abs(xz)) {
				if (isX(face)) {
					return xz < 0 ? Direction.NORTH : Direction.SOUTH;
				} else {
					return (xz < 0) ? Direction.WEST : Direction.EAST;
				}
			} else {
				return y < 0 ? Direction.DOWN : Direction.UP;
			}
		}
	}

	public static boolean isX(Direction dir) {
		return dir.getAxis() == Direction.Axis.X;
	}

	public static boolean isY(Direction dir) {
		return dir.getAxis() == Direction.Axis.Y;
	}

	public static boolean isZ(Direction dir) {
		return dir.getAxis() == Direction.Axis.Z;
	}

	public static Vec3 fraction(Vec3 vec) {
		return new Vec3(
				vec.x() - Math.floor(vec.x()),
				vec.y() - Math.floor(vec.y()),
				vec.z() - Math.floor(vec.z())
		);
	}
}
