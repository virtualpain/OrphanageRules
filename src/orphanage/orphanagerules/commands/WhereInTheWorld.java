package orphanage.orphanagerules.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import orphanage.orphanagerules.OrphanageRules;

public class WhereInTheWorld implements CommandExecutor {
    public OrphanageRules plugin;
    public WhereInTheWorld(OrphanageRules plugin)  
    {
        this.plugin = plugin;
    }
    
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        Player player = null;
        if (sender instanceof Player)
        {
            player = (Player) sender;
        }
        
        String message;
        
        if (args.length == 0)
        {
            if (player == null)
            {
                System.out.println("You are not a player!");
            }
            else
            {
                // Showing current player's world
                String currentWorld = player.getWorld().getName();
                message = plugin.getConfig().getString("whereintheworld.world").replace("%player",player.getName());
                message = message.replace("%world",currentWorld);
                message = plugin.replaceColorMacros(message);
                player.sendMessage(message);
            }
        }
        
        else
        {
            Player target = plugin.getServer().getPlayer(args[0]);
            if (target == null)
            {
                message = plugin.getConfig().getString("whereintheworld.noplayer");
                message = message.replace("%player",args[0]);
                message = plugin.replaceColorMacros(message);
                sender.sendMessage(message);
            }
            else
            {
                message = plugin.getConfig().getString("whereintheworld.world");
                message = message.replace("%player",target.getName()).replace("%world", target.getWorld().getName() );
                message = plugin.replaceColorMacros(message);
                sender.sendMessage(message);
                
            }
        }
        return true;
    }
}
