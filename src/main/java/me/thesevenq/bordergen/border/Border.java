package me.thesevenq.bordergen.border;

import me.thesevenq.bordergen.BorderGenerator;
import me.thesevenq.bordergen.border.managers.BorderManager;
import me.thesevenq.bordergen.border.utils.BorderUtils;
import me.thesevenq.bordergen.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
public class Border {

    public Border(World world, int border) {

        BorderGenerator.getInstance().getBorderManager().addBedrockBorder(world.getName(), border, 5);

        int[] count = {0};

        world.getEntities().stream()
                .filter(entity -> entity != null  && !(entity instanceof Player) && !BorderUtils.checkZone(entity.getLocation(), border))
                .forEach(entity -> {
                    entity.remove();
                    count[0]++;
                });

        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage(Color.translate("&7[&bBorder&7] &eAll entities that were not in &b" + border + "&ex&b" + border + " &esquare were removed. &7(&b" + count[0] + " removed&7)"));        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage("");

    }
}
