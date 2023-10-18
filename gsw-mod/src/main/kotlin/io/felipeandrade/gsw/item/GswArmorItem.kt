package io.felipeandrade.gsw.item

import io.felipeandrade.gsw.GSWMod.Companion.MOD_ID
import io.felipeandrade.gsw.common.Registrable
import io.felipeandrade.gsw.datagen.HAS_TAG_ITEM
import io.felipeandrade.gsw.material.GSWMaterial
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.advancement.AdvancementCriterion
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.RecipeProvider
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.Item
import net.minecraft.item.ItemConvertible
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier

class GswArmorItem(
    val unlocalizedName: String,
    val gswMaterial: GSWMaterial,
    material: ArmorMaterial,
    type: Type,
    settings: Settings = FabricItemSettings()
) : ArmorItem(material, type, settings), Registrable {
    override fun register() {
        Registry.register(Registries.ITEM, Identifier(MOD_ID, "${gswMaterial.unlocalizedName}_$unlocalizedName"), this)
    }

    fun offerRecipe(exporter: RecipeExporter, ingot: ItemConvertible) {
        when (type!!) {
            Type.HELMET -> offerHelmet(exporter, ingot)
            Type.CHESTPLATE -> offerChestplate(exporter, ingot)
            Type.LEGGINGS -> offerLeggings(exporter, ingot)
            Type.BOOTS -> offerBoots(exporter, ingot)
        }
    }

    private fun offerHelmet(exporter: RecipeExporter, ingot: ItemConvertible) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, this)
            .pattern("###")
            .pattern("# #")
            .input('#', ingot)
            .criterion(RecipeProvider.hasItem(ingot), RecipeProvider.conditionsFromItem(ingot))
            .offerTo(exporter, Identifier(MOD_ID, RecipeProvider.getRecipeName(this)))
    }

    private fun offerChestplate(exporter: RecipeExporter, ingot: ItemConvertible) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, this)
            .pattern("# #")
            .pattern("###")
            .pattern("###")
            .input('#', ingot)
            .criterion(RecipeProvider.hasItem(ingot), RecipeProvider.conditionsFromItem(ingot))
            .offerTo(exporter, Identifier(MOD_ID, RecipeProvider.getRecipeName(this)))
    }

    private fun offerLeggings(exporter: RecipeExporter, ingot: ItemConvertible) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, this)
            .pattern("###")
            .pattern("# #")
            .pattern("# #")
            .input('#', ingot)
            .criterion(RecipeProvider.hasItem(ingot), RecipeProvider.conditionsFromItem(ingot))
            .offerTo(exporter, Identifier(MOD_ID, RecipeProvider.getRecipeName(this)))
    }

    private fun offerBoots(exporter: RecipeExporter, ingot: ItemConvertible) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, this)
            .pattern("# #")
            .pattern("# #")
            .input('#', ingot)
            .criterion(RecipeProvider.hasItem(ingot), RecipeProvider.conditionsFromItem(ingot))
            .offerTo(exporter, Identifier(MOD_ID, RecipeProvider.getRecipeName(this)))
    }

    fun offerRecipeFromTag(exporter: RecipeExporter, tag: TagKey<Item>) {
        when (type!!) {
            Type.HELMET -> offerHelmetFromTag(exporter, tag)
            Type.CHESTPLATE -> offerChestplateFromTag(exporter, tag)
            Type.LEGGINGS -> offerLeggingsFromTag(exporter, tag)
            Type.BOOTS -> offerBootsFromTag(exporter, tag)
        }
    }

    private fun offerHelmetFromTag(exporter: RecipeExporter, tag: TagKey<Item>) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, this)
            .pattern("###")
            .pattern("# #")
            .input('#', tag)
            .criterion(HAS_TAG_ITEM, RecipeProvider.conditionsFromTag(tag) as AdvancementCriterion<*>)
            .offerTo(exporter, Identifier(MOD_ID, RecipeProvider.getRecipeName(this)))
    }

    private fun offerChestplateFromTag(exporter: RecipeExporter, tag: TagKey<Item>) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, this)
            .pattern("# #")
            .pattern("###")
            .pattern("###")
            .input('#', tag)
            .criterion(HAS_TAG_ITEM, RecipeProvider.conditionsFromTag(tag) as AdvancementCriterion<*>)
            .offerTo(exporter, Identifier(MOD_ID, RecipeProvider.getRecipeName(this)))
    }

    private fun offerLeggingsFromTag(exporter: RecipeExporter, tag: TagKey<Item>) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, this)
            .pattern("###")
            .pattern("# #")
            .pattern("# #")
            .input('#', tag)
            .criterion(HAS_TAG_ITEM, RecipeProvider.conditionsFromTag(tag) as AdvancementCriterion<*>)
            .offerTo(exporter, Identifier(MOD_ID, RecipeProvider.getRecipeName(this)))
    }

    private fun offerBootsFromTag(exporter: RecipeExporter, tag: TagKey<Item>) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, this)
            .pattern("# #")
            .pattern("# #")
            .input('#', tag)
            .criterion(HAS_TAG_ITEM, RecipeProvider.conditionsFromTag(tag) as AdvancementCriterion<*>)
            .offerTo(exporter, Identifier(MOD_ID, RecipeProvider.getRecipeName(this)))
    }
}