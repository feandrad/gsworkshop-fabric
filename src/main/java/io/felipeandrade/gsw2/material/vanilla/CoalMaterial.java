package io.felipeandrade.gsw2.material.vanilla;

import net.minecraft.item.Item;

import java.util.Collections;
import java.util.List;

import io.felipeandrade.gsw2.GSWItemGroup;
import io.felipeandrade.gsw2.common.GSWColor;
import io.felipeandrade.gsw2.item.GSWItem;
import io.felipeandrade.gsw2.material.ColorProviderMaterialItem;
import io.felipeandrade.gsw2.material.GSWMaterial;
import io.felipeandrade.gsw2.material.GSWMaterialItem;

public class CoalMaterial extends GSWMaterial {

    public static final GSWMaterial MATERIAL = new CoalMaterial();

    public CoalMaterial() {
        super("coal", GSWColor.jet_grey_gray);
    }

    @Override
    public List<? extends GSWItem> allItems() {
        return Collections.singletonList(DUST);
    }


    public static final GSWMaterialItem DUST = new ColorProviderMaterialItem("dust", MATERIAL, new Item.Settings().group(GSWItemGroup.MATERIALS));

}
