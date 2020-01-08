package com.colmarek.adamantine.utils

import com.colmarek.adamantine.AdamantineMod
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import net.minecraft.world.biome.Biome
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.decorator.Decorator
import net.minecraft.world.gen.decorator.RangeDecoratorConfig
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.OreFeatureConfig

fun ItemGroup.asItemSetting(): Item.Settings = Item.Settings().group(this)

fun registerBlock(block: Block, label: String) {
    Registry.register(Registry.BLOCK, Identifier(AdamantineMod.MODID, label), block)
    Registry.register(
        Registry.ITEM,
        Identifier(AdamantineMod.MODID, label),
        BlockItem(block, Item.Settings().group(AdamantineMod.MOD_ITEM_GROUP))
    )
}

fun registerItem(item: Item, label: String) {
    Registry.register(Registry.ITEM, Identifier(AdamantineMod.MODID, label), item)
}

fun generateInBiome(
    biome: Biome,
    blockState: BlockState,
    veinsPerChunk: Int,
    bottomOffset: Int,
    minYLevel: Int,
    maxYLevel: Int,
    sizeOfVein: Int
) {
    val rangeDecoratorConfig = RangeDecoratorConfig(
        veinsPerChunk,
        bottomOffset,
        minYLevel,
        maxYLevel
    )
    val configuredFeature = Biome.configureFeature(
        Feature.ORE,
        OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, blockState, sizeOfVein),
        Decorator.COUNT_RANGE,
        rangeDecoratorConfig
    )

    if (biome.category != Biome.Category.NETHER && biome.category != Biome.Category.THEEND) {
        biome.addFeature(
            GenerationStep.Feature.UNDERGROUND_ORES,
            configuredFeature
        )
    }
}