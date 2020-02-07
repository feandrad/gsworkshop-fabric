package io.felipeandrade.gsw2.material.metal;

import java.util.ArrayList;
import java.util.List;

import io.felipeandrade.gsw2.block.GSWBlock;
import io.felipeandrade.gsw2.item.GSWItem;
import io.felipeandrade.gsw2.material.GSWMaterial;
import io.felipeandrade.gsw2.material.factory.MaterialFactory;

public class MetalFactory extends MaterialFactory {

    public static final GSWMaterial COPPER_MATERIAL = new CopperMaterial();
//    public static final GSWMaterial TIN_MATERIAL = new CopperMaterial();
//    public static final GSWMaterial SILVER_MATERIAL = new CopperMaterial("silver");
//    public static final GSWMaterial TITANIUM_MATERIAL = new CopperMaterial("titanium");
//    public static final GSWMaterial PLATINUM_MATERIAL = new CopperMaterial("platinum");
//
    public static final GSWMaterial BRONZE_MATERIAL = new BronzeMaterial();
//    public static final GSWMaterial STEEL_MATERIAL = new BronzeMaterial("steel");
//
//    public static final GSWMaterial MITHRIL_MATERIAL = new CopperMaterial("mithril");
//    public static final GSWMaterial ORICHALCUM_MATERIAL = new CopperMaterial("orichalcum");


    @Override
    public List<GSWItem> allItems() {
        ArrayList<GSWItem> result = new ArrayList<>();

        result.addAll(COPPER_MATERIAL.allItems());
//        result.addAll(TIN_MATERIAL.allItems());
//        result.addAll(SILVER_MATERIAL.allItems());
//        result.addAll(TITANIUM_MATERIAL.allItems());
//        result.addAll(PLATINUM_MATERIAL.allItems());

        result.addAll(BRONZE_MATERIAL.allItems());
//        result.addAll(STEEL_MATERIAL.allItems());
//
//        result.addAll(MITHRIL_MATERIAL.allItems());
//        result.addAll(ORICHALCUM_MATERIAL.allItems());

        return result;
    }

    @Override
    public List<GSWBlock> allBlocks() {
        ArrayList<GSWBlock> result = new ArrayList<>();

        result.addAll(COPPER_MATERIAL.allBlocks());
//        result.addAll(TIN_MATERIAL.allBlocks());
//        result.addAll(SILVER_MATERIAL.allBlocks());
//        result.addAll(TITANIUM_MATERIAL.allBlocks());
//        result.addAll(PLATINUM_MATERIAL.allBlocks());
//
        result.addAll(BRONZE_MATERIAL.allBlocks());
//        result.addAll(STEEL_MATERIAL.allBlocks());
//
//        result.addAll(MITHRIL_MATERIAL.allBlocks());
//        result.addAll(ORICHALCUM_MATERIAL.allBlocks());

        return result;
    }

}
