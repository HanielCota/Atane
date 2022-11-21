package com.github.hanielcota.methods;

import co.aikar.commands.Locales;
import co.aikar.commands.PaperCommandManager;
import com.github.hanielcota.Atane;
import com.github.hanielcota.commands.AtaneCommand;
import com.github.hanielcota.commands.ClearDropsCommand;
import com.github.hanielcota.commands.ClearMobsCommand;
import com.github.hanielcota.commands.TpsCommand;
import lombok.val;

import java.util.logging.Level;

public class CommandManager {

    public CommandManager(Atane plugin) {
        val logger = plugin.getLogger();
        try {
            PaperCommandManager manager = new PaperCommandManager(plugin);
            manager.registerCommand(new AtaneCommand());
            manager.registerCommand(new ClearMobsCommand());
            manager.registerCommand(new ClearDropsCommand());
            manager.registerCommand(new TpsCommand());
            manager.getLocales().setDefaultLocale(Locales.PORTUGUESE);
            logger.log(Level.INFO, () -> "§awere registered successful commands!");
        } catch (RuntimeException e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, () -> "could not register commands.");
        }
    }

}
