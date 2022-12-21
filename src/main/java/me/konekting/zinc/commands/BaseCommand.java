package me.konekting.zinc.commands;

import me.konekting.zinc.Zinc;
import me.konekting.zinc.utility.chat.CCUtility;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class BaseCommand implements CommandExecutor {

    private final CommandInfo commandInfo;

    public Zinc plugin = Zinc.getInstance();

    public BaseCommand(){
        commandInfo = getClass().getDeclaredAnnotation(CommandInfo.class);
        plugin.getCommand(commandInfo.name()).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandInfo.playerOnly() && commandSender instanceof ConsoleCommandSender){
            commandSender.sendMessage(CCUtility.translate("&cOnly players may execute this command."));
            return true;
        }

        if(!commandInfo.permission().isEmpty() && !commandSender.hasPermission(commandInfo.permission())){
                commandSender.sendMessage(CCUtility.translate("&cNo permission."));
                return true;
        }

        if(commandInfo.playerOnly()){
            Player player = (Player) commandSender;
            execute(player, strings);
            return true;
        }else{
            execute(commandSender, strings);
            return true;
        }
    }

    public void execute(Player player, String[] args){}
    public void execute(CommandSender sender, String[] args){}
}
