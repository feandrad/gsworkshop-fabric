package io.felipeandrade.gsw.datagen

import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.material.gem.RubyMaterial
import io.felipeandrade.gsw.material.gem.SapphireMaterial
import io.felipeandrade.gsw.material.gem.TopazMaterial
import io.felipeandrade.gsw.material.metal.*
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.item.Item

class BlockLootTableGenerator(
    dataOutput: FabricDataOutput
) : FabricBlockLootTableProvider(dataOutput) {

    override fun generate() {

        generateOre(
            TinMaterial.RAW,
            listOf(TinMaterial.RAW_BLOCK, TinMaterial.METAL_BLOCK),
            listOf(TinMaterial.ORE_BLOCK, TinMaterial.DEEPSLATE_ORE_BLOCK)
        )

        generateOre(
            SilverMaterial.RAW,
            listOf(SilverMaterial.RAW_BLOCK, SilverMaterial.METAL_BLOCK),
            listOf(SilverMaterial.ORE_BLOCK, SilverMaterial.DEEPSLATE_ORE_BLOCK)
        )

        generateOre(
            PlatinumMaterial.RAW,
            listOf(PlatinumMaterial.RAW_BLOCK, PlatinumMaterial.METAL_BLOCK),
            listOf(PlatinumMaterial.ORE_BLOCK, PlatinumMaterial.DEEPSLATE_ORE_BLOCK)
        )

        generateOre(
            TitaniumMaterial.RAW,
            listOf(TitaniumMaterial.RAW_BLOCK, TitaniumMaterial.METAL_BLOCK),
            listOf(TitaniumMaterial.ORE_BLOCK, TitaniumMaterial.DEEPSLATE_ORE_BLOCK)
        )

        generateOre(
            CobaltMaterial.RAW,
            listOf(CobaltMaterial.RAW_BLOCK, CobaltMaterial.METAL_BLOCK),
            listOf(CobaltMaterial.ORE_BLOCK, CobaltMaterial.DEEPSLATE_ORE_BLOCK)
        )

        generateOre(
            MithrilMaterial.RAW,
            listOf(MithrilMaterial.RAW_BLOCK, MithrilMaterial.METAL_BLOCK),
            listOf(MithrilMaterial.ORE_BLOCK, MithrilMaterial.DEEPSLATE_ORE_BLOCK)
        )

        generateOre(
            OrichalcumMaterial.RAW,
            listOf(OrichalcumMaterial.RAW_BLOCK, OrichalcumMaterial.METAL_BLOCK),
            listOf(OrichalcumMaterial.ORE_BLOCK, OrichalcumMaterial.DEEPSLATE_ORE_BLOCK)
        )

        miningDrops(RubyMaterial.ORE_BLOCK, RubyMaterial.GEM)
        miningDrops(RubyMaterial.DEEPSLATE_ORE_BLOCK, RubyMaterial.GEM)

        miningDrops(SapphireMaterial.ORE_BLOCK, SapphireMaterial.GEM)
        miningDrops(SapphireMaterial.DEEPSLATE_ORE_BLOCK, SapphireMaterial.GEM)

        miningDrops(TopazMaterial.ORE_BLOCK, TopazMaterial.GEM)
        miningDrops(TopazMaterial.DEEPSLATE_ORE_BLOCK, TopazMaterial.GEM)

        addDrop(BronzeMaterial.METAL_BLOCK)
        addDrop(SteelMaterial.METAL_BLOCK)
    }

    private fun generateOre(
        raw: Item,
        blocks: List<GSWBlock>,
        ores: List<GSWBlock>
    ) {
        blocks.forEach {
            addDrop(it)
        }
        ores.forEach {
            miningDrops(it, raw)
        }
    }

    private fun miningDrops(oreBlock: GSWBlock, rawItem: Item) {
        addDrop(oreBlock, oreDrops(oreBlock, rawItem))
    }
}
