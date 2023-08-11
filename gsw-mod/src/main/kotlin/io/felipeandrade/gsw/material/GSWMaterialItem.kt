package io.felipeandrade.gsw.material

import io.felipeandrade.gsw.item.GSWItem

open class GSWMaterialItem(
    protected val material: GSWMaterial,
    settings: Settings,
    unlocalizedName: String,
) :
    GSWItem(material.unlocalizedName + "_" + unlocalizedName, settings
)