package me.purp.core.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.purp.core.Main;
import me.purp.core.utils.Utils;

public class SetWorldSpawn implements CommandExecutor {

	private Main plugin;

	public SetWorldSpawn(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("setspawn").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		FileConfiguration config = plugin.getConfig();

		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(
					config.getString("nullErrorMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			return true;
		}

		Player p = (Player) sender;

		World world = p.getWorld();
		Location location = p.getLocation();

		if (p.hasPermission("core.setspawn")) {
			world.setSpawnLocation(location.getBlockX(), location.getBlockY() + 1, location.getBlockZ());
			sender.sendMessage(Utils.chat(
					config.getString("setSpawnMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
		} else {
			sender.sendMessage(Utils.chat(
					config.getString("noPermMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));
			return true;
		}

		return false;
	}

}
