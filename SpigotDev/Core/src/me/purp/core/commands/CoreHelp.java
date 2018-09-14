package me.purp.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.purp.core.Main;
import me.purp.core.utils.Utils;

public class CoreHelp implements CommandExecutor {

	private Main plugin;

	public CoreHelp(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("ch").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		FileConfiguration config = plugin.getConfig();

		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(
					config.getString("nullErrorMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("core.*")) {
			p.sendMessage("");
			p.sendMessage(Utils
					.chat(config.getString("chPrefixMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			p.sendMessage("");
			p.sendMessage(Utils
					.chat(config.getString("chCmdMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			p.sendMessage(Utils.chat(
					config.getString("flyCmdMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			p.sendMessage(Utils.chat(
					config.getString("healCmdMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			p.sendMessage(Utils.chat(
					config.getString("feedCmdMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			
			p.sendMessage(Utils.chat(
					config.getString("motdCmdMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			p.sendMessage(Utils.chat(
					config.getString("dayCmdMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			p.sendMessage(Utils.chat(
					config.getString("nightCmdMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			p.sendMessage(Utils.chat(
					config.getString("sunCmdMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			p.sendMessage(Utils.chat(
					config.getString("rainCmdMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			
			p.sendMessage(Utils.chat(
					config.getString("sunCmdMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			p.sendMessage(Utils.chat(
					config.getString("rainCmdMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			p.sendMessage(Utils.chat(
					config.getString("spawnCmdMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			p.sendMessage(Utils.chat(
					config.getString("setSpawnCmdMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			p.sendMessage(Utils.chat(
					config.getString("afkCmdMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			
			p.sendMessage(Utils.chat(
					config.getString("bcCmdMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			p.sendMessage("");
			p.sendMessage(Utils.chat(
					config.getString("chPrefixMessage2").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			p.sendMessage("");
		}

		return false;
	}

}
