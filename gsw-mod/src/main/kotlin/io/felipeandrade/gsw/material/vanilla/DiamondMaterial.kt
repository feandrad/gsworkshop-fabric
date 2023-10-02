package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.datagen.offerSmeltingAndBlasting
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.GSWHammer
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import io.felipeandrade.gsw.material.MATERIAL_GROUP
import io.felipeandrade.gsw.material.TOOLS_GROUP
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.RecipeProvider.offerReversibleCompactingRecipes
import net.minecraft.item.ItemGroup
import net.minecraft.item.Items
import net.minecraft.item.ToolMaterials
import net.minecraft.recipe.book.RecipeCategory

class DiamondMaterial : GSWMaterial("diamond") {

    override fun allItems(): List<GSWItem> = listOf(NUGGET, DUST, CRUSHED, PLATE)
    override fun allTools() = listOf(HAMMER)

    override fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.DIAMOND, RecipeCategory.MISC, NUGGET)
        offerSmeltingAndBlasting(exporter, listOf(DUST, CRUSHED), Items.DIAMOND, 0.7f)
        HAMMER.offerRecipe(exporter, Items.DIAMOND_BLOCK, Items.STICK)
    }

    companion object {
        val MATERIAL: GSWMaterial = DiamondMaterial()
        val NUGGET: GSWMaterialItem = GSWMaterialItem("nugget", MATERIAL, MATERIAL_GROUP)
        val DUST: GSWMaterialItem = GSWMaterialItem("dust", MATERIAL, MATERIAL_GROUP)
        val PLATE: GSWMaterialItem = GSWMaterialItem("plate", MATERIAL, MATERIAL_GROUP)
        val CRUSHED: GSWMaterialItem = GSWMaterialItem("crushed", MATERIAL, MATERIAL_GROUP)

        val HAMMER: GSWHammer = GSWHammer(MATERIAL, ToolMaterials.DIAMOND, TOOLS_GROUP)

        fun addMaterialsToItemGroup(entries: ItemGroup.Entries): Unit = with(entries) {
            add(NUGGET)
            add(DUST)
            add(PLATE)
            add(CRUSHED)
        }
        fun addToolsToItemGroup(entries: ItemGroup.Entries): Unit = with(entries) {
            add(HAMMER)
        }
    }
}