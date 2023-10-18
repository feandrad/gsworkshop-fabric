package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.datagen.offerArmors
import io.felipeandrade.gsw.item.GSWItem
import io.felipeandrade.gsw.item.GswArmorItem
import io.felipeandrade.gsw.item.tool.GSWHammer
import io.felipeandrade.gsw.item.tool.GSWTool
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GSWMaterialItem
import io.felipeandrade.gsw.material.GswArmorMaterial
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.ArmorItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ToolMaterials
import net.minecraft.recipe.Ingredient
import net.minecraft.registry.tag.ItemTags
import net.minecraft.sound.SoundEvents

class WoodMaterial : GSWMaterial("wooden") {
    override fun allArmor(): List<GswArmorItem> = listOf(BOOTS, LEGGINGS, CHESTPLATE, HELMET)
    override fun allItems(): List<GSWItem> = listOf(DUST)
    override fun allTools(): List<GSWTool> = listOf(HAMMER)
    override fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter) {
        offerArmors(exporter, ItemTags.LOGS, allArmor())
    }

    companion object {
        const val ENCHANTABILITY = 5
        val MATERIAL: GSWMaterial = WoodMaterial()
        val DUST: GSWMaterialItem = GSWMaterialItem("dust", MATERIAL, Item.Settings())
        val HAMMER: GSWHammer = GSWHammer(MATERIAL, ToolMaterials.WOOD, Item.Settings())

        val ARMOR_MATERIAL = GswArmorMaterial(
            unlocalizedName = MATERIAL.unlocalizedName,
            durabilityMultiplier = 4,
            protectionAmounts = intArrayOf(1, 2, 3, 1),
            enchantability = ENCHANTABILITY,
            equipSound = SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
            toughness = 0f,
            knockbackResistance = 0f,
            repairIngredient = { Ingredient.fromTag(ItemTags.LOGS) }
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
            add(HAMMER)
            MATERIAL.allArmor().forEach { add(it) }
        }
    }
}