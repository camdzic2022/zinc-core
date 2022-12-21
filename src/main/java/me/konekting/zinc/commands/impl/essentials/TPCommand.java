package me.konekting.zinc.commands.impl.essentials;

import me.konekting.zinc.Zinc;
import me.konekting.zinc.commands.BaseCommand;
import me.konekting.zinc.commands.CommandInfo;
import me.konekting.zinc.utility.chat.CCUtility;
import me.konekting.zinc.utility.general.ErrorUtility;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandInfo(name = "teleport", playerOnly = true, permission = "core.tp")
public class TPCommand extends BaseCommand {

    @Override
    public void execute(Player player, String[] args) {
        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                ErrorUtility.send(player, Zinc.getInstance().getConfig().getString("SETTINGS.OFFLINE"));
                return;
            }
            player.teleport(target);
            player.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.TELEPORT.TO-PLAYER").replace("<player>", target.getName())));
            return;
        }
        if(args.length == 2){
            Player teleportPlayer = Bukkit.getPlayer(args[0]);
            Player teleportToPlayer = Bukkit.getPlayer(args[1]);
            if(teleportPlayer == null){
                ErrorUtility.send(player, Zinc.getInstance().getConfig().getString("MESSAGES.TELEPORT.PLAYER-OFFLINE").replace("<player>", args[0]));
                return;
            }
            if(teleportToPlayer == null){
                ErrorUtility.send(player, Zinc.getInstance().getConfig().getString("MESSAGES.TELEPORT.PLAYER-OFFLINE").replace("<player>", args[1]));
                return;
            }
            teleportPlayer.teleport(teleportToPlayer);
            player.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.TELEPORT.PLAYER-TO-TARGET").replace("<target>", teleportPlayer.getName())).replace("<player>", teleportToPlayer.getName()));
            teleportPlayer.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.TELEPORT.TO-PLAYER").replace("<player>", teleportToPlayer.getName())));
            return;
        }
        ErrorUtility.send(player, Zinc.getInstance().getConfig().getString("MESSAGES.TELEPORT.USAGE"));
        return;
    }
}

