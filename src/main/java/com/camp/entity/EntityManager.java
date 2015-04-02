package com.camp.entity;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityManager {
	public static void mainRegistry() {
		registerEntity();
		spawnEntity();
	}
	
	public static void spawnEntity() {
		addSpawn(CustomEntityPassive.class, 100, 1, 5, EnumCreatureType.creature);
		addSpawn(CustomEntityMob.class, 1000, 1, 5, EnumCreatureType.monster);
	}
	
	public static void addSpawn(Class entityClass, int probability, int min, int max, EnumCreatureType type) {
		for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++) {
			if (BiomeGenBase.getBiomeGenArray()[i] != null) {
				EntityRegistry.addSpawn(entityClass, probability, min, max, type, BiomeGenBase.getBiomeGenArray()[i]);
			}
		}
	}
	
	public static void registerEntity() {
		createEntity(CustomEntityMob.class, "CustomEntityMob", 0x00FF00, 0xFF0000);
		createEntity(CustomEntityPassive.class, "CustomEntityPassive", 0x00FFFF, 0xFF00FF);
	}
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor) {
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, entityId);
		EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, solidColor, spotColor));
	}
	
}
