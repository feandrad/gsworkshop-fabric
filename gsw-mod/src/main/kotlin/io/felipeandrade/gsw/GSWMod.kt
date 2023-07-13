package io.felipeandrade.gsw

import io.felipeandrade.gsw.material.metal.TinMaterial
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.loot.v2.LootTableEvents
import net.minecraft.block.Blocks
import net.minecraft.loot.LootPool
import net.minecraft.loot.entry.ItemEntry

class GSWMod : ModInitializer, ClientModInitializer {

    override fun onInitialize() {
        GSWRegistryHandler.registerAll()

        LootTableEvents.MODIFY.register { _, _, id, tableBuilder, source ->
            if (source.isBuiltin && (id == COPPER_BLOCK_LOOT_TABLE_ID || id == DEEPSLATE_COPPER_ORE_LOOT_TABLE_ID)) {
                val poolBuilder = LootPool.builder().with(ItemEntry.builder(TinMaterial.RAW))
                tableBuilder.pool(poolBuilder)
            }
        }
    }

    override fun onInitializeClient() {}

    companion object {
        const val MOD_ID = "gsw"
        private val COPPER_BLOCK_LOOT_TABLE_ID = Blocks.COPPER_BLOCK.lootTableId
        private val DEEPSLATE_COPPER_ORE_LOOT_TABLE_ID = Blocks.DEEPSLATE_COPPER_ORE.lootTableId
    }
}