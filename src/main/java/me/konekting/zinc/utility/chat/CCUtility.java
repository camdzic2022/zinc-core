package me.konekting.zinc.utility.chat;

import org.bukkit.ChatColor;

public class CCUtility {

    public static String translate(String input){
        return ChatColor.translateAlternateColorCodes('&', input);
    }

}
