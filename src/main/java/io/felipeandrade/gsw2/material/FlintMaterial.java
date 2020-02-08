package io.felipeandrade.gsw2.material;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;

import java.util.Arrays;
import java.util.List;

import io.felipeandrade.gsw2.common.GSWColor;
import io.felipeandrade.gsw2.item.tool.GSWAxe;
import io.felipeandrade.gsw2.item.tool.GSWHammer;
import io.felipeandrade.gsw2.item.tool.GSWHoe;
import io.felipeandrade.gsw2.item.tool.GSWPickaxe;
import io.felipeandrade.gsw2.item.tool.GSWShovel;
import io.felipeandrade.gsw2.item.tool.GSWSword;
import io.felipeandrade.gsw2.item.tool.GSWTool;
import io.felipeandrade.gsw2.item.tool.GSWToolMaterial;

public class FlintMaterial extends GSWMaterial {

    public static final GSWMaterial MATERIAL = new FlintMaterial();

    public FlintMaterial() {
        super("flint", GSWColor.black);
    }

    @Override
    public List<? extends GSWTool> allTools() {
        return Arrays.asList(SWORD, PICKAXE, AXE, SHOVEL, HOE, HAMMER);
    }

    public static final GSWToolMaterial TOOL_MATERIAL = new GSWToolMaterial(0, 64, 5.0F, 1.0F, 5, Items.FLINT);

    public static final GSWTool SWORD = new GSWSword(MATERIAL, TOOL_MATERIAL, 2, -3.0f, new Item.Settings().group(ItemGroup.COMBAT));
    public static final GSWTool PICKAXE = new GSWPickaxe(MATERIAL, TOOL_MATERIAL, 2, -3.0f, new Item.Settings().group(ItemGroup.TOOLS));
    public static final GSWTool AXE = new GSWAxe(MATERIAL, TOOL_MATERIAL, 3, -3.0f, new Item.Settings().group(ItemGroup.TOOLS));
    public static final GSWTool SHOVEL = new GSWShovel(MATERIAL, TOOL_MATERIAL, -3.0f, new Item.Settings().group(ItemGroup.TOOLS));
    public static final GSWTool HOE = new GSWHoe(MATERIAL, TOOL_MATERIAL, -3.0f, new Item.Settings().group(ItemGroup.TOOLS));
    public static final GSWTool HAMMER = new GSWHammer(MATERIAL, TOOL_MATERIAL, 3, -3.0f, new Item.Settings().group(ItemGroup.TOOLS));

}
