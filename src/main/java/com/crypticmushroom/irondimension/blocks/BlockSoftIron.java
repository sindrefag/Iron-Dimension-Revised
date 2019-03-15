package com.crypticmushroom.irondimension.blocks;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tag.FabricItemTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlockSoftIron extends Block {
    public BlockSoftIron() {
        super(FabricBlockSettings
                .of(Material.STONE, MaterialColor.LIGHT_GRAY)
                .breakByTool(FabricItemTags.PICKAXES, 2)
                .sounds(BlockSoundGroup.STONE)
                .hardness(1.5F)
                .resistance(10.0F)
                .build());
    }
}
