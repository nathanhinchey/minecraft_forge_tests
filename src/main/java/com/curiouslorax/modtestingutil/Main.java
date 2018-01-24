package com.curiouslorax.modtestingutil;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Main.MODID, version = Main.VERSION, acceptableRemoteVersions = "*")
public class Main {
	public static final String MODID = "modtestingutil";
	public static final String VERSION = "0.0";

	@EventHandler
	public void init(FMLInitializationEvent e) {
		System.out.println("####### MOD modtestingutil ACTIVE #######");
	}
	
	@EventHandler
	public void registerCommands(FMLServerStartingEvent event) {
		event.registerServerCommand(new RandomTeleport());
	}
}