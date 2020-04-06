package com.colmarek.adamantine.utils

object Config {
    val adamantineOre = AdamantineOre
    val adamantineArmorMaterial = AdamantineArmorMaterial
    val adamantineToolMaterial = AdamantineToolMaterial
    val adamantineAxe = AdamantineAxe
    val adamantineHoe = AdamantineHoe
    val adamantinePickaxe = AdamantinePickaxe
    val adamantineShovel = AdamantineShovel
    val adamantineSword = AdamantineSword

    object AdamantineOre {
        // Block properties
        const val miningLevel = 2
        const val lightLevel = 3
        const val hardness = 50f
        const val resistance = 1200f

        // Ore gen
        const val veinsPerChunk = 1
        const val bottomOffset = 2
        const val minYLevel = 0
        const val maxYLevel = 16
        const val sizeOfVein = 4

        // Drop from other ores
        const val chanceDropFromDiamondOre = 20
    }

    object AdamantineArmorMaterial {
        val baseDurability = intArrayOf(13, 15, 16, 11) // Based off MC values
        const val durabilityMultiplier = 40
        val protectionAmounts = intArrayOf(6, 9, 11, 6) // Diamond + 1
        const val enchantability = 11
        const val toughness = 3f
    }

    object AdamantineToolMaterial {
        const val durability = 1800
        const val miningSpeed = 24f
        const val attackDamage = 5f
        const val miningLevel = 3
        const val enchantability = 15
    }

    object AdamantineAxe {
        const val attackDamage = 5.0f
        const val attackSpeed = -3f
    }

    object AdamantineHoe {
        const val attackSpeed = 0.0f
    }

    object AdamantinePickaxe {
        const val attackDamage = 1 // -1 -> No change, 0 -> Add 1, 1 -> Add 2
        const val attackSpeed = -1f // Closer to zero is faster
    }

    object AdamantineShovel {
        const val attackDamage = 1f
        const val attackSpeed = -3f
    }

    object AdamantineSword {
        const val attackDamage = 4
        const val attackSpeed = -1.4f
    }
}