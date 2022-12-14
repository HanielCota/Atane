package com.github.hanielcota.controllers;

import com.github.hanielcota.misc.ClearDrops;
import org.bukkit.Bukkit;

import java.util.logging.Level;

public class TimerController {
    private int timer = 420;

    public int getTimer() {
        return timer;
    }

    public void reduceTimer() {
        this.timer--;
        if (timer == 0) {
            this.timer = 420;
            Bukkit.getLogger().log(Level.INFO, () -> "§aAtane is performing a cleanup on the server.");
            new ClearDrops().clear();
        }
    }

    public TimerController printValue() {
        Bukkit.getLogger().log(Level.INFO, () -> "" + timer);
        return this;
    }

}
