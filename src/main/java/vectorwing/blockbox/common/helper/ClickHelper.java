package vectorwing.blockbox.common.helper;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

/**
 * Helper for measuring click regions.
 * <p>
 * Credits to XFactHD for some of the methods here!
 */
public class ClickHelper
{
	/**
	 * Selects a direction based on which cross quadrant (areas between an X) of a face was clicked. Works for all cardinal directions.
	 * @param face The face direction which was clicked.
	 * @param hitVec The point which was clicked on the surface.
	 * @return The direction equivalent to the cross quadrant which was clicked.
	 */
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

	/**
	 * Selects a horizontal direction based on which third of a horizontal face (shaped like this: [||]) was clicked. Returns the passed face for vertical directions.
	 * @param face The face direction which was clicked.
	 * @param hitVec The point which was clicked on the surface.
	 * @param edgeWidth The horizontal width, in a decimal from 0.0 to 0.5, which should be considered a left/right edge of the face. Set to 0.0 to check two symmetric halves.
	 * @return The horizontal direction equivalent to the third which was clicked
	 */
	public static Direction getHorizontalDirectionByThirds(Direction face, Vec3 hitVec, double edgeWidth) {
		hitVec = fraction(hitVec);
		edgeWidth = Math.min(edgeWidth, 0.5);
		if (isY(face)) {
			return face;
		}
		double xz = (isX(face) ? hitVec.z() : hitVec.x()) - .5;
		if (isX(face)) {
			if (xz <= -0.5 + edgeWidth) return Direction.NORTH;
			if (xz >= 0.5 - edgeWidth) return Direction.SOUTH;
		} else {
			if (xz <= -0.5 + edgeWidth) return Direction.WEST;
			if (xz >= 0.5 - edgeWidth) return Direction.EAST;
		}
		return face;
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
