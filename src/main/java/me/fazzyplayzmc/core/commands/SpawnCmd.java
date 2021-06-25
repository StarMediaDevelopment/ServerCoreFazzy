package me.fazzyplayzmc.core.commands;

import me.fazzyplayzmc.core.Core;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCmd implements CommandExecutor {
    private Core plugin;

    public SpawnCmd(Core plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player p)){
            sender.sendMessage(Core.color(plugin.getConfig().getString("must-be-player")));
            return true;
        }
        if (p.hasPermission("core.command.spawn")){
            Location spawn = new Location(Bukkit.getWorld(plugin.getConfig().getString("spawn.world")), plugin.getConfig().getDouble("spawn.x"), plugin.getConfig().getDouble("spawn.y"), plugin.getConfig().getDouble("spawn.z"), plugin.getConfig().getInt("spawn.yaw"), plugin.getConfig().getInt("spawn.pitch"));
            p.teleport(spawn);
            p.sendMessage(Core.color(plugin.getConfig().getString("tped-to-spawn")));
        } else {
            sender.sendMessage(Core.color(plugin.getConfig().getString("no-permission")));
        }
        return true;
    }
}
