package com.camp.block;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

import com.camp.item.ItemManager;

public class CustomBlockCrops extends BlockCrops {
// Returns the Item used to plant this crop 
	protected Item func_149866_i() {
		return ItemManager.customSeeds;
	}
// Returns the Item dropped when the plant is harvested
	protected Item func_149865_P() {
		return ItemManager.customItemCrops;
	}
}
