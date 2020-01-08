package com.colmarek.adamantine.items.tools

import com.colmarek.adamantine.AdamantineMod
import com.colmarek.adamantine.utils.Config
import com.colmarek.adamantine.utils.asItemSetting
import net.minecraft.item.AxeItem

class AdamantineAxe : AxeItem(
    AdamantineToolMaterial.INSTANCE,
    Config.adamantineAxe.attackDamage,
    Config.adamantineAxe.attackSpeed,
    AdamantineMod.MOD_ITEM_GROUP.asItemSetting()
)