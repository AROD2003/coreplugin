package me.purp.core;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.plugin.java.JavaPlugin;

import me.purp.core.commands.AwayFromKeyboard;
import me.purp.core.commands.Broadcast;
import me.purp.core.commands.CoreHelp;
import me.purp.core.commands.CoreReload;
import me.purp.core.commands.DisplayRules;
import me.purp.core.commands.FeedPlayer;
import me.purp.core.commands.Gamemode;
import me.purp.core.commands.HealPlayer;
import me.purp.core.commands.MessageOfTheDay;
import me.purp.core.commands.SetFly;
import me.purp.core.commands.SetWorldSpawn;
import me.purp.core.commands.TImeDay;
import me.purp.core.commands.TImeNight;
import me.purp.core.commands.WeatherClear;
import me.purp.core.commands.WeatherRain;
import me.purp.core.commands.WorldSpawn;
import me.purp.core.listeners.AFKListener;
import me.purp.core.listeners.ChatFormat;
import me.purp.core.listeners.JoinQuitMessages;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		// Config
		FileConfiguration config = getConfig();
		FileConfigurationOptions configOptions = config.options();
		configOptions.copyDefaults(true);
		saveDefaultConfig();

		// Commands
		new SetFly(this);
		new CoreHelp(this);
		new Gamemode(this);
		new HealPlayer(this);
		new FeedPlayer(this);
		new MessageOfTheDay(this);
		new TImeDay(this);
		new TImeNight(this);
		new WeatherClear(this);
		new WeatherRain(this);
		new WorldSpawn(this);
		new SetWorldSpawn(this);
		new DisplayRules(this);
		new AwayFromKeyboard(this);
		new Broadcast(this);
		new CoreReload(this);

		// Listeners
		new JoinQuitMessages(this);
		new ChatFormat(this);
		new AFKListener(this);
	}

	@Override
	public void onDisable() {
		saveDefaultConfig();
	}

}
