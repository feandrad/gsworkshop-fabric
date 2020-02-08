package io.felipeandrade.gsw2.item.tool;

import io.felipeandrade.gsw2.material.GSWMaterial;

public class GSWHammer extends GSWPickaxe {


    public GSWHammer(String unlocalizedName, GSWToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(unlocalizedName, toolMaterial, attackDamage, attackSpeed, settings);
    }

    public GSWHammer(GSWMaterial material, GSWToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        this(material.unlocalizedName() + "_hammer", toolMaterial, attackDamage, attackSpeed, settings);
    }

}
