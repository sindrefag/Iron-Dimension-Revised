package com.crypticmushroom.irondimension.world;

import com.crypticmushroom.irondimension.registry.BlocksIDL;
import com.crypticmushroom.irondimension.world.gen.WorldGenIronCaves;
import com.crypticmushroom.irondimension.world.gen.WorldGenIronLakes;
import com.crypticmushroom.irondimension.world.gen.WorldGenIronRavines;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class ChunkProviderIronDim implements IChunkGenerator {

    private final Random rand;
    private NoiseGeneratorOctaves minLimitPerlinNoise;
    private NoiseGeneratorOctaves maxLimitPerlinNoise;
    private NoiseGeneratorOctaves mainPerlinNoise;
    private NoiseGeneratorPerlin surfaceNoise;
    private NoiseGeneratorOctaves depthNoise;
    private final World world;
    private WorldType terrainType;
    private final double[] heightMap;
    private final float[] biomeWeights;
    private double[] depthBuffer = new double[256];
    private Biome biomesForGeneration[];
    private double[] mainNoiseRegion;
    private double[] minLimitRegion;
    private double[] maxLimitRegion;
    private double[] depthRegion;

    private final WorldGenIronCaves caveGenerator = new WorldGenIronCaves();
    private final WorldGenIronRavines ravineGenerator = new WorldGenIronRavines();

    public ChunkProviderIronDim(World world, long l, boolean flag) {
        this.world = world;
        this.terrainType = world.getWorldInfo().getTerrainType();
        this.rand = new Random(l);
        this.minLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.maxLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.mainPerlinNoise = new NoiseGeneratorOctaves(this.rand, 8);
        this.surfaceNoise = new NoiseGeneratorPerlin(this.rand, 4);
        this.depthNoise = new NoiseGeneratorOctaves(rand, 16);
        this.heightMap = new double[825];
        this.biomeWeights = new float[25];

        for (int j = -2; j <= 2; ++j) {
            for (int k = -2; k<= 2; ++k) {
                float f = 10.0F / MathHelper.sqrt((float) (j * j + k * k) + 0.2F);
                this.biomeWeights[j + 2 + (k + 2) * 5] = f;
            }
        }
    }

    @Override
    public Chunk generateChunk(int cx, int cz) {
        rand.setSeed(cx * 0x4f9939f508L + cz * 0x1ef1565bd5L);
        ChunkPrimer primer = new ChunkPrimer();
        setBlocksInChunk(cx, cz, primer);

        //Biome setup for terraingen

        this.biomesForGeneration = world.getBiomeProvider().getBiomes(biomesForGeneration, cx * 16, cz * 16, 16, 16);
        replaceBiomeBlocks(cx, cz, primer, biomesForGeneration);
        caveGenerator.generate(world, cx, cz, primer);
        ravineGenerator.generate(world, cx, cz, primer);

        Chunk chunk = new Chunk(world, primer, cx, cz);

        //Biome setup
        byte[] chunkBiomes = chunk.getBiomeArray();
        for (int i = 0; i < chunkBiomes.length; ++i) {
            chunkBiomes[i] = (byte) Biome.getIdForBiome(this.biomesForGeneration[i]);
        }

        chunk.generateSkylightMap();

        return chunk;
    }

    public void setBlocksInChunk(int chunkX, int chunkZ, ChunkPrimer primer) {
        byte seaLevel = 63;
        this.biomesForGeneration = this.world.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, chunkX * 4 - 2, chunkZ * 4 - 2, 10, 10);
        this.generateHeightmap(chunkX * 4, 0, chunkZ * 4);

        for (int k = 0; k < 4; ++k) {
            int l = k * 5;
            int i1 = (k + 1) * 5;

            for (int j1 = 0; j1 < 4; ++j1) {
                int k1 = (l + j1) * 33;
                int l1 = (l + j1 + 1) * 33;
                int i2 = (i1 + j1) * 33;
                int j2 = (i1 + j1 + 1) * 33;

                for (int k2 = 0; k2 < 32; ++k2) {
                    double d0 = 0.125D;
                    double d1 = this.heightMap[k1 + k2];
                    double d2 = this.heightMap[l1 + k2];
                    double d3 = this.heightMap[i2 + k2];
                    double d4 = this.heightMap[j2 + k2];
                    double d5 = (this.heightMap[k1 + k2 + 1] - d1) * d0;
                    double d6 = (this.heightMap[l1 + k2 + 1] - d2) * d0;
                    double d7 = (this.heightMap[i2 + k2 + 1] - d3) * d0;
                    double d8 = (this.heightMap[j2 + k2 + 1] - d4) * d0;

                    for (int l2 = 0; l2 < 8; ++l2) {
                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;

                        for (int i3 = 0; i3 < 4; ++i3) {
                            double d14 = 0.25D;
                            double d16 = (d11 - d10) * d14;
                            double d15 = d10 - d16;

                            for (int k3 = 0; k3 < 4; ++k3) {
                                if ((d15 += d16) > 0.0D) {
                                    primer.setBlockState(k * 4 + i3, k2 * 8 + l2, j1 * 4 + k3, BlocksIDL.ironstone.getDefaultState());
                                } else if (k2 * 8 + l2 < seaLevel) {
                                    primer.setBlockState(k * 4 + i3, k2 * 8 + l2, j1 * 4 + k3, BlocksIDL.metallic_water_block.getDefaultState());
                                }
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }

    private void generateHeightmap(int x, int zero, int z) {
        this.depthRegion = this.depthNoise.generateNoiseOctaves(this.depthRegion, x, z, 5, 5, 200.0D, 200.0D, 0.5D);
        this.mainNoiseRegion = this.mainPerlinNoise.generateNoiseOctaves(this.mainNoiseRegion, x, zero, z, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
        this.minLimitRegion = this.minLimitPerlinNoise.generateNoiseOctaves(this.minLimitRegion, x, zero, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
        this.maxLimitRegion = this.maxLimitPerlinNoise.generateNoiseOctaves(this.maxLimitRegion, x, zero, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
        int terrainIndex = 0;
        int noiseIndex = 0;

        for (int ax = 0; ax < 5; ++ax) {
            for (int az = 0; az < 5; ++az) {
                float totalVariation = 0.0F;
                float totalHeight = 0.0F;
                float totalFactor = 0.0F;
                byte two = 2;
                Biome biomegenbase = this.biomesForGeneration[ax + 2 + (az + 2) * 10];

                for (int ox = -two; ox <= two; ++ox) {
                    for (int oz = -two; oz <= two; ++oz) {
                        Biome biomegenbase1 = this.biomesForGeneration[ax + ox + 2 + (az + oz + 2) * 10];
                        float rootHeight = biomegenbase1.getBaseHeight();
                        float heightVariation = biomegenbase1.getHeightVariation();

                        if (this.terrainType == WorldType.AMPLIFIED && rootHeight > 0.0F) {
                            rootHeight = 1.0F + rootHeight * 2.0F;
                            heightVariation = 1.0F + heightVariation * 4.0F;
                        }

                        float heightFactor = this.biomeWeights[ox + 2 + (oz + 2) * 5] / (rootHeight + 2.0F);

                        if (biomegenbase1.getBaseHeight() > biomegenbase.getBaseHeight()) {
                            heightFactor /= 2.0F;
                        }

                        totalVariation += heightVariation * heightFactor;
                        totalHeight += rootHeight * heightFactor;
                        totalFactor += heightFactor;
                    }
                }

                totalVariation /= totalFactor;
                totalHeight /= totalFactor;
                totalVariation = totalVariation * 0.9F + 0.1F;
                totalHeight = (totalHeight * 4.0F - 1.0F) / 8.0F;
                double terrainNoise = this.depthRegion[noiseIndex] / 8000.0D;

                if (terrainNoise < 0.0D) {
                    terrainNoise = -terrainNoise * 0.3D;
                }

                terrainNoise = terrainNoise * 3.0D - 2.0D;

                if (terrainNoise < 0.0D) {
                    terrainNoise /= 2.0D;

                    if (terrainNoise < -1.0D) {
                        terrainNoise = -1.0D;
                    }

                    terrainNoise /= 1.4D;
                    terrainNoise /= 2.0D;
                } else {
                    if (terrainNoise > 1.0D) {
                        terrainNoise = 1.0D;
                    }

                    terrainNoise /= 8.0D;
                }

                ++noiseIndex;
                double heightCalc = (double) totalHeight;
                double variationCalc = (double) totalVariation;
                heightCalc += terrainNoise * 0.2D;
                heightCalc = heightCalc * 8.5D / 8.0D;
                double d5 = 8.5D + heightCalc * 4.0D;

                for (int ay = 0; ay < 33; ++ay) {
                    double d6 = ((double) ay - d5) * 12.0D * 128.0D / 256.0D / variationCalc;

                    if (d6 < 0.0D) {
                        d6 *= 4.0D;
                    }

                    double d7 = this.minLimitRegion[terrainIndex] / 512.0D;
                    double d8 = this.maxLimitRegion[terrainIndex] / 512.0D;
                    double d9 = (this.mainNoiseRegion[terrainIndex] / 10.0D + 1.0D) / 2.0D;
                    double terrainCalc = MathHelper.clampedLerp(d7, d8, d9) - d6;

                    if (ay > 29) {
                        double d11 = (double) ((float) (ay - 29) / 3.0F);
                        terrainCalc = terrainCalc * (1.0D - d11) + -10.0D * d11;
                    }

                    this.heightMap[terrainIndex] = terrainCalc;
                    ++terrainIndex;
                }
            }
        }
    }

    public void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, Biome[] biomesIn) {
        if (!net.minecraftforge.event.ForgeEventFactory.onReplaceBiomeBlocks(this, x, z, primer, this.world)) return;
        this.depthBuffer = this.surfaceNoise.getRegion(this.depthBuffer, (double)(x * 16), (double)(z * 16), 16, 16, 0.0625D, 0.0625D, 1.0D);

        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                Biome biome = biomesIn[j + i * 16];
                biome.genTerrainBlocks(this.world, this.rand, primer, x * 16 + i, z * 16 + j, this.depthBuffer[j + i * 16]);
            }
        }
    }

    @Override
    public void populate(int chunkX, int chunkZ) {
        BlockFalling.fallInstantly = true;
        int i = chunkX * 16;
        int j = chunkZ * 16;
        BlockPos blockpos = new BlockPos(i, 0, j);
        Biome biome = this.world.getBiome(blockpos.add(16, 0, 16));
        this.rand.setSeed(this.world.getSeed());
        long k = this.rand.nextLong() / 2L * 2L + 1L;
        long l = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed((long)chunkX * k + (long)chunkZ * l ^ this.world.getSeed());
        boolean flag = false;

        net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(true, this, this.world, this.rand, chunkX, chunkZ, flag);

        if (biome.decorator.generateFalls) {
            int i1 = blockpos.getX() + rand.nextInt(16) + 8;
            int i2 = rand.nextInt(256);
            int i3 = blockpos.getZ() + rand.nextInt(16) + 8;
            (new WorldGenIronLakes(BlocksIDL.metallic_water_block)).generate(world, rand, new BlockPos(i1, i2, i3));
        }

        if (rand.nextInt(16) == 0) {
            int j1 = blockpos.getX() + rand.nextInt(16) + 8;
            int j2 = rand.nextInt(rand.nextInt(256 - 8) + 8);
            int j3 = blockpos.getZ() + rand.nextInt(16) + 8;
            if (j2 < 63 || rand.nextInt(5) == 0) {
                (new WorldGenIronLakes(BlocksIDL.liquid_iron_block)).generate(world, rand, new BlockPos(j1, j2, j3));
            }
        }

        biome.decorate(this.world, this.rand, new BlockPos(i, 0, j));
        if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.rand, chunkX, chunkZ, flag, net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ANIMALS))
            WorldEntitySpawner.performWorldGenSpawning(this.world, biome, i + 8, j + 8, 16, 16, this.rand);

        net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(false, this, this.world, this.rand, chunkX, chunkZ, flag);

        BlockFalling.fallInstantly = false;
    }

    @Override
    public boolean generateStructures(Chunk chunkIn, int x, int z) {
        return false;
    }

    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
        Biome biome = world.getBiome(pos);

        return biome.getSpawnableList(creatureType);
    }

    @Nullable
    @Override
    public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored) {
        return null;
    }

    @Override
    public void recreateStructures(Chunk chunk, int var1, int var2) {

    }

    @Override
    public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
        return false;
    }
}
