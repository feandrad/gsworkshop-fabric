package io.felipeandrade.gsw2.material;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.ItemStack;

import io.felipeandrade.gsw2.common.ClientProxyInit;

public class ColorProviderMaterialItem extends GSWMaterialItem implements ItemColorProvider, ClientProxyInit {


    public ColorProviderMaterialItem(String unlocalizedName, GSWMaterial material, Settings settings) {
        super(unlocalizedName, material, settings);
    }

    @Override
    public int getColor(ItemStack stack, int tintIndex) {
        return material.getPrimaryColor();
    }

    @Override
    public void register() {
        super.register();
    }

    @Override
    public void onClientInit() {
        ColorProviderRegistry.ITEM.register(this, this);
    }
}
