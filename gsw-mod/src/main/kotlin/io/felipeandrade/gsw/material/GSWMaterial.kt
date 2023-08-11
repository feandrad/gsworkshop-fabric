package io.felipeandrade.gsw.material

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.datagen.registerTools
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.GSWTool
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.item.Item
import java.util.function.Consumer

abstract class GSWMaterial(val unlocalizedName: String) {
    open fun allItems(): List<GSWItem> = listOf()
    open fun allBlocks(): List<GSWBlock> = listOf()
    open fun allTools(): List<GSWTool> = listOf()
    open fun allArmor(): List<GSWItem> = listOf()

    abstract fun generateRecipes(provider: FabricRecipeProvider, exporter: Consumer<RecipeJsonProvider>)
    open fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {
        allBlocks().forEach {
            blockStateModelGenerator.registerCubeAllModelTexturePool(it)
        }
    }

    fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
        allItems().forEach {
            itemModelGenerator.register(it, Models.GENERATED)
        }
        itemModelGenerator.registerTools(allTools())
    }

}

val MATERIAL_SETTINGS: Item.Settings = Item.Settings().group(GSWItemGroup.MATERIALS)
val TOOLS_SETTINGS: Item.Settings = Item.Settings().group(GSWItemGroup.TOOLS)