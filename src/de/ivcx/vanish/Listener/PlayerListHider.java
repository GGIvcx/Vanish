package de.ivcx.vanish.Listener;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class PlayerListHider implements Listener {
	
	private Set<String> hiddenPlayers = new HashSet<>();
    
    @EventHandler
    public void onServerListPing(ServerListPingEvent event) {
        if (hiddenPlayers.isEmpty()) return;
        
        Iterator<Player> iterator = event.iterator();
        
        while (iterator.hasNext()) {
            Player player = iterator.next();
            if (hiddenPlayers.contains(player.getName())) {
                iterator.remove();
            }
        }
    }
    public void hidePlayer(String playerName) {
        hiddenPlayers.add(playerName);
    }
    
    public void showPlayer(String playerName) {
        hiddenPlayers.remove(playerName);
    }
}
