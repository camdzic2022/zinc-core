package me.konekting.zinc.commands.impl.essentials.gamemode;

import me.konekting.zinc.commands.BaseCommand;
import me.konekting.zinc.commands.CommandInfo;
import me.konekting.zinc.utility.command.CommandArgs;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandInfo(name = "gmc", playerOnly = true, permission = "core.gamemode")
public class GamemodeCreativeCommand extends BaseCommand {

    @Override
    public void execute(Player player, String[] args) {
        if (args.length == 0) {
            player.performCommand("gamemode 1");
        } else {
            player.performCommand("gamemode " + args[0] + " 1");
        }
    }
}
