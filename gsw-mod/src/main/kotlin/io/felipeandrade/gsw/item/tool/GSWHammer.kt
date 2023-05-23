package io.felipeandrade.gsw.item.tool

import io.felipeandrade.gsw.material.GSWMaterial
import net.minecraft.item.ToolMaterial

class GSWHammer(
    unlocalizedName: String,
    material: GSWMaterial,
    toolMaterial: ToolMaterial,
    settings: Settings,
) : GSWPickaxe(unlocalizedName, material, toolMaterial, 5, -3.4f, settings) {
    constructor(
        material: GSWMaterial,
        toolMaterial: ToolMaterial,
        settings: Settings
    ) : this(material.unlocalizedName + "_hammer", material, toolMaterial, settings)
}