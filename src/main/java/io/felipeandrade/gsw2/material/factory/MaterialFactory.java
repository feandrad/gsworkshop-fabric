package io.felipeandrade.gsw2.material.factory;

import java.util.ArrayList;
import java.util.List;

import io.felipeandrade.gsw2.block.GSWBlock;
import io.felipeandrade.gsw2.common.Registrable;
import io.felipeandrade.gsw2.item.GSWItem;

public abstract class MaterialFactory {


    protected abstract List<GSWItem> allItems();

    protected abstract List<GSWBlock> allBlocks();


    public List<? extends Registrable> allRegistrables() {
        ArrayList<Registrable> result = new ArrayList<>();

        result.addAll(allItems());
        result.addAll(allBlocks());

        return result;
    }
}
