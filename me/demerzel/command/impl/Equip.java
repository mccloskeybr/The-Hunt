package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.item.Item;
import me.demerzel.item.ItemType;
import me.demerzel.util.GameManager;


public class Equip extends Command {
    public Equip(String... aliases) {
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        if(args.length < 2){
            System.out.println("Equip what?");
            return false;
        }

        for(Item item: player.getInventory()){
            if(item.getName().equalsIgnoreCase(args[1])){
                if(item.getType() == ItemType.FIREONCE){
                    System.out.println("You can't equip that item!");
                    return false;
                }

                player.equip(item);
                System.out.println("You equipped the " + item.getName());
                return true;
            }
        }

        System.out.println("You don't have that item!");
        return false;
    }
}
