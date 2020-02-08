package io.felipeandrade.gsw2.material.metal;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.felipeandrade.gsw2.block.GSWBlock;
import io.felipeandrade.gsw2.block.GSWMaterialBlock;
import io.felipeandrade.gsw2.block.MaterialBlock;
import io.felipeandrade.gsw2.common.GSWColor;
import io.felipeandrade.gsw2.item.GSWItem;
import io.felipeandrade.gsw2.material.GSWMaterialItem;
import io.felipeandrade.gsw2.item.tool.GSWShovel;
import io.felipeandrade.gsw2.item.tool.GSWTool;
import io.felipeandrade.gsw2.item.tool.GSWToolMaterial;
import io.felipeandrade.gsw2.material.GSWMaterial;


public class BronzeMaterial extends GSWMaterial {

    public BronzeMaterial() {
        super("bronze", GSWColor.chocolate, GSWColor.peru);
    }

    @Override
    public List<? extends GSWItem> allItems() {
        return Arrays.asList(INGOT, NUGGET, DUST, PLATE);
    }

    @Override
    public List<? extends GSWBlock> allBlocks() {
        return Collections.singletonList(METAL_BLOCK);
    }

    @Override
    public List<? extends GSWTool> allTools() {
        return Arrays.asList(SHOVEL);
    }

    public static final GSWMaterial MATERIAL = new BronzeMaterial();

    public static final GSWItem INGOT = new GSWMaterialItem("ingot", MATERIAL);
    public static final GSWMaterialItem NUGGET = new GSWMaterialItem("nugget", MATERIAL);
    public static final GSWMaterialItem DUST = new GSWMaterialItem("dust", MATERIAL);
    public static final GSWMaterialItem PLATE = new GSWMaterialItem("plate", MATERIAL);

    public static final GSWBlock METAL_BLOCK = new MaterialBlock("block", MATERIAL, GSWMaterialBlock.SETTINGS_METAL);


    public static final GSWToolMaterial TOOL_MATERIAL = new GSWToolMaterial(2, 250, 5.0F, 2.0F, 5, INGOT);

    public static final GSWTool SHOVEL = new GSWShovel(MATERIAL, TOOL_MATERIAL, -3.0f, new Item.Settings().group(ItemGroup.TOOLS));

}
