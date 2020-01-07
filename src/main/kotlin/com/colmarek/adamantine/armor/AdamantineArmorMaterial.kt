package com.colmarek.adamantine.armor

import com.colmarek.adamantine.items.ModItems
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ItemConvertible
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents

class AdamantineArmorMaterial : ArmorMaterial {
    companion object {
        val BASE_DURABILITY = intArrayOf(13, 15, 16, 11) // Based off MC values

        const val NAME = "adamantine"
        const val DURABILITY_MULTIPLIER = 40
        val PROTECTION_AMOUNTS = intArrayOf(6, 9, 11, 6) // Diamond + 1

        val INSTANCE = AdamantineArmorMaterial()
    }

    override fun getName(): String = NAME

    override fun getDurability(slot: EquipmentSlot): Int = BASE_DURABILITY[slot.entitySlotId] * DURABILITY_MULTIPLIER

    override fun getProtectionAmount(slot: EquipmentSlot): Int = PROTECTION_AMOUNTS[slot.entitySlotId]

    override fun getEnchantability(): Int = 11

    override fun getEquipSound(): SoundEvent = SoundEvents.ITEM_ARMOR_EQUIP_GENERIC

    override fun getToughness(): Float = 3f

    override fun getRepairIngredient(): Ingredient = Ingredient.ofItems(ItemConvertible { ModItems.adamantineIngot })
}
