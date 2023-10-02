package io.felipeandrade.gsw.material.gem

import io.felipeandrade.gsw.GSWMod
import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.block.GSWMaterialBlock
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.*
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.world.gen.feature.PlacedFeature

class SapphireMaterial : GSWMaterial("sapphire") {

    override fun allItems(): List<GSWItem> = listOf(GEM)
    override fun allBlocks(): List<GSWBlock> = listOf(ORE_BLOCK, DEEPSLATE_ORE_BLOCK, GEM_BLOCK)
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter) {
//        offerTools(exporter, GEM, listOf(SWORD, PICKAXE, AXE, SHOVEL, HOE))
        HAMMER.offerRecipe(exporter, GEM_BLOCK, Items.STICK)
        HAMMER.offerTier3CrushRecipes(exporter)
    }

    companion object {
        val MATERIAL: GSWMaterial = SapphireMaterial()
        val GEM: GSWItem = GSWMaterialItem("gem", MATERIAL, Item.Settings())
        val GEM_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_GEM)
        val ORE_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_ORE, "ore")
        val DEEPSLATE_ORE_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_ORE, "deepslate_ore")

        val TOOL_MATERIAL: GSWToolMaterial = GSWToolMaterial(3, 800, 6.0f, 3.0f, 5, GEM)
        val SWORD: GSWTool = GSWSword(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val PICKAXE: GSWTool = GSWPickaxe(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val AXE: GSWAxe = GSWAxe(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val SHOVEL: GSWShovel = GSWShovel(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val HOE: GSWHoe = GSWHoe(MATERIAL, TOOL_MATERIAL, -0.0f, Item.Settings())
        val HAMMER: GSWHammer = GSWHammer(MATERIAL, TOOL_MATERIAL, Item.Settings())

        val oreGenFeature: RegistryKey<PlacedFeature> = RegistryKey.of(
            RegistryKeys.PLACED_FEATURE,
            Identifier(GSWMod.MOD_ID, "${ORE_BLOCK.unlocalizedName}_placed")
        )
    }
}