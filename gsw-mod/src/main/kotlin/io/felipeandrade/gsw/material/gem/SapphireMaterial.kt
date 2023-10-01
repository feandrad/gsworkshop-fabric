package io.felipeandrade.gsw.material.gem

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.block.GSWMaterialBlock
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import io.felipeandrade.gsw.world.modifiersWithCount
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.item.Item
import net.minecraft.util.registry.RegistryEntry
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.feature.*
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier
import java.util.function.Consumer

class SapphireMaterial : GSWMaterial("sapphire") {

    override fun allItems(): List<GSWItem> = listOf(GEM)
    override fun allBlocks(): List<GSWBlock> = listOf(ORE_BLOCK, DEEPSLATE_ORE_BLOCK, GEM_BLOCK)
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: Consumer<RecipeJsonProvider>) {

    }

    companion object {
        val MATERIAL: GSWMaterial = SapphireMaterial()
        val GEM: GSWItem = GSWMaterialItem("gem", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val GEM_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_GEM)
        val ORE_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_ORE, "ore")
        val DEEPSLATE_ORE_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_ORE, "deepslate_ore")

        val oreReplaceableList = listOf(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ORE_BLOCK.defaultState),
            OreFeatureConfig.createTarget(
                OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                DEEPSLATE_ORE_BLOCK.defaultState
            ),
        )

        val genFeature = ConfiguredFeatures.register(
            ORE_BLOCK.unlocalizedName,
            Feature.ORE,
            OreFeatureConfig(oreReplaceableList, 4)
        )

        var placedFeature: RegistryEntry<PlacedFeature> = PlacedFeatures.register(
            "${ORE_BLOCK.unlocalizedName}_placed",
            genFeature, modifiersWithCount(
                1,
                HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(16))
            )
        )
    }
}