package io.felipeandrade.gsw.material

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry
import net.minecraft.item.ItemStack

class ColorProviderMaterialItem(unlocalizedName: String, material: GSWMaterial, settings: Settings) :
    GSWMaterialItem(unlocalizedName, material, settings), GSWItemColorProvider {
    override fun getColor(stack: ItemStack, tintIndex: Int): Int {
        return material.primaryColor
    }

    override fun onClientInit() {
        ColorProviderRegistry.ITEM.register(this, this)
    }
}