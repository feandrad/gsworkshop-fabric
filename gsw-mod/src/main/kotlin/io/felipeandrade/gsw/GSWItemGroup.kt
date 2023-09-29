package io.felipeandrade.gsw

import io.felipeandrade.gsw.material.metal.MithrilMaterial
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object GSWItemGroup {
    val MATERIALS: ItemGroup = Registry.register(
        Registries.ITEM_GROUP,
        Identifier(GSWMod.MOD_ID, "materials"),
        FabricItemGroup.builder()
            .icon { ItemStack(MithrilMaterial.INGOT) }
            .entries { displayContext, entries ->
                // TODO: All Materials here
            }
            .build()
    )

    //    (
    val TOOLS: ItemGroup = Registry.register(
        Registries.ITEM_GROUP,
        Identifier(GSWMod.MOD_ID, "tools"),
        FabricItemGroup.builder()
            .icon { ItemStack(MithrilMaterial.PICKAXE as ItemConvertible) }
            .entries { displayContext, entries ->
                // TODO: All Tools here
            }
            .build()
    )

    fun registerItemGroups() {}
}