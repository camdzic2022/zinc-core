package me.konekting.zinc.commands.impl.essentials;

import me.konekting.zinc.Zinc;
import me.konekting.zinc.commands.BaseCommand;
import me.konekting.zinc.commands.CommandInfo;
import me.konekting.zinc.utility.chat.CCUtility;
import me.konekting.zinc.utility.general.ErrorUtility;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandInfo(name = "teleporthere", playerOnly = true, permission = "core.tphere")
public class TPHereCommand extends BaseCommand {

    @Override
    public void execute(Player player, String[] args) {
        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                ErrorUtility.send(player, Zinc.getInstance().getConfig().getString("SETTINGS.OFFLINE"));
                return;
            }
            target.teleport(player);
            player.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.TPHERE.TO-PLAYER").replace("<target>", target.getName())));
            target.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.TPHERE.TO-TARGET").replace("<player>", player.getName())));
            return;
        }
        ErrorUtility.send(player, Zinc.getInstance().getConfig().getString("MESSAGES.TPHERE.USAGE"));
        return;
    }
}
