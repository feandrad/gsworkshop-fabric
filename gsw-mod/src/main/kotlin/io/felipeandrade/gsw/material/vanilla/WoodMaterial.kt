package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.GSWHammer
import io.felipeandrade.gsw.item.tool.GSWTool
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import io.felipeandrade.gsw.material.MATERIAL_SETTINGS
import io.felipeandrade.gsw.material.TOOLS_SETTINGS
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.item.ToolMaterials
import java.util.function.Consumer

class WoodMaterial : GSWMaterial("wood") {

    override fun allItems(): List<GSWItem> = listOf(DUST)
    override fun allTools(): List<GSWTool> = listOf(HAMMER)
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: Consumer<RecipeJsonProvider>) {

    }

    companion object {
        val MATERIAL: GSWMaterial = WoodMaterial()
        val DUST: GSWMaterialItem = GSWMaterialItem(MATERIAL, MATERIAL_SETTINGS, "dust")
        val HAMMER: GSWHammer = GSWHammer(MATERIAL, ToolMaterials.WOOD, TOOLS_SETTINGS)
    }
}