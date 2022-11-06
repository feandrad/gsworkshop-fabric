package io.felipeandrade.gsw

import io.felipeandrade.gsw.common.ClientResourceInit
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.ModInitializer

class GSWMod : ModInitializer, ClientModInitializer {
    override fun onInitialize() {
        GSWRegistryHandler.registerAll()
    }

    override fun onInitializeClient() {
        for (clientProxy in CLIENT_RES) {
            clientProxy.onClientInit()
        }
    }

    companion object {
        const val MOD_ID = "gsw"
        val CLIENT_RES: MutableList<ClientResourceInit> = mutableListOf()
    }
}