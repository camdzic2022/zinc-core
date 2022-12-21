package me.konekting.zinc.commands.impl.essentials;

import me.konekting.zinc.Zinc;
import me.konekting.zinc.commands.BaseCommand;
import me.konekting.zinc.commands.CommandInfo;
import me.konekting.zinc.utility.chat.CCUtility;
import me.konekting.zinc.utility.general.ErrorUtility;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import me.konekting.zinc.utility.general.ErrorUtility;

@CommandInfo(name = "fly", playerOnly = true, permission = "core.fly")
public class FlyCommand extends BaseCommand {

    @Override
    public void execute(Player player, String[] args) {
        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                ErrorUtility.send(player, Zinc.getInstance().getConfig().getString("SETTINGS.OFFLINE"));
                return;
            }
            if (target.getAllowFlight() == true) {
                target.setAllowFlight(false);
                target.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.FLIGHT.DISABLED")));
                player.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.FLIGHT.PLAYER-DISABLED").replace("<player>", target.getName())));
            } else if (target.getAllowFlight() == false) {
                target.setAllowFlight(true);
                target.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.FLIGHT.ENABLED")));
                player.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.FLIGHT.PLAYER-ENABLED").replace("<player>", target.getName())));
            }
        }
        if (args.length == 0) {
            if (player.getAllowFlight() == true) {
                player.setAllowFlight(false);
                player.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.FLIGHT.DISABLED")));
            }
            else if (player.getAllowFlight() == false) {
                player.setAllowFlight(true);
                player.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.FLIGHT.ENABLED")));
            }
        }
    }
}