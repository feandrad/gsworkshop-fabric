package io.felipeandrade.gsw2.block;

import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

import io.felipeandrade.gsw2.material.GSWMaterial;

public class GemOreBlock extends GSWOreBlock {

    public GemOreBlock(GSWMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public void onStacksDropped(BlockState state, World world, BlockPos pos, ItemStack stack) {
        super.onStacksDropped(state, world, pos, stack);
        if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
            int i = this.getExperienceWhenMined(world.random);
            if (i > 0) {
                this.dropExperience(world, pos, i);
            }
        }
    }

    protected int getExperienceWhenMined(Random random) {
        return MathHelper.nextInt(random, 3, 7);
    }

}
