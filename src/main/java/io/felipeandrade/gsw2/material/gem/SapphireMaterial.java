package io.felipeandrade.gsw2.material.gem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.felipeandrade.gsw2.block.GSWBlock;
import io.felipeandrade.gsw2.block.GSWMaterialBlock;
import io.felipeandrade.gsw2.block.GemOreBlock;
import io.felipeandrade.gsw2.common.GSWColor;
import io.felipeandrade.gsw2.item.GSWItem;
import io.felipeandrade.gsw2.item.tool.GSWTool;
import io.felipeandrade.gsw2.material.GSWMaterial;
import io.felipeandrade.gsw2.material.GSWMaterialItem;

public class SapphireMaterial extends GSWMaterial {

    public static final GSWMaterial MATERIAL = new SapphireMaterial();

    public SapphireMaterial() {
        super("sapphire", GSWColor.corn_flower_blue);
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


    public static final GSWItem GEM = new GSWMaterialItem("gem", MATERIAL, new Item.Settings().group(ItemGroup.MISC));

    public static final GSWBlock GEM_BLOCK = new GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_GEM);
    public static final GSWBlock ORE_BLOCK = new GemOreBlock(MATERIAL, GSWMaterialBlock.SETTINGS_GEM);

}

