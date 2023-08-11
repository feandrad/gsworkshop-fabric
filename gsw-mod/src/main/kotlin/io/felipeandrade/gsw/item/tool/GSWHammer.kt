package io.felipeandrade.gsw.item.tool

import io.felipeandrade.gsw.GSWMod.Companion.MOD_ID
import io.felipeandrade.gsw.material.GSWMaterial
import net.minecraft.data.server.RecipeProvider
import net.minecraft.data.server.RecipeProvider.getRecipeName
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ToolMaterial
import net.minecraft.util.Identifier
import java.util.function.Consumer

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

    override fun offerRecipe(exporter: Consumer<RecipeJsonProvider>, ingot: ItemConvertible, handle: ItemConvertible) {
        ShapedRecipeJsonBuilder.create(this)
            .pattern(" # ")
            .pattern(" |#")
            .pattern("|  ")
            .input('#', ingot)
            .input('|', handle)
            .criterion(RecipeProvider.hasItem(ingot), RecipeProvider.conditionsFromItem(ingot))
            .offerTo(exporter, Identifier(MOD_ID, getRecipeName(this)))
    }
}