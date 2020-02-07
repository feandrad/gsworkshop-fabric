package io.felipeandrade.gsw2.material.metal;

import java.util.ArrayList;
import java.util.List;

import io.felipeandrade.gsw2.material.GSWItem;
import io.felipeandrade.gsw2.material.MaterialItem;

public class AlloyMetalMaterial extends GSWMetalMaterial {

    public AlloyMetalMaterial(String unlocalizedName) {
        super(unlocalizedName);
    }

    @Override
    public List<? extends GSWItem> allItems() {
        List<GSWItem> result = new ArrayList<>();

        result.add(MaterialItem.makeItem("ingot", this));
        result.add(MaterialItem.makeItem("nugget", this));

        return result;
    }

    @Override
    public List<? extends GSWItem> allBlocks() {
        List<GSWItem> result = new ArrayList<>();

        result.add(MaterialItem.makeItem("block", this));

        return result;
    }
}
