package io.felipeandrade.gsw2.material.metal;

import net.minecraft.item.Item;

import java.util.Arrays;
import java.util.List;

import io.felipeandrade.gsw2.GSWItemGroup;
import io.felipeandrade.gsw2.block.ColorProviderMaterialBlock;
import io.felipeandrade.gsw2.block.ColorProviderOreBlock;
import io.felipeandrade.gsw2.block.GSWBlock;
import io.felipeandrade.gsw2.block.GSWMaterialBlock;
import io.felipeandrade.gsw2.common.GSWColor;
import io.felipeandrade.gsw2.item.GSWItem;
import io.felipeandrade.gsw2.item.tool.GSWAxe;
import io.felipeandrade.gsw2.item.tool.GSWHammer;
import io.felipeandrade.gsw2.item.tool.GSWHoe;
import io.felipeandrade.gsw2.item.tool.GSWPickaxe;
import io.felipeandrade.gsw2.item.tool.GSWShovel;
import io.felipeandrade.gsw2.item.tool.GSWSword;
import io.felipeandrade.gsw2.item.tool.GSWTool;
import io.felipeandrade.gsw2.item.tool.GSWToolMaterial;
import io.felipeandrade.gsw2.material.ColorProviderMaterialItem;
import io.felipeandrade.gsw2.material.GSWMaterial;
import io.felipeandrade.gsw2.material.GSWMaterialItem;

public class OrichalcumMaterial extends GSWMaterial {

    public static final GSWMaterial MATERIAL = new OrichalcumMaterial();

    public OrichalcumMaterial() {
        super("orichalcum", GSWColor.blue_violet);
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
        return Arrays.asList(SWORD, PICKAXE, AXE, SHOVEL, HOE, HAMMER);
    }


    public static final GSWItem INGOT = new ColorProviderMaterialItem("ingot", MATERIAL, new Item.Settings().group(GSWItemGroup.MATERIALS));
    public static final GSWMaterialItem NUGGET = new ColorProviderMaterialItem("nugget", MATERIAL, new Item.Settings().group(GSWItemGroup.MATERIALS));
    public static final GSWMaterialItem DUST = new ColorProviderMaterialItem("dust", MATERIAL, new Item.Settings().group(GSWItemGroup.MATERIALS));
    public static final GSWMaterialItem PLATE = new ColorProviderMaterialItem("plate", MATERIAL, new Item.Settings().group(GSWItemGroup.MATERIALS));
    public static final GSWMaterialItem GEAR = new ColorProviderMaterialItem("gear", MATERIAL, new Item.Settings().group(GSWItemGroup.MATERIALS));
    public static final GSWMaterialItem WIRE = new ColorProviderMaterialItem("wire", MATERIAL, new Item.Settings().group(GSWItemGroup.MATERIALS));

    public static final GSWBlock METAL_BLOCK = new ColorProviderMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_METAL);
    public static final GSWBlock ORE_BLOCK = new ColorProviderOreBlock(MATERIAL, GSWMaterialBlock.SETTINGS_METAL);


    public static final GSWToolMaterial TOOL_MATERIAL = new GSWToolMaterial(4, 10000, 14.0F, 5.0F, 1, INGOT);

    public static final GSWTool SWORD = new GSWSword(MATERIAL, TOOL_MATERIAL, new Item.Settings().group(GSWItemGroup.TOOLS));
    public static final GSWTool PICKAXE = new GSWPickaxe(MATERIAL, TOOL_MATERIAL, new Item.Settings().group(GSWItemGroup.TOOLS));
    public static final GSWTool AXE = new GSWAxe(MATERIAL, TOOL_MATERIAL, new Item.Settings().group(GSWItemGroup.TOOLS));
    public static final GSWTool SHOVEL = new GSWShovel(MATERIAL, TOOL_MATERIAL, new Item.Settings().group(GSWItemGroup.TOOLS));
    public static final GSWTool HOE = new GSWHoe(MATERIAL, TOOL_MATERIAL, -0.0f, new Item.Settings().group(GSWItemGroup.TOOLS));
    public static final GSWTool HAMMER = new GSWHammer(MATERIAL, TOOL_MATERIAL, new Item.Settings().group(GSWItemGroup.TOOLS));

}
