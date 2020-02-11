package io.felipeandrade.gsw2.material.vanilla;

import io.felipeandrade.gsw2.common.GSWColor;
import io.felipeandrade.gsw2.material.GSWMaterial;

public class WoolMaterial extends GSWMaterial {

    public static final GSWMaterial MATERIAL = new WoolMaterial();

    public WoolMaterial() {
        super("wool", GSWColor.WHITE);
    }

}
