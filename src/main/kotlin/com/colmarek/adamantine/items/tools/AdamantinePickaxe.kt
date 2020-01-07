package com.colmarek.adamantine.items.tools

import com.colmarek.adamantine.AdamantineMod
import com.colmarek.adamantine.utils.asItemSetting
import net.minecraft.item.PickaxeItem

class AdamantinePickaxe : PickaxeItem(
    AdamantineToolMaterial.INSTANCE,
    1, // -1 -> No change, 0 -> Add 1, 1 -> Add 2
    -1f, // Closer to zero is faster
    AdamantineMod.MOD_ITEM_GROUP.asItemSetting()
)
