package io.felipeandrade.gsw2.material;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum GSWToolMaterials implements ToolMaterial {
    COPPER(0, 59, 2.0F, 0.0F, 15, () -> {
        return Ingredient.fromTag(ItemTags.PLANKS);
    }),
    BRONZE(1, 131, 4.0F, 1.0F, 5, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Blocks.COBBLESTONE});
    }),
    SILVER(2, 250, 6.0F, 2.0F, 14, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.IRON_INGOT});
    }),
    STEEL(3, 1561, 8.0F, 3.0F, 10, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.DIAMOND});
    }),
    TITANIUM(3, 1561, 8.0F, 3.0F, 10, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.DIAMOND});
    }),
    PLATINUM(0, 32, 12.0F, 0.0F, 22, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.GOLD_INGOT});
    }),
    MITHRIL(0, 32, 12.0F, 0.0F, 22, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.GOLD_INGOT});
    }),
    ORICHALCUM(0, 32, 12.0F, 0.0F, 22, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.GOLD_INGOT});
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private GSWToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantibility, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantibility;
        this.repairIngredient = new Lazy(repairIngredient);
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
        return (Ingredient) this.repairIngredient.get();
    }
}

