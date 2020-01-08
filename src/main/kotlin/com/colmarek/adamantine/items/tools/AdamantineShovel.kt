package com.colmarek.adamantine.items.tools

import com.colmarek.adamantine.AdamantineMod
import com.colmarek.adamantine.utils.Config
import com.colmarek.adamantine.utils.asItemSetting
import net.minecraft.item.ShovelItem

class AdamantineShovel : ShovelItem(
    AdamantineToolMaterial.INSTANCE,
    Config.adamantineShovel.attackDamage,
    Config.adamantineShovel.attackSpeed,
    AdamantineMod.MOD_ITEM_GROUP.asItemSetting()
)
