package me.konekting.zinc.listeners;

import me.konekting.zinc.Zinc;
import me.konekting.zinc.managers.ChatManager;
import me.konekting.zinc.utility.general.ErrorUtility;
import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import me.konekting.zinc.utility.general.ErrorUtility;
import me.konekting.zinc.utility.chat.CCUtility;

public class PlayerListener implements Listener{

    ChatManager chatManager = Zinc.getInstance().getChatManager();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();

        if(player.hasPermission("core.staff.chat")) return;
        if(chatManager.isChatMuted()){
            ErrorUtility.send(player, Zinc.getInstance().getConfig().getString("MESSAGES.CHATMANAGER.SORRY-MUTED"));
            event.setCancelled(true);
            return;
        }
    }
}
