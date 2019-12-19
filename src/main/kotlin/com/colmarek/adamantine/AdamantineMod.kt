package com.colmarek.adamantine

import com.colmarek.adamantine.blocks.AdamantineOre
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback
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

@Suppress("unused")
class AdamantineMod : ModInitializer {
    companion object {
        const val MODID = "adamantine"
        val MOD_ITEM_GROUP: ItemGroup = FabricItemGroupBuilder.create(Identifier(MODID, "general")).build()

        val adamantineOre = AdamantineOre()
    }

    override fun onInitialize() {
        // Adamantine Ore
        registerBlock(adamantineOre, AdamantineOre.LABEL)
        Registry.BIOME.forEach { generateAdamantineOre(it) }
        RegistryEntryAddedCallback.event(Registry.BIOME)
            .register(RegistryEntryAddedCallback { _, _, biome -> generateAdamantineOre(biome) })
    }

    private fun registerBlock(block: Block, label: String) {
        Registry.register(Registry.BLOCK, Identifier(MODID, label), block)
        Registry.register(
            Registry.ITEM,
            Identifier(MODID, label),
            BlockItem(block, Item.Settings().group(MOD_ITEM_GROUP))
        )
    }

    private fun generateAdamantineOre(biome: Biome) {
        generateInBiome(
            biome,
            adamantineOre.defaultState,
            AdamantineOre.VEINS_PER_CHUNK,
            AdamantineOre.BOTTOM_OFFSET,
            AdamantineOre.MIN_Y_LEVEL,
            AdamantineOre.MAX_Y_LEVEL,
            AdamantineOre.SIZE_OF_VEIN
        )
    }

    private fun generateInBiome(
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
        val configuredFeature = ConfiguredFeature(
            Feature.ORE,
            OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, blockState, sizeOfVein)
        )
            .createDecoratedFeature(Decorator.COUNT_RANGE.configure(rangeDecoratorConfig))

        if (biome.category != Biome.Category.NETHER && biome.category != Biome.Category.THEEND) {
            biome.addFeature(
                GenerationStep.Feature.UNDERGROUND_ORES,
                configuredFeature
            )
        }
    }
}
