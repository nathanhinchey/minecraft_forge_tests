package example.bedrockminertutorials;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, version = Main.VERSION, acceptableRemoteVersions = "*")
public class Main {
	public static final String MODID = "bedrockminertutorials";
	public static final String VERSION = "0.0";

	@EventHandler
	public void init(FMLInitializationEvent e) {
		System.out.println("####### MOD bedrockminertutorials ACTICE #######");
		
		GameRegistry.registerWorldGenerator(new TutorialWorldGen(), 0);
	}
}
