package de.ivcx.vanish;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Vanish {
	
	
	
	//control logic for show and hide functions
	public static void toggleVanish (Player sender, Player target) {
		Player t = (Player)target;
		Player s = (Player)sender;
		if(Main.Vanished.contains(t.getName())) {
			Main.Vanished.remove(t.getName());
			s.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Vanish.System.Prefix")) + " §7Unvanished §3" + t.getName()); //debug
			//t.sendTitle("§eVanish", "§cDeactivated");
			showPlayer(t);
		} else {
			Main.Vanished.add(t.getName());
			s.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Vanish.System.Prefix")) + " §7Vanished §3" + t.getName()); //debug
			//t.sendTitle("§eVanish", "§aActivated");
			hidePlayer(t);
		}
		if(Main.getInstance().getConfig().getBoolean("Vanish.Settings.Particles") == true) {playVisuals(t);}
	}
	
	public static void showPlayer (Player player) {
		Player t = (Player)player;
		for (Player all : Bukkit.getOnlinePlayers()) {
			all.showPlayer(t);
		}
		if(Main.getInstance().getConfig().getBoolean("Vanish.Settings.EnableSuffix") == true) {Scoreboards.removeSuffix(t);}
		
	}
	
	public static void hidePlayer (Player player) {
		Player t = (Player)player;
		for (Player all : Bukkit.getOnlinePlayers()) {
			all.hidePlayer(t);
			if (all.hasPermission(Main.getInstance().getConfig().getString("Vanish.Permissions.SeeVanished"))) {
				all.showPlayer(t);
			}
			if(Main.getInstance().getConfig().getBoolean("Vanish.Settings.EnableSuffix") == true) {Scoreboards.addSuffix(t);}
		}
		
		
		
	}
	
	//helper classes
	//will maybe be used later on again
	private static int getPlayerLevel(Player player) {
		Player p = (Player)player;
	    if (p.hasPermission(Main.getInstance().getConfig().getString("Vanish.Permissions.Level5"))) return 5;
	    if (p.hasPermission(Main.getInstance().getConfig().getString("Vanish.Permissions.Level4"))) return 4;
	    if (p.hasPermission(Main.getInstance().getConfig().getString("Vanish.Permissions.Level3"))) return 3;
	    if (p.hasPermission(Main.getInstance().getConfig().getString("Vanish.Permissions.Level2"))) return 2;
	    if (p.hasPermission(Main.getInstance().getConfig().getString("Vanish.Permissions.Level1"))) return 1;
	    return 0;
	}
	private static void playVisuals (Player player) {
		Player t = (Player)player;
		for(int i=0;i<=5;i++){
			t.getWorld().playEffect(t.getLocation(), Effect.ENDER_SIGNAL, 0);
		}
	}
	
	
	

}
