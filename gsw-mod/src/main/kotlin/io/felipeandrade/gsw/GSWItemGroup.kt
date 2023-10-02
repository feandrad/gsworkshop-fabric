package io.felipeandrade.gsw

import io.felipeandrade.gsw.material.metal.*
import io.felipeandrade.gsw.material.vanilla.*
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier

object GSWItemGroup {
    val MATERIALS: ItemGroup = Registry.register(
        Registries.ITEM_GROUP,
        Identifier(GSWMod.MOD_ID, "materials"),
        FabricItemGroup.builder()
            .icon { ItemStack(MithrilMaterial.INGOT) }
            .displayName(Text.translatable("itemGroup.gsw.materials"))
            .entries { _, entries ->
                BoneMaterial.addMaterialsToItemGroup(entries)
                WoodMaterial.addMaterialsToItemGroup(entries)
                StoneMaterial.addMaterialsToItemGroup(entries)
                FlintMaterial.addMaterialsToItemGroup(entries)
                CoalMaterial.addMaterialsToItemGroup(entries)
                CopperMaterial.addMaterialsToItemGroup(entries)
                IronMaterial.addMaterialsToItemGroup(entries)
                GoldMaterial.addMaterialsToItemGroup(entries)
                DiamondMaterial.addMaterialsToItemGroup(entries)
                NetheriteMaterial.addMaterialsToItemGroup(entries)

                TinMaterial.addMaterialsToItemGroup(entries)
                BronzeMaterial.addMaterialsToItemGroup(entries)
                SilverMaterial.addMaterialsToItemGroup(entries)
                SteelMaterial.addMaterialsToItemGroup(entries)
                PlatinumMaterial.addMaterialsToItemGroup(entries)
                TitaniumMaterial.addMaterialsToItemGroup(entries)
                CobaltMaterial.addMaterialsToItemGroup(entries)
                MithrilMaterial.addMaterialsToItemGroup(entries)
                OrichalcumMaterial.addMaterialsToItemGroup(entries)
            }
            .build()
    )

    val TOOLS: ItemGroup = Registry.register(
        Registries.ITEM_GROUP,
        Identifier(GSWMod.MOD_ID, "tools"),
        FabricItemGroup.builder()
            .icon { ItemStack(MithrilMaterial.PICKAXE as ItemConvertible) }
            .displayName(Text.translatable("itemGroup.gsw.tools"))
            .entries { _, entries ->
                BoneMaterial.addToolsToItemGroup(entries)
                WoodMaterial.addToolsToItemGroup(entries)
                StoneMaterial.addToolsToItemGroup(entries)
                FlintMaterial.addToolsToItemGroup(entries)
                CoalMaterial.addToolsToItemGroup(entries)
                CopperMaterial.addToolsToItemGroup(entries)
                IronMaterial.addToolsToItemGroup(entries)
                GoldMaterial.addToolsToItemGroup(entries)
                DiamondMaterial.addToolsToItemGroup(entries)
                NetheriteMaterial.addToolsToItemGroup(entries)

                TinMaterial.addToolsToItemGroup(entries)
                BronzeMaterial.addToolsToItemGroup(entries)
                SilverMaterial.addToolsToItemGroup(entries)
                SteelMaterial.addToolsToItemGroup(entries)
                PlatinumMaterial.addToolsToItemGroup(entries)
                TitaniumMaterial.addToolsToItemGroup(entries)
                CobaltMaterial.addToolsToItemGroup(entries)
                MithrilMaterial.addToolsToItemGroup(entries)
                OrichalcumMaterial.addToolsToItemGroup(entries)
            }
            .build()
    )

    fun registerItemGroups() {}
}