package io.felipeandrade.gsw2;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

import java.util.ArrayList;
import java.util.List;

import io.felipeandrade.gsw2.common.ClientProxyInit;

public class GSW2Mod implements ModInitializer, ClientModInitializer {

    public static final String MOD_ID = "gsw2";

    public static final List<ClientProxyInit> CLIENT_PROXY = new ArrayList<>();

    @Override
    public void onInitialize() {
        GSWRegistryHandler.registerAll();
    }

    @Override
    public void onInitializeClient() {
        for (ClientProxyInit clientProxy : CLIENT_PROXY) {
            clientProxy.onClientInit();
        }
    }
}
