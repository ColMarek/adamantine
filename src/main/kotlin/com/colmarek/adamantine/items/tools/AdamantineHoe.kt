package com.colmarek.adamantine.items.tools

import com.colmarek.adamantine.AdamantineMod
import com.colmarek.adamantine.utils.Config
import com.colmarek.adamantine.utils.asItemSetting
import net.minecraft.item.HoeItem

class AdamantineHoe : HoeItem(
    AdamantineToolMaterial.INSTANCE,
    Config.adamantineHoe.attackSpeed,
    AdamantineMod.MOD_ITEM_GROUP.asItemSetting()
)