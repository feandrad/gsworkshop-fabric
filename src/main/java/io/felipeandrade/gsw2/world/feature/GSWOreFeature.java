package io.felipeandrade.gsw2.world.feature;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Heightmap;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

import io.felipeandrade.gsw2.common.Range;

public class GSWOreFeature extends Feature<GSWOreFeatureConfig> {
    public GSWOreFeature(Function<Dynamic<?>, ? extends GSWOreFeatureConfig> configDeserializer) {
        super(configDeserializer);
    }

    @Override
    public boolean generate(
            IWorld world,
            ChunkGenerator<? extends ChunkGeneratorConfig> chunkGenerator,
            Random random,
            BlockPos blockPos,
            GSWOreFeatureConfig oreFeatureConfig
    ) {
        float randomNumberFromZeroToPi = random.nextFloat() * 3.1415927F;
        float dividedSize = (float) oreFeatureConfig.size / 8.0F;
        int ceilSize = MathHelper.ceil(((float) oreFeatureConfig.size / 16.0F * 2.0F + 1.0F) / 2.0F);


        Range<Double> rangeX = new Range<>(
                (double) (blockPos.getX() + MathHelper.sin(randomNumberFromZeroToPi) * dividedSize),
                (double) (blockPos.getX() - MathHelper.sin(randomNumberFromZeroToPi) * dividedSize)
        );

        Range<Double> rangeZ = new Range<>(
                (double) (blockPos.getZ() + MathHelper.cos(randomNumberFromZeroToPi) * dividedSize),
                (double) (blockPos.getZ() - MathHelper.cos(randomNumberFromZeroToPi) * dividedSize)
        );

        Range<Double> rangeY = new Range<>(
                (double) (blockPos.getY() + random.nextInt(3) - 2),
                (double) (blockPos.getY() + random.nextInt(3) - 2)
        );

        int startX = blockPos.getX() - MathHelper.ceil(dividedSize) - ceilSize;
        int y = blockPos.getY() - 2 - ceilSize;
        int startZ = blockPos.getZ() - MathHelper.ceil(dividedSize) - ceilSize;
        int xSize = 2 * (MathHelper.ceil(dividedSize) + ceilSize);
        int ySize = 2 * (2 + ceilSize);

        for (int x = startX; x <= startX + xSize; ++x) {
            for (int z = startZ; z <= startZ + xSize; ++z) {
                if (y <= world.getTopY(Heightmap.Type.OCEAN_FLOOR_WG, x, z)) {
                    return this.generateVeinPart(world, random, oreFeatureConfig, rangeX, rangeZ, rangeY, startX, y, startZ, xSize, ySize);
                }
            }
        }

        return false;
    }

    protected boolean generateVeinPart(
            IWorld world,
            Random random,
            GSWOreFeatureConfig oreFeatureConfig,
            Range<Double> rangeX, Range<Double> rangeZ, Range<Double> rangeY,
            int startX, int startY, int startZ,
            int xSize, int ySize
    ) {

        int stonesPlaced = 0;
        BitSet bitSet = new BitSet(xSize * ySize * xSize);
        Mutable blockPos = new Mutable();
        double[] cache = new double[oreFeatureConfig.size * 4];

        int counter;
        double currentX;
        double currentY;
        double currentZ;
        double double_15;
        for (counter = 0; counter < oreFeatureConfig.size; ++counter) {
            float progress = (float) counter / (float) oreFeatureConfig.size;
            currentX = MathHelper.lerp(progress, rangeX.getUp(), rangeX.getDown());
            currentY = MathHelper.lerp(progress, rangeY.getUp(), rangeY.getDown());
            currentZ = MathHelper.lerp(progress, rangeZ.getUp(), rangeZ.getDown());
            double_15 = random.nextDouble() * (double) oreFeatureConfig.size / 16.0D;
            double double_11 = ((double) (MathHelper.sin(3.1415927F * progress) + 1.0F) * double_15 + 1.0D) / 2.0D;
            cache[counter * 4] = currentX;
            cache[counter * 4 + 1] = currentY;
            cache[counter * 4 + 2] = currentZ;
            cache[counter * 4 + 3] = double_11;
        }

        for (counter = 0; counter < oreFeatureConfig.size - 1; ++counter) {
            if (cache[counter * 4 + 3] > 0.0D) {
                for (int int_9 = counter + 1; int_9 < oreFeatureConfig.size; ++int_9) {
                    if (cache[int_9 * 4 + 3] > 0.0D) {
                        currentX = cache[counter * 4] - cache[int_9 * 4];
                        currentY = cache[counter * 4 + 1] - cache[int_9 * 4 + 1];
                        currentZ = cache[counter * 4 + 2] - cache[int_9 * 4 + 2];
                        double_15 = cache[counter * 4 + 3] - cache[int_9 * 4 + 3];
                        if (double_15 * double_15 > currentX * currentX + currentY * currentY + currentZ * currentZ) {
                            if (double_15 > 0.0D) {
                                cache[int_9 * 4 + 3] = -1.0D;
                            } else {
                                cache[counter * 4 + 3] = -1.0D;
                            }
                        }
                    }
                }
            }
        }

        for (counter = 0; counter < oreFeatureConfig.size; ++counter) {
            double double_16 = cache[counter * 4 + 3];
            if (double_16 >= 0.0D) {
                double double_17 = cache[counter * 4];
                double double_18 = cache[counter * 4 + 1];
                double double_19 = cache[counter * 4 + 2];
                int int_11 = Math.max(MathHelper.floor(double_17 - double_16), startX);
                int int_12 = Math.max(MathHelper.floor(double_18 - double_16), startY);
                int int_13 = Math.max(MathHelper.floor(double_19 - double_16), startZ);
                int int_14 = Math.max(MathHelper.floor(double_17 + double_16), int_11);
                int int_15 = Math.max(MathHelper.floor(double_18 + double_16), int_12);
                int int_16 = Math.max(MathHelper.floor(double_19 + double_16), int_13);

                for (int x = int_11; x <= int_14; ++x) {
                    double double_20 = ((double) x + 0.5D - double_17) / double_16;
                    if (double_20 * double_20 < 1.0D) {
                        for (int y = int_12; y <= int_15; ++y) {
                            double double_21 = ((double) y + 0.5D - double_18) / double_16;
                            if (double_20 * double_20 + double_21 * double_21 < 1.0D) {
                                for (int z = int_13; z <= int_16; ++z) {
                                    double double_22 = ((double) z + 0.5D - double_19) / double_16;
                                    if (double_20 * double_20 + double_21 * double_21 + double_22 * double_22 < 1.0D) {
                                        int int_20 = x - startX + (y - startY) * xSize + (z - startZ) * xSize * ySize;
                                        if (!bitSet.get(int_20)) {
                                            bitSet.set(int_20);
                                            blockPos.set(x, y, z);
                                            if (isNaturalStone(world.getBlockState(blockPos).getBlock())) {
                                                world.setBlockState(blockPos, oreFeatureConfig.state, 2);
                                                ++stonesPlaced;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return stonesPlaced > 0;
    }

    private boolean isNaturalStone(Block block) {
        return block == Blocks.STONE || block == Blocks.GRANITE || block == Blocks.DIORITE || block == Blocks.ANDESITE;
    }

}