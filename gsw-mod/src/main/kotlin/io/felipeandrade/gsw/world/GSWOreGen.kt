package io.felipeandrade.gsw.world

import io.felipeandrade.gsw.material.gem.RubyMaterial
import io.felipeandrade.gsw.material.gem.SapphireMaterial
import io.felipeandrade.gsw.material.gem.TopazMaterial
import io.felipeandrade.gsw.material.metal.*
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.placementmodifier.*

fun registerWorldGen() {
    BiomeModifications.addFeature(
        BiomeSelectors.foundInOverworld(),
        GenerationStep.Feature.UNDERGROUND_ORES,
        TinMaterial.placedFeature.key.get()
    )

    BiomeModifications.addFeature(
        BiomeSelectors.foundInOverworld(),
        GenerationStep.Feature.UNDERGROUND_ORES,
        SilverMaterial.placedFeature.key.get()
    )

    BiomeModifications.addFeature(
        BiomeSelectors.foundInOverworld(),
        GenerationStep.Feature.UNDERGROUND_ORES,
        PlatinumMaterial.placedFeature.key.get()
    )

    BiomeModifications.addFeature(
        BiomeSelectors.foundInOverworld(),
        GenerationStep.Feature.UNDERGROUND_ORES,
        TitaniumMaterial.placedFeature.key.get()
    )

    BiomeModifications.addFeature(
        BiomeSelectors.foundInOverworld(),
        GenerationStep.Feature.UNDERGROUND_ORES,
        CobaltMaterial.placedFeature.key.get()
    )

    BiomeModifications.addFeature(
        BiomeSelectors.foundInOverworld(),
        GenerationStep.Feature.UNDERGROUND_ORES,
        RubyMaterial.placedFeature.key.get()
    )

    BiomeModifications.addFeature(
        BiomeSelectors.foundInOverworld(),
        GenerationStep.Feature.UNDERGROUND_ORES,
        SapphireMaterial.placedFeature.key.get()
    )

    BiomeModifications.addFeature(
        BiomeSelectors.foundInOverworld(),
        GenerationStep.Feature.UNDERGROUND_ORES,
        TopazMaterial.placedFeature.key.get()
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
