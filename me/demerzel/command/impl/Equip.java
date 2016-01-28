package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.item.Item;
import me.demerzel.util.Game;


public class Equip extends Command {
    public Equip(String... aliases) {
        super(aliases);
    }

    @Override
    public boolean execute(String[] args) {
        EntityPlayer player = Game.getPlayer();
        for(Item item: player.getInventory()){
            if(item.getName().equalsIgnoreCase(args[1])){
                player.equip(item);
                System.out.println("You equipped the " + item.getName());
                return true;
            }
        }
        return false;
    }
}
