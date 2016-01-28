package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.util.Game;


public class Die extends Command {
    public Die(String[] aliases, String description) {
        super(aliases, description);
    }

    @Override
    public boolean execute(String[] args) {
        System.out.println("You suddenly drop dead. ");
        Game.getPlayer().setHealth(0);
        return false;
    }
}
