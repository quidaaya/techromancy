package com.quidaaya.techromancy.blocks;

import com.quidaaya.techromancy.Techromancy;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockRegister {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
            BuiltInRegistries.BLOCK,
            Techromancy.MODID
    );

    public static final DeferredHolder<Block, Block> OVERGROWN_MECHANICAL_HEAP = BLOCKS.register(
            "overgrown_mechanical_heap",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                            .requiresCorrectToolForDrops()
                            .strength(4.0f)
                            .lightLevel((_a) -> 3)
            )
    );
}
