package main.xpod78.V11887;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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
	public void help(Player player) {
		player.sendMessage("BuildABot Command Help");
		player.sendMessage("Format: /bab <cmd>");
		player.sendMessage("reload - loads in the config again, taking into account any saved changes to the config.");
		player.sendMessage("checkinput <#> - checks the input string at that specific #.");
		player.sendMessage("settings - opens the settings command menu");
		player.sendMessage("checkoutput <#> <#> - second # depends if you have alternate responses enabled.");
		player.sendMessage("setinput <#> - sets the input string at that specific #.");
		player.sendMessage("setoutput <#> <#> - second # depends if you have alternate responses enabled.");
		player.sendMessage("help - access this command menu again.");
	}
	public void reload(Player player) {
		
	}
	public void checkInput(Player player, String args) {
		
	}
	public void checkOutput(Player player) {
		
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, 
			String[] args){
		Player player = (Player) sender;
		
		
		
		if(commandLabel.equalsIgnoreCase("bab")) {
			if(player.hasPermission("bab.bab")) {
			if(args.length==0) {
				help(player);
			}else if(args.length == 1) {
				if (args[0].equalsIgnoreCase("reload")){
					
				}else if(args[0].equalsIgnoreCase("checkinput")) {
					
				}else if(args[0].equalsIgnoreCase("checkoutput")) {
					
				}else if(args[0].equalsIgnoreCase("settings")) {
					
				}else if(args[0].equalsIgnoreCase("setinput")) {
					help(player);
				}else if(args[0].equalsIgnoreCase("setoutput")) {
					help(player);
				}else if(args[0].equalsIgnoreCase("help")) {
					help(player);
				}else {
					help(player);
				}
			}else if(args.length == 2) {
				if (args[0].equalsIgnoreCase("reload")){
					help(player);
				}else if(args[0].equalsIgnoreCase("checkinput")) {
					String input = args[1];
				}else if(args[0].equalsIgnoreCase("checkoutput")) {
					help(player);
				}else if(args[0].equalsIgnoreCase("settings")) {
					
				}else if(args[0].equalsIgnoreCase("setinput")) {
					help(player);
				}else if(args[0].equalsIgnoreCase("setoutput")) {
					help(player);
				}else if(args[0].equalsIgnoreCase("help")) {
					help(player);
				}else {
					help(player);
				}
			}
			}else {
				player.sendMessage(ChatColor.RED + "No permission.");
			}
		}
		
		
		return false;
	
	}
}
