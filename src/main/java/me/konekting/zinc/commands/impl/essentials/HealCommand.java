package me.konekting.zinc.commands.impl.essentials;

import me.konekting.zinc.Zinc;
import me.konekting.zinc.commands.BaseCommand;
import me.konekting.zinc.commands.CommandInfo;
import me.konekting.zinc.utility.general.ErrorUtility;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import me.konekting.zinc.utility.general.ErrorUtility;
import me.konekting.zinc.utility.chat.CCUtility;

@CommandInfo(name = "heal", playerOnly = true, permission = "core.heal")
public class HealCommand extends BaseCommand {

    @Override
    public void execute(Player player, String[] args) {
        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                ErrorUtility.send(player, "Player is offline.");
                return;
            }
            target.setHealth(20.0);
            target.setFoodLevel(20);
            target.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.HEAL.HEALED")));
            player.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.HEAL.PLAYER-HEALED").replace("<player>", target.getName())));
        }    
        if (args.length == 0) {
            player.setHealth(20.0);
            player.setFoodLevel(20);
            player.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.HEAL.HEALED")));
        }
    }
}
