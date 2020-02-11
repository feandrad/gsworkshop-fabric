package io.felipeandrade.gsw2.item.tool;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import io.felipeandrade.gsw2.material.GSWItemColorProvider;
import io.felipeandrade.gsw2.material.GSWMaterial;

import static io.felipeandrade.gsw2.GSW2Mod.MOD_ID;

public class GSWHoe extends HoeItem implements GSWTool, GSWItemColorProvider {

    protected final String unlocalizedName;
    private final GSWMaterial material;

    public GSWHoe(String unlocalizedName, GSWMaterial material, ToolMaterial toolMaterial, float attackSpeed, Settings settings) {
        super(toolMaterial, attackSpeed, settings);
        this.unlocalizedName = unlocalizedName;
        this.material = material;
    }

    public GSWHoe(GSWMaterial material, ToolMaterial toolMaterial, float attackSpeed, Settings settings) {
        this(material.unlocalizedName() + "_hoe", material, toolMaterial, attackSpeed, settings);
    }

    @Override
    public String unlocalizedName() {
        return unlocalizedName;
    }

    @Override
    public void register() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, unlocalizedName), this);
    }

    @Override
    public int getColor(ItemStack stack, int tintIndex) {
        if (tintIndex == 1) {
            return material.getPrimaryColor();
        } else {
            return -1;
        }
    }

    @Override
    public void onClientInit() {
        ColorProviderRegistry.ITEM.register(this, this);
    }

}
