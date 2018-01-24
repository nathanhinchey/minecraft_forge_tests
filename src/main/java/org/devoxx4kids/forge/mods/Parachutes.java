package org.devoxx4kids.forge.mods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class Parachutes {
	@SubscribeEvent
	public void deployParachute(PlayerTickEvent event)
	{

		EntityPlayer player = event.player;
		if (player.onGround)
		{
			return;
		}

		player.motionY = 0.05;
		System.out.println("####### Player fall speed: " + player.motionY + " #######");
	}
}
