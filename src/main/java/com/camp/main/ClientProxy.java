package com.camp.main;

import net.minecraft.client.model.ModelBiped;

import com.camp.entity.CustomEntityMob;
import com.camp.render.RenderCustomBiped;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {
	public void registerRenderThings() {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntityMob.class, new RenderCustomBiped(new ModelBiped(), 0));
		
	}
	
	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
