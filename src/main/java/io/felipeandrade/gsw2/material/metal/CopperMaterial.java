package io.felipeandrade.gsw2.material.metal;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import java.util.Arrays;
import java.util.List;

import io.felipeandrade.gsw2.block.GSWBlock;
import io.felipeandrade.gsw2.block.GSWOreBlock;
import io.felipeandrade.gsw2.block.MaterialBlock;
import io.felipeandrade.gsw2.item.GSWItem;
import io.felipeandrade.gsw2.item.MaterialItem;
import io.felipeandrade.gsw2.item.tool.GSWShovel;
import io.felipeandrade.gsw2.item.tool.GSWTool;
import io.felipeandrade.gsw2.item.tool.GSWToolMaterial;
import io.felipeandrade.gsw2.material.GSWMaterial;

public class CopperMaterial extends GSWMaterial {

    public CopperMaterial() {
        super("copper");
    }

    @Override
    public List<? extends GSWItem> allItems() {
        return Arrays.asList(INGOT, NUGGET, DUST, PLATE);
    }

    @Override
    public List<? extends GSWBlock> allBlocks() {
        return Arrays.asList(METAL_BLOCK, ORE_BLOCK);
    }

    @Override
    public List<? extends GSWTool> allTools() {
        return Arrays.asList(SHOVEL);
    }

    public static final GSWMaterial MATERIAL = new CopperMaterial();

    public static final GSWItem INGOT = new MaterialItem("ingot", MATERIAL);
    public static final MaterialItem NUGGET = new MaterialItem("nugget", MATERIAL);
    public static final MaterialItem DUST = new MaterialItem("dust", MATERIAL);
    public static final MaterialItem PLATE = new MaterialItem("plate", MATERIAL);

    public static final GSWBlock METAL_BLOCK = new MaterialBlock("block", MATERIAL, FabricBlockSettings.copy(Blocks.IRON_BLOCK).build());
    public static final GSWOreBlock ORE_BLOCK = new GSWOreBlock("ore_block", MATERIAL, FabricBlockSettings.copy(Blocks.IRON_ORE).build());

    public static final GSWToolMaterial TOOL_MATERIAL = new GSWToolMaterial(1, 131, 4.0F, 1.0F, 15, CopperMaterial.INGOT);

    public static final GSWTool SHOVEL = new GSWShovel(MATERIAL, TOOL_MATERIAL, -3.0f, new Item.Settings().group(ItemGroup.TOOLS));

}
