package main.xpod78.V11887;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.configuration.file.YamlConfiguration;

public class config {
	
	private YamlConfiguration config;
	private File configFile;
	public config(File configfile) {
		this.config = new YamlConfiguration();
		this.configFile = configfile;
	}
	public boolean save() {
		try {
			if(!configFile.exists()) {
				main.logger.severe("The config doesn't exist, unable to save, regenerating a new one..");
				configFile.createNewFile();
				loaddefaults();
			}
			config.save(configFile);
			config.load(configFile);
			return true;
		}
		catch(Exception e) {
			main.logger.info("There was an error in saving the configuration file.");
			main.logger.severe(e.getMessage());
			return false;
		}
	}
	
	public boolean load() {
		try {
			if(!configFile.exists()) {
				configFile.createNewFile();
				loaddefaults();
			}
			config.load(configFile);
			
			return true;
		}
		catch(Exception e) {
			main.logger.info("There was an error loading in the configuration file.");
			main.logger.severe(e.getMessage());
			return false;
		}
	}
	private void loaddefaults() {
		config.addDefault("private_messages", false);
		config.addDefault("NumberOfMessages", 10000);
		config.addDefault("multiple_responses", false);
		config.addDefault("Name", "");
		config.addDefault("Prefix", "");
		config.addDefault("Suffix", "");
		config.addDefault("Delay", "1");
	}
	public void setString(String s) {
		
		
		
	}
	public void getBoolean(String s) {
		
	}
	public void setBoolean(String s) {
		
	}
	public void getString(String s) {
		
	}
}
