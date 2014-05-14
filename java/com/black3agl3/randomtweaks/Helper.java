package com.black3agl3.randomtweaks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import org.omg.CORBA.portable.UnknownException;

import com.black3agl3.randomtweaks.item.ItemSnowBucket;

import cpw.mods.fml.common.registry.GameRegistry;

public class Helper {
	
	//Just to make my main mod class look nice and clean
	public static void preInit () {
		ItemSnowBucket snow_bucket = new ItemSnowBucket();
		register(snow_bucket);
		
		ItemStack snowBucketItemStack= new ItemStack(snow_bucket);
		
		GameRegistry.addShapelessRecipe(snowBucketItemStack, new Object[]{
			Items.bucket,
			Blocks.snow
		});
		
		GameRegistry.addSmelting(snowBucketItemStack,new ItemStack(Items.water_bucket),0);
	}
	
	public static void init () {
		//re-register any ingotAluminium to ingotAluminum
		for (ItemStack itemStack:OreDictionary.getOres("ingotAluminium")){
			int oreID = OreDictionary.getOreID(itemStack);
			String oreName = OreDictionary.getOreName(oreID);
			log(oreID+":"+oreName+" found for ingotAluminium search");
			OreDictionary.registerOre("ingotAluminum", itemStack);
		}
	}
	
	public static void postInit () {

	}
	
	
	//some random functions I plan to use to help me with stuff.
	/**Registers any object for you
	 * e.g. Block,Item 
	 * @param obj
	 */
	public static void register (Object obj) {
	
		if (obj instanceof Block) {
			Block block = (Block)obj;
			GameRegistry.registerBlock(block, unwrapUnlocalizedName(block.getUnlocalizedName()));
		} 
		else if (obj instanceof Item) {
			Item item = (Item)obj;
			GameRegistry.registerItem(item, unwrapUnlocalizedName(item.getUnlocalizedName()));
		}
		else throw new UnknownException(null);
	}
	
	private static String unwrapUnlocalizedName(String unlocalizedName){
		int startindex = unlocalizedName.indexOf('.') + 1;
		int endindex = unlocalizedName.indexOf('.', startindex);
		
		if (endindex<0) return unlocalizedName.substring(startindex);
		else return unlocalizedName.substring(startindex, endindex);
	}
	
	/**Basically outputs to console
	 * 
	 * @param str
	 */
	public static void log (String str){
		System.out.println("["+Info.MODID+"] : "+str);
	}
}
