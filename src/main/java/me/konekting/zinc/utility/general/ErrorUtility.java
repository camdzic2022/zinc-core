package me.konekting.zinc.utility.general;

import me.konekting.zinc.Zinc;
import me.konekting.zinc.utility.chat.CCUtility;
import org.bukkit.entity.Player;

public class ErrorUtility {

    public static void send(Player player, String error){
        player.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("SETTINGS.ERROR") + error));
    }
}
