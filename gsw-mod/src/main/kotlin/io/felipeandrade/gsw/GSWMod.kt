package io.felipeandrade.gsw

import io.felipeandrade.gsw.GSWItemGroup.registerItemGroups
import io.felipeandrade.gsw.world.registerWorldGen
import net.fabricmc.api.ModInitializer

class GSWMod : ModInitializer {

    override fun onInitialize() {
        registerItemGroups()
        GSWRegistryHandler.registerAll()
        registerWorldGen()
    }

    companion object {
        const val MOD_ID = "gsw"
    }
}