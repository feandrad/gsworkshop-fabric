package io.felipeandrade.gsw2.world;

import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.FlowerFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import io.felipeandrade.gsw2.material.metal.CopperMaterial;

public class GSWWorldGen {


    public static void registerWorldGen() {
        //Loop over existing biomes
        Registry.BIOME.forEach(GSWWorldGen::handleBiome);

        //Listen for other biomes being registered
        RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> handleBiome(biome));
    }

    private static void handleBiome(Biome biome) {

//        Biome biome = Registry.BIOME.get(new Identifier("minecraft:mountains"));
//        biome.addFeature(GenerationStep.Feature.RAW_GENERATION, DWARVEN_DUNGEON.configure(new DefaultFeatureConfig()));
//        biome.addStructureFeature(DWARVEN_DUNGEON.configure(new DefaultFeatureConfig()));


        if (isBiomeOverworld(biome)) {
            biome.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, CopperMaterial.ORE_BLOCK.getDefaultState(), 8))
            );
        }
    }

    public static boolean isBiomeOverworld(Biome biome) {
        return biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND;
    }

    public static <F extends FeatureConfig, D extends DecoratorConfig> ConfiguredFeature<?, ?> configureFeature(Feature<F> feature, F featureConfig, Decorator<D> decorator, D decoratorConfig) {
        Feature<DecoratedFeatureConfig> feature2 = feature instanceof FlowerFeature ? Feature.DECORATED_FLOWER : Feature.DECORATED;
        return new ConfiguredFeature(feature2, new DecoratedFeatureConfig(feature.configure(featureConfig), decorator.configure(decoratorConfig)));
    }

    public static void addOres(Biome biome) {
        biome.addFeature(
                GenerationStep.Feature.UNDERGROUND_ORES,
                configureFeature(HallowedFeatures.ORE, new HallowedOreFeatureConfig(HallowedBlocks.HALLOWED_ORE.getDefaultState(), 5), Decorator.COUNT_RANGE, new RangeDecoratorConfig(1, 0, 0, 16))
        );
    }

}
