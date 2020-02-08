package io.felipeandrade.gsw2.item.tool;

import net.minecraft.item.HoeItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import io.felipeandrade.gsw2.material.GSWMaterial;

import static io.felipeandrade.gsw2.GSW2Mod.MOD_ID;

public class GSWHoe extends HoeItem implements GSWTool {

    private final String unlocalizedName;

    public GSWHoe(String unlocalizedName, GSWToolMaterial toolMaterial, float attackSpeed, Settings settings) {
        super(toolMaterial, attackSpeed, settings);
        this.unlocalizedName = unlocalizedName;
    }

    public GSWHoe(GSWMaterial material, GSWToolMaterial toolMaterial, float attackSpeed, Settings settings) {
        this(material.unlocalizedName() + "_hoe", toolMaterial, attackSpeed, settings);
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
