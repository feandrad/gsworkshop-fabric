package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.item.Item
import java.util.function.Consumer

class CoalMaterial : GSWMaterial("coal") {

    override fun allItems(): List<GSWItem> = listOf(DUST, CRUSHED)
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: Consumer<RecipeJsonProvider>) {

    }

    companion object {
        val MATERIAL: GSWMaterial = CoalMaterial()
        val DUST: GSWMaterialItem = GSWMaterialItem("dust", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val CRUSHED: GSWMaterialItem = GSWMaterialItem("crushed", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
    }
}