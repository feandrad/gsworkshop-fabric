package io.felipeandrade.gsw.material.metal

import io.felipeandrade.gsw.GSWMod
import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.block.GSWMaterialBlock
import io.felipeandrade.gsw.datagen.offerProgressiveCompactingRecipes
import io.felipeandrade.gsw.datagen.offerSmeltingAndBlasting
import io.felipeandrade.gsw.datagen.offerTools
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.*
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import io.felipeandrade.gsw.material.vanilla.CoalMaterial
import io.felipeandrade.gsw.material.vanilla.IronMaterial
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.RecipeProvider
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.Items
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.util.Identifier

class SteelMaterial : GSWMaterial("steel") {
    override fun allItems(): List<GSWItem> = listOf(INGOT, NUGGET, DUST, CRUSHED, PLATE)
    override fun allBlocks(): List<GSWBlock> = listOf(METAL_BLOCK)
    override fun allTools(): List<GSWTool> = BASIC_TOOLS.plus(HAMMER)
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter) {
        offerProgressiveCompactingRecipes(exporter, NUGGET, INGOT, METAL_BLOCK, RecipeCategory.MISC)
        offerSmeltingAndBlasting(exporter, listOf(DUST, CRUSHED), INGOT, 0.7f)
        offerTools(exporter, INGOT, BASIC_TOOLS)
        HAMMER.offerRecipe(exporter, METAL_BLOCK)

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, DUST, 1)
            .input(IronMaterial.DUST, 1)
            .input(CoalMaterial.DUST, 3)
            .criterion(
                RecipeProvider.hasItem(IronMaterial.HAMMER),
                RecipeProvider.conditionsFromItem(IronMaterial.HAMMER)
            )
            .offerTo(exporter, Identifier(GSWMod.MOD_ID, RecipeProvider.getRecipeName(DUST)))

        // Remove after Hammer crush Recipe is implemented
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, INGOT, 1)
            .input(Items.IRON_INGOT, 1)
            .input(Items.COAL, 3)
            .criterion(
                RecipeProvider.hasItem(IronMaterial.HAMMER),
                RecipeProvider.conditionsFromItem(IronMaterial.HAMMER)
            )
            .offerTo(exporter, Identifier(GSWMod.MOD_ID, "${RecipeProvider.getRecipeName(INGOT)}_temp"))
    }

    companion object {
        val MATERIAL: GSWMaterial = SteelMaterial()
        val INGOT: GSWItem = GSWMaterialItem("ingot", MATERIAL, Item.Settings())
        val NUGGET: GSWMaterialItem = GSWMaterialItem("nugget", MATERIAL, Item.Settings())
        val DUST: GSWMaterialItem = GSWMaterialItem("dust", MATERIAL, Item.Settings())
        val PLATE: GSWMaterialItem = GSWMaterialItem("plate", MATERIAL, Item.Settings())
        val CRUSHED: GSWMaterialItem = GSWMaterialItem("crushed", MATERIAL, Item.Settings())
        
        val METAL_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_METAL)

        val TOOL_MATERIAL = GSWToolMaterial(2, 600, 6.0f, 2.0f, 5, INGOT)
        val SWORD: GSWSword = GSWSword(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val PICKAXE: GSWPickaxe = GSWPickaxe(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val AXE: GSWAxe = GSWAxe(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val SHOVEL: GSWShovel = GSWShovel(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val HOE: GSWHoe = GSWHoe(MATERIAL, TOOL_MATERIAL, -1.0f, Item.Settings())
        val HAMMER: GSWHammer = GSWHammer(MATERIAL, TOOL_MATERIAL, Item.Settings())

        val BASIC_TOOLS: List<GSWTool> = listOf(SWORD, SHOVEL, PICKAXE, AXE, HOE)

        fun addMaterialsToItemGroup(entries: ItemGroup.Entries): Unit = with(entries) {
            add(INGOT)
            add(NUGGET)
            add(DUST)
            add(PLATE)
            add(CRUSHED)
            add(METAL_BLOCK)
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