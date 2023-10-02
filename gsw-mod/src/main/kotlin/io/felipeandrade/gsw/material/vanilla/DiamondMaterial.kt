package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.item.tool.GSWHammer
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import io.felipeandrade.gsw.material.MATERIAL_GROUP
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.item.ToolMaterials

class DiamondMaterial : GSWMaterial("diamond") {

    override fun allTools() = listOf(HAMMER)

    override fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter) {
        HAMMER.offerRecipe(exporter, Items.DIAMOND_BLOCK, Items.STICK)
        HAMMER.offerTier3CrushRecipes(exporter)
    }

    companion object {
        val MATERIAL: GSWMaterial = DiamondMaterial()
        val DUST: GSWMaterialItem = GSWMaterialItem("dust", WoodMaterial.MATERIAL, MATERIAL_GROUP)
        val HAMMER: GSWHammer = GSWHammer(MATERIAL, ToolMaterials.DIAMOND, Item.Settings())
    }
}