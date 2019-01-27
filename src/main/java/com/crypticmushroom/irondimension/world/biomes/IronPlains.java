package com.crypticmushroom.irondimension.world.biomes;

import com.crypticmushroom.irondimension.world.gen.surfacebuilder.IronPlainsSurfaceBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class IronPlains extends Biome {
    public IronPlains() {
        super(new Settings()
                .configureSurfaceBuilder(new IronPlainsSurfaceBuilder(), SurfaceBuilder.GRASS_CONFIG)
                .category(Category.PLAINS)
                .depth(0.5F)
                .scale(0.7F)
                .temperature(0.5F)
                .precipitation(Precipitation.NONE)
                .downfall(1.0F)
                .waterColor(0xA9F7FF)
                .waterFogColor(0xA9F7FF)
        );
    }

    @Override
    public int getSkyColor(float float_1)
    {
        return 0xC0C0FF; // Lavender Blue
    }

    @Override
    public int getGrassColorAt(BlockPos pos)
    {
        return 0xB1ffCB;
    }

    @Override
    public int getFoliageColorAt(BlockPos pos)
    {
        return 0xB1ffCB;
    }
}