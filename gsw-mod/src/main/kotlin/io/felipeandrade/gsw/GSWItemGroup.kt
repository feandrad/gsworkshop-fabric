package io.felipeandrade.gsw

import io.felipeandrade.gsw.material.metal.MithrilMaterial
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier

object GSWItemGroup {
    val MATERIALS: ItemGroup = FabricItemGroupBuilder.build(Identifier(GSWMod.MOD_ID, "materials")) { ItemStack(MithrilMaterial.INGOT) }
    val TOOLS: ItemGroup = FabricItemGroupBuilder.build(Identifier(GSWMod.MOD_ID, "tools")) { ItemStack(MithrilMaterial.PICKAXE as ItemConvertible) }
}