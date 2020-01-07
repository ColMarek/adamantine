package com.colmarek.adamantine.blocks

import com.colmarek.adamantine.utils.ChanceLootTableRange
import net.fabricmc.fabric.api.block.FabricBlockSettings
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback
import net.fabricmc.fabric.api.tools.FabricToolTags
import net.minecraft.block.Material
import net.minecraft.block.OreBlock
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.util.Identifier

class AdamantineOre : OreBlock(
    FabricBlockSettings.of(Material.STONE)
        .breakByHand(false)
        .breakByTool(FabricToolTags.PICKAXES, MINING_LEVEL)
        .lightLevel(LIGHT_LEVEL)
        .strength(HARDNESS, RESISTANCE)
        .build()
) {
    companion object {
        const val LABEL = "adamantine_ore"

        // Block properties
        const val MINING_LEVEL = 2
        const val LIGHT_LEVEL = 3
        const val HARDNESS = 50f
        const val RESISTANCE = 1200f

        // Ore gen
        const val VEINS_PER_CHUNK = 1
        const val BOTTOM_OFFSET = 0
        const val MIN_Y_LEVEL = 0
        const val MAX_Y_LEVEL = 16
        const val SIZE_OF_VEIN = 4

        // Drop from other ores
        const val CHANCE_DROP_FROM_DIAMOND_ORE = 2
    }

    init {
        val diamondOreIdentifier = Identifier("minecraft", "blocks/diamond_ore")
        // Add a chance to drop from Diamond Ore
        LootTableLoadingCallback.EVENT.register(LootTableLoadingCallback { _, _, id, supplier, _ ->
            if (id != diamondOreIdentifier) return@LootTableLoadingCallback

            val poolBuilder = FabricLootPoolBuilder.builder()
                .withRolls(ChanceLootTableRange(CHANCE_DROP_FROM_DIAMOND_ORE))
                .withEntry(ItemEntry.builder(this))
            supplier.withPool(poolBuilder)
        })
    }
}
