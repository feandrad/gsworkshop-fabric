package io.felipeandrade.gsw2.block;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;

import io.felipeandrade.gsw2.common.ClientProxyInit;
import io.felipeandrade.gsw2.material.GSWMaterial;

public class ColorProviderMaterialBlock extends GSWMaterialBlock implements BlockColorProvider, ClientProxyInit {


    public ColorProviderMaterialBlock(GSWMaterial material, Settings settings) {
        super(material, settings);
    }


    @Override
    public int getColor(BlockState state, BlockRenderView view, BlockPos pos, int tintIndex) {
        return material.getSecondaryColor();
    }

    @Override
    public void onClientInit() {
        ColorProviderRegistry.BLOCK.register(this, this);
    }

}
