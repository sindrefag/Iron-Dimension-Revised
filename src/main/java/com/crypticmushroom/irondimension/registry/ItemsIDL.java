package com.crypticmushroom.irondimension.registry;

import com.crypticmushroom.irondimension.items.ItemArmor;
import com.crypticmushroom.irondimension.items.ItemIDLGeneric;
import com.crypticmushroom.irondimension.utils.materials.ArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;

public class ItemsIDL {

    public static Item iron_stick = null;
    public static Item iron_charcoal = null;
    public static Item iron_silk = null;
    public static Item radioactive_iron_silk = null;
    public static Item super_iron_ingot = null;
    public static Item radioactive_iron_ingot = null;
    public static Item radioactive_iron_nugget = null;
    public static Item fervid_iron_ingot = null;
    public static Item frozen_iron_ingot = null;
    public static Item lumen_iron_nugget = null;
    public static Item ultra_iron_ingot = null;

    public static Item super_iron_sword = null;
    public static Item super_iron_pickaxe = null;
    public static Item super_iron_axe = null;
    public static Item super_iron_shovel = null;
    public static Item super_iron_hoe = null;
    public static Item radioactive_sword = null;
    public static Item radioactive_pickaxe = null;
    public static Item radioactive_axe = null;
    public static Item radioactive_shovel = null;
    public static Item radioactive_hoe = null;
    public static Item iron_flint_and_steel = null;

    public static Item super_iron_helmet = null;
    public static Item super_iron_chestplate = null;
    public static Item super_iron_legs = null;
    public static Item super_iron_boots = null;
    public static Item radioactive_iron_helmet = null;
    public static Item radioactive_iron_chestplate = null;
    public static Item radioactive_iron_legs = null;
    public static Item radioactive_iron_boots = null;

    public static void init() {
        iron_stick = new ItemIDLGeneric("iron_stick");
        iron_charcoal = new ItemIDLGeneric("iron_charcoal");
        iron_silk = new ItemIDLGeneric("iron_silk");
        radioactive_iron_silk = new ItemIDLGeneric("radioactive_iron_silk");
        radioactive_iron_nugget = new ItemIDLGeneric("radioactive_iron_nugget");
        fervid_iron_ingot = new ItemIDLGeneric("fervid_iron_ingot");
        frozen_iron_ingot = new ItemIDLGeneric("frozen_iron_ingot");
        lumen_iron_nugget = new ItemIDLGeneric("lumen_iron_nugget");
        ultra_iron_ingot = new ItemIDLGeneric("ultra_iron_ingot");

        super_iron_helmet = new ItemArmor("super_iron_helmet",ArmorMaterial.SUPER_IRON, EquipmentSlot.HEAD);
        super_iron_chestplate = new ItemArmor("super_iron_chestplate",ArmorMaterial.SUPER_IRON, EquipmentSlot.CHEST);
        super_iron_legs = new ItemArmor("super_iron_legs",ArmorMaterial.SUPER_IRON, EquipmentSlot.LEGS);
        super_iron_boots = new ItemArmor("super_iron_boots",ArmorMaterial.SUPER_IRON, EquipmentSlot.FEET);
        radioactive_iron_helmet = new ItemArmor("radioactive_iron_helmet",ArmorMaterial.RADIOACTIVE, EquipmentSlot.HEAD);
        radioactive_iron_chestplate = new ItemArmor("radioactive_iron_chestplate",ArmorMaterial.RADIOACTIVE, EquipmentSlot.CHEST);
        radioactive_iron_legs = new ItemArmor("radioactive_iron_legs",ArmorMaterial.RADIOACTIVE, EquipmentSlot.LEGS);
        radioactive_iron_boots = new ItemArmor("radioactive_iron_boots",ArmorMaterial.RADIOACTIVE, EquipmentSlot.FEET);
    }
}
