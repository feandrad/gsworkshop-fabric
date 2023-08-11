package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.datagen.offerTools
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.*
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.RecipeProvider.offerReversibleCompactingRecipes
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.item.Item
import net.minecraft.item.Items
import java.util.function.Consumer

class CopperMaterial : GSWMaterial("copper") {

    override fun allItems(): List<GSWItem> = listOf(NUGGET, DUST, CRUSHED, PLATE)
    override fun allTools(): List<GSWTool> = listOf(SWORD, SHOVEL, PICKAXE, AXE, HOE, HAMMER)

    override fun generateRecipes(provider: FabricRecipeProvider, exporter: Consumer<RecipeJsonProvider>) {
        offerReversibleCompactingRecipes(exporter, Items.COPPER_INGOT, NUGGET)
        offerTools(exporter, Items.COPPER_INGOT, listOf(SWORD, SHOVEL, PICKAXE, AXE, HOE))
        HAMMER.offerRecipe(exporter, Items.COPPER_BLOCK, Items.STICK)
    }

    companion object {
        val MATERIAL: GSWMaterial = CopperMaterial()
        val NUGGET: GSWMaterialItem = GSWMaterialItem(MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS), "nugget")
        val DUST: GSWMaterialItem = GSWMaterialItem(MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS), "dust")
        val PLATE: GSWMaterialItem = GSWMaterialItem(MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS), "plate")
        val CRUSHED: GSWMaterialItem =
            GSWMaterialItem(MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS), "crushed")

        val TOOL_MATERIAL = GSWToolMaterial(1, 160, 5.0f, 1.6f, 16, Items.COPPER_INGOT)
        val SWORD: GSWSword = GSWSword(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val PICKAXE: GSWPickaxe = GSWPickaxe(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val AXE: GSWAxe = GSWAxe(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val SHOVEL: GSWShovel = GSWShovel(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val HOE: GSWHoe = GSWHoe(MATERIAL, TOOL_MATERIAL, -2.0f, Item.Settings().group(GSWItemGroup.TOOLS))
        val HAMMER: GSWHammer = GSWHammer(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
    }
}