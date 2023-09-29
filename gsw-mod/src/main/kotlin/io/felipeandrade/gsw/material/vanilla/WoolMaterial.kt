package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.material.GSWMaterial
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter

class WoolMaterial : GSWMaterial("wool") {
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter) {

    }
    companion object {
        val MATERIAL: GSWMaterial = WoolMaterial()
    }
}