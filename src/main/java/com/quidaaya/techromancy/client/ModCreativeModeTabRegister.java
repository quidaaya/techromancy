package com.quidaaya.techromancy.client;

import com.quidaaya.techromancy.Techromancy;
import com.quidaaya.techromancy.blocks.ModBlockRegister;
import com.quidaaya.techromancy.items.ModItemRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabRegister {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB,
            Techromancy.MODID
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB =
            CREATIVE_MODE_TABS.register(
                    "techromancy_tab",
                    () -> CreativeModeTab.builder()
                            .title(Component.literal("Techromancy"))
                            .icon(() -> new ItemStack(ModItemRegister.OVERGROWN_MECHANICAL_HEAP_ITEM.get()))
                            .withTabsBefore(CreativeModeTabs.COMBAT)
                            .displayItems((parameters, output) -> {
                                output.accept(ModBlockRegister.OVERGROWN_MECHANICAL_HEAP.get());
                                output.accept(ModItemRegister.OVERGROWN_PARTS.get());
                                output.accept(ModItemRegister.GOLEM_SPAWN_EGG.get());
                            }).build());
}
