package com.colmarek.adamantine.armor

import com.colmarek.adamantine.items.ModItems
import com.colmarek.adamantine.utils.Config
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ItemConvertible
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents

class AdamantineArmorMaterial : ArmorMaterial {
    companion object {
        private val BASE_DURABILITY = Config.adamantineArmorMaterial.baseDurability

        const val DURABILITY_MULTIPLIER = Config.adamantineArmorMaterial.durabilityMultiplier
        private val PROTECTION_AMOUNTS = Config.adamantineArmorMaterial.protectionAmounts

        val INSTANCE = AdamantineArmorMaterial()
    }

    override fun getName(): String = "adamantine"

    override fun getDurability(slot: EquipmentSlot): Int = BASE_DURABILITY[slot.entitySlotId] * DURABILITY_MULTIPLIER

    override fun getProtectionAmount(slot: EquipmentSlot): Int = PROTECTION_AMOUNTS[slot.entitySlotId]

    override fun getEnchantability(): Int = Config.adamantineArmorMaterial.enchantability

    override fun getEquipSound(): SoundEvent = SoundEvents.ITEM_ARMOR_EQUIP_GENERIC

    override fun getToughness(): Float = Config.adamantineArmorMaterial.toughness

    override fun getRepairIngredient(): Ingredient = Ingredient.ofItems(ItemConvertible { ModItems.adamantineIngot })
}
