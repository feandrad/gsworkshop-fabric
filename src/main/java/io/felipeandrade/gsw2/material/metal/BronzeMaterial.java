package io.felipeandrade.gsw2.material.metal;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;

import java.util.Arrays;
import java.util.List;

import io.felipeandrade.gsw2.block.GSWBlock;
import io.felipeandrade.gsw2.block.MaterialBlock;
import io.felipeandrade.gsw2.item.GSWItem;
import io.felipeandrade.gsw2.item.MaterialItem;
import io.felipeandrade.gsw2.material.GSWToolMaterial;
import io.felipeandrade.gsw2.tool.GSWShovel;
import io.felipeandrade.gsw2.tool.GSWTool;


public class BronzeMaterial extends GSWToolMaterial {

    public BronzeMaterial() {
        super("bronze");
    }

    @Override
    public ToolMaterial getToolMaterial() {
        return ToolMaterials.IRON;
    }

    @Override
    public List<? extends GSWItem> allItems() {
        return Arrays.asList(
                new MaterialItem("ingot", this),
                new MaterialItem("nugget", this)
        );
    }

    @Override
    public List<? extends GSWBlock> allBlocks() {
        return Arrays.asList(
                new MaterialBlock("block", this, FabricBlockSettings.copy(Blocks.IRON_BLOCK).build())
        );
    }

    @Override
    public List<? extends GSWTool> allTools() {
        return Arrays.asList(
                new GSWShovel(this, 4, 4, new Item.Settings().group(ItemGroup.TOOLS))
        );
    }
}