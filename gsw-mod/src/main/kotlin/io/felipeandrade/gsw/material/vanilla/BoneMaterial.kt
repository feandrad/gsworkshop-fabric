package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.datagen.offerTools
import io.felipeandrade.gsw.item.tool.*
import io.felipeandrade.gsw.material.GSWMaterial
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.Items

class BoneMaterial : GSWMaterial("bone") {
    override fun allTools(): List<GSWTool> = BASIC_TOOLS.plus(HAMMER)

    override fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter) {
        offerTools(exporter, Items.BONE, listOf(SWORD, SHOVEL, PICKAXE, AXE, HOE))
        HAMMER.offerRecipe(exporter, Items.BONE_BLOCK)
    }

    companion object {
        val MATERIAL: GSWMaterial = BoneMaterial()
        val TOOL_MATERIAL = GSWToolMaterial(1, 42, 3.0f, 1.0f, 18, Items.BONE)
        val SWORD: GSWSword = GSWSword(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val PICKAXE: GSWPickaxe = GSWPickaxe(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val AXE: GSWAxe = GSWAxe(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val SHOVEL: GSWShovel = GSWShovel(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val HOE: GSWHoe = GSWHoe(MATERIAL, TOOL_MATERIAL, -3.0f, Item.Settings())
        val HAMMER: GSWHammer = GSWHammer(MATERIAL, TOOL_MATERIAL, Item.Settings())

        val BASIC_TOOLS: List<GSWTool> = listOf(SWORD, SHOVEL, PICKAXE, AXE, HOE)

        fun addMaterialsToItemGroup(entries: ItemGroup.Entries) { }

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