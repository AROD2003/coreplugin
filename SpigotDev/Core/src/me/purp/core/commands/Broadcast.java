package me.purp.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.purp.core.Main;
import me.purp.core.utils.Utils;

public class Broadcast implements CommandExecutor {

	private Main plugin;

	public Broadcast(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("broadcast").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		FileConfiguration config = plugin.getConfig();

		if (!(sender instanceof Player)) {
			sender.sendMessage(
					Utils.chat(config.getString("nullErrorMessage").replace("<cp>", config.getString("corePrefix"))));
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("core.broadcast")) {
			if (args.length >= 1) {

				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < args.length; i++)
					sb.append(args[i] + " ");

				Bukkit.broadcastMessage(Utils.chat(config.getString("corePrefix"))
						+ Utils.chat(config.getString("broadcastMessage")) + Utils.chat("&7") + sb);
			} else {
				p.sendMessage(Utils.chat(config.getString("broadcastEmtpyArgs").replace("<cp>",
						Utils.chat(config.getString("corePrefix")))));
			}
		}

		return false;
	}

}
