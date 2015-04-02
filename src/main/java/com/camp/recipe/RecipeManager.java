package com.camp.recipe;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeManager {
	
	public static void mainRegistry() {
		addCraftingRecipes();
		addSmeltingRecipes();
	}
	
	public static void addCraftingRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 64), Blocks.dirt);
		GameRegistry.addShapedRecipe(new ItemStack(Items.book), "xy", "yx", 'x', Blocks.stone, 'y', Blocks.gravel);
		GameRegistry.addShapedRecipe(new ItemStack(Items.carrot), "xyx", "y y", "xyx", 'x', Blocks.stone, 'y', Blocks.gravel);
	}
	
	public static void addSmeltingRecipes() {
		GameRegistry.addSmelting(new ItemStack(Blocks.bookshelf), new ItemStack(Items.baked_potato), 0.1f);
	}

}
