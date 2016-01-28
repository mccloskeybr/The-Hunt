package me.demerzel.command;

import me.demerzel.command.impl.*;

import java.util.HashMap;

public class Commands {
    private HashMap<String, Command> commandHashMap;

    public Commands(){
        commandHashMap = new HashMap<>();

        new Attack(new String[] {"attack"}, "Attack an enemy entity. Usage: attack <integer>").register(this);
        new Crap(new String[] {"poop", "poo", "crap"}, "Take a poo right on the floor.").register(this);
        new Dance(new String[] {"dance"}, "Dance like you've never danced before.").register(this);
        new Die(new String[] {"die", "suicide"}, "Drop dead where you're standing.").register(this);
        new Equip(new String[] {"equip"}, "Equip an item from your inventory. Usage: equip <item>").register(this);
        new Examine(new String[] {"examine", "look"}, "Look around the room more closely").register(this);
        new Go(new String[] {"go", "move"}, "Move to a different location. Usage: go <direction>").register(this);
        new Inventory(new String[] {"items", "inventory"}, "Look at your inventory, including your stats.").register(this);
        new Pickup(new String[] {"pickup"}, "Pick up an item off the ground. Usage: pickup <item>").register(this);
        new Sell(new String[] {"sell"}, "Not used at this time.").register(this);
        new Use(new String[] {"use"}, "Use an item in your inventory. Usage: use <item>").register(this);
        new Wallet(new String[] {"wallet", "money"}, "Look at your wallet").register(this);
    }

    public Command getCommand(String cmd){
        return commandHashMap.get(cmd);
    }

    public void add(String in, Command command){
        commandHashMap.put(in, command);
    }
}
