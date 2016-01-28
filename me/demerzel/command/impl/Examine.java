package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.location.Location;
import me.demerzel.util.Game;


public class Examine extends Command {
    @Override
    public boolean execute(String[] args) {
        Location location = Game.getPlayer().getLocation();
        System.out.println(location.getCurrentState());

        return false;
    }
}
