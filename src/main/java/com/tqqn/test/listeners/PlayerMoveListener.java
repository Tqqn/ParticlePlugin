package com.tqqn.test.listeners;

import com.tqqn.test.TestPluginMain;
import com.tqqn.test.particles.LobbyParticles;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    private final TestPluginMain plugin;

    public PlayerMoveListener(TestPluginMain plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLavaDrip(PlayerMoveEvent e) {

        Player player = e.getPlayer();

        if (!(plugin.getParticleManager().doesPlayerParticleExist(player)))
            return;

        LobbyParticles lobbyParticles = plugin.getParticleManager().getPlayerParticle(player);

            player.spawnParticle(lobbyParticles.getParticle(), player.getLocation(), lobbyParticles.getCount());
    }
}
