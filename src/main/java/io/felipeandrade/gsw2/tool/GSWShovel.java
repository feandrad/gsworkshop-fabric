package io.felipeandrade.gsw2.tool;

import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


import io.felipeandrade.gsw2.material.GSWToolMaterial;

import static io.felipeandrade.gsw2.GSW2Mod.MOD_ID;

public class GSWShovel extends ShovelItem implements GSWTool {

    private final String unlocalizedName;

    public GSWShovel(String unlocalizedName, ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        this.unlocalizedName = unlocalizedName;
    }

    public GSWShovel(GSWToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        this(material.unlocalizedName() + "_shovel", material.getToolMaterial(), attackDamage, attackSpeed, settings);
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
