package io.felipeandrade.gsw.item.tool

import io.felipeandrade.gsw.GSWMod
import io.felipeandrade.gsw.material.GSWItemColorProvider
import io.felipeandrade.gsw.material.GSWMaterial
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolMaterial
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

class GSWSword(
    private val unlocalizedName: String,
    private val material: GSWMaterial,
    toolMaterial: ToolMaterial,
    settings: Settings
) : SwordItem(toolMaterial, 3, -2.4f, settings), GSWTool, GSWItemColorProvider {
    constructor(
        material: GSWMaterial,
        toolMaterial: ToolMaterial,
        settings: Settings
    ) : this(material.unlocalizedName + "_sword", material, toolMaterial, settings)

    override fun register() {
        Registry.register(Registry.ITEM, Identifier(GSWMod.MOD_ID, unlocalizedName), this)
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