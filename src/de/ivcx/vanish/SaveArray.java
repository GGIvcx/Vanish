package de.ivcx.vanish;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SaveArray extends JavaPlugin{
	
	private static final File listFile;
	private static final YamlConfiguration config;
	static {
		listFile = new File("plugins" + File.separator + "Vanish" + File.separator + "vanished.yml");
		config = YamlConfiguration.loadConfiguration(listFile);
	}
	private static Logger log = Bukkit.getLogger();
	
	public static void saveVanished(){
		config.set("vanished.Players", Main.Vanished);
		try {
			config.save(listFile);
		} catch (IOException e) {
			log.severe("Failed to save file '" + listFile.getName() + "'");
			e.printStackTrace();
		}
	}
	public static void loadVanished(){
		Main.Vanished = (ArrayList<String>) config.getStringList("vanished.Players");
		
	}
}
