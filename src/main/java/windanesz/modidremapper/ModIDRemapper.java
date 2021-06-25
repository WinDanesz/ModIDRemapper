package windanesz.modidremapper;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod(modid = ModIDRemapper.MODID, name = ModIDRemapper.NAME, version = ModIDRemapper.VERSION, acceptedMinecraftVersions = ModIDRemapper.MC_VERSION)
public class ModIDRemapper {

	public static final String MODID = "modidremapper";
	public static final String NAME = "Mod ID Remapper";
	public static final String VERSION = "1.0.0";
	public static final String MC_VERSION = "[1.12.2]";

	public static final Random randClientProxy = new Random();

	/**
	 * Static instance of the {@link Settings} object for Modid Remapper.
	 */
	public static Settings settings = new Settings();

	public static Logger logger;

	@Mod.Instance(ModIDRemapper.MODID)
	public static ModIDRemapper instance;

	// Location of the proxy code, used by Forge.
	@SidedProxy(clientSide = "windanesz.modidremapper.ClientProxy", serverSide = "windanesz.modidremapper.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		settings = new Settings();

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(instance); // Since there's already an instance we might as well use it
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {}

}
