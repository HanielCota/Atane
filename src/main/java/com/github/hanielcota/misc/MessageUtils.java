package com.github.hanielcota.misc;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.Objects;

public class MessageUtils {

    public static void sendMessageWithSound(Player player, String message) {
        player.sendMessage(Objects.isNull(message) ? "§cO Administrador deve inserir uma mensagem dentro do método." : message);
        player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
    }
}
