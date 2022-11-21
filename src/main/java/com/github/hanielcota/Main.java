package com.github.hanielcota;

import com.github.hanielcota.methods.RegisterCommands;
import com.github.hanielcota.methods.RegisterListeners;
import com.github.hanielcota.runnable.AsyncRunnable;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;


public class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        getLogger().log(Level.INFO, () -> "§aAtane is load successful! ");
        new RegisterCommands(this);
        new RegisterListeners(this);
        new AsyncRunnable().runTaskTimerAsynchronously(this, 0, 20);
    }

    @Override
    public void onDisable() {
        getLogger().log(Level.SEVERE, () -> "§cAtane is disabled...");
    }

}