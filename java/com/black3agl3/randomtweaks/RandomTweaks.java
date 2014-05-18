package com.black3agl3.randomtweaks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(
		modid = Info.MODID,
		name = Info.NAME,
		version = Info.VERSION,
		dependencies = Info.DEPENDENCIES)
public class RandomTweaks {
	
	@EventHandler
	public void PreInit (FMLPreInitializationEvent event) {
	
		Helper.preInit();
		System.out.println(Info.MODID + " : PreInit done");
	}
	
	@EventHandler
	public void init (FMLInitializationEvent event) {
	
		Helper.init();
		System.out.println(Info.MODID + " : Init done");
	}
	
	@EventHandler
	public void PostInit (FMLPostInitializationEvent event) {
	
		Helper.postInit();
		System.out.println(Info.MODID + " : PostInit done");
	}
}
