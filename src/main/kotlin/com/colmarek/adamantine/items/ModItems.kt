package com.colmarek.adamantine.items

import com.colmarek.adamantine.AdamantineMod
import com.colmarek.adamantine.armor.AdamantineArmorMaterial
import com.colmarek.adamantine.items.tools.*
import com.colmarek.adamantine.utils.asItemSetting
import com.colmarek.adamantine.utils.registerItem
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorItem

object ModItems {
    val adamantineIngot = AdamantineIngot()

    private val adamantineHelmet: ArmorItem = initArmorItem(EquipmentSlot.HEAD)
    private val adamantineChestplate = initArmorItem(EquipmentSlot.CHEST)
    private val adamantineLeggings = initArmorItem(EquipmentSlot.LEGS)
    private val adamantineBoots = initArmorItem(EquipmentSlot.FEET)

    private val adamantineSword = AdamantineSword()
    private val adamantinePickaxe = AdamantinePickaxe()
    private val adamantineShovel = AdamantineShovel()
    private val adamantineAxe = AdamantineAxe()
    private val adamantineHoe = AdamantineHoe()

    fun init() {
        registerItem(adamantineIngot, "adamantine_ingot")

        registerItem(adamantineHelmet, "adamantine_helmet")
        registerItem(adamantineChestplate, "adamantine_chestplate")
        registerItem(adamantineLeggings, "adamantine_leggings")
        registerItem(adamantineBoots, "adamantine_boots")

        registerItem(adamantineSword, "adamantine_sword")
        registerItem(adamantinePickaxe, "adamantine_pickaxe")
        registerItem(adamantineShovel, "adamantine_shovel")
        registerItem(adamantineAxe, "adamantine_axe")
        registerItem(adamantineHoe, "adamantine_hoe")
    }

    private fun initArmorItem(slot: EquipmentSlot) =
        ArmorItem(AdamantineArmorMaterial.INSTANCE, slot, AdamantineMod.MOD_ITEM_GROUP.asItemSetting())
}