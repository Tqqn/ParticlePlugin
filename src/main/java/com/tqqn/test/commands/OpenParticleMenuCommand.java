package com.tqqn.test.commands;

import com.tqqn.test.TestPluginMain;
import com.tqqn.test.menus.ParticleMenu;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
public class OpenParticleMenuCommand implements CommandExecutor {

    private final TestPluginMain plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String particle, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (!(player.hasPermission("lobbyplugin.particles"))) return true;

        plugin.getParticleMenu().openInventory(player);
        return true;

    }
}
