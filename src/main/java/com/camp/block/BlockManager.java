package com.camp.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import com.camp.lib.StringLibrary;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockManager {
	
	public static void mainRegistry() {
		initializeBlock();
		registerBlock();
	}

	public static Block customBlock;
	public static Block customBlockCrops;
	
	public static void initializeBlock() {
		customBlock = new CustomBlock(Material.rock);
		customBlockCrops = new CustomBlockCrops().setCreativeTab(CreativeTabs.tabBlock).setBlockName("CustomBlockCrops").setBlockTextureName(StringLibrary.MODID +":custom_block_crops");
	}
	
	public static void registerBlock() {
		GameRegistry.registerBlock(customBlock, customBlock.getUnlocalizedName());
		GameRegistry.registerBlock(customBlockCrops, customBlockCrops.getUnlocalizedName());
	}
}
