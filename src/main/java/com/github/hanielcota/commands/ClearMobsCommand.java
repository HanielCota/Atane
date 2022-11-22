package com.github.hanielcota.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import static com.github.hanielcota.misc.MessageUtils.sendMessageWithSound;

@CommandAlias("clearmobs")
@CommandPermission("atane.op")
public class ClearMobsCommand extends BaseCommand {

    private int mobsAlive;

    @Default
    private void onCommand(Player player, String[] args) {
        if (args.length >= 0) {
            World world = Bukkit.getWorld(player.getWorld().getName());
            world.getEntities().stream().filter(entity -> !(entity instanceof Player)).forEachOrdered(entity -> {
                mobsAlive++;
                entity.remove();
            });
            sendMessageWithSound(player, "§aVocê removeu " + mobsAlive + " mobs do servidor. ");
        }
    }
}