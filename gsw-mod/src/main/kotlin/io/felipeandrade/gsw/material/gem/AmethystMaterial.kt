package io.felipeandrade.gsw.material.gem

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.block.GSWMaterialBlock
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.minecraft.item.Item

class AmethystMaterial : GSWMaterial("amethyst") {
    override fun allItems(): List<GSWItem> = listOf(GEM)
    override fun allBlocks(): List<GSWBlock> = listOf(ORE_BLOCK, GEM_BLOCK)

    companion object {
        val MATERIAL: GSWMaterial = AmethystMaterial()
        val GEM: GSWItem = GSWMaterialItem("gem", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val GEM_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_GEM)
        val ORE_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_ORE, "ore")
    }
}