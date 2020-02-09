package io.felipeandrade.gsw2.item.tool;

import io.felipeandrade.gsw2.material.GSWMaterial;

public class GSWHammer extends GSWPickaxe {


    public GSWHammer(String unlocalizedName, GSWToolMaterial toolMaterial,  Settings settings) {
        super(unlocalizedName, toolMaterial, 5, -3.4f, settings);
    }

    public GSWHammer(GSWMaterial material, GSWToolMaterial toolMaterial,  Settings settings) {
        this(material.unlocalizedName() + "_hammer", toolMaterial, settings);
    }

}
