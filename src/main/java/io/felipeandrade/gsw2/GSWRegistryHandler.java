package io.felipeandrade.gsw2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.felipeandrade.gsw2.common.MaterialFactory;
import io.felipeandrade.gsw2.common.Registrable;
import io.felipeandrade.gsw2.material.gem.GemFactory;
import io.felipeandrade.gsw2.material.metal.MetalFactory;

public abstract class GSWRegistryHandler {

    public static final List<MaterialFactory> allFactories = Arrays.asList(
            new MetalFactory(),
            new GemFactory()
    );

    public static void registerAll() {

        List<Registrable> allRegistrables = new ArrayList<>();

        for (MaterialFactory factory : allFactories) {
            allRegistrables.addAll(factory.allRegistrables());
        }

        for (Registrable registrable : allRegistrables) {
            registrable.register();
        }
    }
}
