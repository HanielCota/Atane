package com.github.hanielcota.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class BlockNaturalSpawnListener implements Listener {

    @EventHandler
    public void onSpawnNaturally(CreatureSpawnEvent e) {
        CreatureSpawnEvent.SpawnReason reason = e.getSpawnReason();
        switch (reason) {
            case NATURAL:
            case SPAWNER:
            case CHUNK_GEN:
            case JOCKEY:
            case MOUNT:
                e.setCancelled(true);
                break;
        }
    }
}