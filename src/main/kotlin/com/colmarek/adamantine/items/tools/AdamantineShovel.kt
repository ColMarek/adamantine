package com.colmarek.adamantine.items.tools

import com.colmarek.adamantine.AdamantineMod
import com.colmarek.adamantine.utils.asItemSetting
import net.minecraft.item.ShovelItem

class AdamantineShovel :
    ShovelItem(AdamantineToolMaterial.INSTANCE, 1F, -3F, AdamantineMod.MOD_ITEM_GROUP.asItemSetting())
