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

        if (plugin.getParticleManager().getPlayerParticle(player).getType().equals("CIRCLE")) {

            Location location = player.getLocation();
            float radius = 1;

            for (double t = 0; t<50; t+=0.5) {
                float x = radius*(float)Math.sin(t);
                float z = radius*(float)Math.cos(t);
                location.getWorld().spawnParticle(lobbyParticles.getParticle(), (float) location.getX() + x, (float) location.getY(), (float) location.getZ() + z, 0, 0,0,0,1);
            }
        } else {
            player.spawnParticle(lobbyParticles.getParticle(), player.getLocation(), lobbyParticles.getCount());
        }

    }
}
