package io.felipeandrade.gsw.block

import io.felipeandrade.gsw.GSWItemGroup
import io.felipeandrade.gsw.common.ClientResourceInit
import io.felipeandrade.gsw.material.GSWMaterial
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.block.BlockState
import net.minecraft.client.color.block.BlockColorProvider
import net.minecraft.client.render.RenderLayer
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockRenderView

open class GSWOreBlock(
    val gswMaterial: GSWMaterial,
    settings: Settings,
    unlocalizedName: String = gswMaterial.unlocalizedName + "_ore",
) :
    GSWBlock(unlocalizedName, GSWItemGroup.MATERIALS, settings), BlockColorProvider, ClientResourceInit {

    override fun onClientInit() {
        BlockRenderLayerMap.INSTANCE.putBlock(this, RenderLayer.getCutout())
    }

    override fun getColor(state: BlockState, view: BlockRenderView?, pos: BlockPos?, tintIndex: Int): Int {
        return gswMaterial.primaryColor
    }
}