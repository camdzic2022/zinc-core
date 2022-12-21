package me.konekting.zinc.commands.impl.essentials;

import me.konekting.zinc.Zinc;
import me.konekting.zinc.commands.BaseCommand;
import me.konekting.zinc.commands.CommandInfo;
import me.konekting.zinc.utility.chat.CCUtility;
import org.bukkit.entity.Player;

@CommandInfo(name = "day", playerOnly = true, permission = "core.day")
public class DayCommand extends BaseCommand {

    @Override
    public void execute(Player player, String[] args){
        player.getLocation().getWorld().setTime(0);
        player.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.DAY")));
    }
}
