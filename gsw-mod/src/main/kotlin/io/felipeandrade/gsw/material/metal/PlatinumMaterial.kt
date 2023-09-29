package io.felipeandrade.gsw.material.metal


import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.block.GSWMaterialBlock
import io.felipeandrade.gsw.datagen.offerOreMaterial
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.*
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

class PlatinumMaterial : GSWMaterial("platinum") {

    override fun allItems(): List<GSWItem> = listOf(INGOT, NUGGET, DUST, CRUSHED, PLATE, RAW)
    override fun allBlocks(): List<GSWBlock> = listOf(ORE_BLOCK, DEEPSLATE_ORE_BLOCK, RAW_BLOCK, METAL_BLOCK)
    override fun allTools(): List<GSWTool> = listOf(SWORD, SHOVEL, PICKAXE, AXE, HOE, HAMMER)
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: Consumer<RecipeJsonProvider>) {
        offerOreMaterial(exporter, INGOT, NUGGET, METAL_BLOCK, RAW, RAW_BLOCK, listOf(ORE_BLOCK, DEEPSLATE_ORE_BLOCK))
        HAMMER.offerRecipe(exporter, METAL_BLOCK)
    }

    companion object {
        val MATERIAL: GSWMaterial = PlatinumMaterial()
        val INGOT: GSWItem = GSWMaterialItem("ingot", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val NUGGET: GSWMaterialItem = GSWMaterialItem("nugget", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val DUST: GSWMaterialItem = GSWMaterialItem("dust", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val PLATE: GSWMaterialItem = GSWMaterialItem("plate", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val CRUSHED: GSWMaterialItem = GSWMaterialItem("crushed", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val RAW: GSWMaterialItem = GSWMaterialItem("raw", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))

        val TOOL_MATERIAL: GSWToolMaterial = GSWToolMaterial(3, 980, 8.0f, 3.0f, 18, INGOT)
        val SWORD: GSWTool = GSWSword(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val PICKAXE: GSWTool = GSWPickaxe(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val AXE: GSWAxe = GSWAxe(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val SHOVEL: GSWShovel = GSWShovel(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val HOE: GSWHoe = GSWHoe(MATERIAL, TOOL_MATERIAL, -0.0f, Item.Settings().group(GSWItemGroup.TOOLS))
        val HAMMER: GSWHammer = GSWHammer(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))

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
            OreFeatureConfig(oreReplaceableList, 3)
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