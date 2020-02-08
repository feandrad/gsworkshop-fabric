package io.felipeandrade.gsw2.material.metal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.felipeandrade.gsw2.block.GSWBlock;
import io.felipeandrade.gsw2.block.GSWMaterialBlock;
import io.felipeandrade.gsw2.block.MaterialBlock;
import io.felipeandrade.gsw2.common.GSWColor;
import io.felipeandrade.gsw2.item.GSWItem;
import io.felipeandrade.gsw2.item.tool.GSWTool;
import io.felipeandrade.gsw2.item.tool.GSWToolMaterial;
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
        return Collections.singletonList(METAL_BLOCK);
    }

    @Override
    public List<? extends GSWTool> allTools() {
        return new ArrayList<>();
    }


    public static final GSWItem INGOT = new GSWMaterialItem("ingot", MATERIAL);
    public static final GSWMaterialItem NUGGET = new GSWMaterialItem("nugget", MATERIAL);
    public static final GSWMaterialItem DUST = new GSWMaterialItem("dust", MATERIAL);
    public static final GSWMaterialItem PLATE = new GSWMaterialItem("plate", MATERIAL);
    public static final GSWMaterialItem GEAR = new GSWMaterialItem("gear", MATERIAL);
    public static final GSWMaterialItem WIRE = new GSWMaterialItem("wire", MATERIAL);

    public static final GSWBlock METAL_BLOCK = new MaterialBlock("block", MATERIAL, GSWMaterialBlock.SETTINGS_METAL);

}
