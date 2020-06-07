package me.thesevenq.bordergen;

import lombok.Getter;
import me.thesevenq.bordergen.commands.BorderCommand;
import me.thesevenq.bordergen.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;


public class BorderGenerator extends JavaPlugin {

    @Getter private static BorderGenerator instance;
    @Getter private CommandMap commandMap;

    public void onEnable() {
        instance = this;

        registerCommands();

        Bukkit.getConsoleSender().sendMessage(Color.translate("&7[&bBorderGenerator&7] &ePlugin has been succesfully enabled."));

    }

    public void registerCommands() {
        getCommand("border").setExecutor(new BorderCommand());
    }
}
