package io.felipeandrade.gsw2.block;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;

import io.felipeandrade.gsw2.material.GSWMaterial;

public class ColorProviderOreBlock extends GSWOreBlock implements BlockColorProvider {

    public ColorProviderOreBlock(GSWMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public int getColor(BlockState state, BlockRenderView view, BlockPos pos, int tintIndex) {
        return material.getPrimaryColor();
    }

    @Override
    public void register() {
        super.register();
        ColorProviderRegistry.BLOCK.register(this, this);
    }
}
