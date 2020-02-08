package io.felipeandrade.gsw2;

import java.util.ArrayList;

import io.felipeandrade.gsw2.common.Registrable;
import io.felipeandrade.gsw2.material.GSWMaterial;

public abstract class GSWRegistryHandler {


    public static void registerAll() {
        ArrayList<Registrable> result = new ArrayList<>();

        for (GSWMaterial material : GSWMaterial.ALL_GSW_MATERIALS) {
            result.addAll(material.allItems());
            result.addAll(material.allBlocks());
            result.addAll(material.allTools());
        }

        for (Registrable registrable : result) {
            registrable.register();
        }

    }
}
