package io.felipeandrade.gsw2.material;

import java.util.Arrays;
import java.util.List;

import io.felipeandrade.gsw2.block.GSWBlock;
import io.felipeandrade.gsw2.common.Localizeable;
import io.felipeandrade.gsw2.item.GSWItem;
import io.felipeandrade.gsw2.item.tool.GSWTool;
import io.felipeandrade.gsw2.material.metal.BronzeMaterial;
import io.felipeandrade.gsw2.material.metal.CopperMaterial;

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

    public abstract List<? extends GSWItem> allItems();

    public abstract List<? extends GSWBlock> allBlocks();

    public abstract List<? extends GSWTool> allTools();


    @Override
    public String unlocalizedName() {
        return unlocalizedName;
    }


    public static final List<GSWMaterial> ALL_GSW_MATERIALS = Arrays.asList(
            CopperMaterial.MATERIAL,
            BronzeMaterial.MATERIAL
    );

    public int getPrimaryColor() {
        return primaryColor;
    }

    public int getSecondaryColor() {
        return secondaryColor;
    }


    //    public static final GSWMaterial TIN = new CopperMaterial();
//    public static final GSWMaterial SILVER = new CopperMaterial("silver");
//    public static final GSWMaterial TITANIUM = new CopperMaterial("titanium");
//    public static final GSWMaterial PLATINUM = new CopperMaterial("platinum");
//
//    public static final GSWMaterial STEEL = new BronzeMaterial("steel");
//
//    public static final GSWMaterial MITHRIL = new CopperMaterial("mithril");
//    public static final GSWMaterial ORICHALCUM = new CopperMaterial("orichalcum");


}
