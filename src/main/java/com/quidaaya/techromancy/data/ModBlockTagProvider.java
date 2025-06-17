package com.quidaaya.techromancy.data;

import com.quidaaya.techromancy.Techromancy;
import com.quidaaya.techromancy.blocks.ModBlockRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Techromancy.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Blocks requiring at least a diamond tool.
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlockRegister.OVERGROWN_MECHANICAL_HEAP.get());

        // Block requiring a pickaxe to mine.
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlockRegister.OVERGROWN_MECHANICAL_HEAP.get());
    }
}
