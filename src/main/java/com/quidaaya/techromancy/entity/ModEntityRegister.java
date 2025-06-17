package com.quidaaya.techromancy.entity;

import com.quidaaya.techromancy.Techromancy;
import com.quidaaya.techromancy.entity.custom.ResurrectedGolemEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntityRegister {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(
            BuiltInRegistries.ENTITY_TYPE,
            Techromancy.MODID
    );

    public static final Supplier<EntityType<ResurrectedGolemEntity>> RESURRECTED_GOLEM_ENTITY = ENTITY_TYPES.register(
            "resurrected_golem",
            () -> EntityType.Builder
                    .of(ResurrectedGolemEntity::new, MobCategory.CREATURE)
                    .sized(0.25f, 0.75f)
                    .build("resurrected_golem")
    );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
