package com.tqqn.test.commands;

import com.tqqn.test.TestPluginMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class OpenParticleMenuCommand implements CommandExecutor {

    final TestPluginMain plugin;

    public OpenParticleMenuCommand(TestPluginMain plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String particle, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        if (!(player.hasPermission("lobbyplugin.particles"))) return false;

        plugin.getParticleMenu().openInventory(player);
        return true;
    }
}
