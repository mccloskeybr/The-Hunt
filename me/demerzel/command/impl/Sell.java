package me.demerzel.command.impl;

import me.demerzel.command.Command;


public class Sell extends Command {
    public Sell(String... aliases) {
        super(aliases);
    }

    @Override
    public boolean execute(String[] args) {
        return false;
    }
}
