package me.thesevenq.bordergen.border.utils;

import org.bukkit.Location;

public class BorderUtils {

    public static boolean checkZone(Location location, int input) {
        return Math.abs(location.getBlockX()) <= input && Math.abs(location.getBlockZ()) <= input;
    }
}
