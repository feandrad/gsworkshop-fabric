package io.felipeandrade.gsw2.material;

import java.util.List;

import io.felipeandrade.gsw2.common.Localizeable;

public abstract class GSWMaterial implements Localizeable {

    private final String unlocalizedName;

    public GSWMaterial(String unlocalizedName) {
        this.unlocalizedName = unlocalizedName;
    }

    public abstract List<? extends GSWItem> allItems();

    public abstract List<? extends GSWItem> allBlocks();

    @Override
    public String unlocalizedName() {
        return unlocalizedName;
    }

}
