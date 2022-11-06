package io.felipeandrade.gsw.item.tool

import io.felipeandrade.gsw.GSWMod
import io.felipeandrade.gsw.material.GSWItemColorProvider
import io.felipeandrade.gsw.material.GSWMaterial
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry
import net.minecraft.item.HoeItem
import net.minecraft.item.ItemStack
import net.minecraft.item.ToolMaterial
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

class GSWHoe(
    val material: GSWMaterial,
    toolMaterial: ToolMaterial,
    attackSpeed: Float,
    settings: Settings,
    attackDamage: Int = 1,
    val unlocalizedName: String = material.unlocalizedName + "_hoe",
) : HoeItem(toolMaterial, attackDamage, attackSpeed, settings), GSWTool, GSWItemColorProvider {

    override fun register() {
        Registry.register(Registry.ITEM, Identifier(GSWMod.MOD_ID, unlocalizedName), this)
    }

    override fun getColor(stack: ItemStack, tintIndex: Int) = if (tintIndex == 1) material.primaryColor else -1

    override fun onClientInit() {
        ColorProviderRegistry.ITEM.register(this, this)
    }
}