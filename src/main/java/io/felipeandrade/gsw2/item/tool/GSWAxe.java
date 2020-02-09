package io.felipeandrade.gsw2.item.tool;

import net.minecraft.item.AxeItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import io.felipeandrade.gsw2.material.GSWMaterial;

import static io.felipeandrade.gsw2.GSW2Mod.MOD_ID;

public class GSWAxe extends AxeItem implements GSWTool {

    private final String unlocalizedName;

    public GSWAxe(String unlocalizedName, GSWToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 6.0f, -3.2f, settings);
        this.unlocalizedName = unlocalizedName;
    }

    public GSWAxe(GSWMaterial material, GSWToolMaterial toolMaterial, Settings settings) {
        this(material.unlocalizedName() + "_axe", toolMaterial, settings);
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
