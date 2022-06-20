package com.tqqn.test.particles;

import org.bukkit.Material;
import org.bukkit.Particle;

public enum LobbyParticles {

    PARTICLE_LAVADRIP(Particle.DRIP_LAVA, 1, Material.LAVA_BUCKET, 1, "&6&lDrip-Lava Particle", "lobbyplugin.lavadrip", "CIRCLE"),
    PARTICLE_HEART(Particle.HEART,1, Material.RED_DYE, 2,"&c&lHeart Particle", "lobbyplugin.heart", "CIRCLE"),
    PARTICLE_ANGRY(Particle.VILLAGER_ANGRY,1,Material.DIAMOND_SWORD,3,"&4&lAngry Particle", "lobbyplugin.angry", "CIRCLE"),
    PARTICLE_ASH(Particle.ASH,1,Material.BLACK_DYE,4,"&8&lAsh Particle", "lobbyplugin.ash", "CIRCLE"),
    PARTICLE_CLOUD(Particle.CLOUD,1,Material.GRAY_DYE,5,"&f&lCloud Particle", "lobbyplugin.cloud", "CIRCLE"),
    PARTICLE_CRIT(Particle.CRIT,1,Material.GOLDEN_SWORD,6,"&7&lCrit Particle", "lobbyplugin.crit", "CIRCLE"),
    PARTICLE_CRIT_MAGIC(Particle.CRIT_MAGIC,1,Material.POTION,7,"&5&lCrit-Magic Particle", "lobbyplugin.crit.magic", "CIRCLE"),
    PARTICLE_ENCHANTMENT(Particle.ENCHANTMENT_TABLE,1,Material.ENCHANTED_BOOK,8,"&b&lEnchantment Particle", "lobbyplugin.enchantment", "CIRCLE"),
    PARTICLE_NOTE(Particle.NOTE,1,Material.NOTE_BLOCK,9,"&2&lNote Particle", "lobbyplugin.note", "CIRCLE"),
    PARTICLE_BARRIER(Particle.BARRIER,1,Material.BARRIER,10,"&4&lBarrier Particle", "lobbyplugin.barrier", "CIRCLE");

    private final Particle particle;
    private final int count;
    private final Material menuItem;
    private final int slot;
    private final String itemName;
    private final String permission;
    private final String type;

    /**
     * LobbyParticles Enum
     * @param particle Particle
     * @param count int
     * @param menuItem Material
     * @param slot int
     * @param itemName String
     * @param permission String
     * @param type String
     */
    LobbyParticles(Particle particle, int count, Material menuItem, int slot, String itemName, String permission, String type) {
        this.particle = particle;
        this.count = count;
        this.menuItem = menuItem;
        this.slot = slot;
        this.itemName = itemName;
        this.permission = permission;
        this.type = type;
    }

    public Particle getParticle() {
        return particle;
    }
    public int getCount() {
        return count;
    }
    public Material getMenuItem() {
        return menuItem;
    }
    public int getSlot() {
        return slot;
    }
    public String getItemName() {
        return itemName;
    }
    public String getPermission() {
        return permission;
    }
    public String getType() { return type; }
}
