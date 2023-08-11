package io.felipeandrade.gsw

import net.fabricmc.api.ModInitializer

class GSWMod : ModInitializer {

    override fun onInitialize() {
        GSWRegistryHandler.registerAll()
    }

    companion object {
        const val MOD_ID = "gsw"
    }
}