package com.github.hanielcota.misc;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import static com.github.hanielcota.misc.MessageUtils.sendMessageWithSound;

public class ClearMobs {

    private int mobsAlive;

    public ClearMobs(Player player) {
        World world = Bukkit.getWorld(player.getWorld().getName());
        world.getEntities().stream().filter(entity -> !(entity instanceof Player)).forEach(entity -> {
            mobsAlive++;
            entity.remove();
        });
        sendMessageWithSound(player, "§aVocê removeu " + mobsAlive + " mobs do servidor. ");
    }
}
