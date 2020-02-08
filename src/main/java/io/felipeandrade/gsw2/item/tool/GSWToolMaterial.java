package io.felipeandrade.gsw2.item.tool;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import io.felipeandrade.gsw2.item.GSWItem;
import io.felipeandrade.gsw2.material.metal.BronzeMaterial;
import io.felipeandrade.gsw2.material.metal.CopperMaterial;

public class GSWToolMaterial implements ToolMaterial {

//    SILVER(1, 131, 5.0F, 2.0F, 17,  ),
//    STEEL(3, 500, 7.0F, 2.0F, 5,  ),
//    TITANIUM(3, 3000, 8.0F, 3.0F, 1,  ),
//    PLATINUM(3, 750, 12.0F, 2.0F, 22,  ),
//    MITHRIL(4, 2500, 14.0F, 3.0F, 30,  ),
//    ORICHALCUM(4, 5000, 10.0F, 4.0F, 1,  );

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
                           int enchantability, GSWItem... repairItems) {
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
