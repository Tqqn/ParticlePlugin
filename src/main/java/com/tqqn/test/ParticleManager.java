package com.tqqn.test;

import com.tqqn.test.particles.LobbyParticles;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class ParticleManager {

    private final HashMap<UUID, LobbyParticles> playerLobbyParticles = new HashMap<>();

    private final ArrayList<String> customParticles = new ArrayList<>();

    public void addPlayerToParticleMap(Player player, LobbyParticles lobbyParticles) {
        playerLobbyParticles.put(player.getUniqueId(), lobbyParticles);
    }
    public void removePlayerFromParticleMap(Player player) {
        playerLobbyParticles.remove(player.getUniqueId());
    }
    public LobbyParticles getPlayerParticle(Player player) {
        return playerLobbyParticles.get(player.getUniqueId());
    }
    public boolean doesPlayerParticleExist(Player player) {
        return playerLobbyParticles.containsKey(player.getUniqueId());
    }
    public void addParticleNamesToArray() {
        for (LobbyParticles lobbyParticles : LobbyParticles.values()) {
            customParticles.add(lobbyParticles.name());
        }
    }
    public int getParticlesMapSize() {
        return customParticles.size();
    }
}
