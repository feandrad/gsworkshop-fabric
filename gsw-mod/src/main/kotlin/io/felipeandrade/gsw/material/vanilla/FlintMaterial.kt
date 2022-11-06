package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.common.GSWColor
import io.felipeandrade.gsw.item.tool.*
import io.felipeandrade.gsw.material.GSWMaterial
import net.minecraft.item.Item
import net.minecraft.item.Items
import java.util.*

class FlintMaterial : GSWMaterial("flint", GSWColor.jet_grey_gray) {
    override fun allTools(): List<GSWTool> {
        return listOf(SWORD, PICKAXE, AXE, SHOVEL, HOE)
    }

    companion object {
        val MATERIAL: GSWMaterial = FlintMaterial()
        val TOOL_MATERIAL = GSWToolMaterial(1, 64, 4.0f, 1.0f, 5, Items.FLINT)
        val SWORD: GSWTool = GSWSword(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val PICKAXE: GSWTool = GSWPickaxe(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val AXE: GSWTool = GSWAxe(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val SHOVEL: GSWTool = GSWShovel(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val HOE: GSWTool = GSWHoe(MATERIAL, TOOL_MATERIAL, -3.0f, Item.Settings().group(GSWItemGroup.TOOLS))
    }
}