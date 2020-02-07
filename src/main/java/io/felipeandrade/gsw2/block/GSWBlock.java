package io.felipeandrade.gsw2.block;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import io.felipeandrade.gsw2.common.Localizeable;
import io.felipeandrade.gsw2.common.Registrable;

import static io.felipeandrade.gsw2.GSW2Mod.MOD_ID;

public class GSWBlock extends Block implements Registrable, Localizeable {

    String unlocalizedName;

    public GSWBlock(String unlocalizedName, Settings settings) {
        super(settings);
        this.unlocalizedName = unlocalizedName;
    }

    @Override
    public void register() {
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, unlocalizedName), this);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, unlocalizedName), new BlockItem(this, new Item.Settings().group(ItemGroup.MISC)));
    }

    @Override
    public String unlocalizedName() {
        return unlocalizedName;
    }

}
