package io.felipeandrade.gsw2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.felipeandrade.gsw2.common.ClientProxyInit;
import io.felipeandrade.gsw2.common.Registrable;
import io.felipeandrade.gsw2.material.BoneMaterial;
import io.felipeandrade.gsw2.material.FlintMaterial;
import io.felipeandrade.gsw2.material.GSWMaterial;
import io.felipeandrade.gsw2.material.gem.AmethystMaterial;
import io.felipeandrade.gsw2.material.gem.RubyMaterial;
import io.felipeandrade.gsw2.material.gem.SapphireMaterial;
import io.felipeandrade.gsw2.material.gem.TopazMaterial;
import io.felipeandrade.gsw2.material.metal.BronzeMaterial;
import io.felipeandrade.gsw2.material.metal.CopperMaterial;
import io.felipeandrade.gsw2.material.metal.MithrilMaterial;
import io.felipeandrade.gsw2.material.metal.OrichalcumMaterial;
import io.felipeandrade.gsw2.material.metal.PlatinumMaterial;
import io.felipeandrade.gsw2.material.metal.SilverMaterial;
import io.felipeandrade.gsw2.material.metal.SteelMaterial;
import io.felipeandrade.gsw2.material.metal.TinMaterial;
import io.felipeandrade.gsw2.material.metal.TitaniumMaterial;

public abstract class GSWRegistryHandler {

    public static final List<GSWMaterial> ALL_GSW_MATERIALS = Arrays.asList(
            BoneMaterial.MATERIAL,
            FlintMaterial.MATERIAL,

            CopperMaterial.MATERIAL,
            TinMaterial.MATERIAL,
            SilverMaterial.MATERIAL,
            TitaniumMaterial.MATERIAL,
            PlatinumMaterial.MATERIAL,

            BronzeMaterial.MATERIAL,
            SteelMaterial.MATERIAL,

            AmethystMaterial.MATERIAL,
            TopazMaterial.MATERIAL,
            SapphireMaterial.MATERIAL,
            RubyMaterial.MATERIAL,

            MithrilMaterial.MATERIAL,
            OrichalcumMaterial.MATERIAL
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
            if (registrable instanceof ClientProxyInit) {
                GSW2Mod.CLIENT_PROXY.add(((ClientProxyInit) registrable));
            }
        }

    }

}
