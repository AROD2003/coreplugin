package dev.aaron;

import org.bukkit.plugin.java.JavaPlugin;

import dev.aaron.command.BaseCommand;
import dev.aaron.util.ChatUtil;

public class Core extends JavaPlugin
{

	/**
	 * TODO: - Make a command to set a location for ores to spawn. - Make a gui to select the event to start (for multiple events, not needed until the FAR future) -
	 */

	public Core()
	{
	}

	private static Core instance;

	public void onEnable()
	{
		ChatUtil.log("onEnable() called");
		saveDefaultConfig();

		registerCommands();
	}

	public void onDisable()
	{
		ChatUtil.log("onDisable() called");
	}

	void registerCommands()
	{
		getCommand("startevent").setExecutor(new BaseCommand(this));
	}

	void registerEvents()
	{

	}

	public static Core getInstance()
	{
		return instance;
	}

}
