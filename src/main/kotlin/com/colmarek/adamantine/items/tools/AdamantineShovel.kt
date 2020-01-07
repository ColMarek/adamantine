package com.colmarek.adamantine.items.tools

import com.colmarek.adamantine.AdamantineMod
import net.minecraft.item.ShovelItem

class AdamantineShovel :
    ShovelItem(AdamantineToolMaterial.INSTANCE, 1F, -3F, Settings().group(AdamantineMod.MOD_ITEM_GROUP))
