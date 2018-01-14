package org.devoxx4kids.forge.mods;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = MainMod.MODID, version = MainMod.VERSION)
public class MainMod {
	public static final String MODID = "myMods";
	public static final String VERSION = "1.0";

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		System.out.println("bazooka (ORIGINAL)");
		MinecraftForge.EVENT_BUS.register(new BlockBreakMessage());
	}
}
