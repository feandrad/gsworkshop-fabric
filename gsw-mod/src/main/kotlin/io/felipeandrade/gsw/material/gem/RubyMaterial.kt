package io.felipeandrade.gsw.material.gem

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.block.GSWMaterialBlock
import io.felipeandrade.gsw.common.GSWColor
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.GSWTool
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.minecraft.item.*
import java.util.*

class RubyMaterial : GSWMaterial("ruby") {
    override fun allItems(): List<GSWItem> {
        return listOf(GEM)
    }

    override fun allBlocks(): List<GSWBlock> {
        return listOf(ORE_BLOCK, GEM_BLOCK)
    }

    override fun allTools(): List<GSWTool> {
        return ArrayList()
    }

    companion object {
        val MATERIAL: GSWMaterial = RubyMaterial()
        val GEM: GSWItem = GSWMaterialItem("gem", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
        val GEM_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_GEM)
        val ORE_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_ORE, "ore")
    }
}