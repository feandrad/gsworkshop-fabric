package io.felipeandrade.gsw2.material;

import io.felipeandrade.gsw2.item.GSWItem;

public class GSWMaterialItem extends GSWItem {

    protected final GSWMaterial material;


    public GSWMaterialItem(String unlocalizedName, GSWMaterial material, Settings settings) {
        super(material.unlocalizedName() + "_" + unlocalizedName, settings);
        this.material = material;
    }

}
