package com.quidaaya.techromancy.event;

import com.quidaaya.techromancy.Techromancy;
import com.quidaaya.techromancy.entity.ModEntityRegister;
import com.quidaaya.techromancy.entity.client.golem.ResurrectedGolemModel;
import com.quidaaya.techromancy.entity.custom.ResurrectedGolemEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = Techromancy.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ResurrectedGolemModel.LAYER_LOCATION, ResurrectedGolemModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityRegister.RESURRECTED_GOLEM_ENTITY.get(), ResurrectedGolemEntity.attributes());
    }
}
