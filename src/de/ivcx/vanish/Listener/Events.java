package de.ivcx.vanish.Listener;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;

import de.ivcx.vanish.Main;
import de.ivcx.vanish.Vanish;

public class Events implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		//e.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
		Player p = e.getPlayer();
		if(Main.Vanished.contains(p.getName())) {
			e.setJoinMessage("");
			Vanish.hidePlayer(p);
		}
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if(Main.Vanished.contains(p.getName())) {
			e.setQuitMessage("");
			
		}
		
	}   

}
