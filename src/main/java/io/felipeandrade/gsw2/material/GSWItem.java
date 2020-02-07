package io.felipeandrade.gsw2.material;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import io.felipeandrade.gsw2.common.Localizeable;
import io.felipeandrade.gsw2.common.Registrable;

import static io.felipeandrade.gsw2.GSW2Mod.MOD_ID;

public class GSWItem extends Item implements Registrable, Localizeable {

    protected String unlocalizedName;


    public GSWItem(String unlocalizedName, Settings settings) {
        super(settings);
        this.unlocalizedName = unlocalizedName;
    }

    @Override
    public void register() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, unlocalizedName), this);
    }

    @Override
    public String unlocalizedName() {
        return unlocalizedName;
    }
}