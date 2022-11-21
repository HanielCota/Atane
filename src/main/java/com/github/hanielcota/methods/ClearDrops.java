package com.github.hanielcota.methods;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Item;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClearDrops {
    public static int drops;
    public static String data;
    public static String hora;

    public int getDrops() {
        return drops;
    }

    public void clear() {
        World world = Bukkit.getWorld("world");
        world.getEntities().stream().filter(Item.class::isInstance).forEach(item -> {
            drops++;
            item.getWorld().playEffect(item.getLocation(), Effect.SMOKE, 1);
            item.remove();
        });
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendMessage("§eCalculamos um total de " + drops + " itens removidos pelo mundo.");
            player.playSound(player.getLocation(), Sound.EXPLODE, 5, 5);
        });
        init();
    }

    private void init() {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        data = format.format(now);
        hora = simpleDateFormat.format(now);
    }
}
