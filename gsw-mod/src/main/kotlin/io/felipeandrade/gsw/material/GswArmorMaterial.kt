package io.felipeandrade.gsw.material

import io.felipeandrade.gsw.GSWMod.Companion.MOD_ID
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import java.util.function.Supplier

class GswArmorMaterial(
    private val unlocalizedName: String,
    private val durabilityMultiplier: Int,
    private val protectionAmounts: IntArray,
    private val enchantability: Int,
    private val equipSound: SoundEvent,
    private val toughness: Float,
    private val knockbackResistance: Float,
    repairIngredient: Supplier<Ingredient>

) : ArmorMaterial {
    private val repairIngredient: Supplier<Ingredient>

    init {
        this.repairIngredient = repairIngredient
    }

    override fun getDurability(type: ArmorItem.Type): Int = BASE_DURABILITY[type.ordinal] * durabilityMultiplier
    override fun getProtection(type: ArmorItem.Type): Int = protectionAmounts[type.ordinal]
    override fun getEnchantability(): Int = enchantability
    override fun getEquipSound(): SoundEvent = equipSound
    override fun getRepairIngredient(): Ingredient = repairIngredient.get()
    override fun getName(): String = "$MOD_ID:$unlocalizedName"
    override fun getToughness(): Float = toughness
    override fun getKnockbackResistance(): Float = knockbackResistance

    companion object {
        private val BASE_DURABILITY = intArrayOf(11, 16, 15, 13)
    }
}