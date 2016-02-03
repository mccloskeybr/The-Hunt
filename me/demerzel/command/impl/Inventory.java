package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.ItemType;
import me.demerzel.item.impl.weapon.Fists;

import java.util.HashMap;


public class Inventory extends Command {
    public Inventory(String... aliases) {
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        System.out.println("================ Stats ================");
        System.out.println("You are " + player.getName() + ".");
        System.out.println("Current HP: " + player.getHealth());
        System.out.println("Current Mana: " + player.getMana());
        System.out.println("Current Attack: " + player.getAttack());
        System.out.println("Current Speed: " + player.getSpeed());
        System.out.println("Current Armor: " + player.getArmor());
        System.out.println("Current Level: " + player.getLevel());
        System.out.println("Current EXP: " + player.getExperience());
        System.out.println("Required EXP: " + player.nextLevel());
        System.out.println("======================================= \n");

        System.out.println("============== Inventory ==============");
        if(player.getInventory().size() > 0){
            for(Item item : player.getInventory()){
                String output = item.getName();
                if(item instanceof Fists)
                    continue;

                if(item.getType() == ItemType.SINGLETARGET || item.getType() == ItemType.MULTITARGET) {
                    output += " [Damage: " + item.getMagnitude() + "]";
                }else if(item.getType() == ItemType.FIREONCE){
                    output += " [Potency: " + item.getMagnitude() + "]";
                }else if(item.getType() == ItemType.ARMOR){
                    output += " [Armor: " + item.getArmor() + "]";
                }

                System.out.println("<" + item.getSlot().getName() + "> " + output + " | " + item.getDescription());
            }
        }else{
            System.out.println("Your inventory is empty.");
        }

        System.out.println("======================================= \n");

        if(player.getEquipped().size() > 0){
            System.out.println("============== Equipped ===============");
            for(HashMap.Entry<ItemSlot, Item> entry: player.getEquipped().entrySet()){
                Item item = entry.getValue();

                String output = item.getName();
                if(item.getType() == ItemType.SINGLETARGET || item.getType() == ItemType.MULTITARGET) {
                    output += " [Damage: " + item.getMagnitude() + "]";
                }else if(item.getType() == ItemType.FIREONCE){
                    output += " [Potency: " + item.getMagnitude() + "]";
                }else if(item.getType() == ItemType.ARMOR){
                    output += " [Armor: " + item.getArmor() + "]";
                }

                System.out.println("<" + item.getSlot().getName() + "> " + output + " | " + item.getDescription());
            }
            System.out.println("=======================================");
        }
        return false;
    }
}
