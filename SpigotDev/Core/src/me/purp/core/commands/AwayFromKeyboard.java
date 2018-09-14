package me.purp.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.purp.core.Main;
import me.purp.core.utils.Utils;

public class AwayFromKeyboard implements CommandExecutor {

	private Main plugin;

	public AwayFromKeyboard(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("afk").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		FileConfiguration config = plugin.getConfig();

		String prefix = Utils.chat(config.getString("corePrefix"));
		String afk = Utils.chat(config.getString("afkMessage"));
		String error = Utils.chat(config.getString("nullErrorMessage"));

		if (!(sender instanceof Player)) {
			sender.sendMessage(error.replace("<cp>", prefix));
			return true;
		}

		Player p = (Player) sender;

		if (p.getWalkSpeed() <= 1) {
			Bukkit.broadcastMessage(Utils.chat("&6[*] ") + Utils.chat(p.getName()) + afk);
		}

		return false;
	}

}
