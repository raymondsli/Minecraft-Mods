package com.camp.item;

import net.minecraft.item.Item;

import com.camp.creativetabs.CreativeTabsManager;
import com.camp.lib.StringLibrary;

public class CustomItem extends Item {

	public CustomItem() {
		this.setUnlocalizedName("CustomItem");
		this.setCreativeTab(CreativeTabsManager.tabItem);
		this.setMaxDamage(500);
		this.setMaxStackSize(60);
		this.setTextureName(StringLibrary.MODID + ":custom_item");
	}
	
}
