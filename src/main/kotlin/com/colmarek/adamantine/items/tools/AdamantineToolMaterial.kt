package com.colmarek.adamantine.items.tools

import com.colmarek.adamantine.items.ModItems
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient

class AdamantineToolMaterial : ToolMaterial {
    companion object {
        const val DURABILITY = 1800
        const val MINING_SPEED = 24f
        const val ATTACK_DAMAGE = 5f
        const val MINING_LEVEL = 4
        const val ENCHANTABILITY = 15
        val REPAIR_INGREDIENT: Ingredient = Ingredient.ofItems(ModItems.adamantineIngot)

        val INSTANCE = AdamantineToolMaterial()
    }

    override fun getDurability(): Int = DURABILITY

    override fun getMiningSpeed(): Float = MINING_SPEED

    override fun getAttackDamage(): Float = ATTACK_DAMAGE

    override fun getMiningLevel(): Int = MINING_LEVEL

    override fun getEnchantability(): Int = ENCHANTABILITY

    override fun getRepairIngredient(): Ingredient = REPAIR_INGREDIENT
}
