package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.GSWHammer
import io.felipeandrade.gsw.item.tool.GSWTool
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ToolMaterials

class GoldMaterial : GSWMaterial("gold") {

    override fun allItems(): List<GSWItem> = listOf(DUST, PLATE, CRUSHED)
    override fun allTools(): List<GSWTool> = listOf(HAMMER)

    companion object {
        val MATERIAL: GSWMaterial = GoldMaterial()
        val DUST: GSWMaterialItem = GSWMaterialItem("dust", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val PLATE: GSWMaterialItem = GSWMaterialItem("plate", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val CRUSHED: GSWMaterialItem = GSWMaterialItem("crushed", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))

        val HAMMER: GSWTool = GSWHammer(MATERIAL, ToolMaterials.GOLD, Item.Settings().group(ItemGroup.TOOLS))
    }
}