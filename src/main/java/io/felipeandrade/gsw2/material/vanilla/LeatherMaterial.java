package io.felipeandrade.gsw2.material.vanilla;

import io.felipeandrade.gsw2.common.GSWColor;
import io.felipeandrade.gsw2.material.GSWMaterial;

public class LeatherMaterial extends GSWMaterial {

    public static final GSWMaterial MATERIAL = new LeatherMaterial();

    public LeatherMaterial() {
        super("leather", GSWColor.saddle_brown);
    }

}
