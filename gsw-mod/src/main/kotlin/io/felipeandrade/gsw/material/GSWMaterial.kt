package io.felipeandrade.gsw.material

import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.GSWTool

abstract class GSWMaterial(
    val unlocalizedName: String,
    val primaryColor: Int,
    val secondaryColor: Int = primaryColor,
) {
    open fun allItems(): List<GSWItem> = listOf()
    open fun allBlocks(): List<GSWBlock> = listOf()
    open fun allTools(): List<GSWTool> = listOf()
}