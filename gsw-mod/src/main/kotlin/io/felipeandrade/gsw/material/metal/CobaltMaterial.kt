package io.felipeandrade.gsw.material.metal

import io.felipeandrade.gsw.GSWMod
import io.felipeandrade.gsw.block.GSWBlock
import io.felipeandrade.gsw.block.GSWMaterialBlock
import io.felipeandrade.gsw.datagen.offerArmors
import io.felipeandrade.gsw.datagen.offerOreMaterial
import io.felipeandrade.gsw.datagen.offerTools
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.GswArmorItem
import io.felipeandrade.gsw.item.tool.*
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import io.felipeandrade.gsw.material.GswArmorMaterial
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Blocks
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.ArmorItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.recipe.Ingredient
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Identifier
import net.minecraft.world.gen.feature.PlacedFeature

class CobaltMaterial : GSWMaterial("cobalt") {
    override fun allArmor(): List<GswArmorItem> = listOf(BOOTS, LEGGINGS, CHESTPLATE, HELMET)
    override fun allItems(): List<GSWItem> = listOf(INGOT, NUGGET, DUST, CRUSHED, PLATE, RAW)
    override fun allBlocks(): List<GSWBlock> = listOf(ORE_BLOCK, DEEPSLATE_ORE_BLOCK, RAW_BLOCK, METAL_BLOCK)
    override fun allTools(): List<GSWTool> = BASIC_TOOLS.plus(HAMMER)
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter) {
        offerOreMaterial(
            exporter = exporter,
            ingot = INGOT,
            nugget = NUGGET,
            block = METAL_BLOCK,
            raw = RAW,
            rawBlock = RAW_BLOCK,
            ingotSmelts = listOf(RAW, DUST, CRUSHED, ORE_BLOCK, DEEPSLATE_ORE_BLOCK)
        )
        offerArmors(exporter, INGOT, allArmor())
        offerTools(exporter, INGOT, BASIC_TOOLS)
        HAMMER.offerRecipe(exporter, METAL_BLOCK)
    }

    companion object {
        const val ENCHANTABILITY = 10

        val MATERIAL: GSWMaterial = CobaltMaterial()
        val INGOT: GSWItem = GSWMaterialItem("ingot", MATERIAL, Item.Settings())
        val NUGGET: GSWMaterialItem = GSWMaterialItem("nugget", MATERIAL, Item.Settings())
        val DUST: GSWMaterialItem = GSWMaterialItem("dust", MATERIAL, Item.Settings())
        val PLATE: GSWMaterialItem = GSWMaterialItem("plate", MATERIAL, Item.Settings())
        val CRUSHED: GSWMaterialItem = GSWMaterialItem("crushed", MATERIAL, Item.Settings())
        val RAW: GSWMaterialItem = GSWMaterialItem("raw", MATERIAL, Item.Settings())

        val METAL_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_METAL)
        val RAW_BLOCK: GSWBlock = GSWMaterialBlock(MATERIAL, GSWMaterialBlock.SETTINGS_METAL, "raw_block")
        val ORE_BLOCK: GSWBlock = GSWMaterialBlock(
            gswMaterial = MATERIAL,
            settings = FabricBlockSettings.copy(Blocks.DIAMOND_ORE),
            unlocalizedName = "ore"
        )
        val DEEPSLATE_ORE_BLOCK: GSWBlock = GSWMaterialBlock(
            gswMaterial = MATERIAL,
            settings = FabricBlockSettings.copy(Blocks.DEEPSLATE_DIAMOND_ORE),
            unlocalizedName = "deepslate_ore"
        )

        val TOOL_MATERIAL: GSWToolMaterial = GSWToolMaterial(3, 2500, 7.0f, 2.0f, ENCHANTABILITY, INGOT)
        val SWORD: GSWSword = GSWSword(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val PICKAXE: GSWPickaxe = GSWPickaxe(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val AXE: GSWAxe = GSWAxe(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val SHOVEL: GSWShovel = GSWShovel(MATERIAL, TOOL_MATERIAL, Item.Settings())
        val HOE: GSWHoe = GSWHoe(MATERIAL, TOOL_MATERIAL, -0.0f, Item.Settings())
        val HAMMER: GSWHammer = GSWHammer(MATERIAL, TOOL_MATERIAL, Item.Settings())

        val BASIC_TOOLS: List<GSWTool> = listOf(SWORD, SHOVEL, PICKAXE, AXE, HOE)

        val ARMOR_MATERIAL = GswArmorMaterial(
            unlocalizedName = MATERIAL.unlocalizedName,
            durabilityMultiplier = 33,
            protectionAmounts = intArrayOf(3, 6, 8, 3),
            enchantability = ENCHANTABILITY,
            equipSound = SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            toughness = 0.2f,
            knockbackResistance = 0.1f,
            repairIngredient = { Ingredient.ofItems(INGOT) }
        )

        val BOOTS = GswArmorItem("boots", MATERIAL, ARMOR_MATERIAL, ArmorItem.Type.BOOTS)
        val LEGGINGS = GswArmorItem("leggings", MATERIAL, ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS)
        val CHESTPLATE = GswArmorItem("chestplate", MATERIAL, ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE)
        val HELMET = GswArmorItem("helmet", MATERIAL, ARMOR_MATERIAL, ArmorItem.Type.HELMET)

        fun addMaterialsToItemGroup(entries: ItemGroup.Entries): Unit = with(entries) {
            MATERIAL.allItems().forEach { add(it) }
            MATERIAL.allBlocks().forEach { add(it) }
        }

        fun addToolsToItemGroup(entries: ItemGroup.Entries): Unit = with(entries) {
            add(SWORD)
            add(PICKAXE)
            add(AXE)
            add(SHOVEL)
            add(HOE)
            add(HAMMER)
            MATERIAL.allArmor().forEach { add(it) }
        }

        val oreGenFeature: RegistryKey<PlacedFeature> = RegistryKey.of(
            RegistryKeys.PLACED_FEATURE,
            Identifier(GSWMod.MOD_ID, "${ORE_BLOCK.unlocalizedName}_placed")
        )
    }
}