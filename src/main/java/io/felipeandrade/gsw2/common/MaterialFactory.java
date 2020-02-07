package io.felipeandrade.gsw2.common;

import java.util.ArrayList;
import java.util.List;

import io.felipeandrade.gsw2.material.GSWItem;

public abstract class MaterialFactory {


    protected abstract List<GSWItem> allItems();

    protected abstract List<GSWItem> allBlocks();


    public List<? extends Registrable> allRegistrables() {
        ArrayList<Registrable> result = new ArrayList<>();

        result.addAll(allItems());
        result.addAll(allBlocks());

        return result;
    }
}
