package io.felipeandrade.gsw2.material;

import net.minecraft.item.ToolMaterial;

public abstract class GSWToolMaterial extends GSWMaterial {

    public GSWToolMaterial(String unlocalizedName) {
        super(unlocalizedName);
    }

    public abstract ToolMaterial getToolMaterial();
}
