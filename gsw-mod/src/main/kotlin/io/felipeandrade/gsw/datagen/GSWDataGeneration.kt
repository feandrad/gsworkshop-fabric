package io.felipeandrade.gsw.datagen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

class GSWDataGeneration : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(dataGenerator: FabricDataGenerator) {
        dataGenerator.createPack().apply {
            addProvider(FabricDataGenerator.Pack.Factory { BlockLootTableGenerator(it) })
            addProvider(FabricDataGenerator.Pack.Factory { GSWRecipeProvider(it) })
        }
    }
}

