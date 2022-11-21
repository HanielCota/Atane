package com.github.hanielcota.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.github.hanielcota.Main;
import com.github.hanielcota.inventory.AtaneInventory;
import com.github.hanielcota.misc.ClickMessage;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.entity.Player;

@CommandPermission("atane.op")
@CommandAlias("atane")
public class AtaneCommand extends BaseCommand {

    @Dependency
    Main plugin;

    @Default
    private void onCommand(Player player, String[] args) {
        if (args.length >= 0) {
            player.sendMessage("");
            new ClickMessage("Clique ").then("§e§lAQUI").click(ClickEvent.Action.RUN_COMMAND, "/clearmobs").then(" para limpar todos mobs do mundo que você está.").send(player);
            new ClickMessage("Clique ").then("§e§lAQUI").click(ClickEvent.Action.RUN_COMMAND, "/cleardrops").then(" para limpar todos drops do chão.").send(player);
            new ClickMessage("Clique ").then("§e§lAQUI").click(ClickEvent.Action.RUN_COMMAND, "/looktps").then(" para ver o tps do servidor.").send(player);
            player.sendMessage("");
        }
    }

    @Subcommand("info")
    private void ataneInfo(Player player) {
        AtaneInventory ataneInventory = new AtaneInventory(plugin);
        player.openInventory(ataneInventory.getInventory());

    }
}
