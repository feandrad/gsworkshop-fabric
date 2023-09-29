package io.felipeandrade.gsw.material.gem

import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.block.GSWMaterialBlock
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.Item

class TopazMaterial : GSWMaterial("topaz") {
    override fun allItems(): List<GSWItem> = listOf(GEM)
    override fun allBlocks(): List<GSWBlock> = listOf(ORE_BLOCK, DEEPSLATE_ORE_BLOCK, GEM_BLOCK)
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter) {

    }

    companion object {
        val MATERIAL: GSWMaterial = TopazMaterial()
        val GEM: GSWItem = GSWMaterialItem("gem", MATERIAL, Item.Settings())
        val GEM_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_GEM)
        val ORE_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_ORE, "ore")
        val DEEPSLATE_ORE_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_ORE, "deepslate_ore")
    }
}