package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.command.CommandManager;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.util.GameManager;

import java.util.HashMap;

/**
 * Created by Demerzel on 2/1/16.
 */
public class Help extends Command {
    public Help(String... aliases){
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        CommandManager manager = GameManager.getInstance().getFactory();

        for(HashMap.Entry<String, Command> hash : manager.getCommandHashMap().entrySet()){
            System.out.println(manager.getAliases(hash.getValue().getClass()));
        }

        return false;
    }
}
