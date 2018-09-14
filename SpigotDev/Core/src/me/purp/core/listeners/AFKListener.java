package me.purp.core.listeners;

import org.bukkit.Bukkit;
//import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.purp.core.Main;
//import me.purp.core.utils.Utils;

public class AFKListener implements Listener {
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public AFKListener (Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		
		//FileConfiguration config = plugin.getConfig();
		
		//Player p = e.getPlayer();
		
		//if (p.getWalkSpeed() >= 0) {
			//Bukkit.broadcastMessage(Utils.chat("&6[*] ") + Utils.chat(p.getName()) + Utils.chat(config.getString("notAfkMessage")));
			//return;
		//}
	}

}
