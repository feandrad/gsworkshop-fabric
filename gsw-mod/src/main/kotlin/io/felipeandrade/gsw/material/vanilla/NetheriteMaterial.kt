package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.GSWHammer
import io.felipeandrade.gsw.item.tool.GSWTool
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.item.ToolMaterials

class NetheriteMaterial : GSWMaterial("netherite") {

    override fun allItems(): List<GSWItem> = listOf(DUST, CRUSHED, PLATE)
    override fun allTools(): List<GSWTool> = listOf(HAMMER)
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter) {
        HAMMER.offerRecipe(exporter, Items.NETHERITE_BLOCK, Items.STICK)
    }

    companion object {
        val MATERIAL: GSWMaterial = NetheriteMaterial()
        val DUST: GSWMaterialItem = GSWMaterialItem("dust", MATERIAL, Item.Settings())
        val PLATE: GSWMaterialItem = GSWMaterialItem("plate", MATERIAL, Item.Settings())
        val CRUSHED: GSWMaterialItem =
            GSWMaterialItem("crushed", MATERIAL, Item.Settings())

        val HAMMER: GSWHammer = GSWHammer(MATERIAL, ToolMaterials.NETHERITE, Item.Settings())
    }
}