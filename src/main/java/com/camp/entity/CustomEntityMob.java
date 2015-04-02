package com.camp.entity;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.camp.block.BlockManager;
import com.camp.item.ItemManager;

public class CustomEntityMob extends EntityMob {

	@Override
	public void dropFewItems(boolean recentlyHit, int lootlevel)  
	{
		int quantity = this.rand.nextInt(4) + 1;
		for (int i = 0; i<quantity; i++) 
		{
			if (this.isBurning()) 
			{
				this.dropItem(ItemManager.customItem, 1);
			}
			else 
			{
				Item drop = Item.getItemFromBlock(BlockManager.customBlock);
				this.dropItem(drop, 1);
			}
		}
	}
	
	@Override
	public void dropRareDrop(int par1)
	{
		this.dropItem(Items.golden_apple, 1);
	}
	
	public CustomEntityMob(World par1World) {
		super(par1World);
		// TODO Auto-generated constructor stub
	}

}
