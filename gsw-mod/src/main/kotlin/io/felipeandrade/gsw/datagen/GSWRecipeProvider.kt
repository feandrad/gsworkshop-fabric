package io.felipeandrade.gsw.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import java.util.function.Consumer

class GSWRecipeProvider(generator: FabricDataGenerator) : FabricRecipeProvider(generator) {
    override fun generateRecipes(exporter: Consumer<RecipeJsonProvider>?) {

    }
}