package io.felipeandrade.gsw.datagen

import io.felipeandrade.gsw.material.metal.*
import io.felipeandrade.gsw.material.vanilla.WoodMaterial
import io.felipeandrade.gsw.material.vanilla.WoolMaterial
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.item.ArmorItem

class GswModelProvider(
    output: FabricDataOutput
) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {

    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator): Unit = with(itemModelGenerator) {

        registerArmor(WoolMaterial.BOOTS as ArmorItem)
        registerArmor(WoolMaterial.LEGGINGS as ArmorItem)
        registerArmor(WoolMaterial.CHESTPLATE as ArmorItem)
        registerArmor(WoolMaterial.HELMET as ArmorItem)

        registerArmor(WoodMaterial.BOOTS as ArmorItem)
        registerArmor(WoodMaterial.LEGGINGS as ArmorItem)
        registerArmor(WoodMaterial.CHESTPLATE as ArmorItem)
        registerArmor(WoodMaterial.HELMET as ArmorItem)

        registerArmor(BronzeMaterial.BOOTS as ArmorItem)
        registerArmor(BronzeMaterial.LEGGINGS as ArmorItem)
        registerArmor(BronzeMaterial.CHESTPLATE as ArmorItem)
        registerArmor(BronzeMaterial.HELMET as ArmorItem)

        registerArmor(SteelMaterial.BOOTS as ArmorItem)
        registerArmor(SteelMaterial.LEGGINGS as ArmorItem)
        registerArmor(SteelMaterial.CHESTPLATE as ArmorItem)
        registerArmor(SteelMaterial.HELMET as ArmorItem)

        registerArmor(SilverMaterial.BOOTS as ArmorItem)
        registerArmor(SilverMaterial.LEGGINGS as ArmorItem)
        registerArmor(SilverMaterial.CHESTPLATE as ArmorItem)
        registerArmor(SilverMaterial.HELMET as ArmorItem)

        registerArmor(PlatinumMaterial.BOOTS as ArmorItem)
        registerArmor(PlatinumMaterial.LEGGINGS as ArmorItem)
        registerArmor(PlatinumMaterial.CHESTPLATE as ArmorItem)
        registerArmor(PlatinumMaterial.HELMET as ArmorItem)

        registerArmor(TitaniumMaterial.BOOTS as ArmorItem)
        registerArmor(TitaniumMaterial.LEGGINGS as ArmorItem)
        registerArmor(TitaniumMaterial.CHESTPLATE as ArmorItem)
        registerArmor(TitaniumMaterial.HELMET as ArmorItem)

        registerArmor(CobaltMaterial.BOOTS as ArmorItem)
        registerArmor(CobaltMaterial.LEGGINGS as ArmorItem)
        registerArmor(CobaltMaterial.CHESTPLATE as ArmorItem)
        registerArmor(CobaltMaterial.HELMET as ArmorItem)

        registerArmor(MithrilMaterial.BOOTS as ArmorItem)
        registerArmor(MithrilMaterial.LEGGINGS as ArmorItem)
        registerArmor(MithrilMaterial.CHESTPLATE as ArmorItem)
        registerArmor(MithrilMaterial.HELMET as ArmorItem)

        registerArmor(OrichalcumMaterial.BOOTS as ArmorItem)
        registerArmor(OrichalcumMaterial.LEGGINGS as ArmorItem)
        registerArmor(OrichalcumMaterial.CHESTPLATE as ArmorItem)
        registerArmor(OrichalcumMaterial.HELMET as ArmorItem)
    }

}