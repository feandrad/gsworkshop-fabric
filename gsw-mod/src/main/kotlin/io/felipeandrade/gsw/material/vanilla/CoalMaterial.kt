package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.Item

class CoalMaterial : GSWMaterial("coal") {

    override fun allItems(): List<GSWItem> = listOf(DUST, CRUSHED)
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter) {

    }

    companion object {
        val MATERIAL: GSWMaterial = CoalMaterial()
        val DUST: GSWMaterialItem = GSWMaterialItem("dust", MATERIAL, Item.Settings())
        val CRUSHED: GSWMaterialItem = GSWMaterialItem("crushed", MATERIAL, Item.Settings())
    }
}