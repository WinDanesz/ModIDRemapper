package windanesz.modidremapper;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@Mod.EventBusSubscriber
public class MissingEventHandler {

	@SubscribeEvent
	public static void onMissingBlock(RegistryEvent.MissingMappings<Block> event) {
		for (RegistryEvent.MissingMappings.Mapping<Block> mapping : event.getAllMappings()) {
			if (mapping.key.getNamespace().equals(Settings.settings.old_mod_id)) {
				String resource = mapping.key.toString();

				if (ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Settings.settings.new_mod_id, mapping.key.getPath())) != null) {
					Block target = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Settings.settings.new_mod_id, mapping.key.getPath()));
					mapping.remap(target);
					ModIDRemapper.logger.info("Successfully remapped " + resource + " to " + target.getRegistryName().toString());
				} else {
					ModIDRemapper.logger.warn("Couldn't remap " + resource + " because no equivalent was found in the registry under the " + Settings.settings.new_mod_id + " namespace.");
				}
			}
		}
	}

	@SubscribeEvent
	public static void onMissingItem(RegistryEvent.MissingMappings<Item> event) {
		for (RegistryEvent.MissingMappings.Mapping<Item> mapping : event.getAllMappings()) {
			if (mapping.key.getNamespace().equals(Settings.settings.old_mod_id)) {
				String resource = mapping.key.toString();

				if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(Settings.settings.new_mod_id, mapping.key.getPath())) != null) {
					Item target = ForgeRegistries.ITEMS.getValue(new ResourceLocation(Settings.settings.new_mod_id, mapping.key.getPath()));
					mapping.remap(target);
					ModIDRemapper.logger.info("Successfully remapped " + resource + " to " + target.getRegistryName().toString());
				} else {
					ModIDRemapper.logger.warn("Couldn't remap " + resource + " because no equivalent was found in the registry under the " + Settings.settings.new_mod_id + " namespace.");
				}
			}
		}
	}

	@SubscribeEvent
	public static void onMissingPotion(RegistryEvent.MissingMappings<Potion> event) {
		for (RegistryEvent.MissingMappings.Mapping<Potion> mapping : event.getAllMappings()) {
			if (mapping.key.getNamespace().equals(Settings.settings.old_mod_id)) {
				String resource = mapping.key.toString();

				if (ForgeRegistries.POTIONS.getValue(new ResourceLocation(Settings.settings.new_mod_id, mapping.key.getPath())) != null) {
					Potion target = ForgeRegistries.POTIONS.getValue(new ResourceLocation(Settings.settings.new_mod_id, mapping.key.getPath()));
					mapping.remap(target);
					ModIDRemapper.logger.info("Successfully remapped " + resource + " to " + target.getRegistryName().toString());
				} else {
					ModIDRemapper.logger.warn("Couldn't remap " + resource + " because no equivalent was found in the registry under the " + Settings.settings.new_mod_id + " namespace.");
				}
			}
		}
	}

	@SubscribeEvent
	public static void onMissingEntityEntry(RegistryEvent.MissingMappings<EntityEntry> event) {
		for (RegistryEvent.MissingMappings.Mapping<EntityEntry> mapping : event.getAllMappings()) {
			if (mapping.key.getNamespace().equals(Settings.settings.old_mod_id)) {
				String resource = mapping.key.toString();

				if (ForgeRegistries.ENTITIES.getValue(new ResourceLocation(Settings.settings.new_mod_id, mapping.key.getPath())) != null) {
					EntityEntry target = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(Settings.settings.new_mod_id, mapping.key.getPath()));
					mapping.remap(target);
					ModIDRemapper.logger.info("Successfully remapped " + resource + " to " + target.getRegistryName().toString());
				} else {
					ModIDRemapper.logger.warn("Couldn't remap " + resource + " because no equivalent was found in the registry under the " + Settings.settings.new_mod_id + " namespace.");
				}
			}
		}
	}

	@SubscribeEvent
	public static void onMissingBiome(RegistryEvent.MissingMappings<Biome> event) {
		for (RegistryEvent.MissingMappings.Mapping<Biome> mapping : event.getAllMappings()) {
			if (mapping.key.getNamespace().equals(Settings.settings.old_mod_id)) {
				String resource = mapping.key.toString();

				if (ForgeRegistries.BIOMES.getValue(new ResourceLocation(Settings.settings.new_mod_id, mapping.key.getPath())) != null) {
					Biome target = ForgeRegistries.BIOMES.getValue(new ResourceLocation(Settings.settings.new_mod_id, mapping.key.getPath()));
					mapping.remap(target);
					ModIDRemapper.logger.info("Successfully remapped " + resource + " to " + target.getRegistryName().toString());
				} else {
					ModIDRemapper.logger.warn("Couldn't remap " + resource + " because no equivalent was found in the registry under the " + Settings.settings.new_mod_id + " namespace.");
				}
			}
		}
	}

}
