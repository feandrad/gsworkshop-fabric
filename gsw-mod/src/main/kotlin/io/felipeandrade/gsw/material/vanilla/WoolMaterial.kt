package io.felipeandrade.gsw.material.vanilla

import io.felipeandrade.gsw.datagen.offerArmors
import io.felipeandrade.gsw.item.GswArmorItem
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.GswArmorMaterial
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.ArmorItem
import net.minecraft.item.ItemGroup
import net.minecraft.recipe.Ingredient
import net.minecraft.registry.tag.ItemTags
import net.minecraft.sound.SoundEvents

class WoolMaterial : GSWMaterial("woolen") {
    override fun allArmor(): List<GswArmorItem> = listOf(BOOTS, LEGGINGS, CHESTPLATE, HELMET)

    override fun generateRecipes(provider: FabricRecipeProvider, exporter: RecipeExporter) {
        offerArmors(exporter, ItemTags.WOOL, allArmor())
    }
    companion object {
        const val ENCHANTABILITY = 5

        val MATERIAL: GSWMaterial = WoolMaterial()

        val ARMOR_MATERIAL = GswArmorMaterial(
            unlocalizedName = MATERIAL.unlocalizedName,
            durabilityMultiplier = 4,
            protectionAmounts = intArrayOf(1, 2, 3, 1),
            enchantability = ENCHANTABILITY,
            equipSound = SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
            toughness = 0f,
            knockbackResistance = 0f,
            repairIngredient = { Ingredient.fromTag(ItemTags.WOOL) }
        )

        val BOOTS = GswArmorItem("boots", MATERIAL, ARMOR_MATERIAL, ArmorItem.Type.BOOTS)
        val LEGGINGS = GswArmorItem("leggings", MATERIAL, ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS)
        val CHESTPLATE = GswArmorItem("chestplate", MATERIAL, ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE)
        val HELMET = GswArmorItem("helmet", MATERIAL, ARMOR_MATERIAL, ArmorItem.Type.HELMET)

        fun addMaterialsToItemGroup(entries: ItemGroup.Entries): Unit = with(entries) {

        }

        fun addToolsToItemGroup(entries: ItemGroup.Entries): Unit = with(entries) {
            MATERIAL.allArmor().forEach { add(it) }
        }
    }
}