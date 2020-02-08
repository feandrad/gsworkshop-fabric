package io.felipeandrade.gsw2.material;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import io.felipeandrade.gsw2.item.GSWItem;

public class GSWMaterialItem extends GSWItem implements ItemColorProvider {

    protected final GSWMaterial material;

    public GSWMaterialItem(String unlocalizedName, GSWMaterial material) {
        this(unlocalizedName, material, new Item.Settings().group(ItemGroup.MISC));
    }

    public GSWMaterialItem(String unlocalizedName, GSWMaterial material, Settings settings) {
        super(material.unlocalizedName() + "_" + unlocalizedName, settings);
        this.material = material;
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
