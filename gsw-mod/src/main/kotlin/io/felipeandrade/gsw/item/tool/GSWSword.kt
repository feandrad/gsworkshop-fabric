package io.felipeandrade.gsw.item.tool

import io.felipeandrade.gsw.GSWMod.Companion.MOD_ID
import io.felipeandrade.gsw.material.GSWMaterial
import net.minecraft.data.server.RecipeProvider
import net.minecraft.data.server.RecipeProvider.getRecipeName
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.item.ItemConvertible
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolMaterial
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

class GSWSword(
    private val unlocalizedName: String,
    private val material: GSWMaterial,
    toolMaterial: ToolMaterial,
    settings: Settings
) : SwordItem(toolMaterial, 3, -2.4f, settings), GSWTool {
    constructor(
        material: GSWMaterial,
        toolMaterial: ToolMaterial,
        settings: Settings
    ) : this(material.unlocalizedName + "_sword", material, toolMaterial, settings)

    override fun register() {
        Registry.register(Registries.ITEM, Identifier(MOD_ID, unlocalizedName), this)
    }

    override fun offerRecipe(
        exporter: RecipeExporter,
        ingot: ItemConvertible,
        handle: ItemConvertible
    ) {
        ShapedRecipeJsonBuilder.create(this)
            .pattern("#")
            .pattern("#")
            .pattern("|")
            .input('#', ingot)
            .input('|', handle)
            .criterion(RecipeProvider.hasItem(ingot), RecipeProvider.conditionsFromItem(ingot))
            .offerTo(exporter, Identifier(MOD_ID, getRecipeName(this)))
    }
}