package com.crypticmushroom.irondimension.registry;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.blocks.*;
import com.crypticmushroom.irondimension.world.gen.saplinggenerator.HornbeamSaplingGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.item.block.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlocksID {
    public static Block iron_dim_portal = null;
    public static Block iron_dirt = null;
    public static Block coarse_iron_dirt = null;
    public static Block scorching_dirt = null;
    public static Block iron_grass = null;
    public static Block ironwood_planks = null;
    public static Block rusty_ironwood_planks = null;
    public static Block hornbeam_planks = null;
    public static Block ironwood_log = null;
    public static Block stripped_ironwood_log = null;
    public static Block rusty_ironwood_log = null;
    public static Block stripped_rusty_ironwood_log = null;
    public static Block hornbeam_log = null;
    public static Block stripped_hornbeam_log = null;
    public static Block ironwood_leaves = null;
    public static Block rusty_ironwood_leaves = null;
    public static Block hornbeam_leaves = null;
    public static Block ironwood_sapling = null;
    public static Block rusty_ironwood_sapling = null;
    public static Block hornbeam_sapling = null;
    public static Block ironstone = null;
    public static Block chiselled_ironstone = null;
    public static Block smooth_ironstone = null;
    public static Block soft_iron = null;
    public static Block ironstone_bricks = null;
    public static Block iron_brick_stairs = null;
    public static Block super_iron_ore = null;
    public static Block super_iron_block = null;
    public static Block radioactive_iron_ore = null;
    public static Block radioactive_iron_block = null;
    public static Block infernal_iron_ore = null;
    public static Block infernal_iron_block = null;
    public static Block lumen_iron_ore = null;
    public static Block lumen_iron_block = null;

    public static Block metallic_water_block = null;
    public static Block liquid_iron_block = null;

    public static void init() {
        iron_dim_portal = register("iron_dim_portal", new BlockIronPortal());
        iron_dirt = register("iron_dirt", new BlockIronDirt());
        coarse_iron_dirt = register("coarse_iron_dirt", new BlockIronDirt());
        scorching_dirt = register("scorching_dirt", new BlockIronDirt());
        iron_grass = register("iron_grass", new BlockIronGrass());
        ironwood_planks = register("ironwood_planks", new BlockIronPlanks());
        rusty_ironwood_planks = register("rusty_ironwood_planks", new BlockIronPlanks());
        hornbeam_planks = register("hornbeam_planks", new BlockIronPlanks());
        ironwood_log = register("ironwood_log", new BlockIronLog(MaterialColor.IRON));
        stripped_ironwood_log = register("stripped_ironwood_log", new BlockIronLog(MaterialColor.IRON));
        rusty_ironwood_log = register("rusty_ironwood_log", new BlockIronLog(MaterialColor.IRON));
        stripped_rusty_ironwood_log = register("stripped_rusty_ironwood_log", new BlockIronLog(MaterialColor.IRON));
        hornbeam_log = register("hornbeam_log", new BlockIronLog(MaterialColor.BROWN));
        stripped_hornbeam_log = register("stripped_hornbeam_log", new BlockIronLog(MaterialColor.BROWN));
        ironwood_leaves = register("ironwood_leaves", new BlockIronLeaves());
        rusty_ironwood_leaves = register("rusty_ironwood_leaves", new BlockIronLeaves());
        hornbeam_leaves = register("hornbeam_leaves", new BlockIronLeaves());
        hornbeam_sapling = register("hornbeam_sapling", new BlockSapling(new HornbeamSaplingGenerator()));
        ironstone = register("ironstone", new BlockIronStone());
        chiselled_ironstone = register("chiselled_ironstone", new BlockIronStone());
        smooth_ironstone = register("smooth_ironstone", new BlockIronStone());
        soft_iron = register("soft_iron", new BlockSoftIron());
        ironstone_bricks = register("ironstone_bricks", new BlockIronBrick());
        iron_brick_stairs = register("iron_brick_stairs", new BlockIronBrickStairs(ironstone_bricks.getDefaultState()));
        super_iron_ore = register("super_iron_ore", new BlockIDLOre());
        super_iron_block = register("super_iron_block", new BlockCompact());
        radioactive_iron_ore = register("radioactive_iron_ore", new BlockIDLOre());
        radioactive_iron_block = register("radioactive_iron_block", new BlockCompact());
        infernal_iron_ore = register("infernal_iron_ore", new BlockIDLOre());
        infernal_iron_block = register("infernal_iron_block", new BlockCompact());
        lumen_iron_ore = register("lumen_iron_ore", new BlockIDLOre());
        lumen_iron_block = register("lumen_iron_block", new BlockCompact());
    }

    private static Block register(String name, Block block) {
        Registry.BLOCK.register(new Identifier(IronDimension.MODID, name), block);
        Registry.ITEM.register(new Identifier(IronDimension.MODID, name), new BlockItem(block, new Item.Settings().itemGroup(IronDimension.IDL_ITEM_GROUP)));
        return block;
    }
}
