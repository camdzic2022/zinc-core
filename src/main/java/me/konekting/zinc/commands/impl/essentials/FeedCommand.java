package me.konekting.zinc.commands.impl.essentials;

import me.konekting.zinc.Zinc;
import me.konekting.zinc.commands.BaseCommand;
import me.konekting.zinc.commands.CommandInfo;
import me.konekting.zinc.utility.chat.CCUtility;
import me.konekting.zinc.utility.general.ErrorUtility;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import me.konekting.zinc.utility.general.ErrorUtility;

@CommandInfo(name = "feed", playerOnly = true, permission = "core.feed")
public class FeedCommand extends BaseCommand {

    @Override
    public void execute(Player player, String[] args) {
        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                ErrorUtility.send(player, "Player is offline.");
                return;
            }
            target.setFoodLevel(20);
            target.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.FEED.FEEDED")));
            player.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.FEED.PLAYER-FEEDED").replace("<player>", target.getName())));
        }
        if (args.length == 0) {
            player.setFoodLevel(20);
            player.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.FEED.FEEDED")));
        }
    }
}