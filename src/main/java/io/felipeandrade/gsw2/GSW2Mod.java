package io.felipeandrade.gsw2;

import net.fabricmc.api.ModInitializer;

public class GSW2Mod implements ModInitializer {

    public static final String MOD_ID = "gsw2";

    @Override
    public void onInitialize() {
        GSWRegistryHandler.registerAll();
    }
}
