package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.item.tool.GSWHammer
import io.felipeandrade.gsw.material.GSWMaterial
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.item.ToolMaterials
import java.util.function.Consumer

class DiamondMaterial : GSWMaterial("diamond") {

    override fun allTools() = listOf(HAMMER)

    override fun generateRecipes(provider: FabricRecipeProvider, exporter: Consumer<RecipeJsonProvider>) {
        HAMMER.offerRecipe(exporter, Items.DIAMOND_BLOCK, Items.STICK)
    }

    companion object {
        val MATERIAL: GSWMaterial = DiamondMaterial()

        val HAMMER: GSWHammer = GSWHammer(MATERIAL, ToolMaterials.DIAMOND, Item.Settings().group(GSWItemGroup.TOOLS))
    }
}