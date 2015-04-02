package com.camp.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class FireArrow extends EntityArrow {

	public FireArrow(World par1World, EntityLivingBase par2EntityLivingBase,
			float par3) {
		super(par1World, par2EntityLivingBase, par3);
		// TODO Auto-generated constructor stub
		this.setFire(10);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		if(this.isBurning()) {
			this.worldObj.setBlock((int) this.posX, (int) this.posY, (int) this.posZ, Blocks.fire);
		}
	}

}
