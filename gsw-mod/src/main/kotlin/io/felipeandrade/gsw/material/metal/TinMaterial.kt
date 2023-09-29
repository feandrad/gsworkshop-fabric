package io.felipeandrade.gsw.material.metal

import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.block.GSWMaterialBlock
import io.felipeandrade.gsw.datagen.offerOreMaterial
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import io.felipeandrade.gsw.material.MATERIAL_GROUP
import io.felipeandrade.gsw.world.modifiersWithCount
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.util.registry.RegistryEntry
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.feature.*
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier
import java.util.function.Consumer

class TinMaterial : GSWMaterial("tin") {

    override fun allItems(): List<GSWItem> = listOf(INGOT, NUGGET, DUST, CRUSHED, PLATE, RAW)
    override fun allBlocks(): List<GSWBlock> = listOf(ORE_BLOCK, DEEPSLATE_ORE_BLOCK, RAW_BLOCK, METAL_BLOCK)

    override fun generateRecipes(provider: FabricRecipeProvider, exporter: Consumer<RecipeJsonProvider>) {
        offerOreMaterial(exporter, INGOT, NUGGET, METAL_BLOCK, RAW, RAW_BLOCK, listOf(ORE_BLOCK, DEEPSLATE_ORE_BLOCK))
    }

    companion object {

        val MATERIAL: GSWMaterial = TinMaterial()

        val INGOT: GSWItem = GSWMaterialItem("ingot", MATERIAL, MATERIAL_GROUP)
        val NUGGET: GSWMaterialItem = GSWMaterialItem("nugget", MATERIAL, MATERIAL_GROUP)
        val DUST: GSWMaterialItem = GSWMaterialItem("dust", MATERIAL, MATERIAL_GROUP)
        val PLATE: GSWMaterialItem = GSWMaterialItem("plate", MATERIAL, MATERIAL_GROUP)
        val CRUSHED: GSWMaterialItem = GSWMaterialItem("crushed", MATERIAL, MATERIAL_GROUP)
        val RAW: GSWMaterialItem = GSWMaterialItem("raw", MATERIAL, MATERIAL_GROUP)

        val METAL_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_METAL)
        val RAW_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_METAL, "raw_block")
        val ORE_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_ORE, "ore")
        val DEEPSLATE_ORE_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_ORE, "deepslate_ore")

        val oreReplaceableList = listOf(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ORE_BLOCK.defaultState),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, DEEPSLATE_ORE_BLOCK.defaultState),
        )

        val genFeature = ConfiguredFeatures.register(
            ORE_BLOCK.unlocalizedName,
            Feature.ORE,
            OreFeatureConfig(oreReplaceableList, 8)
        )

        var placedFeature: RegistryEntry<PlacedFeature> = PlacedFeatures.register(
            "${ORE_BLOCK.unlocalizedName}_placed",
            genFeature, modifiersWithCount(
                6,
                HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-63), YOffset.aboveBottom(70))
            )
        )
    }
}