package me.purp.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.purp.core.Main;
import me.purp.core.utils.Utils;

public class JoinQuitMessages implements Listener {

	private Main plugin;

	public JoinQuitMessages(Main plugin) {
		this.plugin = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {

		FileConfiguration config = plugin.getConfig();

		Player p = e.getPlayer();

		if (!p.hasPlayedBefore()) {
			e.setJoinMessage(Utils.chat(config.getString("playerFirstJoin").replace("<player>", p.getName())));
		} else {
			e.setJoinMessage(Utils.chat(config.getString("playerJoin").replace("<player>", p.getName())));
		}
	}

	@EventHandler
	public void onJoin(PlayerQuitEvent e) {

		FileConfiguration config = plugin.getConfig();

		Player p = e.getPlayer();

		e.setQuitMessage(Utils.chat(config.getString("playerQuit").replace("<player>", p.getName())));
	}

}
