package io.felipeandrade.gsw.material.metal

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.block.ColorProviderMaterialBlock
import io.felipeandrade.gsw.block.ColorProviderOreBlock
import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.block.GSWMaterialBlock
import io.felipeandrade.gsw.common.GSWColor
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.GSWTool
import io.felipeandrade.gsw.material.ColorProviderMaterialItem
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.minecraft.item.*
import java.util.*

class TinMaterial : GSWMaterial("tin", GSWColor.light_steel_blue) {
    override fun allItems(): List<GSWItem> {
        return listOf(INGOT, NUGGET, DUST, PLATE, GEAR, WIRE)
    }

    override fun allBlocks(): List<GSWBlock> {
        return listOf(ORE_BLOCK, METAL_BLOCK)
    }

    override fun allTools(): List<GSWTool> {
        return ArrayList()
    }

    companion object {
        val MATERIAL: GSWMaterial = TinMaterial()
        val INGOT: GSWItem = ColorProviderMaterialItem("ingot", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val NUGGET: GSWMaterialItem =
            ColorProviderMaterialItem("nugget", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val DUST: GSWMaterialItem =
            ColorProviderMaterialItem("dust", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val PLATE: GSWMaterialItem =
            ColorProviderMaterialItem("plate", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val GEAR: GSWMaterialItem =
            ColorProviderMaterialItem("gear", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val WIRE: GSWMaterialItem =
            ColorProviderMaterialItem("wire", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val METAL_BLOCK: GSWBlock = ColorProviderMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_METAL)
        val ORE_BLOCK: GSWBlock = ColorProviderOreBlock(MATERIAL, GSWMaterialBlock.SETTINGS_ORE)
    }
}