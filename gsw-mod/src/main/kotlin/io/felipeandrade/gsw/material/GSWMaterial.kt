package io.felipeandrade.gsw.material

import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.GSWTool
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.Item

abstract class GSWMaterial(val unlocalizedName: String) {
    open fun allItems(): List<GSWItem> = listOf()
    open fun allBlocks(): List<GSWBlock> = listOf()
    open fun allTools(): List<GSWTool> = listOf()
    open fun allArmor(): List<GSWTool> = listOf()

    abstract fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter)

}

val MATERIAL_GROUP: Item.Settings = Item.Settings()
val TOOLS_GROUP: Item.Settings = Item.Settings()