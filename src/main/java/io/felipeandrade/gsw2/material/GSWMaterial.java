package io.felipeandrade.gsw2.material;

import java.util.ArrayList;
import java.util.List;

import io.felipeandrade.gsw2.block.GSWBlock;
import io.felipeandrade.gsw2.common.Localizeable;
import io.felipeandrade.gsw2.item.GSWItem;
import io.felipeandrade.gsw2.item.tool.GSWTool;

public abstract class GSWMaterial implements Localizeable {

    private final String unlocalizedName;

    private final int primaryColor;
    private final int secondaryColor;

    public GSWMaterial(String unlocalizedName, int primaryColor) {
        this(unlocalizedName, primaryColor, primaryColor);
    }

    public GSWMaterial(String unlocalizedName, int primaryColor, int secondaryColor) {
        this.unlocalizedName = unlocalizedName;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
    }

    public List<? extends GSWItem> allItems() {
        return new ArrayList<>();
    }

    public List<? extends GSWBlock> allBlocks() {
        return new ArrayList<>();
    }

    public List<? extends GSWTool> allTools() {
        return new ArrayList<>();
    }


    @Override
    public String unlocalizedName() {
        return unlocalizedName;
    }


    public int getPrimaryColor() {
        return primaryColor;
    }

    public int getSecondaryColor() {
        return secondaryColor;
    }
}
