package io.felipeandrade.gsw2.block;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

import io.felipeandrade.gsw2.common.ClientProxyInit;
import io.felipeandrade.gsw2.material.GSWMaterial;

public class GSWOreBlock extends GSWBlock implements ClientProxyInit {

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
        BlockRenderLayerMap.INSTANCE.putBlock(this, RenderLayer.getCutout());
    }
}

