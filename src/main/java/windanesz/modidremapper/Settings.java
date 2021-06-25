package windanesz.modidremapper;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = ModIDRemapper.MODID, name = "ModIDRemapper") // No fancy configs here so we can use the annotation, hurrah!
public class Settings {

	@SuppressWarnings("unused")
	@Mod.EventBusSubscriber(modid = ModIDRemapper.MODID)
	private static class EventHandler {
		/**
		 * Inject the new values and save to the config file when the config has been changed from the GUI.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(ModIDRemapper.MODID)) {
				ConfigManager.sync(ModIDRemapper.MODID, Config.Type.INSTANCE);
			}
		}
	}

	@Config.Name("Settings")
	@Config.LangKey("settings.modidremapper:settings")
	public static GeneralSettings settings = new GeneralSettings();

	public static class GeneralSettings {

		@Config.Name("Old Mod ID")
		@Config.Comment("The old modId which needs to be replaced")
		public String old_mod_id  = "placeholder_old";

		@Config.Name("New Mod ID")
		@Config.Comment("The new modId which will replace anything registered with the modId specified in the 'Old Mod ID' setting")
		public String new_mod_id  = "placeholder_new";
	}
}
