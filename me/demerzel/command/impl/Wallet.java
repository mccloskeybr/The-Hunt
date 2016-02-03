package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.util.GameManager;


public class Wallet extends Command {
    public Wallet(String... aliases) {
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        System.out.println("You currently have " + player.getMoney() + " gold.");
        return false;
    }
}
