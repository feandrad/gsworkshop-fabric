package io.felipeandrade.gsw.datagen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator.Pack

class GswDataGeneration : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(dataGenerator: FabricDataGenerator) {
        dataGenerator.createPack().apply {
            addProvider { output, future -> GswBlockTagProvider(output, future) }
            addProvider { output, future -> GswItemTagProvider(output, future) }
            addProvider(Pack.Factory { BlockLootTableGenerator(it) })
            addProvider(Pack.Factory { GSWRecipeProvider(it) })
            addProvider(Pack.Factory { GswModelProvider(it) })
        }
    }
}

