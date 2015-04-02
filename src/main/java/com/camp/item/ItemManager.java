package com.camp.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.common.util.EnumHelper;

import com.camp.block.BlockManager;
import com.camp.lib.StringLibrary;
import com.camp.main.MainRegistry;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemManager {
	public static void mainRegistry() {
		initializeItem();
		registerItem();
	}
	
	public static Item customItem;
	
	public static Item customFood;
	
	public static Item customPickaxe;
	public static Item customAxe;
	public static Item customSword;
	public static Item customHoe;
	public static Item customSpade;
	public static ToolMaterial customToolMaterial = EnumHelper.addToolMaterial("Custom Tool Material", 3, 5, 15.0F, 4.0F, 25);
	
	public static Item customSeeds;
	public static Item customItemCrops;
	
	public static Item customHelmet;
	public static Item customChestplate;
	public static Item customLeggings;
	public static Item customBoots;
	public static ArmorMaterial customArmorMaterial = EnumHelper.addArmorMaterial("CustomArmorMaterial", 66, new int[]{6, 16, 12, 6}, 20);
	
	public static Item fireBow;
	
	public static void initializeItem() {
		customItem = new CustomItem();
		
		customPickaxe = new CustomPickaxe(customToolMaterial).setUnlocalizedName("CustomPickaxe").setCreativeTab(CreativeTabs.tabTools).setTextureName(StringLibrary.MODID + ":custom_pickaxe");
		customAxe = new CustomAxe(customToolMaterial).setUnlocalizedName("CustomAxe").setCreativeTab(CreativeTabs.tabTools).setTextureName(StringLibrary.MODID + ":custom_axe");
		customSword = new CustomSword(customToolMaterial).setUnlocalizedName("CustomSword").setCreativeTab(CreativeTabs.tabCombat).setTextureName(StringLibrary.MODID + ":custom_sword");
		customHoe = new CustomHoe(customToolMaterial).setUnlocalizedName("CustomHoe").setCreativeTab(CreativeTabs.tabTools).setTextureName(StringLibrary.MODID + ":custom_hoe");
		customSpade = new CustomSpade(customToolMaterial).setUnlocalizedName("CustomSpade").setCreativeTab(CreativeTabs.tabTools).setTextureName(StringLibrary.MODID + ":custom_spade");
		
		customFood = new CustomFood(8, 0.6F, false).setUnlocalizedName("CustomFood").setCreativeTab(CreativeTabs.tabMisc).setTextureName(StringLibrary.MODID + ":custom_food");
		customSeeds = new ItemSeeds(BlockManager.customBlockCrops, Blocks.farmland).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("CustomSeeds").setTextureName(StringLibrary.MODID + ":custom_seeds");
		customItemCrops = new Item().setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("CustomItemCrops").setTextureName(StringLibrary.MODID + ":custom_item_crops");
		
		customHelmet = new CustomArmor(customArmorMaterial, MainRegistry.proxy.addArmor("CustomHelmet"), 0).setUnlocalizedName("CustomHelmet").setCreativeTab(CreativeTabs.tabCombat).setTextureName(StringLibrary.MODID + ":custom_helmet");
		customChestplate = new CustomArmor(customArmorMaterial, MainRegistry.proxy.addArmor("CustomChestplate"), 1).setUnlocalizedName("CustomChestplate").setCreativeTab(CreativeTabs.tabCombat).setTextureName(StringLibrary.MODID + ":custom_chestplate");
		customLeggings = new CustomArmor(customArmorMaterial, MainRegistry.proxy.addArmor("CustomLeggings"), 2).setUnlocalizedName("CustomLeggings").setCreativeTab(CreativeTabs.tabCombat).setTextureName(StringLibrary.MODID + ":custom_leggings");
		customBoots = new CustomArmor(customArmorMaterial, MainRegistry.proxy.addArmor("CustomBoots"), 3).setUnlocalizedName("CustomBoots").setCreativeTab(CreativeTabs.tabCombat).setTextureName(StringLibrary.MODID + ":custom_boots");
	
		fireBow = new FireBow().setUnlocalizedName("FireBow").setCreativeTab(CreativeTabs.tabCombat).setTextureName(StringLibrary.MODID + ":fire_bow");
	}
	
	public static void registerItem() {
		GameRegistry.registerItem(customItem, customItem.getUnlocalizedName());
		
		GameRegistry.registerItem(customPickaxe, customPickaxe.getUnlocalizedName());
		GameRegistry.registerItem(customAxe, customAxe.getUnlocalizedName());
		GameRegistry.registerItem(customSword, customSword.getUnlocalizedName());
		GameRegistry.registerItem(customHoe, customHoe.getUnlocalizedName());
		GameRegistry.registerItem(customSpade, customSpade.getUnlocalizedName());
		
		GameRegistry.registerItem(customFood, customFood.getUnlocalizedName());
		GameRegistry.registerItem(customSeeds, customSeeds.getUnlocalizedName());
		GameRegistry.registerItem(customItemCrops, customItemCrops.getUnlocalizedName());
		
		GameRegistry.registerItem(customHelmet, customHelmet.getUnlocalizedName());
		GameRegistry.registerItem(customChestplate, customChestplate.getUnlocalizedName());
		GameRegistry.registerItem(customLeggings, customLeggings.getUnlocalizedName());
		GameRegistry.registerItem(customBoots, customBoots.getUnlocalizedName());
	
		GameRegistry.registerItem(fireBow, fireBow.getUnlocalizedName());
	}
}
