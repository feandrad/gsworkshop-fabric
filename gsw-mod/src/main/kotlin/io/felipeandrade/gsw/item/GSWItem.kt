package io.felipeandrade.gsw.item

import io.felipeandrade.gsw.GSWMod
import io.felipeandrade.gsw.common.Registrable
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

open class GSWItem(protected var unlocalizedName: String, settings: Settings) : Item(settings), Registrable {
    override fun register() {
        Registry.register(Registry.ITEM, Identifier(GSWMod.MOD_ID, unlocalizedName), this)
    }
}