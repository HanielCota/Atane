package com.github.hanielcota.inventory;

import com.github.hanielcota.Atane;
import com.github.hanielcota.misc.ItemBuilder;
import lombok.AllArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public class AtaneInventory implements InventoryHolder {

    private final Inventory inv;
    private Atane plugin;

    public AtaneInventory(Atane plugin) {
        this.plugin = plugin;
        inv = Bukkit.createInventory(this, 3 * 9, "Info da Atane");
        init(plugin);
    }


    private void init(Atane plugin) {
        if (plugin.getClearDrops().getHora() == null) {
            ItemStack notClean = new ItemBuilder(AtaneHead.HEAD.toString())
                    .setAmount(1)
                    .setName("§aAtane")
                    .setLore("§cAinda não executamos uma limpeza...")
                    .build();
            inv.setItem(13, notClean);
        } else {
            ItemStack stack = new ItemBuilder(AtaneHead.HEAD.toString())
                    .setAmount(1)
                    .setName("§aAtane")
                    .setLore("§fÚltima limpeza: §e" + plugin.getClearDrops().getValueDrops() + " removidos.", "§fData: §a" + plugin.getClearDrops().getData(), "§fHora: §a" + plugin.getClearDrops().getHora())
                    .build();
            inv.setItem(13, stack);
        }
    }


    @Override
    public Inventory getInventory() {
        return inv;
    }
}
