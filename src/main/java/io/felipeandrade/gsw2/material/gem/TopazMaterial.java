package io.felipeandrade.gsw2.material.gem;

import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.felipeandrade.gsw2.GSWItemGroup;
import io.felipeandrade.gsw2.block.GSWBlock;
import io.felipeandrade.gsw2.block.GSWMaterialBlock;
import io.felipeandrade.gsw2.block.GemOreBlock;
import io.felipeandrade.gsw2.common.GSWColor;
import io.felipeandrade.gsw2.item.GSWItem;
import io.felipeandrade.gsw2.item.tool.GSWTool;
import io.felipeandrade.gsw2.material.GSWMaterial;
import io.felipeandrade.gsw2.material.GSWMaterialItem;

public class TopazMaterial extends GSWMaterial {

    public static final GSWMaterial MATERIAL = new TopazMaterial();

    public TopazMaterial() {
        super("topaz", GSWColor.gold);
    }

    @Override
    public List<? extends GSWItem> allItems() {
        return Collections.singletonList(GEM);
    }

    @Override
    public List<? extends GSWBlock> allBlocks() {
        return Arrays.asList(ORE_BLOCK, GEM_BLOCK);
    }

    @Override
    public List<? extends GSWTool> allTools() {
        return new ArrayList<>();
    }


    public static final GSWItem GEM = new GSWMaterialItem("gem", MATERIAL, new Item.Settings().group(GSWItemGroup.MATERIALS));

    public static final GSWBlock GEM_BLOCK = new GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_GEM);
    public static final GSWBlock ORE_BLOCK = new GemOreBlock(MATERIAL, GSWMaterialBlock.SETTINGS_GEM);

}

