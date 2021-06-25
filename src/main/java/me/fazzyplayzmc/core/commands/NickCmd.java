package me.fazzyplayzmc.core.commands;

import me.fazzyplayzmc.core.Core;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NickCmd implements CommandExecutor {

    private Core plugin;

    public NickCmd(Core plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player p)){
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("must-be-player")));
            return true;
        }
        if (!(p.hasPermission("core.command.nick"))){
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("no-permission")));
            return true;
        }
        if (args.length <= 0 || args.length >= 2){
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("nick-format")));
        } else if (args.length == 1) {

        }
        return true;
    }
}
