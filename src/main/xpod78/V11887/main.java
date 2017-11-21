package main.xpod78.V11887;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	public static Logger logger = Logger.getLogger("Minecraft");
	public final PluginDescriptionFile pdf = this.getDescription();
	public final ChatListener cl = new ChatListener(this);
	public static config config_file = null;
	public static main plugin;
	
	public void loadconfig() {
		File dir = this.getDataFolder();
		if(!dir.exists()) {
			dir.mkdir();
		}
		File file = new File(dir, "config.yml");
		config_file = new config(file);
		if(!config_file.load()) {
			this.getServer().getPluginManager().disablePlugin(plugin);
			throw new IllegalStateException("Config failed to load.");
		}
	}
	
	
	@Override
	public void onEnable() {
		logger.info("Loading BuildABot..");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(cl, this);
		loadconfig();
		logger.info("BuildABot Version " + pdf.getVersion() + " has been enabled!");
		}
	@Override
	public void onDisable() {
		logger.info("BuildABot has been disabled!");
	}
}
