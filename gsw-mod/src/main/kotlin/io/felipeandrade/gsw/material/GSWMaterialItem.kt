package io.felipeandrade.gsw.material

import io.felipeandrade.gsw.item.GSWItem

open class GSWMaterialItem(
    unlocalizedName: String,
    protected val material: GSWMaterial,
    settings: Settings,
) :
    GSWItem("${material.unlocalizedName}_$unlocalizedName", settings)