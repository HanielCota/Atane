package com.github.hanielcota.runnable;

import com.github.hanielcota.controllers.TimerController;
import com.github.hanielcota.misc.ClickMessage;
import com.github.hanielcota.misc.MessageUtils;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.stream.IntStream;

public class AsyncRunnable extends BukkitRunnable {

    private final TimerController controller = new TimerController();

    @Override
    public void run() {
        IntStream.of(30, 15, 10).filter(i -> controller.getTimer() == i).forEach(i -> {
            Bukkit.getOnlinePlayers().forEach(player -> {
                MessageUtils.sendMessageWithSound(player, "\n§c Atane vai executar uma limpeza em " + controller.getTimer() + " segundos.");
                new ClickMessage(" §fConfira clicando ").then("§f§lAQUI").tooltip("§fComando rápido /atane info").click(ClickEvent.Action.RUN_COMMAND, "/atane info").then(" §fsobre a última limpeza. \n").send(player);
            });
        });
        IntStream.of(5, 4, 3, 2, 1).filter(i -> controller.getTimer() == i).forEach(i -> {
            Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage("§cLimpando em " + controller.getTimer() + " segundos."));
        });
        controller.reduceTimer();
    }
}
