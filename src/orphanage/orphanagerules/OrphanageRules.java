package orphanage.orphanagerules;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.plugin.java.JavaPlugin;

import orphanage.orphanagerules.commands.Rules;
import orphanage.orphanagerules.commands.WhereInTheWorld;

public class OrphanageRules extends JavaPlugin {
	public Logger log = Logger.getLogger("Minecraft");


	  public void onEnable(){    
	    log.info("[" + getDescription().getName() + "] " + getDescription().getVersion() + " enabled.");
	    // Load Config.yml
	    FileConfiguration cfg = getConfig();
	    FileConfigurationOptions cfgOptions = cfg.options();
	    
	    File f = new File(getDataFolder().getAbsolutePath()+File.separator+"config.yml");
	    if(!f.exists()) {    
	    cfgOptions.copyDefaults(true);
	    cfgOptions.copyHeader(true);
	    saveConfig();
	    }
	    
	    // declare new listener
	    new OrphanageRulesListener(this);
	    // Declare Command Executor
	    this.getCommand("rules").setExecutor(new Rules(this));
	    this.getCommand("whereintheworld").setExecutor(new WhereInTheWorld(this));
	  }

	  public void onDisable(){ 
	    log.info("[" + getDescription().getName() + "] " + getDescription().getVersion() + " disabled.");    
	  }  

	  public String replaceColorMacros(String str) {
	    str = str.replace("&r", ChatColor.RED.toString());
	    str = str.replace("&R", ChatColor.DARK_RED.toString());        
	    str = str.replace("&y", ChatColor.YELLOW.toString());
	    str = str.replace("&Y", ChatColor.GOLD.toString());
	    str = str.replace("&g", ChatColor.GREEN.toString());
	    str = str.replace("&G", ChatColor.DARK_GREEN.toString());        
	    str = str.replace("&c", ChatColor.AQUA.toString());
	    str = str.replace("&C", ChatColor.DARK_AQUA.toString());        
	    str = str.replace("&b", ChatColor.BLUE.toString());
	    str = str.replace("&B", ChatColor.DARK_BLUE.toString());        
	    str = str.replace("&p", ChatColor.LIGHT_PURPLE.toString());
	    str = str.replace("&P", ChatColor.DARK_PURPLE.toString());
	    str = str.replace("&0", ChatColor.BLACK.toString());
	    str = str.replace("&1", ChatColor.DARK_GRAY.toString());
	    str = str.replace("&2", ChatColor.GRAY.toString());
	    str = str.replace("&w", ChatColor.WHITE.toString());
	    str = str.replace("%bold", ChatColor.BOLD.toString());
	    str = str.replace("%italic", ChatColor.ITALIC.toString());
	    str = str.replace("%underline", ChatColor.UNDERLINE.toString());
	    str = str.replace("%strike", ChatColor.STRIKETHROUGH.toString());
	    str = str.replace("%reset", ChatColor.RESET.toString());    
	    return str;
	  }
	  
}
