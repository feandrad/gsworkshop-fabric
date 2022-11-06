package io.felipeandrade.gsw.material.metal


import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.common.GSWColor
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.tool.*
import io.felipeandrade.gsw.material.ColorProviderMaterialItem
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import net.minecraft.item.Item

class PlatinumMaterial : GSWMaterial("platinum", GSWColor.deep_sky_blue) {
    override fun allItems(): List<GSWItem> {
        return listOf<GSWItem>(INGOT, NUGGET, DUST, PLATE, GEAR, WIRE)
    }

//    override fun allBlocks(): List<GSWBlock> {
//        return listOf<GSWBlock>(ORE_BLOCK, METAL_BLOCK)
//    }

    override fun allTools(): List<GSWTool> {
        return listOf<GSWTool>(SWORD, PICKAXE, AXE, SHOVEL, HOE, HAMMER)
    }

    companion object {
        val MATERIAL: GSWMaterial = PlatinumMaterial()
        val INGOT: GSWItem = ColorProviderMaterialItem("ingot", MATERIAL, Item.Settings().group(GSWItemGroup.MATERIALS))
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
//        val METAL_BLOCK: GSWBlock = ColorProviderMaterialBlock(
//            MATERIAL,
//            FabricBlockSettings.copy(Blocks.IRON_BLOCK).breakByTool(FabricToolTags.PICKAXES, 3).build()
//        )
//        val ORE_BLOCK: GSWBlock = ColorProviderOreBlock(
//            MATERIAL,
//            FabricBlockSettings.copy(Blocks.IRON_ORE).breakByTool(FabricToolTags.PICKAXES, 3).build()
//        )
        val TOOL_MATERIAL: GSWToolMaterial = GSWToolMaterial(3, 980, 8.0f, 3.0f, 18, INGOT)
        val SWORD: GSWTool = GSWSword(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val PICKAXE: GSWTool = GSWPickaxe(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val AXE: GSWTool = GSWAxe(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val SHOVEL: GSWTool = GSWShovel(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
        val HOE: GSWTool = GSWHoe(MATERIAL, TOOL_MATERIAL, -0.0f, Item.Settings().group(GSWItemGroup.TOOLS))
        val HAMMER: GSWTool = GSWHammer(MATERIAL, TOOL_MATERIAL, Item.Settings().group(GSWItemGroup.TOOLS))
    }
}