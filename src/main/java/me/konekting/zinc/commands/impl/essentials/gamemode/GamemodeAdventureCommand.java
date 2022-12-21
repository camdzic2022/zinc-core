package me.konekting.zinc.commands.impl.essentials.gamemode;

import me.konekting.zinc.commands.BaseCommand;
import me.konekting.zinc.commands.CommandInfo;
import org.bukkit.entity.Player;

@CommandInfo(name = "gma", playerOnly = true, permission = "core.gamemode")
public class GamemodeAdventureCommand extends BaseCommand {

    @Override
    public void execute(Player player, String[] args) {
        if (args.length == 0) {
            player.performCommand("gamemode 2");
        } else {
            player.performCommand("gamemode " + args[0] + " 2");
        }
    }
}
