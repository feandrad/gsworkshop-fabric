package io.felipeandrade.gsw2.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import io.felipeandrade.gsw2.material.GSWMaterial;

public class MaterialItem extends GSWItem {

    protected final GSWMaterial material;

    private final Settings settings;

    public MaterialItem(String unlocalizedName, GSWMaterial material, Settings settings) {
        super(material.unlocalizedName() + "_" + unlocalizedName, settings);
        this.material = material;
        this.settings = settings;
    }

    public MaterialItem(String unlocalizedName, GSWMaterial material) {
        this(unlocalizedName, material, new Item.Settings().group(ItemGroup.MISC));
    }


    @Environment(EnvType.CLIENT)
    public int getColor(int num) {
        return material.getPrimaryColor();
    }


}
