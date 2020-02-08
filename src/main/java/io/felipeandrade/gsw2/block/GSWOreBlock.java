package io.felipeandrade.gsw2.block;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;

import io.felipeandrade.gsw2.common.ClientProxyInit;
import io.felipeandrade.gsw2.material.GSWMaterial;

public class GSWOreBlock extends GSWBlock implements BlockColorProvider, ClientProxyInit {

    protected final GSWMaterial material;

    public GSWOreBlock(GSWMaterial material, Block.Settings settings) {
        this(material.unlocalizedName() + "_ore", material, settings);
    }

    public GSWOreBlock(String unlocalizedName, GSWMaterial material, Block.Settings settings) {
        super(unlocalizedName, settings);
        this.material = material;
    }

    @Override
    public void onClientInit() {
        ColorProviderRegistry.BLOCK.register(this, this);
        BlockRenderLayerMap.INSTANCE.putBlock(this, RenderLayer.getCutout());
    }

    @Override
    public int getColor(BlockState state, BlockRenderView view, BlockPos pos, int tintIndex) {
        return material.getPrimaryColor();
    }

}

