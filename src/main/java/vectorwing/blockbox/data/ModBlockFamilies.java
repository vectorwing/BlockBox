package vectorwing.blockbox.data;

import com.google.common.collect.Maps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;
import vectorwing.blockbox.common.registry.ModBlocks;

import java.util.Map;
import java.util.stream.Stream;

public class ModBlockFamilies
{
    private static final Map<Block, BlockFamily> MAP = Maps.newHashMap();

    public static final BlockFamily GRANITE_BRICK = familyBuilder(ModBlocks.GRANITE_BRICKS.get())
            .stairs(ModBlocks.GRANITE_BRICK_STAIRS.get())
            .slab(ModBlocks.GRANITE_BRICK_SLAB.get())
            .wall(ModBlocks.GRANITE_BRICK_WALL.get())
            .getFamily();
    public static final BlockFamily DIORITE_BRICK = familyBuilder(ModBlocks.DIORITE_BRICKS.get())
            .stairs(ModBlocks.DIORITE_BRICK_STAIRS.get())
            .slab(ModBlocks.DIORITE_BRICK_SLAB.get())
            .wall(ModBlocks.DIORITE_BRICK_WALL.get())
            .getFamily();
    public static final BlockFamily ANDESITE_BRICK = familyBuilder(ModBlocks.ANDESITE_BRICKS.get())
            .stairs(ModBlocks.ANDESITE_BRICK_STAIRS.get())
            .slab(ModBlocks.ANDESITE_BRICK_SLAB.get())
            .wall(ModBlocks.ANDESITE_BRICK_WALL.get())
            .getFamily();
    public static final BlockFamily SANDSTONE_BRICK = familyBuilder(ModBlocks.SANDSTONE_BRICKS.get())
            .stairs(ModBlocks.SANDSTONE_BRICK_STAIRS.get())
            .slab(ModBlocks.SANDSTONE_BRICK_SLAB.get())
            .getFamily();
    public static final BlockFamily RED_SANDSTONE_BRICK = familyBuilder(ModBlocks.RED_SANDSTONE_BRICKS.get())
            .stairs(ModBlocks.RED_SANDSTONE_BRICK_STAIRS.get())
            .slab(ModBlocks.RED_SANDSTONE_BRICK_SLAB.get())
            .getFamily();
    public static final BlockFamily TILE = familyBuilder(ModBlocks.TILES.get())
            .stairs(ModBlocks.TILE_STAIRS.get())
            .slab(ModBlocks.TILE_SLAB.get())
            .getFamily();
    public static final BlockFamily SNOW_BRICK = familyBuilder(ModBlocks.SNOW_BRICKS.get())
            .stairs(ModBlocks.SNOW_BRICK_STAIRS.get())
            .slab(ModBlocks.SNOW_BRICK_SLAB.get())
            .wall(ModBlocks.SNOW_BRICK_WALL.get())
            .getFamily();
    public static final BlockFamily PACKED_ICE_BRICK = familyBuilder(ModBlocks.PACKED_ICE_BRICKS.get())
            .stairs(ModBlocks.PACKED_ICE_BRICK_STAIRS.get())
            .slab(ModBlocks.PACKED_ICE_BRICK_SLAB.get())
            .wall(ModBlocks.PACKED_ICE_BRICK_WALL.get())
            .getFamily();
    public static final BlockFamily IRON_PLATE = familyBuilder(ModBlocks.IRON_PLATE.get())
            .door(ModBlocks.IRON_PLATE_DOOR.get())
            .trapdoor(ModBlocks.IRON_PLATE_TRAPDOOR.get())
            .getFamily();
    public static final BlockFamily IRON_TREAD_PLATE = familyBuilder(ModBlocks.IRON_TREAD_PLATE.get())
            .stairs(ModBlocks.IRON_TREAD_PLATE_STAIRS.get())
            .slab(ModBlocks.IRON_TREAD_PLATE_SLAB.get())
            .getFamily();
    public static final BlockFamily CORRUGATED_IRON_PLATE = familyBuilder(ModBlocks.CORRUGATED_IRON_PLATE.get())
            .stairs(ModBlocks.CORRUGATED_IRON_PLATE_STAIRS.get())
            .slab(ModBlocks.CORRUGATED_IRON_PLATE_SLAB.get())
            .getFamily();
    public static final BlockFamily GOLDEN_BRICK = familyBuilder(ModBlocks.GOLDEN_BRICKS.get())
            .stairs(ModBlocks.GOLDEN_BRICK_STAIRS.get())
            .slab(ModBlocks.GOLDEN_BRICK_SLAB.get())
            .getFamily();
    public static final BlockFamily CUT_AMETHYST = familyBuilder(ModBlocks.CUT_AMETHYST.get())
            .stairs(ModBlocks.CUT_AMETHYST_STAIRS.get())
            .slab(ModBlocks.CUT_AMETHYST_SLAB.get())
            .getFamily();
    public static final BlockFamily AMETHYST_MOSAIC = familyBuilder(ModBlocks.AMETHYST_MOSAIC.get())
            .stairs(ModBlocks.AMETHYST_MOSAIC_STAIRS.get())
            .slab(ModBlocks.AMETHYST_MOSAIC_SLAB.get())
            .getFamily();
    public static final BlockFamily LAPIS_LAZULI_BRICK = familyBuilder(ModBlocks.LAPIS_LAZULI_BRICKS.get())
            .stairs(ModBlocks.LAPIS_LAZULI_BRICK_STAIRS.get())
            .slab(ModBlocks.LAPIS_LAZULI_BRICK_SLAB.get())
            .getFamily();
    public static final BlockFamily LAPIS_LAZULI_MOSAIC = familyBuilder(ModBlocks.LAPIS_LAZULI_MOSAIC.get())
            .stairs(ModBlocks.LAPIS_LAZULI_MOSAIC_STAIRS.get())
            .slab(ModBlocks.LAPIS_LAZULI_MOSAIC_SLAB.get())
            .getFamily();

    private static BlockFamily.Builder familyBuilder(Block base) {
        BlockFamily.Builder builder = new BlockFamily.Builder(base);
        BlockFamily blockFamily = MAP.put(base, builder.getFamily());
        if (blockFamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + BuiltInRegistries.BLOCK.getKey(base));
        } else {
            return builder;
        }
    }

    public static Stream<BlockFamily> getAllFamilies() {
        return MAP.values().stream();
    }
}
