package me.konekting.zinc.commands.impl.essentials.gamemode;

import me.konekting.zinc.Zinc;
import me.konekting.zinc.commands.BaseCommand;
import me.konekting.zinc.commands.CommandInfo;
import me.konekting.zinc.managers.EssentialsManager;
import me.konekting.zinc.utility.chat.CCUtility;
import me.konekting.zinc.utility.general.ErrorUtility;
import me.konekting.zinc.utility.general.StringUtility;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import me.konekting.zinc.utility.general.ErrorUtility;

@CommandInfo(name = "gamemode", playerOnly = true, permission = "core.gamemode")
public class GamemodeCommand extends BaseCommand {

    EssentialsManager essentialsManager = Zinc.getInstance().getEssentialsManager();

    @Override
    public void execute(Player player, String[] args) {
        if (args.length == 0) {
            helpMessage(player);
            return;
        }
        if (args.length == 1) {
            if(essentialsManager.getByString(args[0]) == null){
                helpMessage(player);
                return;
            }
            GameMode gameMode = essentialsManager.getByString(args[0]);
            if (player.getGameMode() == gameMode) {
                player.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.GAMEMODE.ALREADY").replace("<gamemode>", StringUtility.getNiceString(gameMode.toString()))));
                return;
            }
            player.setGameMode(gameMode);
            player.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.GAMEMODE.UPDATED").replace("<gamemode>", StringUtility.getNiceString(gameMode.toString()))));
            return;
        }
        if (args.length == 2) {
            if (essentialsManager.getByString(args[0]) == null) {
                helpMessage(player);
                return;
            }
            GameMode gameMode = essentialsManager.getByString(args[0]);
            Player target = Bukkit.getPlayer(args[1]);
            if (target == null) {
                ErrorUtility.send(player, Zinc.getInstance().getConfig().getString("SETTINGS.OFFLINE"));
                return;
            }

            if (target.getGameMode() == gameMode) {
                player.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.GAMEMODE.PLAYER-ALREADY").replace("<gamemode>", StringUtility.getNiceString(gameMode.toString()))));
                return;
            }
            target.setGameMode(gameMode);
            if (!player.getName().equalsIgnoreCase(target.getName())) {
                target.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.GAMEMODE.UPDATED").replace("<gamemode>", StringUtility.getNiceString(gameMode.toString()))));
            }
            player.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.GAMEMODE.PLAYER-UPDATED").replace("<gamemode>", StringUtility.getNiceString(gameMode.toString()))).replace("<player>", target.getName()));
            return;
        }
        helpMessage(player);
        return;
    }

    private void helpMessage(Player player){
        Zinc.getInstance().getConfig().getStringList("MESSAGES.GAMEMODE.USAGE").forEach(line -> player.sendMessage(CCUtility.translate(line)));
    }
}
