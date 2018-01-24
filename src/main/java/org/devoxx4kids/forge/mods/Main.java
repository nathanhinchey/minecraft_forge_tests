package org.devoxx4kids.forge.mods;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Main.MODID, version = Main.VERSION, acceptableRemoteVersions = "*")
public class Main
{
    public static final String MODID = "mymods";
    public static final String VERSION = "1.0";

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		System.out.println("####### MOD IS ACTIVE: " + MODID + " #######");
		MinecraftForge.EVENT_BUS.register(new BlockBreakMessage());
	    MinecraftForge.EVENT_BUS.register(new ExplodingMinecarts());
	    MinecraftForge.EVENT_BUS.register(new CreeperReenforcements());
	    MinecraftForge.EVENT_BUS.register(new GolemClimbWall());
	    
	    
	    // Client side only mods:
	    // MinecraftForge.EVENT_BUS.register(new SuperJump());
	    // MinecraftForge.EVENT_BUS.register(new Parachutes());
	}

	@EventHandler
	public void registerCommands(FMLServerStartingEvent event) {
		event.registerServerCommand(new FlamingPigs());
	}
}
