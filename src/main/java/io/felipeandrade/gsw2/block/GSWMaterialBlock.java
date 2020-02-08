package io.felipeandrade.gsw2.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Blocks;

import io.felipeandrade.gsw2.material.GSWMaterial;

public class GSWMaterialBlock extends GSWBlock {

    public static final Settings SETTINGS_ORE = FabricBlockSettings.copy(Blocks.IRON_ORE).build();
    public static final Settings SETTINGS_METAL = FabricBlockSettings.copy(Blocks.IRON_BLOCK).build();
    public static final Settings SETTINGS_GEM = FabricBlockSettings.copy(Blocks.EMERALD_BLOCK).build();


//    protected static final Map<EntityType<?>, GSWMaterialBlock> BLOCKS = Maps.newIdentityHashMap();


    private final GSWMaterial material;

    public GSWMaterialBlock(GSWMaterial material, Settings settings) {
        super(material.unlocalizedName() + "_block", settings);
        this.material = material;
    }

}
