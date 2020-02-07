package io.felipeandrade.gsw2.material.gem;

import java.util.ArrayList;
import java.util.List;

import io.felipeandrade.gsw2.material.GSWItem;
import io.felipeandrade.gsw2.material.GSWMaterial;
import io.felipeandrade.gsw2.material.MaterialItem;

public class GemMaterial extends GSWMaterial {


    public GemMaterial(String unlocalizedName) {
        super(unlocalizedName);
    }

    @Override
    public List<? extends GSWItem> allItems() {
        List<GSWItem> result = new ArrayList<>();

        result.add(MaterialItem.makeItem("gem", this));

        return result;
    }

    @Override
    public List<? extends GSWItem> allBlocks() {
        List<GSWItem> result = new ArrayList<>();

        result.add(MaterialItem.makeItem("block", this));

        return result;
    }
}