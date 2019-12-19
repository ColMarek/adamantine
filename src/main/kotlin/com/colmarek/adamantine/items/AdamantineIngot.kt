package com.colmarek.adamantine.items

import com.colmarek.adamantine.AdamantineMod
import net.minecraft.item.Item

class AdamantineIngot : Item(Settings().group(AdamantineMod.MOD_ITEM_GROUP)) {
    companion object {
        const val LABEL = "adamantine_ingot"
    }
}
