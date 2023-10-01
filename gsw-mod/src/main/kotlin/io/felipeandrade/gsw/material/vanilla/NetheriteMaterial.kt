package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.GSWHammer
import io.felipeandrade.gsw.item.tool.GSWTool
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.item.ToolMaterials
import java.util.function.Consumer

class NetheriteMaterial : GSWMaterial("netherite") {

    override fun allItems(): List<GSWItem> = listOf(DUST, CRUSHED, PLATE)
    override fun allTools(): List<GSWTool> = listOf(HAMMER)
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: Consumer<RecipeJsonProvider>) {
        HAMMER.offerRecipe(exporter, Items.NETHERITE_BLOCK, Items.STICK)
    }

    companion object {
        val MATERIAL: GSWMaterial = NetheriteMaterial()
        val DUST: GSWMaterialItem = GSWMaterialItem("dust", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val PLATE: GSWMaterialItem = GSWMaterialItem("plate", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val CRUSHED: GSWMaterialItem =
            GSWMaterialItem("crushed", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))

        val HAMMER: GSWHammer = GSWHammer(MATERIAL, ToolMaterials.NETHERITE, Item.Settings().group(GSWItemGroup.TOOLS))
    }
}