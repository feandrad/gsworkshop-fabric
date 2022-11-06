package io.felipeandrade.gsw.material.metal

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.common.GSWColor
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.*
import io.felipeandrade.gsw.material.ColorProviderMaterialItem
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.minecraft.item.Item
import net.minecraft.item.Items

class CopperMaterial : GSWMaterial("copper", GSWColor.dark_orange) {
    override fun allItems(): List<GSWItem> = listOf(NUGGET, DUST, PLATE, GEAR, WIRE)
    override fun allTools(): List<GSWTool> = listOf(SWORD, PICKAXE, AXE, SHOVEL, HOE, HAMMER)

    companion object {
        val MATERIAL: GSWMaterial = CopperMaterial()
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
        val TOOL_MATERIAL = GSWToolMaterial(1, 160, 5.0f, 1.6f, 16, Items.COPPER_INGOT)
        val SWORD: GSWTool = GSWSword(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val PICKAXE: GSWTool = GSWPickaxe(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val AXE: GSWTool = GSWAxe(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val SHOVEL: GSWTool = GSWShovel(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val HOE: GSWTool = GSWHoe(MATERIAL, TOOL_MATERIAL, -2.0f, Item.Settings().group(GSWItemGroup.TOOLS))
        val HAMMER: GSWTool = GSWHammer(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
    }
}