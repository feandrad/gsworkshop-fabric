package io.felipeandrade.gsw.item.tool

import net.minecraft.item.ItemConvertible
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient

class GSWToolMaterial internal constructor(
    private val miningLevel: Int,
    private val itemDurability: Int,
    val miningSpeed: Float,
    private val attackDamage: Float,
    private val enchantability: Int,
    private val repairIngredient: Ingredient
) : ToolMaterial {
    constructor(
        miningLevel: Int, itemDurability: Int, miningSpeed: Float, attackDamage: Float,
        enchantability: Int, vararg repairItems: ItemConvertible
    ) : this(
        miningLevel, itemDurability, miningSpeed, attackDamage, enchantability,
        Ingredient.ofItems(*repairItems)
    ) {
    }

    override fun getDurability(): Int {
        return itemDurability
    }

    override fun getMiningSpeedMultiplier(): Float = 1.0f

    override fun getAttackDamage(): Float {
        return attackDamage
    }

    override fun getMiningLevel(): Int {
        return miningLevel
    }

    override fun getEnchantability(): Int {
        return enchantability
    }

    override fun getRepairIngredient(): Ingredient {
        return repairIngredient
    }
}