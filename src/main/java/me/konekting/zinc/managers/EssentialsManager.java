package me.konekting.zinc.managers;

import org.bukkit.GameMode;

public class EssentialsManager {

    public GameMode getByString(String string){
        switch(string){
            case "survival": case "s": case "0":
                return GameMode.SURVIVAL;
            case "creative": case "c": case "1":
                return GameMode.CREATIVE;
            case "adventure": case "a": case "2":
                return GameMode.ADVENTURE;
            case "spectator": case "spec": case "3":
                return GameMode.SPECTATOR;
        }
        return null;
    }
}
