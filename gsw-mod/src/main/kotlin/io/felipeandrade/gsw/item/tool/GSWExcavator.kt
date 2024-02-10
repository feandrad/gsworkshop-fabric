package io.felipeandrade.gsw.item.tool

import io.felipeandrade.gsw.GSWMod
import io.felipeandrade.gsw.material.GSWMaterial
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.RecipeProvider
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.util.Identifier

// aplica o que entendeu de herança de classes abstratas e interfaces
//todo turn GSWShovel to open clas

class GSWExcavator(
    unlocalizedName: String,
    material: GSWMaterial,
    toolMaterial: ToolMaterial,
    settings: Settings,
) : GSWShovel(unlocalizedName, material, toolMaterial, settings) {
    constructor(
        material: GSWMaterial,
        toolMaterial: ToolMaterial,
        settings: Settings
    ) : this(material.unlocalizedName + "_excavator", material, toolMaterial, settings)

    override fun offerRecipe(exporter: RecipeExporter, ingot: ItemConvertible, handle: ItemConvertible) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, this)
            //TODO How to use the right pattern?
            .pattern("###")
            .pattern(" | ")
            .pattern(" | ")
            .input('#', ingot)
            .input('|', handle)
            .criterion(RecipeProvider.hasItem(ingot), RecipeProvider.conditionsFromItem(ingot))
            .offerTo(exporter, Identifier(GSWMod.MOD_ID, RecipeProvider.getRecipeName(this)))
    }

    //TODO inser Excavator inside every material
}