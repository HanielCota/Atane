package com.github.hanielcota.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.github.hanielcota.misc.TimeUtils;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.lang.management.ManagementFactory;
import java.util.List;

@CommandPermission("atane.op")
@CommandAlias("looktps")
public class TpsCommand extends BaseCommand {

    @Default
    private void onCommand(Player sender) {
        final long uptime = ManagementFactory.getRuntimeMXBean().getUptime();
        final long maxMemory = Runtime.getRuntime().maxMemory();
        final long freeMemory = Runtime.getRuntime().freeMemory();
        final int processors = Runtime.getRuntime().availableProcessors();

        final double[] recentTps = MinecraftServer.getServer().recentTps;
        final String tps1 = String.format("%.2f", recentTps[0]).replace(",", ".");
        final String tps2 = String.format("%.2f", recentTps[1]).replace(",", ".");
        final String tps3 = String.format("%.2f", recentTps[2]).replace(",", ".");

        final int sizeOfRunnables = MinecraftServer.getServer().processQueue.size() + Bukkit.getScheduler().getActiveWorkers().size() + Bukkit.getScheduler().getPendingTasks().size();

        final double lagOfTPS = Math.round((1.0D - recentTps[0] / 20.0D) * 100.0D);

        final String jarType = Bukkit.getVersion().split("git-")[1].split("-")[0];
        final String version = Bukkit.getVersion().split("MC: ")[1].split("\\)")[0];

        sender.sendMessage("");
        sender.sendMessage("§a Informações de desempenho");
        sender.sendMessage("");
        sender.sendMessage("  §7Tempo de Execução: §f" + TimeUtils.format(uptime));
        sender.sendMessage("  §7Versão do servidor: §f" + jarType + " " + version);
        sender.sendMessage("  §7Núcleos do Processador: §f" + processors);
        sender.sendMessage("  §7Memória: §f" + formatSize(maxMemory - freeMemory) + "/" + formatSize(maxMemory));
        sender.sendMessage("  §7TPS (1m, 5m, 15): §f" + tps1 + ", " + tps2 + ", " + tps3 + " [ " + lagOfTPS + "% ]");
        sender.sendMessage("  §7Tasks: §f" + sizeOfRunnables);
        sender.sendMessage("");

        List<World> listWorlds = Bukkit.getWorlds();
        sender.sendMessage("  §aLista de Mundos (" + listWorlds.size() + ")");
        sender.sendMessage("");
        listWorlds.stream().map(world -> "  §7- §f" + world.getName() + "§7 (Chunks: §f" + world.getLoadedChunks().length + "§7, Entidades: §f" + world.getLivingEntities().size() + "§7)").forEach(sender::sendMessage);
        sender.sendMessage("");
    }

    private String formatSize(long v) {
        int z = (63 - Long.numberOfLeadingZeros(v)) / 10;
        return String.format("%.1f %sB", (double) v / (1L << (z * 10)), " KMGTPE".charAt(z));
    }

}
