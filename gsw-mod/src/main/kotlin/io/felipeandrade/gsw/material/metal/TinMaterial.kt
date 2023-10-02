package io.felipeandrade.gsw.material.metal

import io.felipeandrade.gsw.GSWMod.Companion.MOD_ID
import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.block.GSWMaterialBlock
import io.felipeandrade.gsw.datagen.offerOreMaterial
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import io.felipeandrade.gsw.material.MATERIAL_GROUP
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.world.gen.feature.PlacedFeature

class TinMaterial : GSWMaterial("tin") {

    override fun allItems(): List<GSWItem> = listOf(INGOT, NUGGET, DUST, CRUSHED, PLATE, RAW)
    override fun allBlocks(): List<GSWBlock> = listOf(ORE_BLOCK, DEEPSLATE_ORE_BLOCK, RAW_BLOCK, METAL_BLOCK)

    override fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter) {
        offerOreMaterial(
            exporter = exporter,
            recipeCategory = RecipeCategory.MISC,
            ingot = INGOT,
            nugget = NUGGET,
            block = METAL_BLOCK,
            raw = RAW,
            rawBlock = RAW_BLOCK,
            ingotSmelts = listOf(RAW, ORE_BLOCK, DEEPSLATE_ORE_BLOCK)
        )
    }

    companion object {

        val MATERIAL: GSWMaterial = TinMaterial()

        val INGOT: GSWItem = GSWMaterialItem("ingot", MATERIAL, MATERIAL_GROUP)
        val NUGGET: GSWMaterialItem = GSWMaterialItem("nugget", MATERIAL, MATERIAL_GROUP)
        val DUST: GSWMaterialItem = GSWMaterialItem("dust", MATERIAL, MATERIAL_GROUP)
        val PLATE: GSWMaterialItem = GSWMaterialItem("plate", MATERIAL, MATERIAL_GROUP)
        val CRUSHED: GSWMaterialItem = GSWMaterialItem("crushed", MATERIAL, MATERIAL_GROUP)
        val RAW: GSWMaterialItem = GSWMaterialItem("raw", MATERIAL, MATERIAL_GROUP)

        val METAL_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_METAL)
        val RAW_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_METAL, "raw_block")
        val ORE_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_ORE, "ore")
        val DEEPSLATE_ORE_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_ORE, "deepslate_ore")

        val oreGenFeature: RegistryKey<PlacedFeature> = RegistryKey.of(
            RegistryKeys.PLACED_FEATURE,
            Identifier(MOD_ID, "${ORE_BLOCK.unlocalizedName}_placed")
        )
    }
}