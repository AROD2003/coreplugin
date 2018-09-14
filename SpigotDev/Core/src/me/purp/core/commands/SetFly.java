package me.purp.core.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.purp.core.Main;
import me.purp.core.utils.Utils;

public class SetFly implements CommandExecutor {

	private Main plugin;

	public SetFly(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("fly").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		FileConfiguration config = plugin.getConfig();

		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(
					config.getString("nullErrorMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			return true;
		}

		Player p = (Player) sender;

		if (p.getGameMode() == GameMode.CREATIVE || p.getGameMode() == GameMode.SPECTATOR) {
			if (p.hasPermission("core.fly")) {
				p.sendMessage(Utils.chat(config.getString("csFlyErrorMessage")).replace("<cp>",
						Utils.chat(config.getString("corePrefix"))));
			} else {
				p.sendMessage(Utils.chat(
						config.getString("noPermMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			}
		}

		if (p.getGameMode() == GameMode.SURVIVAL || p.getGameMode() == GameMode.ADVENTURE) {
			if (p.hasPermission("core.fly")) {
				if (p.isFlying() || p.getAllowFlight() == true) {
					p.setAllowFlight(false);
					p.setFlying(false);
					p.sendMessage(Utils.chat(config.getString("flyingDisabledMessage").replace("<cp>",
							Utils.chat(config.getString("corePrefix")))));
					return true;
				} else {
					p.setAllowFlight(true);
					p.setFlying(true);
					p.sendMessage(Utils.chat(config.getString("flyingEnabledMessage").replace("<cp>",
							Utils.chat(config.getString("corePrefix")))));
				}
			} else {
				p.sendMessage(Utils.chat(
						config.getString("noPermMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			}
		}

		return false;
	}

}
