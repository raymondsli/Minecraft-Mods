package com.camp.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class CustomEntityPassive extends EntityAnimal {

	public CustomEntityPassive(World par1World) {
		super(par1World);
		// TODO Auto-generated constructor stub
		this.setSize(1.0f, 1.0f);
		// width, height
		this.tasks.addTask(0, new EntityAISwimming(this));
		// first part is to add the task, the 0 is highest priority, and new Entity is the particular AI task
		this.tasks.addTask(1,  new EntityAITempt(this, 1.0d, Items.apple, false));
		this.tasks.addTask(2, new EntityAIPanic(this, 0.7d));
		this.tasks.addTask(3, new EntityAIWander(this,0.3d));
	}

	@Override
	public EntityAgeable createChild(EntityAgeable var1) {
		// TODO Auto-generated method stub
		return new CustomEntityPassive(worldObj);
	}
	
	protected void applyEntityAttributes() {
	super.applyEntityAttributes();
	this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0D);
	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0d);
	}
	
	public boolean isAIEnabled() {
		return true;
		// this overrides the superclass method and enables AI for this mob
	}

}
