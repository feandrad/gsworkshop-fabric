package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.common.GSWColor
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.GSWHammer
import io.felipeandrade.gsw.item.tool.GSWTool
import io.felipeandrade.gsw.material.ColorProviderMaterialItem
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ToolMaterials
import java.util.*

class DiamondMaterial : GSWMaterial("diamond", GSWColor.cyan) {
    override fun allItems(): List<GSWItem> {
        return listOf(DUST, PLATE, GEAR)
    }

    override fun allTools(): List<GSWTool> {
        return listOf(HAMMER)
    }

    companion object {
        val MATERIAL: GSWMaterial = DiamondMaterial()
        val DUST: GSWMaterialItem =
            ColorProviderMaterialItem("dust", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val PLATE: GSWMaterialItem =
            ColorProviderMaterialItem("plate", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val GEAR: GSWMaterialItem =
            ColorProviderMaterialItem("gear", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val HAMMER: GSWTool = GSWHammer(MATERIAL, ToolMaterials.DIAMOND, Item.Settings().group(ItemGroup.TOOLS))
    }
}