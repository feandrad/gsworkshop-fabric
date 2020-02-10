package io.felipeandrade.gsw2.item.tool;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class GSWToolMaterial implements ToolMaterial {

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Ingredient repairIngredient;

    GSWToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage,
                    int enchantability, Ingredient repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    public GSWToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage,
                           int enchantability, ItemConvertible... repairItems) {
        this(miningLevel, itemDurability, miningSpeed, attackDamage, enchantability,
                Ingredient.ofItems(repairItems));
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeed() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }
}
