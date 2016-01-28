package me.demerzel.command;

import me.demerzel.command.impl.*;

public class CommandFactory {
    public Command getCommand(String cmd){
        if(cmd.equalsIgnoreCase("die") || cmd.equalsIgnoreCase("drop dead") || cmd.equalsIgnoreCase("commit suicide")){
            return new Die();
        }else if(cmd.startsWith("pickup")){
            return new Pickup();
        }else if(cmd.startsWith("examine")){
            return new Examine();
        }else if(cmd.equalsIgnoreCase("take a poo") || cmd.equalsIgnoreCase("take a crap") || cmd.equalsIgnoreCase("poo") || cmd.equalsIgnoreCase("poop")){
            return new Crap();
        }else if(cmd.startsWith("go")){
            return new Go();
        }else if(cmd.equalsIgnoreCase("items")){
            return new Inventory();
        }else if(cmd.equalsIgnoreCase("wallet")){
            return new Wallet();
        }else if(cmd.startsWith("use")){
            return new Use();
        }else if(cmd.equalsIgnoreCase("equip")){
            return new Equip();
        }

        return null;
    }
}
