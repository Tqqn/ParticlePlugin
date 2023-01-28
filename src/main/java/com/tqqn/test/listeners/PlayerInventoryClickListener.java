package com.tqqn.test.listeners;

import com.tqqn.test.Particles;
import com.tqqn.test.particles.LobbyParticles;
import com.tqqn.test.utils.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PlayerInventoryClickListener implements Listener {

    private final Particles plugin;

    public PlayerInventoryClickListener(Particles plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) return;

        if (!(event.getView().getTitle().equalsIgnoreCase(Color.translate("&6Particle Menu")))) return;

        event.setCancelled(true);

        if (event.getCurrentItem().getType() == Material.BARRIER && event.getCurrentItem().getItemMeta().getDisplayName().equals(Color.translate("&cTurn off Particle"))) {
            if (plugin.getParticleManager().doesPlayerParticleExist(player)) {
                plugin.getParticleManager().removePlayerFromParticleMap(player);
                player.sendMessage(Color.translate("&cYou disabled your particle."));
                player.closeInventory();
            } else {
                player.sendMessage(Color.translate("&cYou don't have a particle enabled."));
            }
            return;

        }

        if (!plugin.getParticleMenu().doesMaterialExistInMap(event.getCurrentItem())) return;

        if (plugin.getParticleManager().doesPlayerParticleExist(player)) {
            plugin.getParticleManager().removePlayerFromParticleMap(player);
        }

        LobbyParticles lobbyParticles = plugin.getParticleMenu().getLobbyParticlesFromMap(event.getCurrentItem());

        if (player.hasPermission(lobbyParticles.getPermission())) {
            plugin.getParticleManager().addPlayerToParticleMap(player, lobbyParticles);
            player.sendMessage(Color.translate("&6You enabled the &c" + lobbyParticles.getItemName() + " &6particle."));
        } else {
            player.sendMessage(Color.translate("&cYou don't have permission to use this command."));
        }
        player.closeInventory();
    }
}
