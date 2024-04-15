// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelmagic_arrow<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "magic_arrow"), "main");
	private final ModelPart magic_arrow;

	public Modelmagic_arrow(ModelPart root) {
		this.magic_arrow = root.getChild("magic_arrow");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition magic_arrow = partdefinition.addOrReplaceChild("magic_arrow",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-7.0F, -9.0F, -1.0F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 6)
						.addBox(5.0F, -9.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(9, 14)
						.addBox(5.0F, -9.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 13)
						.addBox(-7.0F, -9.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(9, 11)
						.addBox(-7.0F, -10.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(9, 3)
						.addBox(-8.0F, -11.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 8)
						.addBox(-8.0F, -7.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 6)
						.addBox(-8.0F, -9.0F, -3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 3)
						.addBox(-8.0F, -9.0F, 1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 10)
						.addBox(-7.0F, -8.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.0F, 16.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r1 = magic_arrow
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(0, 16).addBox(8.0F, -7.0F, 0.0F, 1.0F, 3.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r2 = magic_arrow.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(5, 16)
						.addBox(7.0F, 5.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 14)
						.addBox(9.0F, 5.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		magic_arrow.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}