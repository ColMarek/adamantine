package com.colmarek.adamantine.items.tools

import com.colmarek.adamantine.AdamantineMod
import com.colmarek.adamantine.utils.asItemSetting
import net.minecraft.item.SwordItem

class AdamantineSword : SwordItem(
    AdamantineToolMaterial.INSTANCE, 4, -1.4f, AdamantineMod.MOD_ITEM_GROUP.asItemSetting()
)
