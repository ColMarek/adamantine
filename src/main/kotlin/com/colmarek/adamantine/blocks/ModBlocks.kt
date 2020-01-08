package com.colmarek.adamantine.blocks

import com.colmarek.adamantine.utils.Config
import com.colmarek.adamantine.utils.generateInBiome
import com.colmarek.adamantine.utils.registerBlock
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback
import net.minecraft.util.registry.Registry
import net.minecraft.world.biome.Biome

object ModBlocks {
    private val adamantineOre = AdamantineOre()

    fun init() {
        registerBlock(adamantineOre, "adamantine_ore")

        Registry.BIOME.forEach { generateAdamantineOre(it) }
        RegistryEntryAddedCallback.event(Registry.BIOME)
            .register(RegistryEntryAddedCallback { _, _, biome -> generateAdamantineOre(biome) })
    }

    private fun generateAdamantineOre(biome: Biome) {
        generateInBiome(
            biome,
            adamantineOre.defaultState,
            Config.adamantineOre.veinsPerChunk,
            Config.adamantineOre.bottomOffset,
            Config.adamantineOre.minYLevel,
            Config.adamantineOre.maxYLevel,
            Config.adamantineOre.sizeOfVein
        )
    }
}