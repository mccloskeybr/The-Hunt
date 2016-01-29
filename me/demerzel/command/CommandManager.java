package me.demerzel.command;

import me.demerzel.command.impl.*;

import java.util.HashMap;

public class CommandManager {
    private HashMap<String, Command> commandHashMap;

    public CommandManager(){
        commandHashMap = new HashMap<>();

        new Attack("attack").setDescription("Attack an entity. Usage: attack <integer>").register(this);
        new Crap("crap", "poo", "poop").setDescription("Take a poo right where you're standing.").register(this);
        new Dance("dance").setDescription("Break out into a killer dance").register(this);
        new Die("die", "suicide").setDescription("Drop dead in the middle of the room.").register(this);
        new Equip("equip").setDescription("Equip an item from your inventory. Usage: equip <item>").register(this);
        new Examine("examine", "look").setDescription("Examine the room you're in more closely.").register(this);
        new Go("go", "move").setDescription("Move to another room. Usage: go <direction>").register(this);
        new Inventory("items", "inventory").setDescription("Look at your inventory along with your current stats.").register(this);
        new Pickup("pickup").setDescription("Pick up an item off the ground. Usage: pickup <item>").register(this);
        new Sell("sell").setDescription("Not currently in use.").register(this);
        new Use("use").setDescription("Use an item from your inventory. Usage: use <item>").register(this);
        new Wallet("wallet", "money").setDescription("View your wallet.").register(this);
    }

    public Command getCommand(String cmd){
        return commandHashMap.get(cmd);
    }

    public void add(String in, Command command){
        commandHashMap.put(in, command);
    }
}
