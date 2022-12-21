package me.konekting.zinc;

import lombok.Getter;
import me.konekting.zinc.commands.impl.essentials.gamemode.GamemodeAdventureCommand;
import me.konekting.zinc.commands.impl.essentials.gamemode.GamemodeCommand;
import me.konekting.zinc.commands.impl.essentials.gamemode.GamemodeCreativeCommand;
import me.konekting.zinc.commands.impl.essentials.gamemode.GamemodeSurvivalCommand;
import me.konekting.zinc.commands.impl.staff.ChatCommand;
import me.konekting.zinc.commands.impl.essentials.*;
import me.konekting.zinc.listeners.PlayerListener;
import me.konekting.zinc.managers.ChatManager;
import me.konekting.zinc.managers.EssentialsManager;
import me.konekting.zinc.utility.chat.CCUtility;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class Zinc extends JavaPlugin {

    @Getter private static Zinc instance;

    private ChatManager chatManager;
    private EssentialsManager essentialsManager;

    @Override
    public void onEnable() {
        onLoadMessage();

        this.instance = this;

        this.registerConfig();

        chatManager = new ChatManager();
        essentialsManager = new EssentialsManager();

        this.registerCommands();
        this.registerListeners();
    }

    private void registerCommands() {
        new GamemodeCommand();
        new GamemodeCreativeCommand();
        new GamemodeSurvivalCommand();
        new GamemodeAdventureCommand();
        new FlyCommand();
        new HealCommand();
        new FeedCommand();
        new ChatCommand();
        new DayCommand();
        new NightCommand();
        new InvseeCommand();
        new GiveCommand();
        new TPCommand();
        new TPHereCommand();
    }

    private void registerListeners(){
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
    }

    public ChatManager getChatManager() {
        return chatManager;
    }

    public EssentialsManager getEssentialsManager() {
        return essentialsManager;
    }

    private void registerConfig(){
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
    }

    public static final void onLoadMessage() {
        Bukkit.getConsoleSender().sendMessage(CCUtility.translate("&7&m---------------------------"));
        Bukkit.getConsoleSender().sendMessage(CCUtility.translate("&6&lZinc"));
        Bukkit.getConsoleSender().sendMessage(CCUtility.translate(""));
        Bukkit.getConsoleSender().sendMessage(CCUtility.translate("&eState: &aEnabled"));
        Bukkit.getConsoleSender().sendMessage(CCUtility.translate("&eType: &6Core"));
        Bukkit.getConsoleSender().sendMessage(CCUtility.translate("&eAuthor: &6connetinq_"));
        Bukkit.getConsoleSender().sendMessage(CCUtility.translate("&7&m---------------------------"));
    }
}
