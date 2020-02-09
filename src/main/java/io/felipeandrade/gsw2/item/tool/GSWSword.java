package io.felipeandrade.gsw2.item.tool;

import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import io.felipeandrade.gsw2.material.GSWMaterial;

import static io.felipeandrade.gsw2.GSW2Mod.MOD_ID;

public class GSWSword extends SwordItem implements GSWTool {

    private final String unlocalizedName;

    public GSWSword(String unlocalizedName, GSWToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 3, -2.4f, settings);
        this.unlocalizedName = unlocalizedName;
    }

    public GSWSword(GSWMaterial material, GSWToolMaterial toolMaterial, Settings settings) {
        this(material.unlocalizedName() + "_sword", toolMaterial, settings);
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
