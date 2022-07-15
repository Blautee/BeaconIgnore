package de.trebtee.beaconignore;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	
	public void onEnable() {
		plugin = this;
		
		saveDefaultConfig();
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new BeaconListener(), (Plugin) this);
		
		getCommand("beaconignore").setExecutor((CommandExecutor) new BeaconIgnoreCommand());
	}
	
	public static Main getPlugin() {
		return plugin;
	}

}
