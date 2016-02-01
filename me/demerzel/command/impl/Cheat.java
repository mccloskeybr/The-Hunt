package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.item.ItemManager;

/**
 * Created by Demerzel on 1/31/16.
 */
public class Cheat extends Command {
    public Cheat(String... aliases){
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        switch(args[0]){
            case "addexp":
                player.modExperience(Integer.parseInt(args[1]));
                System.out.println("Added " + args[1] + " EXP.");
                break;
            case "god":
                player.setGod(true);
                System.out.println("You are now invincible.");
                break;
            case "ungod":
                player.setGod(false);
                System.out.println("You can now be damaged.");
                break;
            case "additem":
                ItemManager manager = new ItemManager();
                player.addItem(manager.getItem(args[1]));
                System.out.println("Added " + args[1] + " to your inventory.");
                break;
        }

        return false;
    }
}
