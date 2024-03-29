package io.felipeandrade.gsw.material.metal

import io.felipeandrade.gsw.GSWMod
import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.block.GSWMaterialBlock
import io.felipeandrade.gsw.datagen.offerOreMaterial
import io.felipeandrade.gsw.datagen.offerTools
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.*
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.Item
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.world.gen.feature.PlacedFeature

class SilverMaterial : GSWMaterial("silver") {

    override fun allItems(): List<GSWItem> = listOf(INGOT, NUGGET, DUST, CRUSHED, PLATE, RAW)
    override fun allBlocks(): List<GSWBlock> = listOf(ORE_BLOCK, DEEPSLATE_ORE_BLOCK, RAW_BLOCK, METAL_BLOCK)
    override fun allTools(): List<GSWTool> = listOf(SWORD, SHOVEL, PICKAXE, AXE, HOE, HAMMER)
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter) {
        offerOreMaterial(exporter, RecipeCategory.MISC, INGOT, NUGGET, METAL_BLOCK, RAW, RAW_BLOCK, listOf(ORE_BLOCK, DEEPSLATE_ORE_BLOCK))
        offerTools(exporter, INGOT, listOf(SWORD, SHOVEL, PICKAXE, AXE, HOE))
        HAMMER.offerRecipe(exporter, METAL_BLOCK)
    }

    companion object {
        val MATERIAL: GSWMaterial = SilverMaterial()
        val INGOT: GSWItem = GSWMaterialItem("ingot", MATERIAL, Item.Settings())
        val NUGGET: GSWMaterialItem = GSWMaterialItem("nugget", MATERIAL, Item.Settings())
        val DUST: GSWMaterialItem = GSWMaterialItem("dust", MATERIAL, Item.Settings())
        val PLATE: GSWMaterialItem = GSWMaterialItem("plate", MATERIAL, Item.Settings())
        val CRUSHED: GSWMaterialItem = GSWMaterialItem("crushed", MATERIAL, Item.Settings())
        val RAW: GSWMaterialItem = GSWMaterialItem("raw", MATERIAL, Item.Settings())

        val TOOL_MATERIAL = GSWToolMaterial(2, 180, 7.0f, 1.8f, 18, INGOT)
        val SWORD: GSWTool = GSWSword(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val PICKAXE: GSWTool = GSWPickaxe(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val AXE: GSWAxe = GSWAxe(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val SHOVEL: GSWShovel = GSWShovel(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val HOE: GSWHoe = GSWHoe(MATERIAL, TOOL_MATERIAL, -1.0f, Item.Settings())
        val HAMMER: GSWHammer = GSWHammer(MATERIAL, TOOL_MATERIAL, Item.Settings())

        val METAL_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_METAL)
        val RAW_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_METAL, "raw_block")
        val ORE_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_ORE, "ore")
        val DEEPSLATE_ORE_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_ORE, "deepslate_ore")

        val oreGenFeature: RegistryKey<PlacedFeature> = RegistryKey.of(
            RegistryKeys.PLACED_FEATURE,
            Identifier(GSWMod.MOD_ID, "${ORE_BLOCK.unlocalizedName}_placed")
        )
    }
}