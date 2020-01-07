package com.colmarek.adamantine.blocks

import com.colmarek.adamantine.utils.generateInBiome
import com.colmarek.adamantine.utils.registerBlock
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback
import net.minecraft.util.registry.Registry
import net.minecraft.world.biome.Biome

object ModBlocks {
    private val adamantineOre = AdamantineOre()

    fun init() {
        registerBlock(adamantineOre, AdamantineOre.LABEL)

        Registry.BIOME.forEach { generateAdamantineOre(it) }
        RegistryEntryAddedCallback.event(Registry.BIOME)
            .register(RegistryEntryAddedCallback { _, _, biome -> generateAdamantineOre(biome) })
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
}