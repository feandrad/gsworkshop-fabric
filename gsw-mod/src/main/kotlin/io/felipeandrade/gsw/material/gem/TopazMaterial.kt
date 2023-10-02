package io.felipeandrade.gsw.material.gem

import io.felipeandrade.gsw.GSWMod
import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.block.GSWMaterialBlock
import io.felipeandrade.gsw.datagen.offerCompactingRecipes
import io.felipeandrade.gsw.datagen.offerSmeltingAndBlasting
import io.felipeandrade.gsw.datagen.offerTools
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.*
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Blocks
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.Items
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.world.gen.feature.PlacedFeature

class TopazMaterial : GSWMaterial("topaz") {
    override fun allItems(): List<GSWItem> = listOf(GEM)
    override fun allBlocks(): List<GSWBlock> = listOf(ORE_BLOCK, DEEPSLATE_ORE_BLOCK, GEM_BLOCK)
    override fun allTools(): List<GSWTool> = BASIC_TOOLS.plus(HAMMER)
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter) {
        offerCompactingRecipes(exporter, GEM, GEM_BLOCK)
        offerSmeltingAndBlasting(exporter, listOf(ORE_BLOCK, DEEPSLATE_ORE_BLOCK), GEM)
        offerTools(exporter, GEM, BASIC_TOOLS)
        HAMMER.offerRecipe(exporter, GEM_BLOCK, Items.STICK)
    }

    companion object {
        val MATERIAL: GSWMaterial = TopazMaterial()
        val GEM: GSWItem = GSWMaterialItem("gem", MATERIAL, Item.Settings())
        val GEM_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_GEM)
        val ORE_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, FabricBlockSettings.copy(Blocks.IRON_ORE), "ore")
        val DEEPSLATE_ORE_BLOCK: GSWBlock =
            GSWMaterialBlock(MATERIAL, FabricBlockSettings.copy(Blocks.IRON_ORE), "deepslate_ore")

        val TOOL_MATERIAL: GSWToolMaterial = GSWToolMaterial(3, 800, 6.0f, 3.0f, 5, GEM)
        val SWORD: GSWSword = GSWSword(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val PICKAXE: GSWPickaxe = GSWPickaxe(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val AXE: GSWAxe = GSWAxe(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val SHOVEL: GSWShovel = GSWShovel(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val HOE: GSWHoe = GSWHoe(MATERIAL, TOOL_MATERIAL, -0.0f, Item.Settings())
        val HAMMER: GSWHammer = GSWHammer(MATERIAL, TOOL_MATERIAL, Item.Settings())

        val BASIC_TOOLS: List<GSWTool> = listOf(SWORD, SHOVEL, PICKAXE, AXE, HOE)

        val oreGenFeature: RegistryKey<PlacedFeature> = RegistryKey.of(
            RegistryKeys.PLACED_FEATURE,
            Identifier(GSWMod.MOD_ID, "${ORE_BLOCK.unlocalizedName}_placed")
        )

        fun addMaterialsToItemGroup(entries: ItemGroup.Entries): Unit = with(entries) {
            add(GEM)
            add(GEM_BLOCK)
            add(ORE_BLOCK)
            add(DEEPSLATE_ORE_BLOCK)
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