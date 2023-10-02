package io.felipeandrade.gsw.material.metal

import io.felipeandrade.gsw.GSWMod
import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.block.GSWMaterialBlock
import io.felipeandrade.gsw.datagen.offerProgressiveCompactingRecipes
import io.felipeandrade.gsw.datagen.offerTools
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.*
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import io.felipeandrade.gsw.material.vanilla.CopperMaterial
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.RecipeProvider
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder
import net.minecraft.item.Item
import net.minecraft.item.Items.STICK
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.util.Identifier

class BronzeMaterial : GSWMaterial("bronze") {

    override fun allItems(): List<GSWItem> = listOf(INGOT, NUGGET, DUST, CRUSHED, PLATE)
    override fun allBlocks(): List<GSWBlock> = listOf(METAL_BLOCK)
    override fun allTools(): List<GSWTool> = listOf(SWORD, SHOVEL, PICKAXE, AXE, HOE, HAMMER)
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter) {
        offerProgressiveCompactingRecipes(exporter, RecipeCategory.MISC, NUGGET, INGOT, METAL_BLOCK)
        offerTools(exporter, INGOT, listOf(SWORD, SHOVEL, PICKAXE, AXE, HOE))
        HAMMER.offerRecipe(exporter, METAL_BLOCK, STICK)
        HAMMER.offerTier2CrushRecipes(exporter)

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, DUST, 4)
            .input(TinMaterial.DUST, 1)
            .input(CopperMaterial.DUST, 3)
            .criterion(RecipeProvider.hasItem(TinMaterial.DUST), RecipeProvider.conditionsFromItem(TinMaterial.DUST))
            .offerTo(exporter, Identifier(GSWMod.MOD_ID, RecipeProvider.getRecipeName(DUST)))
    }

    companion object {
        val MATERIAL: GSWMaterial = BronzeMaterial()
        val INGOT: GSWItem = GSWMaterialItem("ingot", MATERIAL, Item.Settings())
        val NUGGET: GSWMaterialItem = GSWMaterialItem("nugget", MATERIAL, Item.Settings())
        val DUST: GSWMaterialItem = GSWMaterialItem("dust", MATERIAL, Item.Settings())
        val PLATE: GSWMaterialItem = GSWMaterialItem("plate", MATERIAL, Item.Settings())
        val CRUSHED: GSWMaterialItem =
            GSWMaterialItem("crushed", MATERIAL, Item.Settings())

        val TOOL_MATERIAL = GSWToolMaterial(2, 250, 6.0f, 2.0f, 14, INGOT)
        val SHOVEL: GSWShovel = GSWShovel(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val SWORD: GSWTool = GSWSword(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val AXE: GSWAxe = GSWAxe(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val PICKAXE: GSWTool = GSWPickaxe(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val HAMMER: GSWHammer = GSWHammer(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val HOE: GSWHoe = GSWHoe(MATERIAL, TOOL_MATERIAL, -1.0f, Item.Settings())

        val METAL_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_METAL)

        val MATERIAL_ENTRIES = listOf(NUGGET, DUST, PLATE, CRUSHED)
        val TOOL_ENTRIES = listOf(SWORD, PICKAXE, AXE, SHOVEL, HOE, HAMMER)
    }
}