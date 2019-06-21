package com.crypticmushroom.irondimension.world.biomes;

import com.crypticmushroom.irondimension.world.gen.feature.IronFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.FeatureConfig;

public class IronHighlands extends IronBiome {
    public IronHighlands() {
        super(new Settings()
                .category(Category.PLAINS)
                .depth(0.45F)
                .precipitation(Precipitation.NONE)
                .temperature(0.7F)
                .scale(0.3F)
                .downfall(0.6F)
        );
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, configureFeature(IronFeatures.HORNBEAM_TREE, FeatureConfig.DEFAULT,
                Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(1, 0.05F, 1)));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, configureFeature(IronFeatures.IRONWOOD_TREE, FeatureConfig.DEFAULT,
                Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(1, 0.05F, 1)));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, configureFeature(IronFeatures.RUSTY_IRONWOOD_TREE, FeatureConfig.DEFAULT,
                Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(1, 0.05F, 1)));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, configureFeature(IronFeatures.FLOWER, FeatureConfig.DEFAULT,
                Decorator.COUNT_HEIGHTMAP_32, new CountDecoratorConfig(40)));
    }
}
