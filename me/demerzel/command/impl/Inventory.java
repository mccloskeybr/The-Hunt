package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.util.Game;

import java.util.HashMap;


public class Inventory extends Command {
    public Inventory(String[] aliases, String description) {
        super(aliases, description);
    }

    @Override
    public boolean execute(String[] args) {
        EntityPlayer player = Game.getPlayer();
        System.out.println("Current HP: " + player.getHealth());
        System.out.println("Current Mana: " + player.getMana());
        System.out.println("Current Attack: " + player.getAttack());
        System.out.println("Current Armor: " + player.getArmor());
        System.out.println("EXP: " + player.getExperience() + "\n");

        if(player.getInventory().size() > 0){
            System.out.println("Your current inventory:");
            for(Item item : player.getInventory()){
                String output = item.getName();
                if(item.getSlot() == ItemSlot.BACKUP || item.getSlot() == ItemSlot.WEAPON){
                    output += " [" + item.getDamage() + "]";
                }else if(item.getSlot() != ItemSlot.DEFAULT){
                    output += " (" + item.getArmor() + ")";
                }

                System.out.println("<" + item.getSlot().getName() + "> " + output );
            }
        }else{
            System.out.println("Your inventory is empty.");
        }

        if(player.getEquipped().size() > 0){
            System.out.println("\nEquipped items:");
            for(HashMap.Entry<ItemSlot, Item> entry: Game.getPlayer().getEquipped().entrySet()){
                Item item = entry.getValue();
                String output = item.getName();
                if(item.getSlot() == ItemSlot.BACKUP || item.getSlot() == ItemSlot.WEAPON){
                    output += " [" + item.getDamage() + "]";
                }else if(item.getSlot() != ItemSlot.DEFAULT){
                    output += " (" + item.getArmor() + ")";
                }

                System.out.println("<" + item.getSlot().getName() + "> " + output);
            }
        }
        return false;
    }
}
