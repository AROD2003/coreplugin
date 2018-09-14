package me.purp.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.purp.core.Main;
import me.purp.core.utils.Utils;

public class DisplayRules implements CommandExecutor {

	private Main plugin;

	public DisplayRules(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("rules").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		FileConfiguration config = plugin.getConfig();

		if (!(sender instanceof Player)) {
			sender.sendMessage(
					Utils.chat(config.getString("nullErrorMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			return true;
		}

		Player p = (Player) sender;

		p.sendMessage("");
		p.sendMessage(Utils.chat(config.getString("rulesPrefix")));
		p.sendMessage(Utils.chat(config.getString("rulesList1")));
		p.sendMessage(Utils.chat(config.getString("rulesList2")));
		p.sendMessage(Utils.chat(config.getString("rulesList3")));
		p.sendMessage(Utils.chat(config.getString("rulesList4")));
		p.sendMessage(Utils.chat(config.getString("rulesList5")));
		p.sendMessage(Utils.chat(config.getString("rulesList6")));
		p.sendMessage("");

		return false;
	}

}
