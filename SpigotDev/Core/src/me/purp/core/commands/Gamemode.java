package me.purp.core.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.purp.core.Main;
import me.purp.core.utils.Utils;

public class Gamemode implements CommandExecutor {

	private Main plugin;

	public Gamemode(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("gm").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		FileConfiguration config = plugin.getConfig();

		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(
					config.getString("nullErrorMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("core.gamemode")) {
			if (!(args.length <= 0)) {
				if (args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("creative")) {
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.sendMessage(Utils.chat(config.getString("gameModeErrorCreative").replace("<cp>",
								Utils.chat(config.getString("corePrefix")))));
					} else {
						p.sendMessage(Utils.chat(config.getString("gameModeSetCreative").replace("<cp>",
								Utils.chat(config.getString("corePrefix")))));
						p.setGameMode(GameMode.CREATIVE);
					}
				}
				if (args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("survival")) {
					if (p.getGameMode() == GameMode.SURVIVAL) {
						p.sendMessage(Utils.chat(config.getString("gameModeErrorSurvival").replace("<cp>",
								Utils.chat(config.getString("corePrefix")))));
					} else {
						p.sendMessage(Utils.chat(config.getString("gameModeSetSurvival").replace("<cp>",
								Utils.chat(config.getString("corePrefix")))));
						p.setGameMode(GameMode.SURVIVAL);
					}
				}
				if (args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("adventure")) {
					if (p.getGameMode() == GameMode.ADVENTURE) {
						p.sendMessage(Utils.chat(config.getString("gameModeErrorAdventure").replace("<cp>",
								Utils.chat(config.getString("corePrefix")))));
					} else {
						p.sendMessage(Utils.chat(config.getString("gameModeSetAdventure").replace("<cp>",
								Utils.chat(config.getString("corePrefix")))));
						p.setGameMode(GameMode.ADVENTURE);
					}
				}
				if (args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("spectator")) {
					if (p.getGameMode() == GameMode.SPECTATOR) {
						p.sendMessage(Utils.chat(config.getString("gameModeErrorSpectator").replace("<cp>",
								Utils.chat(config.getString("corePrefix")))));
					} else {
						p.sendMessage(Utils.chat(config.getString("gameModeSetSpectator").replace("<cp>",
								Utils.chat(config.getString("corePrefix")))));
						p.setGameMode(GameMode.SPECTATOR);
					}
				}
			} else {
				p.sendMessage(Utils.chat(config.getString("gameModeEmptyArgs").replace("<cp>",
						Utils.chat(config.getString("corePrefix")))));
			}
		}

		return false;
	}

}
