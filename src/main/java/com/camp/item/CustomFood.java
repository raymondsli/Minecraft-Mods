package com.camp.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class CustomFood extends ItemFood {

	public CustomFood(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
		// TODO Auto-generated constructor stub
		this.setAlwaysEdible();
	}
	
	@Override
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		super.onFoodEaten(stack, world, player);
		if(!world.isRemote) {
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 100, 2));
		}
	}

}
