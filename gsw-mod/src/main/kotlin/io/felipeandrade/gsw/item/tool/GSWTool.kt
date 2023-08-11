package io.felipeandrade.gsw.item.tool

import io.felipeandrade.gsw.common.Registrable
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.item.Item
import net.minecraft.item.ItemConvertible
import net.minecraft.item.Items
import java.util.function.Consumer

interface GSWTool : Registrable {

    val item: Item

    fun offerRecipe(
        exporter: Consumer<RecipeJsonProvider>,
        ingot: ItemConvertible,
        handle: ItemConvertible = Items.STICK,
    )
}