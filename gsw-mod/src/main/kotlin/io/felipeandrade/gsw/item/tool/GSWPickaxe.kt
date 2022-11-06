package io.felipeandrade.gsw.item.tool

import io.felipeandrade.gsw.GSWMod
import io.felipeandrade.gsw.material.GSWItemColorProvider
import io.felipeandrade.gsw.material.GSWMaterial
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry
import net.minecraft.block.BlockState
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.PickaxeItem
import net.minecraft.item.ToolMaterial
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import net.minecraft.util.registry.Registry
import net.minecraft.world.World

open class GSWPickaxe internal constructor(
    protected val unlocalizedName: String,
    protected val material: GSWMaterial,
    toolMaterial: ToolMaterial,
    attackDamage: Int,
    attackSpeed: Float,
    settings: Settings
) : PickaxeItem(toolMaterial, attackDamage, attackSpeed, settings), GSWTool, GSWItemColorProvider {
    constructor(
        material: GSWMaterial,
        toolMaterial: ToolMaterial,
        settings: Settings
    ) : this(material.unlocalizedName + "_pickaxe", material, toolMaterial, 1, -2.8f, settings)

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

    override fun canMine(state: BlockState, world: World, pos: BlockPos, miner: PlayerEntity): Boolean {
        return super.canMine(state, world, pos, miner)
    }
}