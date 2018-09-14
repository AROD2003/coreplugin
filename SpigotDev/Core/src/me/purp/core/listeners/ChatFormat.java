package me.purp.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.purp.core.Main;
import me.purp.core.utils.Utils;

public class ChatFormat implements Listener {

	private Main plugin;

	public ChatFormat(Main plugin) {
		this.plugin = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void chatFormat(AsyncPlayerChatEvent e) {

		FileConfiguration config = plugin.getConfig();

		Player p = e.getPlayer();

		e.setFormat(Utils.chat(config.getString("chatFrontFormat") + p.getDisplayName() + config.getString("chatEndFormat") + e.getMessage()));
	}

}
