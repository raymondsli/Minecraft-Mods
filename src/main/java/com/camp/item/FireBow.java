package com.camp.item;

import com.camp.entity.FireArrow;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

public class FireBow extends ItemBow {
	 public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
	    {
	        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

	        ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
	        MinecraftForge.EVENT_BUS.post(event);
	        if (event.isCanceled())
	        {
	            return;
	        }
	        j = event.charge;

	        boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

	        if (flag || par3EntityPlayer.inventory.hasItem(Items.arrow))
	        {
	            float f = (float)j / 20.0F;
	            f = (f * f + f * 2.0F) / 3.0F;

	            if ((double)f < 0.1D)
	            {
	                return;
	            }

	            if (f > 1.0F)
	            {
	                f = 1.0F;
	            }

	            EntityArrow entityarrow = new FireArrow(par2World, par3EntityPlayer, f * 2.0F);

	            if (f == 1.0F)
	            {
	                entityarrow.setIsCritical(true);
	            }

	            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

	            if (k > 0)
	            {
	                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
	            }

	            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

	            if (l > 0)
	            {
	                entityarrow.setKnockbackStrength(l);
	            }

	            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
	            {
	                entityarrow.setFire(100);
	            }

	            par1ItemStack.damageItem(1, par3EntityPlayer);
	            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

	            if (flag)
	            {
	                entityarrow.canBePickedUp = 2;
	            }
	            else
	            {
	                par3EntityPlayer.inventory.consumeInventoryItem(Items.arrow);
	            }

	            if (!par2World.isRemote)
	            {
	                par2World.spawnEntityInWorld(entityarrow);
	            }
	        }
	    }
	 
	 @SideOnly(Side.CLIENT)
	 private IIcon[] iconArray;
	 
	 @SideOnly(Side.CLIENT)
	    public void registerIcons(IIconRegister par1IconRegister)
	    {
	        this.itemIcon = par1IconRegister.registerIcon(this.getIconString() + "_standby");
	        this.iconArray = new IIcon[bowPullIconNameArray.length];

	        for (int i = 0; i < this.iconArray.length; ++i)
	        {
	            this.iconArray[i] = par1IconRegister.registerIcon(this.getIconString() + "_" + bowPullIconNameArray[i]);
	        }
	    }
	 
	 public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
		 if (player.getItemInUse() == null) {
			 return this.itemIcon;
		 }
		 int duration = stack.getMaxItemUseDuration() - useRemaining;
		 
		 if (duration < 13) {
			 return this.iconArray[0];
		 }
		 else if (duration < 17) {
			 return this.iconArray[1];
		 }
		 else {
			 return this.iconArray[2];
		 }
	 }
	 
}
