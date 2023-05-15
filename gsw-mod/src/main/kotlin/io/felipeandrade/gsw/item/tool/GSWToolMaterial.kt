package io.felipeandrade.gsw.item.tool

import net.minecraft.item.ItemConvertible
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient

class GSWToolMaterial internal constructor(
    private val miningLevel: Int,
    private val itemDurability: Int,
    private val miningSpeed: Float,
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
    )

    override fun getDurability(): Int = itemDurability
    override fun getMiningSpeedMultiplier(): Float = miningSpeed
    override fun getAttackDamage(): Float = attackDamage
    override fun getMiningLevel(): Int = miningLevel
    override fun getEnchantability(): Int = enchantability
    override fun getRepairIngredient(): Ingredient = repairIngredient
}