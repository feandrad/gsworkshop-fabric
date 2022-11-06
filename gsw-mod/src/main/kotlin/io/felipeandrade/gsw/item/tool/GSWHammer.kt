package io.felipeandrade.gsw.item.tool

import io.felipeandrade.gsw.material.GSWMaterial
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry
import net.minecraft.item.ItemStack
import net.minecraft.item.ToolMaterial

class GSWHammer(unlocalizedName: String, material: GSWMaterial, toolMaterial: ToolMaterial, settings: Settings) :
    GSWPickaxe(unlocalizedName, material, toolMaterial, 5, -3.4f, settings) {
    constructor(
        material: GSWMaterial,
        toolMaterial: ToolMaterial,
        settings: Settings
    ) : this(material.unlocalizedName + "_hammer", material, toolMaterial, settings) {
    }

    override fun getColor(stack: ItemStack, tintIndex: Int): Int {
        return if (tintIndex == 1) {
            material.primaryColor
        } else {
            -1
        }
    }

    override fun onClientInit() {
        ColorProviderRegistry.ITEM.register(this, this)
    }
}