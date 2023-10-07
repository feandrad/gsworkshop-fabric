package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.datagen.offerSmeltingAndBlasting
import io.felipeandrade.gsw.datagen.offerTools
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.*
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.RecipeProvider.offerReversibleCompactingRecipes
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.Items
import net.minecraft.recipe.book.RecipeCategory

class CopperMaterial : GSWMaterial("copper") {

    override fun allItems(): List<GSWItem> = listOf(NUGGET, DUST, CRUSHED, PLATE)
    override fun allTools(): List<GSWTool> = BASIC_TOOLS.plus(HAMMER)

    override fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, NUGGET, RecipeCategory.MISC, Items.COPPER_INGOT)
        offerSmeltingAndBlasting(exporter, listOf(DUST, CRUSHED), Items.COPPER_INGOT, 0.7f)
        offerTools(exporter, Items.COPPER_INGOT, listOf(SWORD, SHOVEL, PICKAXE, AXE, HOE))
        HAMMER.offerRecipe(exporter, Items.COPPER_BLOCK, Items.STICK)
    }

    companion object {
        val MATERIAL: GSWMaterial = CopperMaterial()
        val NUGGET: GSWMaterialItem = GSWMaterialItem("nugget", MATERIAL, Item.Settings())
        val DUST: GSWMaterialItem = GSWMaterialItem("dust", MATERIAL, Item.Settings())
        val PLATE: GSWMaterialItem = GSWMaterialItem("plate", MATERIAL, Item.Settings())
        val CRUSHED: GSWMaterialItem = GSWMaterialItem("crushed", MATERIAL, Item.Settings())

        val TOOL_MATERIAL = GSWToolMaterial(1, 160, 5.0f, 1.6f, 16, Items.COPPER_INGOT)
        val SWORD: GSWSword = GSWSword(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val PICKAXE: GSWPickaxe = GSWPickaxe(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val AXE: GSWAxe = GSWAxe(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val SHOVEL: GSWShovel = GSWShovel(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val HOE: GSWHoe = GSWHoe(MATERIAL, TOOL_MATERIAL, -2.0f, Item.Settings())
        val HAMMER: GSWHammer = GSWHammer(MATERIAL, TOOL_MATERIAL, Item.Settings())

        val BASIC_TOOLS: List<GSWTool> = listOf(SWORD, SHOVEL, PICKAXE, AXE, HOE)

        fun addMaterialsToItemGroup(entries: ItemGroup.Entries): Unit = with(entries) {
            add(NUGGET)
            add(DUST)
            add(PLATE)
            add(CRUSHED)
        }
        fun addToolsToItemGroup(entries: ItemGroup.Entries): Unit = with(entries) {
            add(SWORD)
            add(PICKAXE)
            add(AXE)
            add(SHOVEL)
            add(HOE)
            add(HAMMER)
        }
    }
}