package io.felipeandrade.gsw2.material;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.item.ItemStack;

public class ColorProviderMaterialItem extends GSWMaterialItem implements GSWItemColorProvider {


    public ColorProviderMaterialItem(String unlocalizedName, GSWMaterial material, Settings settings) {
        super(unlocalizedName, material, settings);
    }

    @Override
    public int getColor(ItemStack stack, int tintIndex) {
        return material.getPrimaryColor();
    }

    @Override
    public void onClientInit() {
        ColorProviderRegistry.ITEM.register(this, this);
    }
}
