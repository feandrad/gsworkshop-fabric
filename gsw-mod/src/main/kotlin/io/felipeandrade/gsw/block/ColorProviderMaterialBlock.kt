package io.felipeandrade.gsw.block

import io.felipeandrade.gsw.common.ClientResourceInit
import io.felipeandrade.gsw.material.GSWMaterial
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry
import net.minecraft.block.BlockState
import net.minecraft.client.color.block.BlockColorProvider
import net.minecraft.client.color.item.ItemColorProvider
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockRenderView

class ColorProviderMaterialBlock(
    gswMaterial: GSWMaterial,
    settings: Settings,
) : GSWMaterialBlock(gswMaterial, settings), BlockColorProvider, ItemColorProvider, ClientResourceInit {

    override fun getColor(state: BlockState, view: BlockRenderView?, pos: BlockPos?, tintIndex: Int): Int =
        gswMaterial.secondaryColor

    override fun getColor(stack: ItemStack, tintIndex: Int): Int {
        return gswMaterial.secondaryColor
    }

    override fun onClientInit() {
        ColorProviderRegistry.BLOCK.register(this, this)
        ColorProviderRegistry.ITEM.register(this, this)
    }
}