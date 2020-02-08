package io.felipeandrade.gsw2.material;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.ItemStack;

public class ColorProviderMaterialItem extends GSWMaterialItem implements ItemColorProvider {


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
        ColorProviderRegistry.ITEM.register(this, this);
    }
}
