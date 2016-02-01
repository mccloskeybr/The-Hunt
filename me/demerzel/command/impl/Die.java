package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.util.GameManager;


public class Die extends Command {
    public Die(String... aliases) {
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        System.out.println("You suddenly drop dead. ");
        player.setHealth(0);
        return false;
    }
}
