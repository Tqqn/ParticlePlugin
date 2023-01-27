package com.tqqn.test.listeners;


import com.tqqn.test.Particles;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnLeaveListener implements Listener {

    private final Particles plugin;

    public OnLeaveListener(Particles plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (!plugin.getParticleManager().doesPlayerParticleExist(player)) return;

        plugin.getParticleManager().removePlayerFromParticleMap(player);
    }
}
