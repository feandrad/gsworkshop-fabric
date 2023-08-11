package io.felipeandrade.gsw

import io.felipeandrade.gsw.common.Registrable
import io.felipeandrade.gsw.material.gem.RubyMaterial
import io.felipeandrade.gsw.material.gem.SapphireMaterial
import io.felipeandrade.gsw.material.gem.TopazMaterial
import io.felipeandrade.gsw.material.metal.*
import io.felipeandrade.gsw.material.vanilla.*

object GSWRegistryHandler {
    private val ALL_GSW_MATERIALS = listOf(
        WoodMaterial.MATERIAL,
        StoneMaterial.MATERIAL,
        IronMaterial.MATERIAL,
        GoldMaterial.MATERIAL,
        DiamondMaterial.MATERIAL,
        BoneMaterial.MATERIAL,
        FlintMaterial.MATERIAL,
        CoalMaterial.MATERIAL,
        WoolMaterial.MATERIAL,
        LeatherMaterial.MATERIAL,
        CopperMaterial.MATERIAL,
        NetheriteMaterial.MATERIAL,

        TinMaterial.MATERIAL,
        SilverMaterial.MATERIAL,
        TitaniumMaterial.MATERIAL,
        PlatinumMaterial.MATERIAL,
        CobaltMaterial.MATERIAL,
        MithrilMaterial.MATERIAL,
        OrichalcumMaterial.MATERIAL,

        BronzeMaterial.MATERIAL,
        SteelMaterial.MATERIAL,

        TopazMaterial.MATERIAL,
        SapphireMaterial.MATERIAL,
        RubyMaterial.MATERIAL
    )

    fun registerAll() {
        val result = ArrayList<Registrable>()
        for (material in ALL_GSW_MATERIALS) {
            result.addAll(material.allItems())
            result.addAll(material.allBlocks())
            result.addAll(material.allTools())
            result.addAll(material.allArmor())
        }
        for (registrable in result) {
            registrable.register()
        }
    }
}