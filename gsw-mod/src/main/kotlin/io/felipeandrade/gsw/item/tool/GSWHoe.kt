package io.felipeandrade.gsw.item.tool

import io.felipeandrade.gsw.GSWMod
import io.felipeandrade.gsw.material.GSWMaterial
import net.minecraft.item.HoeItem
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
) : HoeItem(toolMaterial, attackDamage, attackSpeed, settings), GSWTool {

    override fun register() {
        Registry.register(Registry.ITEM, Identifier(GSWMod.MOD_ID, unlocalizedName), this)
    }

}