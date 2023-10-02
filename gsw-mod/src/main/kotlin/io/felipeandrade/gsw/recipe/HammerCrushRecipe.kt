package io.felipeandrade.gsw.recipe

import net.minecraft.inventory.SimpleInventory
import net.minecraft.item.ItemStack
import net.minecraft.recipe.*
import net.minecraft.recipe.book.CraftingRecipeCategory
import net.minecraft.registry.DynamicRegistryManager
import net.minecraft.util.Identifier
import net.minecraft.util.collection.DefaultedList
import net.minecraft.world.World

class HammerCrushRecipe(
    val id: Identifier,
    val output: ItemStack,
    val recipeItems: DefaultedList<Ingredient>
) : Recipe<SimpleInventory> {

    override fun matches(inventory: SimpleInventory?, world: World?): Boolean {

    }

    override fun craft(inventory: SimpleInventory?, registryManager: DynamicRegistryManager?): ItemStack {

    }

    override fun fits(width: Int, height: Int): Boolean {

    }

    override fun getResult(registryManager: DynamicRegistryManager?): ItemStack {

    }

    override fun getSerializer(): RecipeSerializer<*> =

    override fun getType(): RecipeType<*> = Type

    object Type: RecipeType<HammerCrushRecipe> {
        const val ID = "hammer_crush"
    }

    companion object{
        val SERIALIZER = RecipeSerializer.register(
            "hammer_crush",
            SpecialRecipeSerializer<BookCloningRecipe> { craftingRecipeCategory: CraftingRecipeCategory? ->
                BookCloningRecipe(
                    craftingRecipeCategory
                )
            });
    }
}