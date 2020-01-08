package com.colmarek.adamantine.items.tools

import com.colmarek.adamantine.AdamantineMod
import com.colmarek.adamantine.utils.Config
import com.colmarek.adamantine.utils.asItemSetting
import net.minecraft.item.PickaxeItem

class AdamantinePickaxe : PickaxeItem(
    AdamantineToolMaterial.INSTANCE,
    Config.adamantinePickaxe.attackDamage,
    Config.adamantinePickaxe.attackSpeed,
    AdamantineMod.MOD_ITEM_GROUP.asItemSetting()
)
