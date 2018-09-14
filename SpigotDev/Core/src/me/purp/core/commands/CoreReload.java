package me.purp.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.purp.core.Main;
import me.purp.core.utils.Utils;

public class CoreReload implements CommandExecutor {

	private Main plugin;

	public CoreReload(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("cr").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		FileConfiguration config = plugin.getConfig();

		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(
					config.getString("nullErrorMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
		}

		Player p = (Player) sender;

		if (p.hasPermission("core.reload")) {
			plugin.reloadConfig();
			p.sendMessage(Utils.chat(
					config.getString("coreReloadMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
		} else {
			p.sendMessage(Utils.chat(config.getString("noPermMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
		}

		return false;
	}

}
