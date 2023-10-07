package io.felipeandrade.gsw.datagen

import io.felipeandrade.gsw.GSWRegistryHandler.ALL_GSW_MATERIALS
import io.felipeandrade.gsw.GswBlockTags
import io.felipeandrade.gsw.material.gem.RubyMaterial
import io.felipeandrade.gsw.material.gem.SapphireMaterial
import io.felipeandrade.gsw.material.gem.TopazMaterial
import io.felipeandrade.gsw.material.metal.*
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.BlockTagProvider
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier
import java.util.concurrent.CompletableFuture

class GswBlockTagProvider(
    output: FabricDataOutput, completableFuture: CompletableFuture<WrapperLookup>
) : BlockTagProvider(output, completableFuture) {
    override fun configure(arg: WrapperLookup) {
        ores()
        materialBlocks()
        pickaxeMineable()
    }

    private fun ores() {
        getOrCreateTagBuilder(GswBlockTags.TIN_ORES)
            .add(TinMaterial.ORE_BLOCK)
            .add(TinMaterial.DEEPSLATE_ORE_BLOCK)

        getOrCreateTagBuilder(GswBlockTags.SILVER_ORES)
            .add(SilverMaterial.ORE_BLOCK)
            .add(SilverMaterial.DEEPSLATE_ORE_BLOCK)

        getOrCreateTagBuilder(GswBlockTags.PLATINUM_ORES)
            .add(PlatinumMaterial.ORE_BLOCK)
            .add(PlatinumMaterial.DEEPSLATE_ORE_BLOCK)

        getOrCreateTagBuilder(GswBlockTags.TITANIUM_ORES)
            .add(TitaniumMaterial.ORE_BLOCK)
            .add(TitaniumMaterial.DEEPSLATE_ORE_BLOCK)

        getOrCreateTagBuilder(GswBlockTags.COBALT_ORES)
            .add(CobaltMaterial.ORE_BLOCK)
            .add(CobaltMaterial.DEEPSLATE_ORE_BLOCK)

        getOrCreateTagBuilder(GswBlockTags.MITHRIL_ORES)
            .add(MithrilMaterial.ORE_BLOCK)
            .add(MithrilMaterial.DEEPSLATE_ORE_BLOCK)

        getOrCreateTagBuilder(GswBlockTags.ORICHALCUM_ORES)
            .add(OrichalcumMaterial.ORE_BLOCK)
            .add(OrichalcumMaterial.DEEPSLATE_ORE_BLOCK)

        getOrCreateTagBuilder(GswBlockTags.RUBY_ORES)
            .add(RubyMaterial.ORE_BLOCK)
            .add(RubyMaterial.DEEPSLATE_ORE_BLOCK)

        getOrCreateTagBuilder(GswBlockTags.TOPAZ_ORES)
            .add(TopazMaterial.ORE_BLOCK)
            .add(TopazMaterial.DEEPSLATE_ORE_BLOCK)

        getOrCreateTagBuilder(GswBlockTags.SAPPHIRE_ORES)
            .add(SapphireMaterial.ORE_BLOCK)
            .add(SapphireMaterial.DEEPSLATE_ORE_BLOCK)
    }

    private fun materialBlocks() {
        getOrCreateTagBuilder(GswBlockTags.TIN_BLOCKS)
            .add(TinMaterial.RAW_BLOCK)
            .add(TinMaterial.METAL_BLOCK)
            .forceAddTag(GswBlockTags.TIN_ORES)

        getOrCreateTagBuilder(GswBlockTags.SILVER_BLOCKS)
            .add(SilverMaterial.RAW_BLOCK)
            .add(SilverMaterial.METAL_BLOCK)
            .forceAddTag(GswBlockTags.SILVER_ORES)

        getOrCreateTagBuilder(GswBlockTags.PLATINUM_BLOCKS)
            .add(PlatinumMaterial.RAW_BLOCK)
            .add(PlatinumMaterial.METAL_BLOCK)
            .forceAddTag(GswBlockTags.PLATINUM_ORES)

        getOrCreateTagBuilder(GswBlockTags.TITANIUM_BLOCKS)
            .add(TitaniumMaterial.RAW_BLOCK)
            .add(TitaniumMaterial.METAL_BLOCK)
            .forceAddTag(GswBlockTags.TITANIUM_ORES)

        getOrCreateTagBuilder(GswBlockTags.COBALT_BLOCKS)
            .add(CobaltMaterial.RAW_BLOCK)
            .add(CobaltMaterial.METAL_BLOCK)
            .forceAddTag(GswBlockTags.COBALT_ORES)

        getOrCreateTagBuilder(GswBlockTags.MITHRIL_BLOCKS)
            .add(MithrilMaterial.RAW_BLOCK)
            .add(MithrilMaterial.METAL_BLOCK)
            .forceAddTag(GswBlockTags.MITHRIL_ORES)

        getOrCreateTagBuilder(GswBlockTags.ORICHALCUM_BLOCKS)
            .add(OrichalcumMaterial.RAW_BLOCK)
            .add(OrichalcumMaterial.METAL_BLOCK)
            .forceAddTag(GswBlockTags.ORICHALCUM_ORES)

        getOrCreateTagBuilder(GswBlockTags.RUBY_BLOCKS)
            .add(RubyMaterial.GEM_BLOCK)
            .forceAddTag(GswBlockTags.RUBY_ORES)

        getOrCreateTagBuilder(GswBlockTags.SAPPHIRE_BLOCKS)
            .add(SapphireMaterial.GEM_BLOCK)
            .forceAddTag(GswBlockTags.SAPPHIRE_ORES)

        getOrCreateTagBuilder(GswBlockTags.TOPAZ_BLOCKS)
            .add(TopazMaterial.GEM_BLOCK)
            .forceAddTag(GswBlockTags.TOPAZ_ORES)
    }

    private fun pickaxeMineable() {
        val pickMine = getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
        ALL_GSW_MATERIALS.forEach {
            it.allBlocks().forEach {
                pickMine.add(it)
            }
        }

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier("fabric", "needs_tool_level_4")))
            .forceAddTag(GswBlockTags.MITHRIL_BLOCKS)
            .forceAddTag(GswBlockTags.ORICHALCUM_BLOCKS)

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .forceAddTag(GswBlockTags.BRONZE_BLOCKS)
            .forceAddTag(GswBlockTags.STEEL_BLOCKS)
            .forceAddTag(GswBlockTags.PLATINUM_BLOCKS)
            .forceAddTag(GswBlockTags.TITANIUM_BLOCKS)
            .forceAddTag(GswBlockTags.COBALT_BLOCKS)

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
            .forceAddTag(GswBlockTags.TIN_BLOCKS)
    }
}