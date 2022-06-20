package com.tqqn.test.menus;

import com.tqqn.test.Color;
import com.tqqn.test.TestPluginMain;
import com.tqqn.test.particles.LobbyParticles;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class ParticleMenu {

    private final Inventory inventory;

    private final HashMap<ItemStack, LobbyParticles> loadedParticlesMaterial = new HashMap<>();

    public ParticleMenu(TestPluginMain plugin) {
        int size = plugin.getParticleManager().getParticlesMapSize();
        inventory = Bukkit.createInventory(null, size, "&6Particle Menu");
        addItemsToInventory();
    }

    private void addItemsToInventory() {
        for (LobbyParticles lobbyParticles : LobbyParticles.values()) {
            inventory.setItem(lobbyParticles.getSlot(), createGuiItem(lobbyParticles.getMenuItem(), lobbyParticles.getItemName()));
        }
    }

    public ItemStack createGuiItem(Material material, String name) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setLocalizedName(Color.translate(name));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public void openInventory(Player player) {
        player.openInventory(inventory);
    }

    public boolean doesMaterialExistInMap(ItemStack itemStack) {
        return loadedParticlesMaterial.containsKey(itemStack);
    }
    public LobbyParticles getLobbyParticlesFromMap(ItemStack itemStack) {
        return loadedParticlesMaterial.get(itemStack);
    }
}
