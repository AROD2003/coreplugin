package dev.aaron.command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import dev.aaron.Core;
import dev.aaron.util.ChatUtil;

public class BaseCommand implements CommandExecutor
{

	private Core plugin;

	public BaseCommand(Core plugin)
	{
		this.plugin = plugin;

		plugin.getCommand("startevent").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		FileConfiguration config = plugin.getConfig();
		if (!(sender instanceof Player))
		{
			sender.sendMessage("You must be a player to execute this command");
			return false;
		}

		Player player = (Player) sender;

		if (command.getName().equalsIgnoreCase("startevent"))
		{
			if (player.hasPermission("tronix.oreparty"))
			{
				if (args[0].equalsIgnoreCase("event"))
				{
					if (args[1].equalsIgnoreCase("location"))
					{
						if (args[2].equalsIgnoreCase("add"))
						{
							Location location = player.getLocation();
							/*
							 * config.getList("ServerEvents.OreParty.Locations").add(location.toString()); config.set("ServerEvents.OreParty.Locations", config.getStringList("ServerEvents.OreParty.Locations").add(location.toString())); player.sendMessage(ChatUtil.format("&aLocation added &b(" + location.getBlockX() + location.getBlockY() + location.getBlockY()));
							 */
							/*
							 * List<String> list = config.getStringList("List"); list.add(location.toString()); config.set("List", list);
							 */

							List<String> locations = config.getStringList("ServerEvents.OreParty.Locations");
							locations.add(location.toString());
							config.set("ServerEvents.OreParty.Locations", locations);
							player.sendMessage(ChatUtil.format("&aOreParty Location added: &b" + "x: " + location.getBlockX() + ", y: " + location.getBlockY() + ", z: " + location.getBlockZ()));
							plugin.saveConfig();
						}
						else
						{
							player.sendMessage("oof");
						}
					}
					else
					{
						player.sendMessage("oof");
					}
				}
				else
				{
					player.sendMessage("oof");
				}
			}
			else if (!player.hasPermission("tronix.oreparty"))
			{
				player.sendMessage(ChatUtil.format("&cInsufficient permissions."));
			}
		}

		return false;
	}

}
