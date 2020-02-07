package io.felipeandrade.gsw2.material.metal;

import java.util.ArrayList;
import java.util.List;

import io.felipeandrade.gsw2.material.GSWItem;
import io.felipeandrade.gsw2.material.MaterialItem;

public class OreMetalMaterial extends GSWMetalMaterial {

    public OreMetalMaterial(String unlocalizedName) {
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
        result.add(MaterialItem.makeItem("ore", this));

        return result;
    }
}
