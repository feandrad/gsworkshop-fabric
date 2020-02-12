package io.felipeandrade.gsw2.world.feature;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Heightmap;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

public class GSWOreFeature extends Feature<GSWOreFeatureConfig> {


    public static final float PI = 3.1415927F;

    public GSWOreFeature(Function<Dynamic<?>, ? extends GSWOreFeatureConfig> configDeserializer) {
        super(configDeserializer);
    }

    @Override
    public boolean generate(IWorld iWorld, ChunkGenerator<? extends ChunkGeneratorConfig> chunkGenerator, Random random, BlockPos blockPos, GSWOreFeatureConfig oreFeatureConfig) {
        float randomRad = random.nextFloat() * PI;
        float quadrantFactor = (float) oreFeatureConfig.size / 8.0F;
        int int_a = MathHelper.ceil((quadrantFactor + 1.0F) / 2.0F);

        double startX =  blockPos.getX() + MathHelper.sin(randomRad) * quadrantFactor;
        double endX =   blockPos.getX() - MathHelper.sin(randomRad) * quadrantFactor;
        double startZ = (float) blockPos.getZ() + MathHelper.cos(randomRad) * quadrantFactor;
        double endZ = (float) blockPos.getZ() - MathHelper.cos(randomRad) * quadrantFactor;
        double startY = blockPos.getY() + random.nextInt(3) - 2;
        double endY = blockPos.getY() + random.nextInt(3) - 2;

        int x = blockPos.getX() - MathHelper.ceil(quadrantFactor) - int_a;
        int y = blockPos.getY() - 2 - int_a;
        int z = blockPos.getZ() - MathHelper.ceil(quadrantFactor) - int_a;

        int size = 2 * (MathHelper.ceil(quadrantFactor) + int_a);

        for (int xi = x; xi <= x + size; ++xi) {
            for (int zi = z; zi <= z + size; ++zi) {
                if (y <= iWorld.getTopY(Heightmap.Type.OCEAN_FLOOR_WG, xi, zi)) {
                    return this.generateVeinPart(iWorld, random, oreFeatureConfig, startX, endX, startZ, endZ, startY, endY, x, y, z, size, int_a);
                }
            }
        }

        return false;
    }

    protected boolean generateVeinPart(
            IWorld world,
            Random random,
            GSWOreFeatureConfig config,
            double startX, double endX,
            double startZ, double endZ,
            double startY, double endY,
            int x, int y, int z,
            int size,
            int int_a
    ) {

        int int_i = 2 * (2 + int_a);

        int j = 0;
        BitSet bitSet = new BitSet(size * int_i * size);
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        double[] cache = new double[config.size * 4];

        int i;
        double currentX;
        double currentY;
        double currentZ;
        double r;
        for (i = 0; i < config.size; ++i) {
            float f = (float) i / (float) config.size;
            currentX = MathHelper.lerp(f, startX, endX);
            currentY = MathHelper.lerp(f, startY, endY);
            currentZ = MathHelper.lerp(f, startZ, endZ);
            r = random.nextDouble() * (double) config.size / 16.0D;
            double l = ((double) (MathHelper.sin(PI * f) + 1.0F) * r + 1.0D) / 2.0D;
            cache[i * 4] = currentX;
            cache[i * 4 + 1] = currentY;
            cache[i * 4 + 2] = currentZ;
            cache[i * 4 + 3] = l;
        }

        for (i = 0; i < config.size - 1; ++i) {
            if (cache[i * 4 + 3] > 0.0D) {
                for (int n = i + 1; n < config.size; ++n) {
                    if (cache[n * 4 + 3] > 0.0D) {
                        currentX = cache[i * 4] - cache[n * 4];
                        currentY = cache[i * 4 + 1] - cache[n * 4 + 1];
                        currentZ = cache[i * 4 + 2] - cache[n * 4 + 2];
                        r = cache[i * 4 + 3] - cache[n * 4 + 3];
                        if (r * r > currentX * currentX + currentY * currentY + currentZ * currentZ) {
                            if (r > 0.0D) {
                                cache[n * 4 + 3] = -1.0D;
                            } else {
                                cache[i * 4 + 3] = -1.0D;
                            }
                        }
                    }
                }
            }
        }

        for (i = 0; i < config.size; ++i) {
            double t = cache[i * 4 + 3];
            if (t >= 0.0D) {
                double u = cache[i * 4];
                double v = cache[i * 4 + 1];
                double w = cache[i * 4 + 2];
                int aa = Math.max(MathHelper.floor(u - t), x);
                int ab = Math.max(MathHelper.floor(v - t), y);
                int ac = Math.max(MathHelper.floor(w - t), z);
                int ad = Math.max(MathHelper.floor(u + t), aa);
                int ae = Math.max(MathHelper.floor(v + t), ab);
                int af = Math.max(MathHelper.floor(w + t), ac);

                for (int ag = aa; ag <= ad; ++ag) {
                    double ah = ((double) ag + 0.5D - u) / t;
                    if (ah * ah < 1.0D) {
                        for (int ai = ab; ai <= ae; ++ai) {
                            double aj = ((double) ai + 0.5D - v) / t;
                            if (ah * ah + aj * aj < 1.0D) {
                                for (int ak = ac; ak <= af; ++ak) {
                                    double al = ((double) ak + 0.5D - w) / t;
                                    if (ah * ah + aj * aj + al * al < 1.0D) {
                                        int am = ag - x + (ai - y) * size + (ak - z) * size * int_i;
                                        if (!bitSet.get(am)) {
                                            bitSet.set(am);
                                            mutable.set(ag, ai, ak);
                                            if (config.target.getCondition().test(world.getBlockState(mutable))) {
                                                world.setBlockState(mutable, config.state, 2);
                                                ++j;
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

        return j > 0;
    }
}
