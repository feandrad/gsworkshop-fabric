package io.felipeandrade.gsw2.item.tool;

import net.minecraft.item.ShovelItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import io.felipeandrade.gsw2.material.GSWMaterial;

import static io.felipeandrade.gsw2.GSW2Mod.MOD_ID;

public class GSWShovel extends ShovelItem implements GSWTool {

    private final String unlocalizedName;

    public GSWShovel(String unlocalizedName, GSWToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, toolMaterial.getAttackDamage(), toolMaterial.getMiningSpeed(), settings);
        this.unlocalizedName = unlocalizedName;
    }

    public GSWShovel(GSWMaterial material, GSWToolMaterial toolMaterial,  Settings settings) {
        this(material.unlocalizedName() + "_shovel", toolMaterial, settings);
    }

    @Override
    public String unlocalizedName() {
        return unlocalizedName;
    }

    @Override
    public void register() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, unlocalizedName), this);
    }
}
