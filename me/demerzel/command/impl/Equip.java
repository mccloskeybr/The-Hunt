package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.item.Item;
import me.demerzel.util.Player;
import me.demerzel.util.Game;


public class Equip extends Command {
    @Override
    public boolean execute(String[] args) {
        Player player = Game.getPlayer();
        for(Item item: player.getItems()){
            if(item.getName().equalsIgnoreCase(args[1])){
                player.equip(item);
                System.out.println("You equipped the " + item.getName());
                return true;
            }
        }
        return false;
    }
}
