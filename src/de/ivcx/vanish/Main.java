package de.ivcx.vanish;

import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;

import de.ivcx.vanish.Commands.CMDvanish;
import de.ivcx.vanish.Listener.Events;
import de.ivcx.vanish.Listener.PlayerListHider;

public class Main extends JavaPlugin{
	
	private static Main instance;
	
	public static ArrayList<String> Vanished = new ArrayList<>();
	
	public void onEnable() {
		instance = this;
		SaveArray.loadVanished();
		
		getCommand("v").setExecutor(new CMDvanish());
		getCommand("vanish").setExecutor(new CMDvanish());
		
		getServer().getPluginManager().registerEvents(new Events(), this);
		getServer().getPluginManager().registerEvents(new PlayerListHider(), this);
		
		initConfig();
		//startActionBarRotation();
		
	}
	
	public void onDisable() {
		SaveArray.saveVanished();
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	public void initConfig(){
		this.reloadConfig();			
		this.getConfig().addDefault("Vanish.System.Prefix", "&eVanish &8>");
		this.getConfig().addDefault("Vanish.User.Suffix", "&8[&eV&8]");
		this.getConfig().addDefault("Vanish.Settings.Particles", true);
		this.getConfig().addDefault("Vanish.Settings.EnableSuffix", true);
		this.getConfig().addDefault("Vanish.Permissions.Use", "Vanish.use");
		this.getConfig().addDefault("Vanish.Permissions.UseOnOthers", "Vanish.others");
		this.getConfig().addDefault("Vanish.Permissions.SeeVanished", "Vanish.seeOthers");
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		System.out.println("[ServerSystem] config.yml succesfully (re)loaded");
    }
}