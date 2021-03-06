package com.crypticmushroom.irondimension.world.biomes;

import com.crypticmushroom.irondimension.registry.BlocksIDL;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BiomeMoltenChasms extends BiomeIronDimension {

    public BiomeMoltenChasms(BiomeProperties props) {
        super(props);

        spawnableCreatureList.clear();

        decorator.treesPerChunk = -1;
        decorator.lavaPoolChance = 0.45F;
    }

    //TODO: Peek at a generator or find some other solution to make Chasms... It may be that I'll need the ChunkGenerator for this

    @Override
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos) {
        return 0x6d2d1e;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos) {
        return 0xe6d2d1e;
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        topBlock = BlocksIDL.ironstone.getDefaultState();
        fillerBlock = BlocksIDL.ironstone.getDefaultState();

        if (noiseVal > 1.75D) {
            topBlock = BlocksIDL.ironstone.getDefaultState();
            fillerBlock = BlocksIDL.ironstone.getDefaultState();
        } else if (noiseVal > -0.5D) {
            topBlock = BlocksIDL.iron_dirt.getDefaultState();
        }

        this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }
}
