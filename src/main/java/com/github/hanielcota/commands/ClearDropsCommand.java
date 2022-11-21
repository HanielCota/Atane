package com.github.hanielcota.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

import static com.github.hanielcota.misc.sendMessage.sendMessageWithSound;

@CommandPermission("atane.op")
@CommandAlias("cleardrops")
public class ClearDropsCommand extends BaseCommand {

    private int drops;

    @Default
    public void onCommand(Player player, String[] args) {
        if (args.length >= 0) {
            World world = player.getWorld();
            world.getEntities().stream().filter(Item.class::isInstance).forEachOrdered(item -> {
                drops++;
                item.remove();
            });
            sendMessageWithSound(player, "§aVocê removeu " + drops + " drops do chão. ");
        }
    }
}
