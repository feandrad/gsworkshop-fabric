package io.felipeandrade.gsw.item

import io.felipeandrade.gsw.GSWMod
import io.felipeandrade.gsw.common.Registrable
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

open class GSWItem(var unlocalizedName: String, settings: Settings) : Item(settings), Registrable {
    override fun register() {
        Registry.register(Registries.ITEM, Identifier(GSWMod.MOD_ID, unlocalizedName), this)
    }
}