package io.felipeandrade.gsw.datagen

import io.felipeandrade.gsw.item.tool.GSWTool
import io.felipeandrade.gsw.material.gem.RubyMaterial
import io.felipeandrade.gsw.material.gem.SapphireMaterial
import io.felipeandrade.gsw.material.gem.TopazMaterial
import io.felipeandrade.gsw.material.metal.*
import io.felipeandrade.gsw.material.vanilla.*
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.RecipeProvider.*
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.item.ItemConvertible
import net.minecraft.item.Items
import java.util.function.Consumer

class GSWRecipeProvider(dataGenerator: FabricDataGenerator) : FabricRecipeProvider(dataGenerator) {

    override fun generateRecipes(exporter: Consumer<RecipeJsonProvider>) {
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
    exporter: Consumer<RecipeJsonProvider>,
    input: ItemConvertible,
    compacted: ItemConvertible
) {
    offerReversibleCompactingRecipes(
        exporter,
        input,
        compacted,
        getItemPath(compacted) + "_from_" + getItemPath(input),
        getItemPath(compacted),
        getItemPath(input) + "_from_" + getItemPath(compacted),
        getItemPath(input)
    )
}

fun offerProgressiveCompactingRecipes(
    exporter: Consumer<RecipeJsonProvider>,
    nugget: ItemConvertible,
    ingot: ItemConvertible,
    block: ItemConvertible,
) {
    offerCompactingRecipes(exporter, nugget, ingot)
    offerCompactingRecipes(exporter, ingot, block)
}

fun offerOreMaterial(
    exporter: Consumer<RecipeJsonProvider>,
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
    offerCompactingRecipes(exporter, raw, rawBlock)
    offerProgressiveCompactingRecipes(exporter, nugget, ingot, block)
    if (ingotSmelts.isNotEmpty()) {
        offerSmeltingAndBlasting(exporter, ingotSmelts, ingot, ingotExp, ingotCookTime)
    }
    if (nuggetSmelts.isNotEmpty()) {
        offerSmeltingAndBlasting(exporter, nuggetSmelts, nugget, nuggetExp, nuggetCookTime)
    }
}

fun offerSmeltingAndBlasting(
    exporter: Consumer<RecipeJsonProvider>,
    inputList: List<ItemConvertible>,
    output: ItemConvertible,
    exp: Float,
    cookTime: Int
) {
    offerSmelting(exporter, inputList, output, exp, cookTime, getItemPath(output))
    offerBlasting(exporter, inputList, output, exp, cookTime, getItemPath(output))
}

fun offerTools(
    exporter: Consumer<RecipeJsonProvider>,
    ingot: ItemConvertible,
    outputList: List<GSWTool>
) {
    outputList.forEach {
        it.offerRecipe(exporter, ingot, Items.STICK)
    }
}