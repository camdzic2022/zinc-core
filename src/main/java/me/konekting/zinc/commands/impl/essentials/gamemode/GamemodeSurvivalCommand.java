package me.konekting.zinc.commands.impl.essentials.gamemode;

import me.konekting.zinc.commands.BaseCommand;
import me.konekting.zinc.commands.CommandInfo;
import org.bukkit.entity.Player;

@CommandInfo(name = "gms", playerOnly = true, permission = "core.gamemode")
public class GamemodeSurvivalCommand extends BaseCommand {

    @Override
    public void execute(Player player, String[] args) {
        if (args.length == 0) {
            player.performCommand("gamemode 0");
        } else {
            player.performCommand("gamemode " + args[0] + " 0");
        }
    }
}
