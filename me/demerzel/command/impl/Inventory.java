package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.item.ItemSlot;
import me.demerzel.util.Player;
import me.demerzel.util.Game;


public class Inventory extends Command {
    @Override
    public boolean execute(String[] args) {
        Player player = Game.getPlayer();
        System.out.println("Current HP: " + player.getHealth());
        System.out.println("Current Mana: " + player.getMana());
        System.out.println("Current Armor: " + player.getArmor() + "\n");

        if(player.getItems().size() > 0){
            System.out.println("Your current inventory:");
            player.getItems().forEach(System.out::println);
        }else{
            System.out.println("Your inventory is empty.");
        }

        if(player.getEquippedItems().size() > 0){
            System.out.println("\nEquipped items:");
            for (ItemSlot name: player.getEquippedItems().keySet()){
                String value = player.getEquippedItems().get(name).toString();
                System.out.println(value);
            }
        }
        return false;
    }
}
