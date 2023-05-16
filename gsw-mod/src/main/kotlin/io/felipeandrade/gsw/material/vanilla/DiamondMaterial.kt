package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.GSWHammer
import io.felipeandrade.gsw.item.tool.GSWTool
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.minecraft.item.Item
import net.minecraft.item.ToolMaterials

class DiamondMaterial : GSWMaterial("diamond") {
    override fun allItems(): List<GSWItem> {
        return listOf(DUST, CRUSHED)
    }

    override fun allTools(): List<GSWTool> {
        return listOf(HAMMER)
    }

    companion object {
        val MATERIAL: GSWMaterial = DiamondMaterial()
        val DUST: GSWMaterialItem = GSWMaterialItem("dust", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val CRUSHED: GSWMaterialItem = GSWMaterialItem("crushed", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))

        val HAMMER: GSWTool = GSWHammer(MATERIAL, ToolMaterials.DIAMOND, Item.Settings().group(GSWItemGroup.TOOLS))
    }
}