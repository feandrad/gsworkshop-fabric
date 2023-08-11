package io.felipeandrade.gsw.datagen

import io.felipeandrade.gsw.GSWMod.Companion.MOD_ID
import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.material.gem.RubyMaterial
import io.felipeandrade.gsw.material.gem.SapphireMaterial
import io.felipeandrade.gsw.material.gem.TopazMaterial
import io.felipeandrade.gsw.material.metal.*
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider
import net.minecraft.data.server.BlockLootTableGenerator
import net.minecraft.item.Item
import net.minecraft.loot.LootTable
import net.minecraft.loot.context.LootContextTypes
import net.minecraft.util.Identifier
import java.util.function.BiConsumer


class BlockLootTableGenerator(
    dataGenerator: FabricDataGenerator
) : SimpleFabricLootTableProvider(dataGenerator, LootContextTypes.BLOCK) {

    override fun accept(t: BiConsumer<Identifier, LootTable.Builder>) {

        t.generateOre(
            TinMaterial.RAW,
            listOf(TinMaterial.RAW_BLOCK, TinMaterial.METAL_BLOCK),
            listOf(TinMaterial.ORE_BLOCK, TinMaterial.DEEPSLATE_ORE_BLOCK)
        )

        t.generateOre(
            SilverMaterial.RAW,
            listOf(SilverMaterial.RAW_BLOCK, SilverMaterial.METAL_BLOCK),
            listOf(SilverMaterial.ORE_BLOCK, SilverMaterial.DEEPSLATE_ORE_BLOCK)
        )

        t.generateOre(
            PlatinumMaterial.RAW,
            listOf(PlatinumMaterial.RAW_BLOCK, PlatinumMaterial.METAL_BLOCK),
            listOf(PlatinumMaterial.ORE_BLOCK, PlatinumMaterial.DEEPSLATE_ORE_BLOCK)
        )

        t.generateOre(
            TitaniumMaterial.RAW,
            listOf(TitaniumMaterial.RAW_BLOCK, TitaniumMaterial.METAL_BLOCK),
            listOf(TitaniumMaterial.ORE_BLOCK, TitaniumMaterial.DEEPSLATE_ORE_BLOCK)
        )

        t.generateOre(
            CobaltMaterial.RAW,
            listOf(CobaltMaterial.RAW_BLOCK, CobaltMaterial.METAL_BLOCK),
            listOf(CobaltMaterial.ORE_BLOCK, CobaltMaterial.DEEPSLATE_ORE_BLOCK)
        )

        t.generateOre(
            MithrilMaterial.RAW,
            listOf(MithrilMaterial.RAW_BLOCK, MithrilMaterial.METAL_BLOCK),
            listOf(MithrilMaterial.ORE_BLOCK, MithrilMaterial.DEEPSLATE_ORE_BLOCK)
        )

        t.generateOre(
            OrichalcumMaterial.RAW,
            listOf(OrichalcumMaterial.RAW_BLOCK, OrichalcumMaterial.METAL_BLOCK),
            listOf(OrichalcumMaterial.ORE_BLOCK, OrichalcumMaterial.DEEPSLATE_ORE_BLOCK)
        )

        t.miningDrops(RubyMaterial.ORE_BLOCK, RubyMaterial.GEM)
        t.miningDrops(RubyMaterial.DEEPSLATE_ORE_BLOCK, RubyMaterial.GEM)

        t.miningDrops(SapphireMaterial.ORE_BLOCK, SapphireMaterial.GEM)
        t.miningDrops(SapphireMaterial.DEEPSLATE_ORE_BLOCK, SapphireMaterial.GEM)

        t.miningDrops(TopazMaterial.ORE_BLOCK, TopazMaterial.GEM)
        t.miningDrops(TopazMaterial.DEEPSLATE_ORE_BLOCK, TopazMaterial.GEM)

        t.accept(Identifier(MOD_ID, "${PATH_BLOCK}/${BronzeMaterial.METAL_BLOCK.unlocalizedName}"), BlockLootTableGenerator.drops(BronzeMaterial.METAL_BLOCK))
        t.accept(Identifier(MOD_ID, "${PATH_BLOCK}/${SteelMaterial.METAL_BLOCK.unlocalizedName}"), BlockLootTableGenerator.drops(SteelMaterial.METAL_BLOCK))
    }
}

private fun BiConsumer<Identifier, LootTable.Builder>.generateOre(
    raw: Item,
    blocks: List<GSWBlock>,
    ores: List<GSWBlock>
) {
    blocks.forEach {
        accept(Identifier(MOD_ID, "${PATH_BLOCK}/${it.unlocalizedName}"), BlockLootTableGenerator.drops(it))
    }
    ores.forEach {
        miningDrops(it, raw)
    }
}

private fun BiConsumer<Identifier, LootTable.Builder>.miningDrops(oreBlock: GSWBlock, rawItem: Item) {
    accept(Identifier(MOD_ID, "${PATH_BLOCK}/${oreBlock.unlocalizedName}"), BlockLootTableGenerator.drops(rawItem))
    accept(Identifier(MOD_ID, "${PATH_BLOCK}/${oreBlock.unlocalizedName}_silk"), BlockLootTableGenerator.dropsWithSilkTouch(oreBlock))
}
