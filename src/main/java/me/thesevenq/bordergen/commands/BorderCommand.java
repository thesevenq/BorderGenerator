package me.thesevenq.bordergen.commands;

import me.thesevenq.bordergen.BorderGenerator;
import me.thesevenq.bordergen.border.Border;
import me.thesevenq.bordergen.border.helper.BorderHelper;
import me.thesevenq.bordergen.border.utils.BorderUtils;
import me.thesevenq.bordergen.utils.Color;
import net.minecraft.util.org.apache.commons.lang3.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BorderCommand implements CommandExecutor {

    public BorderCommand() {
        BorderGenerator.getInstance().getCommand("border").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(!(sender.hasPermission("border.use") || sender.isOp())) {
            player.sendMessage(Color.translate("&cNo permission!"));
            return false;
        }

        if (args.length != 2 || !NumberUtils.isNumber(args[1])) {
            player.sendMessage(Color.translate("&cUsage: /border <world> <radius>"));
            return false;
        }

        int amount = Integer.valueOf(args[1]);

        if (amount > 5000) {
            sender.sendMessage(Color.translate("&7[&4Border&7] &cBorder limit is &45000&c."));
            return false;
        }

        new Border(Bukkit.getWorld(args[0]), amount);

        player.sendMessage(Color.translate("&7[&bBorder&7] &eStarted placing border."));
        player.sendMessage(Color.translate("&7[&bBorder&7] &eYou have &asucessfully &eplaced border with radius of &b" + amount + " &ein world named &b" + args[0] + "&e."));

        World world = player.getWorld();
        world.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 10, 1);

        return false;
    }
}

