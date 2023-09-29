package io.felipeandrade.gsw.item.tool

import io.felipeandrade.gsw.common.Registrable
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.ItemConvertible
import net.minecraft.item.Items

interface GSWTool : Registrable {
    fun offerRecipe(
        exporter: RecipeExporter,
        ingot: ItemConvertible,
        handle: ItemConvertible = Items.STICK,
    )
}