package io.felipeandrade.gsw.material.metal

import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.block.GSWMaterialBlock
import io.felipeandrade.gsw.datagen.offerProgressiveCompactingRecipes
import io.felipeandrade.gsw.datagen.offerTools
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.*
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.Item
import net.minecraft.recipe.book.RecipeCategory

class SteelMaterial : GSWMaterial("steel") {
    override fun allItems(): List<GSWItem> = listOf(INGOT, NUGGET, DUST, CRUSHED, PLATE)
    override fun allBlocks(): List<GSWBlock> = listOf(METAL_BLOCK)
    override fun allTools(): List<GSWTool> = listOf(SWORD, SHOVEL, PICKAXE, AXE, HOE, HAMMER)
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter) {
        offerProgressiveCompactingRecipes(exporter, RecipeCategory.MISC, NUGGET, INGOT, METAL_BLOCK)
        offerTools(exporter, INGOT, listOf(SWORD, SHOVEL, PICKAXE, AXE, HOE))
        HAMMER.offerRecipe(exporter, METAL_BLOCK)
    }

    companion object {
        val MATERIAL: GSWMaterial = SteelMaterial()
        val INGOT: GSWItem = GSWMaterialItem("ingot", MATERIAL, Item.Settings())
        val NUGGET: GSWMaterialItem = GSWMaterialItem("nugget", MATERIAL, Item.Settings())
        val DUST: GSWMaterialItem = GSWMaterialItem("dust", MATERIAL, Item.Settings())
        val PLATE: GSWMaterialItem = GSWMaterialItem("plate", MATERIAL, Item.Settings())
        val CRUSHED: GSWMaterialItem = GSWMaterialItem("crushed", MATERIAL, Item.Settings())

        val TOOL_MATERIAL = GSWToolMaterial(2, 600, 6.0f, 2.0f, 5, INGOT)
        val SWORD: GSWTool = GSWSword(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val PICKAXE: GSWTool = GSWPickaxe(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val AXE: GSWAxe = GSWAxe(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val SHOVEL: GSWShovel = GSWShovel(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val HOE: GSWHoe = GSWHoe(MATERIAL, TOOL_MATERIAL, -1.0f, Item.Settings())
        val HAMMER: GSWHammer = GSWHammer(MATERIAL, TOOL_MATERIAL, Item.Settings())

        val METAL_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_METAL)
    }
}