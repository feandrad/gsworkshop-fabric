package io.felipeandrade.gsw.item.tool

import io.felipeandrade.gsw.GSWMod.Companion.MOD_ID
import io.felipeandrade.gsw.material.GSWMaterial
import io.felipeandrade.gsw.material.metal.*
import io.felipeandrade.gsw.material.vanilla.*
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.RecipeProvider.*
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder
import net.minecraft.item.ItemConvertible
import net.minecraft.item.Items
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.util.Identifier

class GSWHammer(
    unlocalizedName: String,
    material: GSWMaterial,
    toolMaterial: ToolMaterial,
    settings: Settings,
) : GSWPickaxe(unlocalizedName, material, toolMaterial, 5, -3.4f, settings) {
    constructor(
        material: GSWMaterial,
        toolMaterial: ToolMaterial,
        settings: Settings
    ) : this(material.unlocalizedName + "_hammer", material, toolMaterial, settings)

    override fun offerRecipe(exporter: RecipeExporter, ingot: ItemConvertible, handle: ItemConvertible) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, this)
            .pattern(" # ")
            .pattern(" |#")
            .pattern("|  ")
            .input('#', ingot)
            .input('|', handle)
            .criterion(hasItem(ingot), conditionsFromItem(ingot))
            .offerTo(exporter, Identifier(MOD_ID, this.unlocalizedName))
    }

    private fun offerHammerCrushRecipe(exporter: RecipeExporter, ingot: ItemConvertible, dust: ItemConvertible, count: Int = 2) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, dust, count)
            .input(this)
            .input(ingot)
            .criterion(hasItem(this), conditionsFromItem(this))
            .offerTo(exporter, Identifier(MOD_ID, "${getItemPath(this)}_crush_${getItemPath(ingot)}"))
    }

    fun offerTier1CrushRecipes(exporter: RecipeExporter) {

        offerHammerCrushRecipe(exporter, Items.RAW_COPPER, CopperMaterial.DUST)
        offerHammerCrushRecipe(exporter, TinMaterial.RAW, TinMaterial.DUST)

        offerHammerCrushRecipe(exporter, Items.BONE, Items.BONE_MEAL, 3)
        offerHammerCrushRecipe(exporter, Items.COAL, CoalMaterial.DUST, 1)
        offerHammerCrushRecipe(exporter, Items.COPPER_INGOT, CopperMaterial.DUST, 1)

        offerHammerCrushRecipe(exporter, TinMaterial.INGOT, TinMaterial.DUST, 1)
    }

    fun offerTier2CrushRecipes(exporter: RecipeExporter) {
        offerTier1CrushRecipes(exporter)
        offerHammerCrushRecipe(exporter, Items.RAW_IRON, IronMaterial.DUST)
        offerHammerCrushRecipe(exporter, Items.RAW_GOLD, GoldMaterial.DUST)
        offerHammerCrushRecipe(exporter, SilverMaterial.RAW, SilverMaterial.DUST)

        offerHammerCrushRecipe(exporter, Items.IRON_INGOT, IronMaterial.DUST, 1)
        offerHammerCrushRecipe(exporter, Items.GOLD_INGOT, GoldMaterial.DUST, 1)
        offerHammerCrushRecipe(exporter, SilverMaterial.INGOT, SilverMaterial.DUST, 1)

        offerHammerCrushRecipe(exporter, BronzeMaterial.INGOT, BronzeMaterial.DUST, 1)
    }

    fun offerTier3CrushRecipes(exporter: RecipeExporter) {
        offerTier2CrushRecipes(exporter)
        offerHammerCrushRecipe(exporter, Items.DIAMOND, DiamondMaterial.DUST)

        offerHammerCrushRecipe(exporter, PlatinumMaterial.RAW, PlatinumMaterial.DUST)
        offerHammerCrushRecipe(exporter, TitaniumMaterial.RAW, TitaniumMaterial.DUST)
        offerHammerCrushRecipe(exporter, CobaltMaterial.RAW, CobaltMaterial.DUST)

        offerHammerCrushRecipe(exporter, PlatinumMaterial.INGOT, PlatinumMaterial.DUST, 1)
        offerHammerCrushRecipe(exporter, TitaniumMaterial.INGOT, TitaniumMaterial.DUST, 1)
        offerHammerCrushRecipe(exporter, CobaltMaterial.INGOT, CobaltMaterial.DUST, 1)

        offerHammerCrushRecipe(exporter, SteelMaterial.INGOT, SteelMaterial.DUST, 1)
    }

    fun offerTier4CrushRecipes(exporter: RecipeExporter) {
        offerTier3CrushRecipes(exporter)
        offerHammerCrushRecipe(exporter, Items.NETHERITE_INGOT, NetheriteMaterial.DUST, 1)

        offerHammerCrushRecipe(exporter, MithrilMaterial.RAW, MithrilMaterial.DUST)
        offerHammerCrushRecipe(exporter, OrichalcumMaterial.RAW, OrichalcumMaterial.DUST)

        offerHammerCrushRecipe(exporter, MithrilMaterial.INGOT, MithrilMaterial.DUST, 1)
        offerHammerCrushRecipe(exporter, OrichalcumMaterial.INGOT, OrichalcumMaterial.DUST, 1)
    }
}