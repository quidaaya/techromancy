package com.quidaaya.techromancy.data;

import com.quidaaya.techromancy.Techromancy;
import com.quidaaya.techromancy.items.ModItemRegister;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Techromancy.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItemRegister.OVERGROWN_PARTS.get());
        withExistingParent(ModItemRegister.GOLEM_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}
