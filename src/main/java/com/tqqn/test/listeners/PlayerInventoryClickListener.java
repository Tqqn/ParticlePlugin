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
                player.sendMessage(Color.translate("&cJe hebt nu je particle uitgezet."));
                player.closeInventory();
            } else {
                player.sendMessage(Color.translate("&cJe hebt geen particle aanstaan."));
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
            player.sendMessage(Color.translate("&6Je hebt nu de &c" + lobbyParticles.getItemName() + " &6aangezet."));
        } else {
            player.sendMessage(Color.translate("&cJe hebt geen permission om deze particle te gebruiken."));
        }
        player.closeInventory();
    }
}
