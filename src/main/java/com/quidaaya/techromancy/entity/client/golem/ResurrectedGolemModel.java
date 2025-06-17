package com.quidaaya.techromancy.entity.client.golem;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.quidaaya.techromancy.Techromancy;
import com.quidaaya.techromancy.entity.custom.ResurrectedGolemEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ResurrectedGolemModel<T extends ResurrectedGolemEntity> extends HierarchicalModel<T> {
    // TODO
    // We need to remodel this golem. The with the initial modeling I didn't realize I should have had a root node for
    // all the other parts to fit under, and now the golem is hovering in the air an extra block.
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Techromancy.MODID, "resurrected_golem"), "main");

    private final ModelPart body;
    private final ModelPart arms;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart torso;
    private final ModelPart lower;
    private final ModelPart upper;
    private final ModelPart legs;
    private final ModelPart left_leg;
    private final ModelPart right_leg;
    private final ModelPart head;

    public ResurrectedGolemModel(ModelPart root) {
        this.body = root.getChild("body");
        this.arms = this.body.getChild("arms");
        this.left_arm = this.arms.getChild("left_arm");
        this.right_arm = this.arms.getChild("right_arm");
        this.torso = this.body.getChild("torso");
        this.lower = this.torso.getChild("lower");
        this.upper = this.torso.getChild("upper");
        this.legs = this.body.getChild("legs");
        this.left_leg = this.legs.getChild("left_leg");
        this.right_leg = this.legs.getChild("right_leg");
        this.head = this.body.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild(
                "body",
                CubeListBuilder.create(),
                PartPose.offset(0f,  0f, 0f)
        );

        PartDefinition arms = body.addOrReplaceChild(
                "arms", CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 0.0F)
        );

        PartDefinition left_arm = arms.addOrReplaceChild(
                "left_arm",
                CubeListBuilder.create()
                        .texOffs(8, 15)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(8.0F, -7.0F, 0.0F)
        );

        PartDefinition right_arm = arms.addOrReplaceChild(
                "right_arm",
                CubeListBuilder.create()
                        .texOffs(12, 6)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -7.0F, 0.0F)
        );

        PartDefinition torso = body.addOrReplaceChild(
                "torso",
                CubeListBuilder.create(),
                PartPose.offset(4.0F, 0.0F, 0.0F)
        );

        PartDefinition lower = torso.addOrReplaceChild(
                "lower",
                CubeListBuilder.create()
                        .texOffs(0, 6)
                        .addBox(-2.0F, -7.0F, -1.0F, 4.0F, 4.0F, 2.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 4.0F, 0.0F)
        );

        PartDefinition upper = torso.addOrReplaceChild(
                "upper",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-3.0F, -11.0F, -1.0F, 6.0F, 4.0F, 2.0F,
                                new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F)
        );

        PartDefinition legs = body.addOrReplaceChild(
                "legs",
                CubeListBuilder.create(),
                PartPose.offset(3.0F, 8.0F, 0.0F)
        );

        PartDefinition left_leg = legs.addOrReplaceChild(
                "left_leg",
                CubeListBuilder.create()
                        .texOffs(0, 12)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F,
                                new CubeDeformation(0.0F)), PartPose.offset(2.0F, -7.0F, 0.0F)
        );

        PartDefinition right_leg = legs.addOrReplaceChild(
                "right_leg",
                CubeListBuilder.create()
                        .texOffs(16, 15)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F,
                                new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F)
        );

        PartDefinition head = body.addOrReplaceChild(
                "head",
                CubeListBuilder.create()
                        .texOffs(16, 0)
                        .addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(4.0F, -7.0F, -0.5F)
        );

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        arms.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }

    @Override
    public void setupAnim(ResurrectedGolemEntity golem, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(ResurrectedGolemAnimations.walk, limbSwing, limbSwingAmount, 2f, 2.5f);

        this.animate(golem.idleAnimationState, ResurrectedGolemAnimations.idle, ageInTicks, 1f);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -20f, 20f);

        this.head.yRot = headYaw * ((float) Math.PI / 180f);
        this.head.xRot = headPitch * ((float) Math.PI / 180f);
    }
}
