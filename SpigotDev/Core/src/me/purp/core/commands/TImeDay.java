package me.purp.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.purp.core.Main;
import me.purp.core.utils.Utils;

public class TImeDay implements CommandExecutor {

	private Main plugin;

	public TImeDay(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("day").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		FileConfiguration config = plugin.getConfig();

		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(
					config.getString("nullErrorMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("core.time")) {
			p.getLocation().getWorld().setTime(0);
			sender.sendMessage(Utils
					.chat(config.getString("timeSetDay").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			return true;
		} else {
			sender.sendMessage(Utils.chat(
					config.getString("noPermMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
		}

		return false;
	}

}
