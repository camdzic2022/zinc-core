package me.konekting.zinc.commands.impl.staff;

import com.sun.xml.internal.ws.util.StringUtils;
import me.konekting.zinc.Zinc;
import me.konekting.zinc.commands.BaseCommand;
import me.konekting.zinc.commands.CommandInfo;
import me.konekting.zinc.utility.chat.CCUtility;
import me.konekting.zinc.utility.general.ErrorUtility;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import me.konekting.zinc.utility.general.ErrorUtility;

@CommandInfo(name = "chat", playerOnly = true, permission = "core.staff.chat")
public class ChatCommand extends BaseCommand {

    @Override
    public void execute(Player player, String[] args) {
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("clear")) {
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 100));
                Bukkit.broadcastMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.CHATMANAGER.CLEARED-BY").replace("<player>", player.getName())));
                return;
            }
            if (args[0].equalsIgnoreCase("mute")) {
                if (Zinc.getInstance().getChatManager().isChatMuted()) {
                    ErrorUtility.send(player, Zinc.getInstance().getConfig().getString("MESSAGES.CHATMANAGER.MUTED-ALREADY"));
                    return;
                }
                Zinc.getInstance().getChatManager().setChatMuted(true);
                Bukkit.broadcastMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.CHATMANAGER.MUTED-BY").replace("<player>", player.getName())));
                return;
            }
            if (args[0].equalsIgnoreCase("unmute")) {
                if (!Zinc.getInstance().getChatManager().isChatMuted()) {
                    ErrorUtility.send(player, Zinc.getInstance().getConfig().getString("MESSAGES.CHATMANAGER.NOT-MUTED"));
                    return;
                }
                Zinc.getInstance().getChatManager().setChatMuted(false);
                Bukkit.broadcastMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.CHATMANAGER.UNMUTED-BY").replace("<player>", player.getName())));
                return;
            }
        }
        helpMessage(player);
        return;
    }

    private void helpMessage(Player player){
        Zinc.getInstance().getConfig().getStringList("MESSAGES.CHATMANAGER.USAGE").forEach(line -> player.sendMessage(CCUtility.translate(line)));
    }
}
