package io.felipeandrade.gsw2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.felipeandrade.gsw2.common.Registrable;
import io.felipeandrade.gsw2.material.GSWMaterial;
import io.felipeandrade.gsw2.material.gem.AmethystMaterial;
import io.felipeandrade.gsw2.material.gem.RubiMaterial;
import io.felipeandrade.gsw2.material.gem.SapphireMaterial;
import io.felipeandrade.gsw2.material.gem.TopazMaterial;
import io.felipeandrade.gsw2.material.metal.BronzeMaterial;
import io.felipeandrade.gsw2.material.metal.CopperMaterial;
import io.felipeandrade.gsw2.material.metal.SilverMaterial;
import io.felipeandrade.gsw2.material.metal.TinMaterial;


public abstract class GSWRegistryHandler {

    public static final List<GSWMaterial> ALL_GSW_MATERIALS = Arrays.asList(
            CopperMaterial.MATERIAL,
            TinMaterial.MATERIAL,
            SilverMaterial.MATERIAL,

            BronzeMaterial.MATERIAL,

            AmethystMaterial.MATERIAL,
            TopazMaterial.MATERIAL,
            SapphireMaterial.MATERIAL,
            RubiMaterial.MATERIAL
    );

    public static void registerAll() {
        ArrayList<Registrable> result = new ArrayList<>();

        for (GSWMaterial material : ALL_GSW_MATERIALS) {
            result.addAll(material.allItems());
            result.addAll(material.allBlocks());
            result.addAll(material.allTools());
        }

        for (Registrable registrable : result) {
            registrable.register();
        }

    }
}
