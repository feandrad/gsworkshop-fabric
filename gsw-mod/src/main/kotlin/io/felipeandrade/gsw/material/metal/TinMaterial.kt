package io.felipeandrade.gsw.material.metal

import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.block.GSWMaterialBlock
import io.felipeandrade.gsw.datagen.offerOreMaterial
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import io.felipeandrade.gsw.material.MATERIAL_SETTINGS
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import java.util.function.Consumer

class TinMaterial : GSWMaterial("tin") {

    override fun allItems(): List<GSWItem> = listOf(INGOT, NUGGET, DUST, CRUSHED, PLATE, RAW)
    override fun allBlocks(): List<GSWBlock> = listOf(ORE_BLOCK, DEEPSLATE_ORE_BLOCK, RAW_BLOCK, METAL_BLOCK)

    override fun generateRecipes(provider: FabricRecipeProvider, exporter: Consumer<RecipeJsonProvider>) {
        offerOreMaterial(exporter, INGOT, NUGGET, METAL_BLOCK, RAW, RAW_BLOCK, listOf(ORE_BLOCK, DEEPSLATE_ORE_BLOCK))
    }

    companion object {
        val MATERIAL: GSWMaterial = TinMaterial()

        val INGOT: GSWItem = GSWMaterialItem(MATERIAL, MATERIAL_SETTINGS, "ingot")
        val NUGGET: GSWMaterialItem = GSWMaterialItem(MATERIAL, MATERIAL_SETTINGS, "nugget")
        val DUST: GSWMaterialItem = GSWMaterialItem(MATERIAL, MATERIAL_SETTINGS, "dust")
        val PLATE: GSWMaterialItem = GSWMaterialItem(MATERIAL, MATERIAL_SETTINGS, "plate")
        val CRUSHED: GSWMaterialItem = GSWMaterialItem(MATERIAL, MATERIAL_SETTINGS, "crushed")
        val RAW: GSWMaterialItem = GSWMaterialItem(MATERIAL, MATERIAL_SETTINGS, "raw")

        val METAL_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_METAL)
        val RAW_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_METAL, "raw_block")
        val ORE_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_ORE, "ore")
        val DEEPSLATE_ORE_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_ORE, "deepslate_ore")
    }
}