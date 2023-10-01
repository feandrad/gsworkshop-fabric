package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.item.tool.GSWHammer
import io.felipeandrade.gsw.item.tool.GSWTool
import io.felipeandrade.gsw.material.GSWMaterial
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.item.ToolMaterials
import java.util.function.Consumer

class StoneMaterial : GSWMaterial("stone") {

    override fun allTools(): List<GSWTool> = listOf(HAMMER)
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: Consumer<RecipeJsonProvider>) {
        HAMMER.offerRecipe(exporter, Items.STONE, Items.STICK)
    }

    companion object {
        val MATERIAL: GSWMaterial = StoneMaterial()
        val HAMMER: GSWHammer = GSWHammer(MATERIAL, ToolMaterials.STONE, Item.Settings().group(GSWItemGroup.TOOLS))
    }
}