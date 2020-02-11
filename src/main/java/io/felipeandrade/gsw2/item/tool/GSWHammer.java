package io.felipeandrade.gsw2.item.tool;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

import io.felipeandrade.gsw2.material.GSWMaterial;

public class GSWHammer extends GSWPickaxe {


    public GSWHammer(String unlocalizedName, GSWMaterial material, ToolMaterial toolMaterial, Settings settings) {
        super(unlocalizedName, material, toolMaterial, 5, -3.4f, settings);
    }

    public GSWHammer(GSWMaterial material, ToolMaterial toolMaterial, Settings settings) {
        this(material.unlocalizedName() + "_hammer", material, toolMaterial, settings);
    }

    @Override
    public int getColor(ItemStack stack, int tintIndex) {
        if (tintIndex == 1) {
            return material.getPrimaryColor();
        } else {
            return -1;
        }
    }

    @Override
    public void onClientInit() {
        ColorProviderRegistry.ITEM.register(this, this);
    }

}
