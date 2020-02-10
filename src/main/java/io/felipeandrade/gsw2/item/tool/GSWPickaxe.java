package io.felipeandrade.gsw2.item.tool;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import io.felipeandrade.gsw2.material.GSWItemColorProvider;
import io.felipeandrade.gsw2.material.GSWMaterial;

import static io.felipeandrade.gsw2.GSW2Mod.MOD_ID;

public class GSWPickaxe extends PickaxeItem implements GSWTool, GSWItemColorProvider {

    protected final String unlocalizedName;
    protected final GSWMaterial material;

    GSWPickaxe(String unlocalizedName, GSWMaterial material, GSWToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.unlocalizedName = unlocalizedName;
        this.material = material;
    }

    public GSWPickaxe(GSWMaterial material, GSWToolMaterial toolMaterial, Settings settings) {
        this(material.unlocalizedName() + "_pickaxe", material, toolMaterial, 1, -2.8f, settings);
    }

    @Override
    public String unlocalizedName() {
        return unlocalizedName;
    }

    @Override
    public void register() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, unlocalizedName), this);
    }

    @Override
    public int getColor(ItemStack stack, int tintIndex) {
        if (tintIndex == 1) {
            return material.getPrimaryColor();
        } else {
            return -1;
        }
    }

    @Override
    public void onClientInit() {
        ColorProviderRegistry.ITEM.register(this, this);
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return super.canMine(state, world, pos, miner);
    }
}
