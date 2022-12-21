package me.konekting.zinc.commands.impl.essentials;

import me.konekting.zinc.Zinc;
import me.konekting.zinc.commands.BaseCommand;
import me.konekting.zinc.commands.CommandInfo;
import me.konekting.zinc.utility.chat.CCUtility;
import org.bukkit.entity.Player;

@CommandInfo(name = "night", playerOnly = true, permission = "core.night")
public class NightCommand extends BaseCommand {

    @Override
    public void execute(Player player, String[] args){
        player.getLocation().getWorld().setTime(13000);
        player.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.NIGHT")));
    }
}
