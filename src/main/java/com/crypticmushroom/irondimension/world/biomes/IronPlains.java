package com.crypticmushroom.irondimension.world.biomes;

public class IronPlains extends IronBiome {
    public IronPlains() {
        super(new Settings()
                .category(Category.PLAINS)
                .depth(0.1F)
                .precipitation(Precipitation.NONE)
                .temperature(0.65F)
                .scale(0.05F)
                .downfall(0.01F)
        );
    }
}
