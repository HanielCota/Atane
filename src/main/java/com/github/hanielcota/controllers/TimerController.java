package com.github.hanielcota.controllers;

import com.github.hanielcota.methods.ClearDrops;
import org.bukkit.Bukkit;

import java.util.logging.Level;

public class TimerController {
    private int timer = 420;

    public int getTimer() {
        return timer;
    }

    public TimerController reduceTimer() {
        this.timer--;
        if (timer == 0) {
            this.timer = 420;
            Bukkit.getLogger().log(Level.INFO, () -> "§aAtane is performing a cleanup on the server.");
            new ClearDrops().clear();
        }
        return this;
    }

    public TimerController printValue() {
        Bukkit.getLogger().log(Level.INFO, () -> "" + timer);
        return this;
    }

}
