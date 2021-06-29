package me.fazzyplayzmc.core.commands;

import me.fazzyplayzmc.core.Core;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCmd implements CommandExecutor {

    private Core plugin;

    public SetSpawnCmd(Core plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player p)){
            sender.sendMessage(Core.color(plugin.getConfig().getString("must-be-player")));
            return true;
        }
        if (!(p.hasPermission("core.command.setspawn"))){
            p.sendMessage(Core.color(plugin.getConfig().getString("no-permission")));
            return true;
        }
        Location loc = p.getLocation();
        plugin.getConfig().set("spawn.world", loc.getWorld().getName());
        plugin.getConfig().set("spawn.x", loc.getX());
        plugin.getConfig().set("spawn.y", loc.getY());
        plugin.getConfig().set("spawn.z", loc.getZ());
        plugin.getConfig().set("spawn.yaw", loc.getYaw());
        plugin.getConfig().set("spawn.pitch", loc.getPitch());
        plugin.saveConfig();
        p.sendMessage(Core.color(plugin.getConfig().getString("set-spawn")));
        return true;
    }
}
