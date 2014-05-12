package com.black3agl3.randomtweaks;

import org.omg.CORBA.portable.UnknownException;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class Helper {
	
	public static void preInit () {
	
	}
	
	public static void init () {
	
	}
	
	public static void postInit () {
	
	}
	
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
}
