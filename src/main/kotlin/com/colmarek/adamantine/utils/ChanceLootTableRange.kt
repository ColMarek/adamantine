package com.colmarek.adamantine.utils

import net.minecraft.world.loot.LootTableRange
import net.minecraft.util.Identifier
import java.util.*

/**
 * Percentage based Loot Table Range.
 * @param chance The x/10 change to drop an item e.g. 2 => 20%
 */
class ChanceLootTableRange(private val chance: Int) : LootTableRange {
    override fun next(random: Random): Int {
        return if(generate(random)) 1 else 0
    }

    override fun getType(): Identifier {
        return Identifier("change_loot_table_range")
    }

    private fun generate(random: Random = Random()): Boolean {
        return random.nextInt(10) + 1 <= chance // + 1 to exclude zero
    }
}
