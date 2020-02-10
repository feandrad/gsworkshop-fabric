package io.felipeandrade.gsw2.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import io.felipeandrade.gsw2.GSWItemGroup;
import io.felipeandrade.gsw2.material.GSWMaterial;

public class GSWMaterialBlock extends GSWBlock {

    public static final Settings SETTINGS_ORE = FabricBlockSettings.copy(Blocks.IRON_ORE).build();

    public static final Settings SETTINGS_METAL = FabricBlockSettings.copy(Blocks.IRON_BLOCK).build();
    public static final Settings SETTINGS_GEM = FabricBlockSettings.copy(Blocks.EMERALD_BLOCK).build();

    protected final GSWMaterial material;

    public GSWMaterialBlock(GSWMaterial material, Block.Settings settings) {
        this(material.unlocalizedName() + "_block", material, settings);
    }

    public GSWMaterialBlock(String unlocalizedName, GSWMaterial material, Settings settings) {
        super(unlocalizedName, GSWItemGroup.MATERIALS, settings);
        this.material = material;
    }
}
