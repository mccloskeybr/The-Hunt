package me.demerzel.command;

import me.demerzel.command.impl.*;

import java.util.ArrayList;
import java.util.HashMap;

public class CommandManager {
    private HashMap<String, Command> commandHashMap;

    public CommandManager(){
        commandHashMap = new HashMap<>();

        new Battle("battle").setDescription("Battle an entity. Usage: battle <integer>").register(this);
        new Crap("crap", "poo", "poop", "take a poop", "take a crap").setDescription("Take a poo right where you're standing.").register(this);
        new Dance("dance").setDescription("Break out into a killer dance").register(this);
        new Die("die", "suicide", "drop dead").setDescription("Drop dead in the middle of the room.").register(this);
        new Equip("equip", "equip the").setDescription("Equip an item from your inventory. Usage: equip <item>").register(this);
        new Examine("examine", "look closer", "take a closer look", "look at", "look at the").setDescription("Examine the room you're in more closely.").register(this);
        new Go("move", "go to", "move to").setDescription("Move to another room. Usage: go <direction>").register(this);
        new Inventory("items", "inventory", "list items", "show inventory", "show items").setDescription("Look at your inventory along with your current stats.").register(this);
        new Pickup("pickup", "pick up", "pick up the").setDescription("Pick up an item off the ground. Usage: pickup <item>").register(this);
        new Sell("sell", "sell the").setDescription("Not currently in use.").register(this);
        new Wallet("wallet", "money", "open wallet").setDescription("View your wallet.").register(this);
        new Buy("buy", "purchase").setDescription("Buy an item").register(this);
        new Interact("interact", "talk", "talk to").setDescription("Interact with an entity").register(this);
        new Cast("cast").setDescription("Cast a spell at an enemy. Usage: cast <spell> <integer>").register(this);
        new Use("use").setDescription("Use an item from your inventory").register(this);
        new Spellbook("spells", "spellbook").setDescription("View your currently known spells.").register(this);
        new Attack("attack").setDescription("The basic attack move.").register(this);
        new Cheat("addexp", "god", "ungod", "additem").setDescription("A few cheats").register(this);
    }

    public Command getCommand(String cmd){
        return commandHashMap.get(cmd);
    }

    public ArrayList<String> getAliases(Class<? extends Command> get){
        ArrayList<String> aliases = new ArrayList<>();

        for(HashMap.Entry<String, Command> command : commandHashMap.entrySet()){
            if(command.getValue().getClass().equals(get)){
                aliases.add(command.getKey());
            }
        }

        return aliases;
    }

    public HashMap<String, Command> getCommandHashMap(){ return commandHashMap;}

    public void add(String in, Command command){
        commandHashMap.put(in, command);
    }
}
