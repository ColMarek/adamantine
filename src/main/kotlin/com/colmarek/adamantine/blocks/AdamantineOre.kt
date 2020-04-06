package com.colmarek.adamantine.blocks

import com.colmarek.adamantine.utils.ChanceLootTableRange
import com.colmarek.adamantine.utils.Config
import net.fabricmc.fabric.api.block.FabricBlockSettings
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback
import net.fabricmc.fabric.api.tools.FabricToolTags
import net.minecraft.block.Material
import net.minecraft.block.OreBlock
import net.minecraft.enchantment.Enchantments
import net.minecraft.loot.condition.MatchToolLootCondition
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.predicate.NumberRange
import net.minecraft.predicate.item.EnchantmentPredicate
import net.minecraft.predicate.item.ItemPredicate
import net.minecraft.util.Identifier

class AdamantineOre : OreBlock(
    FabricBlockSettings.of(Material.STONE)
        .breakByHand(false)
        .breakByTool(FabricToolTags.PICKAXES, Config.adamantineOre.miningLevel)
        .lightLevel(Config.adamantineOre.lightLevel)
        .strength(Config.adamantineOre.hardness, Config.adamantineOre.resistance)
        .build()
) {

    init {
        val diamondOreIdentifier = Identifier("minecraft", "blocks/diamond_ore")
        // Add a chance to drop from Diamond Ore
        LootTableLoadingCallback.EVENT.register(LootTableLoadingCallback { _, _, id, supplier, _ ->
            if (id != diamondOreIdentifier) return@LootTableLoadingCallback

            // Create a loot condition for silk touch
            val intRange = NumberRange.IntRange.exactly(Enchantments.SILK_TOUCH.maximumLevel)
            val enchantmentPredicate = EnchantmentPredicate(Enchantments.SILK_TOUCH, intRange)
            val predicate = ItemPredicate.Builder.create().enchantment(enchantmentPredicate)
            val lootCondition = MatchToolLootCondition.builder(predicate).build()

            val poolBuilder = FabricLootPoolBuilder.builder()
                .withCondition { lootContext ->
                    // Invert it so that it never drops when the tool has silk touch
                    !lootCondition.test(lootContext)
                }
                .withRolls(ChanceLootTableRange(Config.adamantineOre.chanceDropFromDiamondOre))
                .withEntry(ItemEntry.builder(this))
            supplier.withPool(poolBuilder)
        })
    }
}
