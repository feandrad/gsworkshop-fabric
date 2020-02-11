package io.felipeandrade.gsw2.material.vanilla;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.felipeandrade.gsw2.GSWItemGroup;
import io.felipeandrade.gsw2.common.GSWColor;
import io.felipeandrade.gsw2.item.GSWItem;
import io.felipeandrade.gsw2.item.tool.GSWHammer;
import io.felipeandrade.gsw2.item.tool.GSWTool;
import io.felipeandrade.gsw2.material.ColorProviderMaterialItem;
import io.felipeandrade.gsw2.material.GSWMaterial;
import io.felipeandrade.gsw2.material.GSWMaterialItem;

public class DiamondMaterial extends GSWMaterial {

    public static final GSWMaterial MATERIAL = new DiamondMaterial();

    public DiamondMaterial() {
        super("diamond", GSWColor.cyan);
    }

    @Override
    public List<? extends GSWItem> allItems() {
        return Arrays.asList(DUST, PLATE, GEAR);
    }

    @Override
    public List<? extends GSWTool> allTools() {
        return Collections.singletonList(HAMMER);
    }


    public static final GSWMaterialItem DUST = new ColorProviderMaterialItem("dust", MATERIAL, new Item.Settings().group(GSWItemGroup.MATERIALS));
    public static final GSWMaterialItem PLATE = new ColorProviderMaterialItem("plate", MATERIAL, new Item.Settings().group(GSWItemGroup.MATERIALS));
    public static final GSWMaterialItem GEAR = new ColorProviderMaterialItem("gear", MATERIAL, new Item.Settings().group(GSWItemGroup.MATERIALS));


    public static final GSWTool HAMMER = new GSWHammer(MATERIAL, ToolMaterials.DIAMOND, new Item.Settings().group(GSWItemGroup.TOOLS));

}
