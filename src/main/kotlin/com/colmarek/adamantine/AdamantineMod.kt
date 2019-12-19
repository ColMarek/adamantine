package com.colmarek.adamantine

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier

@Suppress("unused")
class AdamantineMod : ModInitializer {
    companion object {
        const val MODID = "adamantine"
        val ITEM_GROUP: ItemGroup = FabricItemGroupBuilder.create(Identifier(MODID, "general" )).build()
    }

    override fun onInitialize() {
    }
}
