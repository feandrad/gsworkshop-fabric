package io.felipeandrade.gsw2.material.gem;

import java.util.ArrayList;
import java.util.List;

import io.felipeandrade.gsw2.common.MaterialFactory;
import io.felipeandrade.gsw2.material.GSWItem;
import io.felipeandrade.gsw2.material.GSWMaterial;

public class GemFactory extends MaterialFactory {

    public static final GSWMaterial AMETHYST_MATERIAL = new GemMaterial("amethyst");
    public static final GSWMaterial TOPAZ_MATERIAL = new GemMaterial("topaz");
    public static final GSWMaterial SAPPHIRE_MATERIAL = new GemMaterial("sapphire");
    public static final GSWMaterial RUBY_MATERIAL = new GemMaterial("ruby");


    @Override
    public List<GSWItem> allItems() {
        ArrayList<GSWItem> result = new ArrayList<>();

        result.addAll(AMETHYST_MATERIAL.allItems());
        result.addAll(TOPAZ_MATERIAL.allItems());
        result.addAll(SAPPHIRE_MATERIAL.allItems());
        result.addAll(RUBY_MATERIAL.allItems());

        return result;
    }

    @Override
    public List<GSWItem> allBlocks() {
        ArrayList<GSWItem> result = new ArrayList<>();

        result.addAll(AMETHYST_MATERIAL.allBlocks());
        result.addAll(TOPAZ_MATERIAL.allBlocks());
        result.addAll(SAPPHIRE_MATERIAL.allBlocks());
        result.addAll(RUBY_MATERIAL.allBlocks());

        return result;
    }

}
