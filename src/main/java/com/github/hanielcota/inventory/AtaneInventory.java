package com.github.hanielcota.inventory;

import com.github.hanielcota.methods.ClearDrops;
import com.github.hanielcota.misc.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class AtaneInventory implements InventoryHolder {

    private final Inventory inv;

    public AtaneInventory() {
        inv = Bukkit.createInventory(this, 3 * 9, "Info da Atane");
        init();
    }

    private void init() {
        if (ClearDrops.data == null) {
            ItemStack notcleanyet = new ItemBuilder(AtaneHead.HEAD.toString())
                    .setAmount(1)
                    .setName("§aAtane")
                    .setLore("§cAinda não fiz nenhuma limpeza...")
                    .build();
            inv.setItem(13, notcleanyet);
        } else {
            ItemStack stack = new ItemBuilder(AtaneHead.HEAD.toString())
                    .setAmount(1)
                    .setName("§aAtane")
                    .setLore("§fÚltima limpeza: §e" + ClearDrops.drops + " removidos.", "§fData: §a" + ClearDrops.data, "§fHora: §a" + ClearDrops.hora)
                    .build();

            inv.setItem(13, stack);
        }
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
