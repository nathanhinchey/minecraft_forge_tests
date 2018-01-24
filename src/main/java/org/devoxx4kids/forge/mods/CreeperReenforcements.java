package org.devoxx4kids.forge.mods;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CreeperReenforcements {
	public final static int CREEPER_COUNT = 2;

	@SubscribeEvent
	public void spawnReinforcements(LivingDeathEvent event){
		
		if (!(event.getEntity() instanceof EntityCreeper)) {
			return;
		}

		for (int i = 0 ; i < CREEPER_COUNT ; i++) {
			EntityCreeper creeper = new EntityCreeper(event.getEntity().world);
			creeper.setLocationAndAngles(event.getEntity().posX,
				event.getEntity().posY,
				event.getEntity().posZ,
				0,
				0);
			if (!event.getEntity().world.isRemote) {
				event.getEntity().world.spawnEntity(creeper);
			}
		}
	}
}
