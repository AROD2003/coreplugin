package dev.aaron.util;

import org.bukkit.Bukkit;

import net.md_5.bungee.api.ChatColor;

public class ChatUtil
{

	public static void log(String message)
	{
		Bukkit.getConsoleSender().sendMessage(message);
	}

	public static String format(String message)
	{
		return ChatColor.translateAlternateColorCodes('&', message);
	}

}
