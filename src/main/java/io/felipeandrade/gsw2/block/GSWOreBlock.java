package io.felipeandrade.gsw2.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

import io.felipeandrade.gsw2.material.GSWMaterial;
import io.felipeandrade.gsw2.material.metal.CopperMaterial;

public class GSWOreBlock extends GSWBlock {

    protected final GSWMaterial material;

    public GSWOreBlock(String unlocalizedName, GSWMaterial material, Block.Settings settings) {
        super(unlocalizedName, settings);
        this.material = material;
    }



}

