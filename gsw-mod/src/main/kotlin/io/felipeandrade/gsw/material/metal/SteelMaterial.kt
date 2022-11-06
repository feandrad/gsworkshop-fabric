package io.felipeandrade.gsw.material.metal

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.block.ColorProviderMaterialBlock
import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.block.GSWMaterialBlock
import io.felipeandrade.gsw.common.GSWColor
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.*
import io.felipeandrade.gsw.material.ColorProviderMaterialItem
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.minecraft.item.*
import java.util.*

class SteelMaterial : GSWMaterial("steel", GSWColor.gray_grey) {
    override fun allItems(): List<GSWItem> {
        return listOf(INGOT, NUGGET, DUST, PLATE, GEAR, WIRE)
    }

    override fun allBlocks(): List<GSWBlock> {
        return listOf(METAL_BLOCK)
    }

    override fun allTools(): List<GSWTool> {
        return listOf(SWORD, PICKAXE, AXE, SHOVEL, HOE, HAMMER)
    }

    companion object {
        val MATERIAL: GSWMaterial = SteelMaterial()
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
        val TOOL_MATERIAL = GSWToolMaterial(2, 600, 6.0f, 2.0f, 5, INGOT)
        val SWORD: GSWTool = GSWSword(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val PICKAXE: GSWTool = GSWPickaxe(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val AXE: GSWTool = GSWAxe(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val SHOVEL: GSWTool = GSWShovel(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val HOE: GSWTool = GSWHoe(MATERIAL, TOOL_MATERIAL, -1.0f, Item.Settings().group(GSWItemGroup.TOOLS))
        val HAMMER: GSWTool = GSWHammer(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
    }
}