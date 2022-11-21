package com.github.hanielcota.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class AtaneListener implements Listener {

    @EventHandler
    private void ataneInteractionInventory(InventoryClickEvent event) {
        if (event.getInventory() == null) return;
        if (event.getCurrentItem() == null) return;
        if (event.getClickedInventory().getHolder() instanceof AtaneInventory) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(final InventoryDragEvent event) {
        if (event.getInventory().getHolder() instanceof AtaneInventory) {
            event.setCancelled(true);
        }
    }
}
