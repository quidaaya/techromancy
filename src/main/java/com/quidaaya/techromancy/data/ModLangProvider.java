package com.quidaaya.techromancy.data;

import com.quidaaya.techromancy.Techromancy;
import com.quidaaya.techromancy.blocks.ModBlockRegister;
import com.quidaaya.techromancy.items.ModItemRegister;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(PackOutput output, String locale) {
        super(output, Techromancy.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        // Blocks
        this.add(ModBlockRegister.OVERGROWN_MECHANICAL_HEAP.get(), "Overgrown Mechanical Heap");

        // Items
        this.add(ModItemRegister.OVERGROWN_PARTS.get(), "Overgrown Parts");
        this.add(ModItemRegister.GOLEM_SPAWN_EGG.get(), "Golem Spawn Egg");
    }
}
