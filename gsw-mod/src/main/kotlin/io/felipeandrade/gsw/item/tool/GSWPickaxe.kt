package io.felipeandrade.gsw.item.tool

import io.felipeandrade.gsw.GSWMod.Companion.MOD_ID
import io.felipeandrade.gsw.material.GSWMaterial
import net.minecraft.block.BlockState
import net.minecraft.data.server.RecipeProvider
import net.minecraft.data.server.RecipeProvider.getRecipeName
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemConvertible
import net.minecraft.item.PickaxeItem
import net.minecraft.item.ToolMaterial
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import net.minecraft.util.registry.Registry
import net.minecraft.world.World
import java.util.function.Consumer

open class GSWPickaxe internal constructor(
    protected val unlocalizedName: String,
    protected val material: GSWMaterial,
    toolMaterial: ToolMaterial,
    attackDamage: Int,
    attackSpeed: Float,
    settings: Settings
) : PickaxeItem(toolMaterial, attackDamage, attackSpeed, settings), GSWTool {
    constructor(
        material: GSWMaterial,
        toolMaterial: ToolMaterial,
        settings: Settings
    ) : this(material.unlocalizedName + "_pickaxe", material, toolMaterial, 1, -2.8f, settings)

    override fun register() {
        Registry.register(Registry.ITEM, Identifier(MOD_ID, unlocalizedName), this)
    }

    override fun canMine(state: BlockState, world: World, pos: BlockPos, miner: PlayerEntity): Boolean {
        return super.canMine(state, world, pos, miner)
    }

    override fun offerRecipe(exporter: Consumer<RecipeJsonProvider>, ingot: ItemConvertible, handle: ItemConvertible) {
        ShapedRecipeJsonBuilder.create(this)
            .pattern("###")
            .pattern(" | ")
            .pattern(" | ")
            .input('#', ingot)
            .input('|', handle)
            .criterion(RecipeProvider.hasItem(ingot), RecipeProvider.conditionsFromItem(ingot))
            .offerTo(exporter, Identifier(MOD_ID, getRecipeName(this)))
    }
}
