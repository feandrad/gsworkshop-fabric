package io.felipeandrade.gsw2.world.feature;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.FeatureConfig;

public class GSWOreFeatureConfig implements FeatureConfig {
    public final BlockState state;
    public final int size;

    public GSWOreFeatureConfig(BlockState blockState, int size) {
        this.state = blockState;
        this.size = size;
    }

    public static GSWOreFeatureConfig deserialize(Dynamic<?> dynamic) {
        int int_1 = dynamic.get("size").asInt(0);
        BlockState blockState_1 = dynamic.get("state").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        return new GSWOreFeatureConfig(blockState_1, int_1);
    }

    @Override
    public <T> Dynamic<T> serialize(DynamicOps<T> dynamicOps) {
        return new Dynamic<T>(dynamicOps, dynamicOps.createMap(ImmutableMap.of(dynamicOps.createString("size"), dynamicOps.createInt(this.size), dynamicOps.createString("state"), BlockState.serialize(dynamicOps, this.state).getValue())));
    }
}