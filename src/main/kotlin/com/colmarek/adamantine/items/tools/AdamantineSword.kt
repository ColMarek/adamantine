package com.colmarek.adamantine.items.tools

import com.colmarek.adamantine.AdamantineMod
import net.minecraft.item.SwordItem

class AdamantineSword : SwordItem(
    AdamantineToolMaterial.INSTANCE, 4, -1.4f, Settings().group(AdamantineMod.MOD_ITEM_GROUP)
)
