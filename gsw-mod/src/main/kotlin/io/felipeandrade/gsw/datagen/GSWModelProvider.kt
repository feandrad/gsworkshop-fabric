package io.felipeandrade.gsw.datagen

import io.felipeandrade.gsw.GSWRegistryHandler
import io.felipeandrade.gsw.item.tool.GSWTool
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models

class GSWModelProvider(dataGenerator: FabricDataGenerator) : FabricModelProvider(dataGenerator) {

    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {
        GSWRegistryHandler.ALL_GSW_MATERIALS.forEach {
            it.generateBlockStateModels(blockStateModelGenerator)
        }
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
        GSWRegistryHandler.ALL_GSW_MATERIALS.forEach {
            it.generateItemModels(itemModelGenerator)
        }
    }
}

fun ItemModelGenerator.registerTools(allTools: List<GSWTool>) {
    allTools.forEach {
        register(it.item, Models.HANDHELD)
    }
}
