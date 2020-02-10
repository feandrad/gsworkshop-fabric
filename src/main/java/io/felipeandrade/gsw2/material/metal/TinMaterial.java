package io.felipeandrade.gsw2.material.metal;

import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.felipeandrade.gsw2.GSWItemGroup;
import io.felipeandrade.gsw2.block.ColorProviderMaterialBlock;
import io.felipeandrade.gsw2.block.ColorProviderOreBlock;
import io.felipeandrade.gsw2.block.GSWBlock;
import io.felipeandrade.gsw2.block.GSWMaterialBlock;
import io.felipeandrade.gsw2.common.GSWColor;
import io.felipeandrade.gsw2.item.GSWItem;
import io.felipeandrade.gsw2.item.tool.GSWTool;
import io.felipeandrade.gsw2.material.ColorProviderMaterialItem;
import io.felipeandrade.gsw2.material.GSWMaterial;
import io.felipeandrade.gsw2.material.GSWMaterialItem;

public class TinMaterial extends GSWMaterial {

    public static final GSWMaterial MATERIAL = new TinMaterial();

    public TinMaterial() {
        super("tin", GSWColor.light_steel_blue);
    }

    @Override
    public List<? extends GSWItem> allItems() {
        return Arrays.asList(INGOT, NUGGET, DUST, PLATE, GEAR, WIRE);
    }

    @Override
    public List<? extends GSWBlock> allBlocks() {
        return Arrays.asList(ORE_BLOCK, METAL_BLOCK);
    }

    @Override
    public List<? extends GSWTool> allTools() {
        return new ArrayList<>();
    }


    public static final GSWItem INGOT = new ColorProviderMaterialItem("ingot", MATERIAL, new Item.Settings().group(GSWItemGroup.MATERIALS));
    public static final GSWMaterialItem NUGGET = new ColorProviderMaterialItem("nugget", MATERIAL, new Item.Settings().group(GSWItemGroup.MATERIALS));
    public static final GSWMaterialItem DUST = new ColorProviderMaterialItem("dust", MATERIAL, new Item.Settings().group(GSWItemGroup.MATERIALS));
    public static final GSWMaterialItem PLATE = new ColorProviderMaterialItem("plate", MATERIAL, new Item.Settings().group(GSWItemGroup.MATERIALS));
    public static final GSWMaterialItem GEAR = new ColorProviderMaterialItem("gear", MATERIAL, new Item.Settings().group(GSWItemGroup.MATERIALS));
    public static final GSWMaterialItem WIRE = new ColorProviderMaterialItem("wire", MATERIAL, new Item.Settings().group(GSWItemGroup.MATERIALS));

    public static final GSWBlock METAL_BLOCK = new ColorProviderMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_METAL);
    public static final GSWBlock ORE_BLOCK = new ColorProviderOreBlock(MATERIAL, GSWMaterialBlock.SETTINGS_ORE);

}
