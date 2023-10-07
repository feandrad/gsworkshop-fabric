package io.felipeandrade.gsw.datagen

import io.felipeandrade.gsw.GswItemTags
import io.felipeandrade.gsw.material.gem.RubyMaterial
import io.felipeandrade.gsw.material.gem.SapphireMaterial
import io.felipeandrade.gsw.material.gem.TopazMaterial
import io.felipeandrade.gsw.material.metal.*
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.ItemTagProvider
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import java.util.concurrent.CompletableFuture

class GswItemTagProvider(
    output: FabricDataOutput, completableFuture: CompletableFuture<WrapperLookup>
) : ItemTagProvider(output, completableFuture) {
    override fun configure(arg: WrapperLookup) {
        ironAlternatives()
        pickaxes()
    }

    private fun pickaxes() {
        getOrCreateTagBuilder(GswItemTags.PICKAXES)
            .add(BronzeMaterial.PICKAXE)
            .add(SteelMaterial.PICKAXE)
            .add(SilverMaterial.PICKAXE)
            .add(PlatinumMaterial.PICKAXE)
            .add(TitaniumMaterial.PICKAXE)
            .add(CobaltMaterial.PICKAXE)
            .add(MithrilMaterial.PICKAXE)
            .add(OrichalcumMaterial.PICKAXE)
            .add(RubyMaterial.PICKAXE)
            .add(SapphireMaterial.PICKAXE)
            .add(TopazMaterial.PICKAXE)
    }

    private fun ironAlternatives() {
        getOrCreateTagBuilder(GswItemTags.IRON_ALTERNATIVE)
            .add(TinMaterial.INGOT)
            .add(BronzeMaterial.INGOT)
            .add(SilverMaterial.INGOT)
    }
}