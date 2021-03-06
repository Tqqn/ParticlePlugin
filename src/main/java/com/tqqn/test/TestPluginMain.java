package com.tqqn.test;

import com.tqqn.test.commands.OpenParticleMenuCommand;
import com.tqqn.test.listeners.OnLeaveListener;
import com.tqqn.test.listeners.PlayerInventoryClickListener;
import com.tqqn.test.listeners.PlayerMoveListener;
import com.tqqn.test.managers.ParticleManager;
import com.tqqn.test.menus.ParticleMenu;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPluginMain extends JavaPlugin {

    private final ParticleManager particleManager;
    private final ParticleMenu particleMenu;

    public TestPluginMain() {
        this.particleManager = new ParticleManager();
        this.particleMenu = new ParticleMenu(this);
    }

    @Override
    public void onEnable() {
        registerCommands();
        registerEvents();
        particleManager.addParticleNamesToArray();

        particleMenu.setUpParticleMenu();
        Bukkit.getLogger().info("Plugin has been enabled.");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Plugin has been disabled.");
    }

    public ParticleManager getParticleManager() {
        return this.particleManager;
    }

    public ParticleMenu getParticleMenu() {
        return this.particleMenu;
    }

    public void registerCommands() {
        this.getCommand("particle").setExecutor(new OpenParticleMenuCommand(this));
    }

    public void registerEvents() {
        PluginManager pluginManager = Bukkit.getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerMoveListener(this), this);
        pluginManager.registerEvents(new PlayerInventoryClickListener(this), this);
        pluginManager.registerEvents(new OnLeaveListener(this), this);
    }
}
