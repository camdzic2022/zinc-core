package me.konekting.zinc.commands.impl.essentials;

import me.konekting.zinc.Zinc;
import me.konekting.zinc.commands.BaseCommand;
import me.konekting.zinc.commands.CommandInfo;
import me.konekting.zinc.utility.chat.CCUtility;
import me.konekting.zinc.utility.general.ErrorUtility;
import me.konekting.zinc.utility.general.StringUtility;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Locale;

@CommandInfo(name = "give", playerOnly = true, permission = "core.give")
public class GiveCommand extends BaseCommand {

    @Override
    public void execute(Player player, String[] args){
        if(args.length == 3){
            Player target = Bukkit.getPlayer(args[0]);
            if(target == null){
                ErrorUtility.send(player, Zinc.getInstance().getConfig().getString("SETTINGS.OFFLINE"));
                return;
            }
            if(!StringUtility.isInteger(args[1])){
                ErrorUtility.send(player, "Amount must be valid number.");
                return;
            }
            int amount = Integer.parseInt(args[1]);
            Material material = null;

            try{
                material = Material.valueOf(args[2].toUpperCase());
            }catch(Exception exception){
                ErrorUtility.send(player, "Item must be valid item.");
                return;
            }

            player.sendMessage(CCUtility.translate(Zinc.getInstance().getConfig().getString("MESSAGES.GIVE.GAVE").replace("<player>", target.getName())).replace("<item>", args[2].toUpperCase()).replace("<amount>", args[1]));
            StringUtility.giveItem(target, material, amount);
            return;
        }
        ErrorUtility.send(player, Zinc.getInstance().getConfig().getString("MESSAGES.GIVE.USAGE"));
        return;
    }
}
