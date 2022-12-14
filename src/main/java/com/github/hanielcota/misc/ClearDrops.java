package com.github.hanielcota.misc;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Item;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClearDrops {
    private static int drops;
    private static String data;
    private static String hora;

    public void clear() {
        World world = Bukkit.getWorld("world");
        world.getEntities().stream().filter(Item.class::isInstance).forEach(item -> {
            drops++;
            item.getWorld().playEffect(item.getLocation(), Effect.SMOKE, 1);
            item.remove();
            init();
        });
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendMessage("┬žeCalculamos um total de " + drops + " itens removidos pelo mundo.");
            player.playSound(player.getLocation(), Sound.CAT_MEOW, 5, 5);
        });
    }

    private void init() {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        data = format.format(now);
        ClearDrops.hora = simpleDateFormat.format(now);
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public int getValueDrops() {
        return drops;
    }
}
