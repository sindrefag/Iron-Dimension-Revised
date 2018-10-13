package com.crypticmushroom.irondimension.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * Soft_Iron_Creature - 123wdog
 * Created using Tabula 7.0.0
 */
public class ModelSoftIronCreature extends ModelBase {
    public ModelRenderer shape1 ;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape3_1;
    public ModelRenderer shape5;
    public ModelRenderer shape3_2;
    public ModelRenderer shape3_3;
    public ModelRenderer shape5_1;
    public ModelRenderer shape9;
    public ModelRenderer shape9_1;
    public ModelRenderer shape9_2;
    public ModelRenderer shape1_1;
    public ModelRenderer shape1_2;
    public ModelRenderer shape9_3;
    public ModelRenderer shape9_4;
    public ModelRenderer shape9_5;
    public ModelRenderer shape5_2;
    public ModelRenderer shape5_3;
    public ModelRenderer shape21;
    public ModelRenderer shape24;
    public ModelRenderer shape21_1;
    public ModelRenderer shape21_2;
    public ModelRenderer shape17;
    public ModelRenderer shape17_1;

    public ModelSoftIronCreature() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.shape3 = new ModelRenderer(this, 0, 0);
        this.shape3.setRotationPoint(6.5F, 23.0F, -6.3F);
        this.shape3.addBox(0.0F, 0.0F, 0.0F, 2, -7, 3, 0.0F);
        this.setRotateAngle(shape3, -0.148352986419518F, 0.0F, 0.0F);
        this.shape1_1 = new ModelRenderer(this, 0, 0);
        this.shape1_1.setRotationPoint(6.0F, 23.0F, -8.0F);
        this.shape1_1.addBox(0.0F, 0.0F, 0.0F, 3, 2, 5, 0.0F);
        this.setRotateAngle(shape1_1, 0.13962634015954636F, 0.0F, 0.0F);
        this.shape2 = new ModelRenderer(this, 9, 0);
        this.shape2.setRotationPoint(-9.0F, 23.0F, -8.0F);
        this.shape2.addBox(0.0F, 0.0F, 0.0F, 3, 2, 5, 0.0F);
        this.setRotateAngle(shape2, 0.13962634015954636F, 0.0F, 0.0F);
        this.shape3_1 = new ModelRenderer(this, 0, 0);
        this.shape3_1.setRotationPoint(-8.5F, 23.0F, -6.3F);
        this.shape3_1.addBox(0.0F, 0.0F, 0.0F, 2, -7, 3, 0.0F);
        this.setRotateAngle(shape3_1, -0.148352986419518F, 0.0F, 0.0F);
        this.shape21 = new ModelRenderer(this, 0, 0);
        this.shape21.setRotationPoint(-2.0F, 12.0F, 13.0F);
        this.shape21.addBox(0.0F, 0.0F, 0.0F, 3, 2, 7, 0.0F);
        this.setRotateAngle(shape21, 0.4363323129985824F, 0.0F, 0.0F);
        this.shape1_2 = new ModelRenderer(this, 0, 0);
        this.shape1_2.setRotationPoint(7.3000000000000025F, 23.0F, 3.0F);
        this.shape1_2.addBox(0.0F, 0.0F, 0.0F, 3, 2, 5, 0.0F);
        this.setRotateAngle(shape1_2, 0.13962634015954636F, 0.0F, 0.0F);
        this.shape17 = new ModelRenderer(this, 0, 0);
        this.shape17.setRotationPoint(-2.5F, 0.0F, 0.0F);
        this.shape17.addBox(0.0F, 0.0F, 0.0F, 8, -5, -8, 0.0F);
        this.setRotateAngle(shape17, 0.4363323129985824F, 0.0F, 0.0F);
        this.shape17_1 = new ModelRenderer(this, 0, 0);
        this.shape17_1.setRotationPoint(-2.5F, 0.0F, 0.0F);
        this.shape17_1.addBox(0.0F, 0.0F, 0.0F, 8, 2, -6, 0.0F);
        this.setRotateAngle(shape17_1, 0.7853981633974483F, 0.0F, 0.0F);
        this.shape9_4 = new ModelRenderer(this, 0, 0);
        this.shape9_4.setRotationPoint(7.800000000000002F, 16.05F, 0.2F);
        this.shape9_4.addBox(0.0F, 0.0F, -8.0F, 2, 4, 7, 0.0F);
        this.setRotateAngle(shape9_4, 2.206096174520833F, 0.0F, 0.0F);
        this.shape5 = new ModelRenderer(this, 0, 0);
        this.shape5.setRotationPoint(-9.0F, 3.6F, -1.0F);
        this.shape5.addBox(0.0F, 0.0F, 0.0F, 18, 8, 11, 0.0F);
        this.setRotateAngle(shape5, -0.5235987755982988F, 0.0F, 0.0F);
        this.shape9_1 = new ModelRenderer(this, 0, 0);
        this.shape9_1.setRotationPoint(-9.8F, 12.0F, 8.8F);
        this.shape9_1.addBox(0.0F, 0.0F, -9.0F, 2, 4, 10, 0.0F);
        this.setRotateAngle(shape9_1, 0.47123889803846897F, 0.0F, 0.0F);
        this.shape3_3 = new ModelRenderer(this, 0, 0);
        this.shape3_3.setRotationPoint(6.5F, 16.1F, -5.25F);
        this.shape3_3.addBox(0.0F, 0.0F, 0.0F, 2, -7, 3, 0.0F);
        this.setRotateAngle(shape3_3, -0.3490658503988659F, 0.0F, 0.0F);
        this.shape5_1 = new ModelRenderer(this, 0, 0);
        this.shape5_1.setRotationPoint(-8.0F, 9.1F, 8.5F);
        this.shape5_1.addBox(0.0F, 0.0F, 0.0F, 16, 8, 7, 0.0F);
        this.setRotateAngle(shape5_1, -0.7853981633974483F, 0.0F, 0.0F);
        this.shape24 = new ModelRenderer(this, 0, 0);
        this.shape24.setRotationPoint(-1.5F, 3.0F, -4.5F);
        this.shape24.addBox(0.0F, 0.0F, 0.0F, 3, 3, 4, 0.0F);
        this.setRotateAngle(shape24, -0.4363323129985824F, 0.0F, 0.0F);
        this.shape21_2 = new ModelRenderer(this, 0, 0);
        this.shape21_2.setRotationPoint(0.0F, 0.3F, 6.0F);
        this.shape21_2.addBox(0.0F, 0.0F, 0.0F, 3, 2, 7, 0.0F);
        this.setRotateAngle(shape21_2, 0.5462880558742251F, 0.0F, 0.0F);
        this.shape9 = new ModelRenderer(this, 0, 0);
        this.shape9.setRotationPoint(-9.8F, 20.15F, 8.1F);
        this.shape9.addBox(0.0F, 0.0F, 0.0F, 2, 4, 3, 0.0F);
        this.setRotateAngle(shape9, -1.5707963267948966F, 0.0F, 0.0F);
        this.shape21_1 = new ModelRenderer(this, 0, 0);
        this.shape21_1.setRotationPoint(0.0F, 0.6F, 5.5F);
        this.shape21_1.addBox(0.0F, 0.0F, 0.0F, 3, 2, 7, 0.0F);
        this.setRotateAngle(shape21_1, 0.7740535232594852F, 0.0F, 0.0F);
        this.shape5_2 = new ModelRenderer(this, 0, 0);
        this.shape5_2.setRotationPoint(-7.0F, 3.6F, -1.0F);
        this.shape5_2.addBox(0.0F, -1.0F, 0.0F, 14, 1, 11, 0.0F);
        this.setRotateAngle(shape5_2, -0.5235987755982988F, 0.0F, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(-10.3F, 23.0F, 3.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 3, 2, 5, 0.0F);
        this.setRotateAngle(shape1, 0.13962634015954636F, 0.0F, 0.0F);
        this.shape9_2 = new ModelRenderer(this, 0, 0);
        this.shape9_2.setRotationPoint(-9.8F, 16.05F, 0.2F);
        this.shape9_2.addBox(0.0F, 0.0F, -8.0F, 2, 4, 7, 0.0F);
        this.setRotateAngle(shape9_2, 2.206096174520833F, 0.0F, 0.0F);
        this.shape9_5 = new ModelRenderer(this, 0, 0);
        this.shape9_5.setRotationPoint(7.800000000000002F, 12.0F, 8.8F);
        this.shape9_5.addBox(0.0F, 0.0F, -9.0F, 2, 4, 10, 0.0F);
        this.setRotateAngle(shape9_5, 0.47123889803846897F, 0.0F, 0.0F);
        this.shape3_2 = new ModelRenderer(this, 0, 0);
        this.shape3_2.setRotationPoint(-8.5F, 16.1F, -5.25F);
        this.shape3_2.addBox(0.0F, 0.0F, 0.0F, 2, -7, 3, 0.0F);
        this.setRotateAngle(shape3_2, -0.3490658503988659F, 0.0F, 0.0F);
        this.shape9_3 = new ModelRenderer(this, 0, 0);
        this.shape9_3.setRotationPoint(7.800000000000002F, 20.15F, 8.1F);
        this.shape9_3.addBox(0.0F, 0.0F, 0.0F, 2, 4, 3, 0.0F);
        this.setRotateAngle(shape9_3, -1.5707963267948966F, 0.0F, 0.0F);
        this.shape5_3 = new ModelRenderer(this, 0, 0);
        this.shape5_3.setRotationPoint(-7.1F, 9.1F, 8.5F);
        this.shape5_3.addBox(0.0F, -1.0F, -1.0F, 14, 1, 8, 0.0F);
        this.setRotateAngle(shape5_3, -0.7853981633974483F, 0.0F, 0.0F);
        this.shape24.addChild(this.shape17);
        this.shape24.addChild(this.shape17_1);
        this.shape21_1.addChild(this.shape21_2);
        this.shape21.addChild(this.shape21_1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape3.render(f5);
        this.shape1_1.render(f5);
        this.shape2.render(f5);
        this.shape3_1.render(f5);
        this.shape21.render(f5);
        this.shape1_2.render(f5);
        this.shape9_4.render(f5);
        this.shape5.render(f5);
        this.shape9_1.render(f5);
        this.shape3_3.render(f5);
        this.shape5_1.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.shape24.offsetX, this.shape24.offsetY, this.shape24.offsetZ);
        GlStateManager.translate(this.shape24.rotationPointX * f5, this.shape24.rotationPointY * f5, this.shape24.rotationPointZ * f5);
        GlStateManager.scale(1.0D, 1.1D, 1.0D);
        GlStateManager.translate(-this.shape24.offsetX, -this.shape24.offsetY, -this.shape24.offsetZ);
        GlStateManager.translate(-this.shape24.rotationPointX * f5, -this.shape24.rotationPointY * f5, -this.shape24.rotationPointZ * f5);
        this.shape24.render(f5);
        GlStateManager.popMatrix();
        this.shape9.render(f5);
        this.shape5_2.render(f5);
        this.shape1.render(f5);
        this.shape9_2.render(f5);
        this.shape9_5.render(f5);
        this.shape3_2.render(f5);
        this.shape9_3.render(f5);
        this.shape5_3.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
