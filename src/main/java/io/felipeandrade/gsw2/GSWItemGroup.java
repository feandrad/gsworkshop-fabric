package io.felipeandrade.gsw2;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import io.felipeandrade.gsw2.material.metal.MithrilMaterial;

import static io.felipeandrade.gsw2.GSW2Mod.MOD_ID;

public class GSWItemGroup {

    public static final ItemGroup MATERIALS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "materials"), () -> new ItemStack(MithrilMaterial.INGOT));
    public static final ItemGroup TOOLS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "tools"), () -> new ItemStack((ItemConvertible) MithrilMaterial.PICKAXE));
}
