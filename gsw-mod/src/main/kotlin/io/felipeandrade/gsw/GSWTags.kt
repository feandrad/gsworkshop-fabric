package io.felipeandrade.gsw

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier

object GswBlockTags {
    val TIN_ORES = createTag("tin_ores", "c")
    val SILVER_ORES = createTag("silver_ores", "c")
    val PLATINUM_ORES = createTag("platinum_ores", "c")
    val TITANIUM_ORES = createTag("titanium_ores", "c")
    val COBALT_ORES = createTag("cobalt_ores", "c")
    val MITHRIL_ORES = createTag("mithril_ores", "c")
    val ORICHALCUM_ORES = createTag("orichalcum_ores", "c")
    val RUBY_ORES = createTag("ruby_ores", "c")
    val SAPPHIRE_ORES = createTag("sapphire_ores", "c")
    val TOPAZ_ORES = createTag("topaz_ores", "c")

    val TIN_BLOCKS = createTag("tin_blocks", "c")
    val SILVER_BLOCKS = createTag("silver_blocks", "c")
    val PLATINUM_BLOCKS = createTag("platinum_blocks", "c")
    val TITANIUM_BLOCKS = createTag("titanium_blocks", "c")
    val COBALT_BLOCKS = createTag("cobalt_blocks", "c")
    val MITHRIL_BLOCKS = createTag("mithril_blocks", "c")
    val ORICHALCUM_BLOCKS = createTag("orichalcum_blocks", "c")
    val RUBY_BLOCKS = createTag("ruby_blocks", "c")
    val SAPPHIRE_BLOCKS = createTag("sapphire_blocks", "c")
    val TOPAZ_BLOCKS = createTag("topaz_blocks", "c")

    val BRONZE_BLOCKS = createTag("bronze_blocks", "c")
    val STEEL_BLOCKS = createTag("steel_blocks", "c")

    private fun createTag(
        name: String,
        c: String = GSWMod.MOD_ID
    ): TagKey<Block> = TagKey.of(RegistryKeys.BLOCK, Identifier(c, name));
}

object GswItemTags {
    val BRONZE_INGOTS = createTag("bronze_ingots", "c")
    val STEEL_INGOTS = createTag("steel_ingots", "c")
    val TIN_INGOTS = createTag("tin_ingots", "c")
    val SILVER_INGOTS = createTag("silver_ingots", "c")
    val PLATINUM_INGOTS = createTag("platinum_ingots", "c")
    val TITANIUM_INGOTS = createTag("titanium_ingots", "c")
    val COBALT_INGOTS = createTag("cobalt_ingots", "c")
    val MITHRIL_INGOTS = createTag("mithril_ingots", "c")
    val ORICHALCUM_INGOTS = createTag("orichalcum_ingots", "c")

    val BRONZE_NUGGETS = createTag("bronze_nuggets", "c")
    val STEEL_NUGGETS = createTag("steel_nuggets", "c")
    val TIN_NUGGETS = createTag("tin_nuggets", "c")
    val SILVER_NUGGETS = createTag("silver_nuggets", "c")
    val PLATINUM_NUGGETS = createTag("platinum_nuggets", "c")
    val TITANIUM_NUGGETS = createTag("titanium_nuggets", "c")
    val COBALT_NUGGETS = createTag("cobalt_nuggets", "c")
    val MITHRIL_NUGGETS = createTag("mithril_nuggets", "c")
    val ORICHALCUM_NUGGETS = createTag("orichalcum_nuggets", "c")

    val IRON_ALTERNATIVE = createTag("iron_alternative")
    val PICKAXES = createTag("pickaxe", "fabric")

    private fun createTag(
        name: String,
        c: String = GSWMod.MOD_ID
    ): TagKey<Item> = TagKey.of(RegistryKeys.ITEM, Identifier(c, name));
}