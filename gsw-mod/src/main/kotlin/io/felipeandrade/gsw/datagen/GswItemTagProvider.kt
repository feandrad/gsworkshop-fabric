package io.felipeandrade.gsw.datagen

import io.felipeandrade.gsw.GswItemTags
import io.felipeandrade.gsw.material.gem.RubyMaterial
import io.felipeandrade.gsw.material.gem.SapphireMaterial
import io.felipeandrade.gsw.material.gem.TopazMaterial
import io.felipeandrade.gsw.material.metal.*
import io.felipeandrade.gsw.material.vanilla.WoodMaterial
import io.felipeandrade.gsw.material.vanilla.WoolMaterial
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.ItemTagProvider
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import net.minecraft.registry.tag.ItemTags
import java.util.concurrent.CompletableFuture

class GswItemTagProvider(
    output: FabricDataOutput, completableFuture: CompletableFuture<WrapperLookup>
) : ItemTagProvider(output, completableFuture) {
    override fun configure(arg: WrapperLookup) {
        ironAlternatives()
        pickaxes()
        armorTrims()
    }

    private fun ironAlternatives() {
        getOrCreateTagBuilder(GswItemTags.IRON_ALTERNATIVE)
            .add(TinMaterial.INGOT)
            .add(BronzeMaterial.INGOT)
            .add(SilverMaterial.INGOT)
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

    private fun armorTrims() {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
            .add(WoolMaterial.BOOTS, WoolMaterial.LEGGINGS, WoolMaterial.CHESTPLATE, WoolMaterial.HELMET)
            .add(WoodMaterial.BOOTS, WoodMaterial.LEGGINGS, WoodMaterial.CHESTPLATE, WoodMaterial.HELMET)
            .add(BronzeMaterial.BOOTS, BronzeMaterial.LEGGINGS, BronzeMaterial.CHESTPLATE, BronzeMaterial.HELMET)
            .add(SteelMaterial.BOOTS, SteelMaterial.LEGGINGS, SteelMaterial.CHESTPLATE, SteelMaterial.HELMET)
            .add(SilverMaterial.BOOTS, SilverMaterial.LEGGINGS, SilverMaterial.CHESTPLATE, SilverMaterial.HELMET)
            .add(PlatinumMaterial.BOOTS, PlatinumMaterial.LEGGINGS, PlatinumMaterial.CHESTPLATE, PlatinumMaterial.HELMET)
            .add(TitaniumMaterial.BOOTS, TitaniumMaterial.LEGGINGS, TitaniumMaterial.CHESTPLATE, TitaniumMaterial.HELMET)
            .add(CobaltMaterial.BOOTS, CobaltMaterial.LEGGINGS, CobaltMaterial.CHESTPLATE, CobaltMaterial.HELMET)
            .add(MithrilMaterial.BOOTS, MithrilMaterial.LEGGINGS, MithrilMaterial.CHESTPLATE, MithrilMaterial.HELMET)
            .add(OrichalcumMaterial.BOOTS, OrichalcumMaterial.LEGGINGS, OrichalcumMaterial.CHESTPLATE, OrichalcumMaterial.HELMET)
    }
}