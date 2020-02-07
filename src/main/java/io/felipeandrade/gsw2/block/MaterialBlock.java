package io.felipeandrade.gsw2.block;

import net.minecraft.block.Block;

import io.felipeandrade.gsw2.material.GSWMaterial;

public class MaterialBlock extends GSWBlock {

    protected final GSWMaterial material;

    private final Block.Settings settings;


    public MaterialBlock(String unlocalizedName, GSWMaterial material, Settings settings) {
        super(material.unlocalizedName() + "_" + unlocalizedName, settings);
        this.material = material;
        this.settings = settings;
    }

}
