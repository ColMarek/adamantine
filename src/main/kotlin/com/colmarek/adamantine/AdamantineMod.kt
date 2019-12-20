package com.colmarek.adamantine

import com.colmarek.adamantine.armor.AdamantineArmorMaterial
import com.colmarek.adamantine.blocks.AdamantineOre
import com.colmarek.adamantine.items.AdamantineIngot
import com.colmarek.adamantine.items.tools.AdamantinePickaxe
import com.colmarek.adamantine.items.tools.AdamantineSword
import com.colmarek.adamantine.items.tools.AdamantineToolMaterial
import com.colmarek.adamantine.utils.ChanceLootTableRange
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.*
import net.minecraft.loot.entry.ItemEntry
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
        val MOD_ITEM_GROUP: ItemGroup = FabricItemGroupBuilder.create(Identifier(MODID, "general"))
            .icon { ItemStack(adamantineIngot) }
            .build()

        val adamantineOre = AdamantineOre()
        val adamantineIngot = AdamantineIngot()

        private val adamantineArmorMaterial = AdamantineArmorMaterial()
        val adamantineHelmet = ArmorItem(adamantineArmorMaterial, EquipmentSlot.HEAD, Item.Settings().group(MOD_ITEM_GROUP))
        val adamantineChestplate = ArmorItem(adamantineArmorMaterial, EquipmentSlot.CHEST, Item.Settings().group(MOD_ITEM_GROUP))
        val adamantineLeggings = ArmorItem(adamantineArmorMaterial, EquipmentSlot.LEGS, Item.Settings().group(MOD_ITEM_GROUP))
        val adamantineBoots = ArmorItem(adamantineArmorMaterial, EquipmentSlot.FEET, Item.Settings().group(MOD_ITEM_GROUP))

        val adamantineToolMaterial = AdamantineToolMaterial()
        val adamantineSword = AdamantineSword()
        val adamantinePickaxe = AdamantinePickaxe()
    }

    override fun onInitialize() {
        // Adamantine Ore
        registerBlock(adamantineOre, AdamantineOre.LABEL)
        Registry.BIOME.forEach { generateAdamantineOre(it) }
        RegistryEntryAddedCallback.event(Registry.BIOME)
            .register(RegistryEntryAddedCallback { _, _, biome -> generateAdamantineOre(biome) })
        // Chance to drop from Diamond Ore
        val diamondOreIdentifier = Identifier("minecraft", "blocks/diamond_ore")
        LootTableLoadingCallback.EVENT.register(LootTableLoadingCallback{_, _, id, supplier, _ ->
            if (diamondOreIdentifier == id){
                val poolBuilder = FabricLootPoolBuilder.builder()
                    .withRolls(ChanceLootTableRange(AdamantineOre.CHANCE_DROP_FROM_DIAMOND_ORE))
                    .withEntry(ItemEntry.builder(adamantineOre))
                supplier.withPool(poolBuilder)
            }
        })

        // Adamantine Ingot
        registerItem(adamantineIngot, AdamantineIngot.LABEL)

        // Adamantine Armor
        registerItem(adamantineHelmet, "adamantine_helmet")
        registerItem(adamantineChestplate, "adamantine_chestplate")
        registerItem(adamantineLeggings, "adamantine_leggings")
        registerItem(adamantineBoots, "adamantine_boots")

        // Tools
        registerItem(adamantineSword, "adamantine_sword")
        registerItem(adamantinePickaxe, "adamantine_pickaxe")
    }

    private fun registerBlock(block: Block, label: String) {
        Registry.register(Registry.BLOCK, Identifier(MODID, label), block)
        Registry.register(
            Registry.ITEM,
            Identifier(MODID, label),
            BlockItem(block, Item.Settings().group(MOD_ITEM_GROUP))
        )
    }

    private fun registerItem(item: Item, label: String) {
        Registry.register(Registry.ITEM, Identifier(MODID, label), item)
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
