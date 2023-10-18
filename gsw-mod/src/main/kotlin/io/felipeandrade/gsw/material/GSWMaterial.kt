package io.felipeandrade.gsw.material

import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.GswArmorItem
import io.felipeandrade.gsw.item.tool.GSWTool
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter

abstract class GSWMaterial(val unlocalizedName: String) {
    open fun allItems(): List<GSWItem> = listOf()
    open fun allBlocks(): List<GSWBlock> = listOf()
    open fun allTools(): List<GSWTool> = listOf()
    open fun allArmor(): List<GswArmorItem> = listOf()

    abstract fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter)

}