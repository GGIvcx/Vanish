package de.ivcx.vanish;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import net.md_5.bungee.api.ChatColor;

public class Scoreboards {
	
	public static void addSuffix(Player player) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        String teamName = "suffix_" + player.getName();
        
        Team team = scoreboard.getTeam(teamName);
        if (team != null) {
            team.unregister();
        }
        
        team = scoreboard.registerNewTeam(teamName);
        team.setSuffix(" " + ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Vanish.User.Suffix")));
        team.addEntry(player.getName());
        
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.setScoreboard(scoreboard);
        }
    }
	
	public static void removeSuffix(Player player) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        String teamName = "suffix_" + player.getName();
        
        Team team = scoreboard.getTeam(teamName);
        if (team != null) {
            team.unregister();
        }
        
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.setScoreboard(scoreboard);
        }
    }

}
