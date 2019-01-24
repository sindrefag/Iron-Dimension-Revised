package com.crypticmushroom.irondimension.blocks;

import com.crypticmushroom.irondimension.registry.BlocksIDL;
import net.fabricmc.fabric.block.FabricBlockSettings;
import net.fabricmc.fabric.tags.FabricItemTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.loot.context.LootContext;

import java.util.List;
import java.util.Random;

public class BlockIronGrass extends Block {
    public BlockIronGrass() {
        super(FabricBlockSettings
                .of(Material.PLANT, MaterialColor.LIGHT_GRAY)
                .breakByTool(FabricItemTags.SHOVELS, 2)
                .sounds(BlockSoundGroup.GRASS)
                .hardness(0.5F)
                .ticksRandomly()
                .build());
    }

    @Override
    public void randomDisplayTick(BlockState blockState_1, World world, BlockPos pos, Random rand) {
        if (!world.isClient)
            if (world.getLightLevel(LightType.BLOCK_LIGHT,pos.up()) < 4 && world.getBlockState(pos.up()).getBlock().getLightSubtracted(world.getBlockState(pos.up()), world, pos.up()) > 2)
                world.setBlockState(pos, BlocksIDL.iron_dirt.getDefaultState());
            else if (world.getLightLevel(LightType.BLOCK_LIGHT,pos.up()) >= 9)
                for (int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
                    Block block = world.getBlockState(blockpos.up()).getBlock();
                    BlockState iblockstate = world.getBlockState(blockpos);

                    if (iblockstate.getBlock() == BlocksIDL.iron_dirt && world.getLightLevel(LightType.BLOCK_LIGHT,blockpos.up()) >= 4 && block.getLightSubtracted(world.getBlockState(blockpos.up()), world, blockpos.up()) <= 2)
                        world.setBlockState(blockpos, BlocksIDL.iron_grass.getDefaultState());
                }
    }
}
