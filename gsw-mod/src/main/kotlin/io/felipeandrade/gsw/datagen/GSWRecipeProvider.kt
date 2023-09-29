package io.felipeandrade.gsw.datagen

import io.felipeandrade.gsw.item.tool.GSWTool
import io.felipeandrade.gsw.material.gem.RubyMaterial
import io.felipeandrade.gsw.material.gem.SapphireMaterial
import io.felipeandrade.gsw.material.gem.TopazMaterial
import io.felipeandrade.gsw.material.metal.*
import io.felipeandrade.gsw.material.vanilla.*
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.RecipeProvider.*
import net.minecraft.item.ItemConvertible
import net.minecraft.item.Items
import net.minecraft.recipe.book.RecipeCategory

class GSWRecipeProvider(dataOutput: FabricDataOutput) : FabricRecipeProvider(dataOutput) {

    override fun generate(exporter: RecipeExporter) {
        TinMaterial.MATERIAL.generateRecipes(this, exporter)
        SilverMaterial.MATERIAL.generateRecipes(this, exporter)
        PlatinumMaterial.MATERIAL.generateRecipes(this, exporter)
        TitaniumMaterial.MATERIAL.generateRecipes(this, exporter)
        CobaltMaterial.MATERIAL.generateRecipes(this, exporter)
        MithrilMaterial.MATERIAL.generateRecipes(this, exporter)
        OrichalcumMaterial.MATERIAL.generateRecipes(this, exporter)

        BronzeMaterial.MATERIAL.generateRecipes(this, exporter)
        SteelMaterial.MATERIAL.generateRecipes(this, exporter)

        TopazMaterial.MATERIAL.generateRecipes(this, exporter)
        SapphireMaterial.MATERIAL.generateRecipes(this, exporter)
        RubyMaterial.MATERIAL.generateRecipes(this, exporter)

        CopperMaterial.MATERIAL.generateRecipes(this, exporter)
        IronMaterial.MATERIAL.generateRecipes(this, exporter)
        GoldMaterial.MATERIAL.generateRecipes(this, exporter)
        DiamondMaterial.MATERIAL.generateRecipes(this, exporter)
        NetheriteMaterial.MATERIAL.generateRecipes(this, exporter)

        WoodMaterial.MATERIAL.generateRecipes(this, exporter)
        StoneMaterial.MATERIAL.generateRecipes(this, exporter)
        BoneMaterial.MATERIAL.generateRecipes(this, exporter)
        FlintMaterial.MATERIAL.generateRecipes(this, exporter)
        CoalMaterial.MATERIAL.generateRecipes(this, exporter)
        WoolMaterial.MATERIAL.generateRecipes(this, exporter)
        LeatherMaterial.MATERIAL.generateRecipes(this, exporter)
    }
}

fun offerCompactingRecipes(
    exporter: RecipeExporter,
    recipeCategory: RecipeCategory,
    input: ItemConvertible,
    compacted: ItemConvertible,
) {
    offerReversibleCompactingRecipes(
        exporter,
        recipeCategory,
        input,
        recipeCategory,
        compacted,
        getItemPath(compacted) + "_from_" + getItemPath(input),
        getItemPath(compacted),
        getItemPath(input) + "_from_" + getItemPath(compacted),
        getItemPath(input)
    )
}

fun offerProgressiveCompactingRecipes(
    exporter: RecipeExporter,
    recipeCategory: RecipeCategory,
    nugget: ItemConvertible,
    ingot: ItemConvertible,
    block: ItemConvertible,
) {
    offerCompactingRecipes(exporter, recipeCategory, nugget, ingot)
    offerCompactingRecipes(exporter, recipeCategory, ingot, block)
}

fun offerOreMaterial(
    exporter: RecipeExporter,
    recipeCategory: RecipeCategory,
    ingot: ItemConvertible,
    nugget: ItemConvertible,
    block: ItemConvertible,
    raw: ItemConvertible,
    rawBlock: ItemConvertible,
    ingotSmelts: List<ItemConvertible> = listOf(),
    ingotExp: Float = 0.7f,
    ingotCookTime: Int = 200,
    nuggetSmelts: List<ItemConvertible> = listOf(),
    nuggetExp: Float = 0.7f,
    nuggetCookTime: Int = 200
) {
    offerCompactingRecipes(exporter, recipeCategory, raw, rawBlock)
    offerProgressiveCompactingRecipes(exporter, recipeCategory, nugget, ingot, block)
    if (ingotSmelts.isNotEmpty()) {
        offerSmeltingAndBlasting(exporter, recipeCategory, ingotSmelts, ingot, ingotExp, ingotCookTime)
    }
    if (nuggetSmelts.isNotEmpty()) {
        offerSmeltingAndBlasting(exporter, recipeCategory, nuggetSmelts, nugget, nuggetExp, nuggetCookTime)
    }
}

fun offerSmeltingAndBlasting(
    exporter: RecipeExporter,
    recipeCategory: RecipeCategory,
    inputList: List<ItemConvertible>,
    output: ItemConvertible,
    exp: Float,
    cookTime: Int
) {
    offerSmelting(exporter, inputList, recipeCategory, output, exp, cookTime, getItemPath(output))
    offerBlasting(exporter, inputList, recipeCategory, output, exp, cookTime, getItemPath(output))
}

fun offerTools(
    exporter: RecipeExporter,
    ingot: ItemConvertible,
    outputList: List<GSWTool>
) {
    outputList.forEach {
        it.offerRecipe(exporter, ingot, Items.STICK)
    }
}