package io.felipeandrade.gsw.block

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.material.GSWMaterial
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Blocks

open class GSWMaterialBlock(
    val gswMaterial: GSWMaterial,
    settings: Settings,
    unlocalizedName: String = "block",
) : GSWBlock("${gswMaterial.unlocalizedName}_$unlocalizedName", GSWItemGroup.MATERIALS, settings) {

    companion object {
        val SETTINGS_ORE: Settings = FabricBlockSettings.copy(Blocks.IRON_ORE)
        val SETTINGS_DEEPSLATE_ORE: Settings = FabricBlockSettings.copy(Blocks.DEEPSLATE_IRON_ORE)
        val SETTINGS_METAL: Settings = FabricBlockSettings.copy(Blocks.IRON_BLOCK)
        val SETTINGS_GEM: Settings = FabricBlockSettings.copy(Blocks.EMERALD_BLOCK)
    }
}