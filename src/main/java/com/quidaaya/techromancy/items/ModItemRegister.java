package com.quidaaya.techromancy.items;

import com.quidaaya.techromancy.Techromancy;
import com.quidaaya.techromancy.blocks.ModBlockRegister;
import com.quidaaya.techromancy.entity.ModEntityRegister;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItemRegister {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
            BuiltInRegistries.ITEM,
            Techromancy.MODID
    );

    public static final DeferredHolder<Item, BlockItem> OVERGROWN_MECHANICAL_HEAP_ITEM = ITEMS.register(
            "overgrown_mechanical_heap",
            () -> new BlockItem(ModBlockRegister.OVERGROWN_MECHANICAL_HEAP.get(), new Item.Properties())
    );

    public static final DeferredHolder<Item, Item> OVERGROWN_PARTS = ITEMS.register(
            "overgrown_parts",
            () -> new Item(
                    new Item.Properties().fireResistant()
            )
    );

    public static final DeferredHolder<Item, Item> GOLEM_SPAWN_EGG = ITEMS.register(
            "golem_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntityRegister.RESURRECTED_GOLEM_ENTITY, 0xFFFFFF, 0x00000000, new Item.Properties())
    );
}
