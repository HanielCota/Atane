package com.github.hanielcota.methods;

import com.github.hanielcota.Main;
import com.github.hanielcota.inventory.AtaneListener;
import com.github.hanielcota.listeners.BlockNaturalSpawnListener;
import lombok.val;
import org.bukkit.Bukkit;

import java.util.logging.Level;

public class RegisterListeners {
    public RegisterListeners(Main plugin) {
        val logger = plugin.getLogger();
        Bukkit.getPluginManager().registerEvents(new AtaneListener(), plugin);
        Bukkit.getPluginManager().registerEvents(new BlockNaturalSpawnListener(), plugin);
        logger.log(Level.INFO, () -> "§awere registered successful listeners!");
    }
}
