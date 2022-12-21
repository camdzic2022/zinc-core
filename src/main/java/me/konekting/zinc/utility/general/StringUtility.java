package me.konekting.zinc.utility.general;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class StringUtility {

    public static String getNiceString(String input){
        return input.toLowerCase().charAt(0) + input.substring(1).toLowerCase();
    }

    public static boolean isInteger(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch(NumberFormatException exception){
            return false;
        }
    }

    public static void giveItem(Player player, Material material, int amount){
        if(player.getInventory().firstEmpty() == -1){
            player.getWorld().dropItemNaturally(player.getLocation(), new ItemStack(material, amount));
        }else{
            player.getInventory().addItem(new ItemStack(material, amount));
        }
    }
}
