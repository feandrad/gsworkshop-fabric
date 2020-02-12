package io.felipeandrade.gsw2.world.feature;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class GSWOreFeatureConfig implements FeatureConfig {
    public final OreFeatureConfig.Target target;
    public final int size;
    public final BlockState state;

    public GSWOreFeatureConfig(OreFeatureConfig.Target target, BlockState state, int size) {
        this.size = size;
        this.state = state;
        this.target = target;
    }

    @Override
    public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
        return new Dynamic<>(
                ops,
                ops.createMap(
                        ImmutableMap.of(
                                ops.createString("size"), ops.createInt(this.size),
                                ops.createString("target"), ops.createString(this.target.getName()),
                                ops.createString("state"), BlockState.serialize(ops, this.state).getValue()
                        )
                )
        );
    }

}
