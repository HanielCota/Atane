package com.github.hanielcota;

import com.github.hanielcota.inventory.AtaneListener;
import com.github.hanielcota.listeners.BlockNaturalSpawnListener;
import com.github.hanielcota.methods.CommandManager;
import com.github.hanielcota.misc.ClearDrops;
import com.github.hanielcota.runnable.AsyncRunnable;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class Atane extends JavaPlugin {

    @Getter
    private ClearDrops clearDrops;

    @Override
    public void onEnable() {
        this.clearDrops = new ClearDrops();
        getLogger().log(Level.INFO, () -> "§aAtane is load successful! ");
        new CommandManager(this);
        initListeners();
        new AsyncRunnable().runTaskTimerAsynchronously(this, 0, 20);
    }

    @Override
    public void onDisable() {
        getLogger().log(Level.SEVERE, () -> "§cAtane is disabled...");
    }

    private void initListeners() {
        Bukkit.getPluginManager().registerEvents(new AtaneListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockNaturalSpawnListener(), this);
        getLogger().log(Level.INFO, () -> "§awere registered successful listeners!");
    }
}