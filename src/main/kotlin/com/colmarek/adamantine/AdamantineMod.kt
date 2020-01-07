package com.colmarek.adamantine

import com.colmarek.adamantine.blocks.ModBlocks
import com.colmarek.adamantine.items.ModItems
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier

@Suppress("unused")
class AdamantineMod : ModInitializer {
    companion object {
        const val MODID = "adamantine"

        val MOD_ITEM_GROUP: ItemGroup = FabricItemGroupBuilder.create(Identifier(MODID, "general"))
            .icon { ItemStack(ModItems.adamantineIngot) }
            .build()
    }

    override fun onInitialize() {
        ModItems.init()
        ModBlocks.init()
    }
}
