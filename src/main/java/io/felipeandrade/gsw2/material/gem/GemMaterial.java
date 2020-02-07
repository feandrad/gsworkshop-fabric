package io.felipeandrade.gsw2.material.gem;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Blocks;

import java.util.ArrayList;
import java.util.List;

import io.felipeandrade.gsw2.block.GSWBlock;
import io.felipeandrade.gsw2.block.MaterialBlock;
import io.felipeandrade.gsw2.item.GSWItem;
import io.felipeandrade.gsw2.material.GSWMaterial;
import io.felipeandrade.gsw2.item.MaterialItem;
import io.felipeandrade.gsw2.tool.GSWShovel;

public class GemMaterial extends GSWMaterial {


    public GemMaterial(String unlocalizedName) {
        super(unlocalizedName);
    }

    @Override
    public List<? extends GSWItem> allItems() {
        List<GSWItem> result = new ArrayList<>();

        result.add(new MaterialItem("gem", this));

        return result;
    }

    @Override
    public List<? extends GSWBlock> allBlocks() {
        List<GSWBlock> result = new ArrayList<>();

        result.add(new MaterialBlock("block", this, FabricBlockSettings.copy(Blocks.IRON_BLOCK).build()));
        result.add(new MaterialBlock("ore", this, FabricBlockSettings.copy(Blocks.IRON_ORE).build()));

        return result;
    }

    @Override
    public List<? extends GSWShovel> allTools() {
        return new ArrayList<>();
    }
}