package io.felipeandrade.gsw

import io.felipeandrade.gsw.world.registerWorldGen
import net.fabricmc.api.ModInitializer

class GSWMod : ModInitializer {

    override fun onInitialize() {
        GSWRegistryHandler.registerAll()
        registerWorldGen()
    }

    companion object {
        const val MOD_ID = "gsw"
    }
}