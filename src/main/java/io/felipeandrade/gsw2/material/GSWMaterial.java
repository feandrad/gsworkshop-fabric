package io.felipeandrade.gsw2.material;

import java.util.List;

import io.felipeandrade.gsw2.block.GSWBlock;
import io.felipeandrade.gsw2.common.Localizeable;
import io.felipeandrade.gsw2.item.GSWItem;
import io.felipeandrade.gsw2.tool.GSWTool;

public abstract class GSWMaterial implements Localizeable {

    private final String unlocalizedName;

    public GSWMaterial(String unlocalizedName) {
        this.unlocalizedName = unlocalizedName;
    }

    public abstract List<? extends GSWItem> allItems();

    public abstract List<? extends GSWBlock> allBlocks();

    public abstract List<? extends GSWTool> allTools();


    @Override
    public String unlocalizedName() {
        return unlocalizedName;
    }

}
