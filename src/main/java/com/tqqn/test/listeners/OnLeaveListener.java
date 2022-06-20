package com.tqqn.test.listeners;


import com.tqqn.test.TestPluginMain;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

@RequiredArgsConstructor
public class OnLeaveListener implements Listener {

    private final TestPluginMain plugin;

    @EventHandler
    public void OnLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (!plugin.getParticleManager().doesPlayerParticleExist(player)) return;

        plugin.getParticleManager().removePlayerFromParticleMap(player);
    }
}
