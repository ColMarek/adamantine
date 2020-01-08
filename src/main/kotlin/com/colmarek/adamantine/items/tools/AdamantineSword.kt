package com.colmarek.adamantine.items.tools

import com.colmarek.adamantine.AdamantineMod
import com.colmarek.adamantine.utils.Config
import com.colmarek.adamantine.utils.asItemSetting
import net.minecraft.item.SwordItem

class AdamantineSword : SwordItem(
    AdamantineToolMaterial.INSTANCE,
    Config.adamantineSword.attackDamage,
    Config.adamantineSword.attackSpeed,
    AdamantineMod.MOD_ITEM_GROUP.asItemSetting()
)
