package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.material.GSWMaterial
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import java.util.function.Consumer

class LeatherMaterial : GSWMaterial("leather") {
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: Consumer<RecipeJsonProvider>) {

    }

    companion object {
        val MATERIAL: GSWMaterial = LeatherMaterial()
    }
}