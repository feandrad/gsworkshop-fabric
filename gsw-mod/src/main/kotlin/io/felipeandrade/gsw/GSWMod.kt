package io.felipeandrade.gsw

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.ModInitializer
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.screen.ingame.HandledScreens
import net.minecraft.screen.ScreenHandler

class GSWMod : ModInitializer, ClientModInitializer {
    override fun onInitialize() {
        GSWRegistryHandler.registerAll()
    }

    override fun onInitializeClient() {}

    companion object {
        const val MOD_ID = "gsw"
    }
}