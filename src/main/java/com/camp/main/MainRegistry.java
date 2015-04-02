package com.camp.main;

import com.camp.block.BlockManager;
import com.camp.creativetabs.CreativeTabsManager;
import com.camp.entity.EntityManager;
import com.camp.item.ItemManager;
import com.camp.lib.StringLibrary;
import com.camp.recipe.RecipeManager;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = StringLibrary.MODID, name = StringLibrary.name, version = StringLibrary.version)

public class MainRegistry {

@SidedProxy(clientSide = "com.camp.main.ClientProxy", serverSide = "com.camp.main.ServerProxy")
public static ClientProxy proxy;	

@EventHandler
	public static void PreLoad(FMLPreInitializationEvent PreEvent) {
		CreativeTabsManager.mainRegistry();
		BlockManager.mainRegistry();
		ItemManager.mainRegistry();
		proxy.registerRenderThings();
		EntityManager.mainRegistry();
		RecipeManager.mainRegistry();
	}
	
	@EventHandler
	public static void Load(FMLInitializationEvent Event) {
		
	}
	
	@EventHandler
	public static void PostLoad(FMLPostInitializationEvent PostEvent) {
		
	}
	
}
