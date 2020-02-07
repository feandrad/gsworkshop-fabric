package io.felipeandrade.gsw2.material;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class MaterialItem extends GSWItem {

    protected final GSWMaterial material;

    private final Settings settings;

    public MaterialItem(String unlocalizedName, GSWMaterial material, Settings settings) {
        super(material.unlocalizedName() + "_" + unlocalizedName, settings);
        this.material = material;
        this.settings = settings;
    }


    public static GSWItem makeItem(String unlocalizedName, GSWMaterial material){
        return new MaterialItem(unlocalizedName, material, new Item.Settings().group(ItemGroup.MISC));
    }
}
