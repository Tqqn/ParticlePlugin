package com.tqqn.test.listeners;

import com.tqqn.test.Particles;
import com.tqqn.test.particles.LobbyParticles;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    private final Particles plugin;

    public PlayerMoveListener(Particles plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {

        Player player = e.getPlayer();

        if (!(plugin.getParticleManager().doesPlayerParticleExist(player)))
            return;

        LobbyParticles lobbyParticles = plugin.getParticleManager().getPlayerParticle(player);

        player.spawnParticle(lobbyParticles.getParticle(), player.getLocation(), lobbyParticles.getCount());

    }
}
