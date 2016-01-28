package me.demerzel.command.impl;

import me.demerzel.command.Command;


public class Sell extends Command {
    public Sell(String[] aliases, String description) {
        super(aliases, description);
    }

    @Override
    public boolean execute(String[] args) {
        return false;
    }
}
