package com.black3agl3.randomtweaks.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemSnowBucket extends Item {
	
	public ItemSnowBucket() {
	
		super();
		setUnlocalizedName("itemSnowBucket");
		setTextureName("randomtweaks:bucket_snow");
		setCreativeTab(CreativeTabs.tabMisc);
		setMaxStackSize(1);
	}
}
