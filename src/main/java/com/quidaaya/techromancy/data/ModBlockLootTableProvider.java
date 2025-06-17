package com.quidaaya.techromancy.data;

import com.quidaaya.techromancy.blocks.ModBlockRegister;
import com.quidaaya.techromancy.items.ModItemRegister;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        add(ModBlockRegister.OVERGROWN_MECHANICAL_HEAP.get(),
                block -> createOreDrop(
                        ModBlockRegister.OVERGROWN_MECHANICAL_HEAP.get(),
                        ModItemRegister.OVERGROWN_PARTS.get()
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlockRegister.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
