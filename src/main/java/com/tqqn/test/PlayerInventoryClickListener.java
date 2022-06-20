package com.tqqn.test;

import com.tqqn.test.particles.LobbyParticles;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PlayerInventoryClickListener implements Listener {

    private final TestPluginMain plugin;

    public PlayerInventoryClickListener(TestPluginMain plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();

        if (!(event.getView().getTitle().equalsIgnoreCase(Color.translate("&6Particle Menu")))) return;

        event.setCancelled(true);

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
