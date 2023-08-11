package io.felipeandrade.gsw.datagen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

const val PATH_BLOCK = "blocks"

class GSWDataGeneration : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        fabricDataGenerator.addProvider(BlockLootTableGenerator(fabricDataGenerator))
        fabricDataGenerator.addProvider(GSWRecipeProvider(fabricDataGenerator))
        fabricDataGenerator.addProvider(GSWModelProvider(fabricDataGenerator))
    }
}

