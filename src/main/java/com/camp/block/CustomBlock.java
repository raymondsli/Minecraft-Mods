package com.camp.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import com.camp.creativetabs.CreativeTabsManager;
import com.camp.item.ItemManager;
import com.camp.lib.StringLibrary;

public class CustomBlock extends Block {

	protected CustomBlock(Material p_i45394_1_) {
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
		this.setBlockName("CustomBlock");
		this.setCreativeTab(CreativeTabsManager.tabBlock);
		this.setLightLevel((float) 1.0);
		this.setHardness((float) 1.0);
		this.setResistance((float) 10.0);
		this.setBlockTextureName(StringLibrary.MODID + ":custom_block");
	}
		
	@Override
	public int quantityDropped(Random rand){
		return rand.nextInt(3) + 1;
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_){
		return ItemManager.customItem;
	}

}




