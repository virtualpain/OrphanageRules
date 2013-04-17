package orphanage.orphanagerules;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OrphanageRulesListener implements Listener {
	private final OrphanageRules plugin;
	
	public OrphanageRulesListener(OrphanageRules plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
	}
		
	@EventHandler
	public void onPlayerJoined(PlayerJoinEvent event)	{
		Player player = event.getPlayer();
		String playerName = player.getName();		 
		List<String> motd = plugin.getConfig().getStringList("motd");
		
		for (String motd_line : motd) {
		  player.sendMessage(plugin.replaceColorMacros(motd_line).replace("%player", playerName));  
		}	
	
	}
}
