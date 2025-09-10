package de.ivcx.vanish.Listener;

import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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
	@EventHandler
	public void onPickup(EntityPickupItemEvent e) {
		if(Main.getInstance().getConfig().getBoolean("Vanish.Settings.EnableItemPickup") == false && Main.Vanished.contains(e.getEntity().getName())) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onTarget(EntityTargetLivingEntityEvent e) {
		if(Main.getInstance().getConfig().getBoolean("Vanish.Settings.EnableMobTarget") == false && Main.Vanished.contains(e.getTarget().getName())) {
			e.setTarget(null);
		}
	}
	
	

}
