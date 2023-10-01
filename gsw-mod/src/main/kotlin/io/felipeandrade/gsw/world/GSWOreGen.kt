package io.felipeandrade.gsw.world

import io.felipeandrade.gsw.material.gem.RubyMaterial
import io.felipeandrade.gsw.material.gem.SapphireMaterial
import io.felipeandrade.gsw.material.gem.TopazMaterial
import io.felipeandrade.gsw.material.metal.*
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.placementmodifier.*

fun registerWorldGen() {
    BiomeModifications.addFeature(
        BiomeSelectors.foundInOverworld(),
        GenerationStep.Feature.UNDERGROUND_ORES,
        TinMaterial.oreGenFeature
    )

    BiomeModifications.addFeature(
        BiomeSelectors.foundInOverworld(),
        GenerationStep.Feature.UNDERGROUND_ORES,
        SilverMaterial.oreGenFeature
    )

    BiomeModifications.addFeature(
        BiomeSelectors.foundInOverworld(),
        GenerationStep.Feature.UNDERGROUND_ORES,
        PlatinumMaterial.oreGenFeature
    )

    BiomeModifications.addFeature(
        BiomeSelectors.foundInOverworld(),
        GenerationStep.Feature.UNDERGROUND_ORES,
        TitaniumMaterial.oreGenFeature
    )

    BiomeModifications.addFeature(
        BiomeSelectors.foundInOverworld(),
        GenerationStep.Feature.UNDERGROUND_ORES,
        CobaltMaterial.oreGenFeature
    )

    BiomeModifications.addFeature(
        BiomeSelectors.tag(ConventionalBiomeTags.JUNGLE),
        GenerationStep.Feature.UNDERGROUND_ORES,
        RubyMaterial.oreGenFeature
    )

    BiomeModifications.addFeature(
        BiomeSelectors.tag(ConventionalBiomeTags.ICY),
        GenerationStep.Feature.UNDERGROUND_ORES,
        SapphireMaterial.oreGenFeature
    )

    BiomeModifications.addFeature(
        BiomeSelectors.tag(ConventionalBiomeTags.DESERT),
        GenerationStep.Feature.UNDERGROUND_ORES,
        TopazMaterial.oreGenFeature
    )
}

fun modifiers(countModifier: PlacementModifier, heightModifier: PlacementModifier): List<PlacementModifier> {
    return listOf(
        countModifier,
        SquarePlacementModifier.of(),
        heightModifier,
        BiomePlacementModifier.of()
    )
}

fun modifiersWithCount(count: Int, heightModifier: PlacementModifier): List<PlacementModifier> {
    return modifiers(CountPlacementModifier.of(count), heightModifier)
}

fun modifiersWithRarity(chance: Int, heightModifier: PlacementModifier): List<PlacementModifier> {
    return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier)
}
