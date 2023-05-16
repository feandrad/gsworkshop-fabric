package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.GSWHammer
import io.felipeandrade.gsw.item.tool.GSWTool
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.minecraft.item.Item
import net.minecraft.item.ToolMaterials

class WoodMaterial : GSWMaterial("wood") {

    override fun allItems(): List<GSWItem> = listOf(DUST)
    override fun allTools(): List<GSWTool> = listOf(HAMMER)

    companion object {
        val MATERIAL: GSWMaterial = WoodMaterial()
        val DUST: GSWMaterialItem = GSWMaterialItem("dust", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val HAMMER: GSWTool = GSWHammer(MATERIAL, ToolMaterials.WOOD, Item.Settings().group(GSWItemGroup.TOOLS))
    }
}