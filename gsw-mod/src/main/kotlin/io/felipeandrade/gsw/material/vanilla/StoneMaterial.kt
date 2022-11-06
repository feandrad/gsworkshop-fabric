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

class StoneMaterial : GSWMaterial("stone", GSWColor.dark_gray_dark_grey) {
    override fun allTools(): List<GSWTool> {
        return listOf(HAMMER)
    }

    override fun allItems(): List<GSWItem> {
        return listOf(GEAR)
    }

    companion object {
        val MATERIAL: GSWMaterial = StoneMaterial()
        val GEAR: GSWMaterialItem =
            ColorProviderMaterialItem("gear", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val HAMMER: GSWTool = GSWHammer(MATERIAL, ToolMaterials.STONE, Item.Settings().group(ItemGroup.TOOLS))
    }
}