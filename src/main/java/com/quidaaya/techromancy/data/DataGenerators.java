package com.quidaaya.techromancy.data;

import com.quidaaya.techromancy.Techromancy;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Techromancy.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // Add the loot table provider.
        generator.addProvider(
                event.includeServer(),
                new LootTableProvider(
                        packOutput,
                        Collections.emptySet(),
                        List.of(
                                new LootTableProvider.SubProviderEntry(
                                        ModBlockLootTableProvider::new,
                                        LootContextParamSets.BLOCK
                                )
                        ),
                        lookupProvider
                )
        );

        // Add the block tags provider.
        generator.addProvider(
                event.includeServer(),
                new ModBlockTagProvider(
                        packOutput,
                        lookupProvider,
                        existingFileHelper
                )
        );

        // Add the block state provider for modded blocks.
        generator.addProvider(
                event.includeClient(),
                new ModBlockStateProvider(packOutput, existingFileHelper)
        );

        // Add the language provider for all modded objects.
        generator.addProvider(
                event.includeClient(),
                new ModLangProvider(packOutput, "en_us")
        );

        // Add the item model provided for all modded items.
        generator.addProvider(
                event.includeClient(),
                new ModItemModelProvider(
                        packOutput,
                        existingFileHelper
                )
        );
    }
}
