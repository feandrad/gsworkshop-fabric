package io.felipeandrade.gsw.item.tool

import io.felipeandrade.gsw.GSWMod.Companion.MOD_ID
import io.felipeandrade.gsw.material.GSWMaterial
import net.minecraft.data.server.RecipeProvider
import net.minecraft.data.server.RecipeProvider.getRecipeName
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.item.HoeItem
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ToolMaterial
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import java.util.function.Consumer

class GSWHoe(
    val material: GSWMaterial,
    toolMaterial: ToolMaterial,
    attackSpeed: Float,
    settings: Settings,
    attackDamage: Int = 1,
    val unlocalizedName: String = material.unlocalizedName + "_hoe",
) : HoeItem(toolMaterial, attackDamage, attackSpeed, settings), GSWTool {

    override fun register() {
        Registry.register(Registry.ITEM, Identifier(MOD_ID, unlocalizedName), this)
    }

    override fun offerRecipe(exporter: Consumer<RecipeJsonProvider>, ingot: ItemConvertible, handle: ItemConvertible) {
        ShapedRecipeJsonBuilder.create(this)
            .pattern("##")
            .pattern(" |")
            .pattern(" |")
            .input('#', ingot)
            .input('|', handle)
            .criterion(RecipeProvider.hasItem(ingot), RecipeProvider.conditionsFromItem(ingot))
            .offerTo(exporter, Identifier(MOD_ID, getRecipeName(this)))
    }
}