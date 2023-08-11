package io.felipeandrade.gsw.material.metal

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.block.GSWMaterialBlock
import io.felipeandrade.gsw.datagen.offerProgressiveCompactingRecipes
import io.felipeandrade.gsw.datagen.offerTools
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.*
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.item.Item
import java.util.function.Consumer

class SteelMaterial : GSWMaterial("steel") {
    override fun allItems(): List<GSWItem> = listOf(INGOT, NUGGET, DUST, CRUSHED, PLATE)
    override fun allBlocks(): List<GSWBlock> = listOf(METAL_BLOCK)
    override fun allTools(): List<GSWTool> = listOf(SWORD, SHOVEL, PICKAXE, AXE, HOE, HAMMER)
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: Consumer<RecipeJsonProvider>) {
        offerProgressiveCompactingRecipes(exporter, NUGGET, INGOT, METAL_BLOCK)
        offerTools(exporter, INGOT, listOf(SWORD, SHOVEL, PICKAXE, AXE, HOE))
        HAMMER.offerRecipe(exporter, METAL_BLOCK)
    }

    companion object {
        val MATERIAL: GSWMaterial = SteelMaterial()
        val INGOT: GSWItem = GSWMaterialItem(MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS), "ingot")
        val NUGGET: GSWMaterialItem = GSWMaterialItem(MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS), "nugget")
        val DUST: GSWMaterialItem = GSWMaterialItem(MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS), "dust")
        val PLATE: GSWMaterialItem = GSWMaterialItem(MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS), "plate")
        val CRUSHED: GSWMaterialItem = GSWMaterialItem(
            MATERIAL,
            Item.Settings().group(GSWItemGroup.MATERIALS),
            "crushed"
        )

        val TOOL_MATERIAL = GSWToolMaterial(2, 600, 6.0f, 2.0f, 5, INGOT)
        val SWORD: GSWTool = GSWSword(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val PICKAXE: GSWTool = GSWPickaxe(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val AXE: GSWAxe = GSWAxe(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val SHOVEL: GSWShovel = GSWShovel(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val HOE: GSWHoe = GSWHoe(MATERIAL, TOOL_MATERIAL, -1.0f, Item.Settings().group(GSWItemGroup.TOOLS))
        val HAMMER: GSWHammer = GSWHammer(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))

        val METAL_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_METAL)
    }
}