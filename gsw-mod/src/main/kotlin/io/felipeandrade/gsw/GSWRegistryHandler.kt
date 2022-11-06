package io.felipeandrade.gsw

import io.felipeandrade.gsw.common.ClientResourceInit
import io.felipeandrade.gsw.common.Registrable
import io.felipeandrade.gsw.material.gem.AmethystMaterial
import io.felipeandrade.gsw.material.gem.RubyMaterial
import io.felipeandrade.gsw.material.gem.SapphireMaterial
import io.felipeandrade.gsw.material.gem.TopazMaterial
import io.felipeandrade.gsw.material.metal.*
import io.felipeandrade.gsw.material.vanilla.*
import java.util.*

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
        TinMaterial.MATERIAL,
        SilverMaterial.MATERIAL,
        TitaniumMaterial.MATERIAL,
        PlatinumMaterial.MATERIAL,
        BronzeMaterial.MATERIAL,
        SteelMaterial.MATERIAL,
        MithrilMaterial.MATERIAL,
        OrichalcumMaterial.MATERIAL,
        AmethystMaterial.MATERIAL,
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
        }
        for (registrable in result) {
            registrable.register()
            if (registrable is ClientResourceInit) {
                GSWMod.CLIENT_RES.add(registrable as ClientResourceInit)
            }
        }
    }
}