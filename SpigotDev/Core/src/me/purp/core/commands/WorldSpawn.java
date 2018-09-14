package me.purp.core.commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.purp.core.Main;
import me.purp.core.utils.Utils;

public class WorldSpawn implements CommandExecutor {

	private Main plugin;

	public WorldSpawn(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("spawn").setExecutor(this);
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

		p.teleport(world.getSpawnLocation().add(0.5, -0.5, 0.5));
		sender.sendMessage(Utils.chat(
				config.getString("spawnMessage").replace("<cp>", Utils.chat(config.getString("corePrefix")))));

		return false;
	}

}
