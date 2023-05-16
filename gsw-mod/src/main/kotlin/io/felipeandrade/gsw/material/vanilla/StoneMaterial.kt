package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.item.tool.GSWHammer
import io.felipeandrade.gsw.item.tool.GSWTool
import io.felipeandrade.gsw.material.GSWMaterial
import net.minecraft.item.Item
import net.minecraft.item.ToolMaterials

class StoneMaterial : GSWMaterial("stone") {

    override fun allTools(): List<GSWTool> = listOf(HAMMER)

    companion object {
        val MATERIAL: GSWMaterial = StoneMaterial()
        val HAMMER: GSWTool = GSWHammer(MATERIAL, ToolMaterials.STONE, Item.Settings().group(GSWItemGroup.TOOLS))
    }
}