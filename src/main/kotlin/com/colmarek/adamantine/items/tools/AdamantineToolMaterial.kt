package com.colmarek.adamantine.items.tools

import com.colmarek.adamantine.items.ModItems
import com.colmarek.adamantine.utils.Config
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient

class AdamantineToolMaterial : ToolMaterial {
    companion object {
        val INSTANCE = AdamantineToolMaterial()
    }

    override fun getDurability(): Int = Config.adamantineToolMaterial.durability

    override fun getMiningSpeed(): Float = Config.adamantineToolMaterial.miningSpeed

    override fun getAttackDamage(): Float = Config.adamantineToolMaterial.attackDamage

    override fun getMiningLevel(): Int = Config.adamantineToolMaterial.miningLevel

    override fun getEnchantability(): Int = Config.adamantineToolMaterial.enchantability

    override fun getRepairIngredient(): Ingredient = Ingredient.ofItems(ModItems.adamantineIngot)
}
