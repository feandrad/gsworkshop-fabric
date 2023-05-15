package io.felipeandrade.gsw.block

import io.felipeandrade.gsw.GSWMod
import io.felipeandrade.gsw.common.Registrable
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

open class GSWBlock(
    val unlocalizedName: String,
    var itemGroup: ItemGroup,
    settings: Settings
) : Block(settings), Registrable {
    override fun register() {
        Registry.register(Registry.BLOCK, Identifier(GSWMod.MOD_ID, unlocalizedName), this)
        Registry.register(
            Registry.ITEM,
            Identifier(GSWMod.MOD_ID, unlocalizedName),
            BlockItem(this, Item.Settings().group(itemGroup))
        )
    }
}