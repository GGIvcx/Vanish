package de.ivcx.vanish.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;
import de.ivcx.vanish.Main;
import de.ivcx.vanish.Vanish;

public class CMDvanish implements CommandExecutor{
	
	public boolean onCommand (CommandSender sender, Command cmd, String labels, String[] args) {
		if(cmd.getName().equalsIgnoreCase("v")||cmd.getName().equalsIgnoreCase("vanish")) {
			if (sender instanceof Player) {
				Player p = (Player)sender;
				if(args.length == 0 && p.hasPermission(Main.getInstance().getConfig().getString("Vanish.Permissions.Use"))){
					Vanish.toggleVanish(p, p); //toggle yourself
				} else if(args.length == 1 && p.hasPermission(Main.getInstance().getConfig().getString("Vanish.Permissions.UseOnOthers"))){
						if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?")) {
							p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Vanish.System.Prefix")) + " §7Toggle with §e/vanish §7for yourself");
							p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Vanish.System.Prefix")) + " §7Toggle with §e/vanish (Player) §7for others");
						} else {
							Player target = Bukkit.getPlayer(args[0]);
							if(target != null){
								Vanish.toggleVanish(p, target); //toggle other
							} else {p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Vanish.System.Prefix")) + " §cNot a real player");}
						}
				} else { 
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Vanish.System.Prefix")) + " §cIncorrect use");
				}
				 
			}
				
				
		}
		return false;
	}
}
