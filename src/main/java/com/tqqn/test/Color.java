package com.tqqn.test;

import org.bukkit.ChatColor;

public class Color {

    public static String translate(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
