package com.quidaaya.techromancy.entity.client.golem;

import com.mojang.blaze3d.vertex.PoseStack;
import com.quidaaya.techromancy.Techromancy;
import com.quidaaya.techromancy.entity.custom.ResurrectedGolemEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ResurrectedGolemRenderer extends MobRenderer<ResurrectedGolemEntity, ResurrectedGolemModel<ResurrectedGolemEntity>> {
    public ResurrectedGolemRenderer(EntityRendererProvider.Context context) {
        super(context, new ResurrectedGolemModel<>(context.bakeLayer(ResurrectedGolemModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(ResurrectedGolemEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(Techromancy.MODID, "textures/entity/golem/resurrected_golem.png");
    }

    @Override
    public void render(ResurrectedGolemEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
