package io.felipeandrade.gsw2;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

import java.util.ArrayList;
import java.util.List;

import io.felipeandrade.gsw2.common.ClientResourceInit;

public class GSW2Mod implements ModInitializer, ClientModInitializer {

    public static final String MOD_ID = "gsw2";

    public static final List<ClientResourceInit> CLIENT_RES = new ArrayList<>();

    @Override
    public void onInitialize() {
        GSWRegistryHandler.registerAll();
    }

    @Override
    public void onInitializeClient() {
        for (ClientResourceInit clientProxy : CLIENT_RES) {
            clientProxy.onClientInit();
        }
    }
}
