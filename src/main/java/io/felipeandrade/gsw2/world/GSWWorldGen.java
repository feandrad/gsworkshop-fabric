package io.felipeandrade.gsw2.world;

import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.block.Block;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.Target;

import java.util.ArrayList;
import java.util.List;

import io.felipeandrade.gsw2.material.gem.AmethystMaterial;
import io.felipeandrade.gsw2.material.gem.RubyMaterial;
import io.felipeandrade.gsw2.material.gem.SapphireMaterial;
import io.felipeandrade.gsw2.material.gem.TopazMaterial;
import io.felipeandrade.gsw2.material.metal.CopperMaterial;
import io.felipeandrade.gsw2.material.metal.PlatinumMaterial;
import io.felipeandrade.gsw2.material.metal.SilverMaterial;
import io.felipeandrade.gsw2.material.metal.TinMaterial;
import io.felipeandrade.gsw2.material.metal.TitaniumMaterial;

public class GSWWorldGen {


    private static final RangeDecoratorConfig COPPER_RANGE = new RangeDecoratorConfig(16, 30, 30, 80);
    private static final RangeDecoratorConfig TIN_RANGE = new RangeDecoratorConfig(16, 30, 30, 80);
    private static final RangeDecoratorConfig SILVER_RANGE = new RangeDecoratorConfig(16, 10, 10, 60);
    private static final RangeDecoratorConfig TITANIUM_RANGE = new RangeDecoratorConfig(1, 3, 3, 20);
    private static final RangeDecoratorConfig PLATINUM_RANGE = new RangeDecoratorConfig(1, 3, 3, 20);

    private static final RangeDecoratorConfig TOPAZ_RANGE = new RangeDecoratorConfig(1, 4, 4, 40);
    private static final RangeDecoratorConfig AMETHYST_RANGE = new RangeDecoratorConfig(1, 4, 4, 40);
    private static final RangeDecoratorConfig RUBY_RANGE = new RangeDecoratorConfig(1, 4, 4, 40);
    private static final RangeDecoratorConfig SAPPHIRE_RANGE = new RangeDecoratorConfig(1, 4, 4, 40);

    private static List<Biome> checkedBiomes = new ArrayList<>();

    public static void registerWorldGen() {
        //Loop over existing biomes
        Registry.BIOME.forEach(GSWWorldGen::handleBiome);

        //Listen for other biomes being registered
        RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> handleBiome(biome));
    }

    private static void handleBiome(Biome biome) {

        if (checkedBiomes.contains(biome)) {
            //Just to be sure we dont add the stuff twice to the same biome
            return;
        }
        checkedBiomes.add(biome);

        if (isBiomeOverworld(biome)) {
            addOre(biome, CopperMaterial.ORE_BLOCK, 8, COPPER_RANGE);
            addOre(biome, TinMaterial.ORE_BLOCK, 8, TIN_RANGE);
            addOre(biome, SilverMaterial.ORE_BLOCK, 6, SILVER_RANGE);
            addOre(biome, TitaniumMaterial.ORE_BLOCK, 3, TITANIUM_RANGE);
            addOre(biome, PlatinumMaterial.ORE_BLOCK, 3, PLATINUM_RANGE);

            if(Biome.Category.MESA == biome.getCategory()) {
                addOre(biome, RubyMaterial.ORE_BLOCK, 4, RUBY_RANGE);
            }

            if(Biome.Category.JUNGLE == biome.getCategory()){
                addOre(biome, AmethystMaterial.ORE_BLOCK, 4, AMETHYST_RANGE);
            }

            if(Biome.Category.DESERT == biome.getCategory()){
                addOre(biome, TopazMaterial.ORE_BLOCK, 4, TOPAZ_RANGE);
            }

            if(Biome.Category.ICY == biome.getCategory()){
                addOre(biome, SapphireMaterial.ORE_BLOCK, 4, SAPPHIRE_RANGE);
            }
        }

    }


    public static boolean isBiomeOverworld(Biome biome) {
        return biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND;
    }



    private static void addOre(Biome biome, Block ore, int veinSize, RangeDecoratorConfig rangeConfig) {

        OreFeatureConfig featureConfig = new OreFeatureConfig(Target.NATURAL_STONE, ore.getDefaultState(), veinSize);

        biome.addFeature(
                GenerationStep.Feature.UNDERGROUND_ORES,
                Feature.ORE.configure(featureConfig)
                        .createDecoratedFeature(Decorator.COUNT_RANGE.configure(rangeConfig))
        );
    }


}
