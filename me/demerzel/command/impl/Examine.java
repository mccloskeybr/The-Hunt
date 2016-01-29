package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.location.Location;
import me.demerzel.util.GameManager;


public class Examine extends Command {
    public Examine(String... aliases) {
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        Location location = player.getLocation();
        System.out.println(location.getCurrentState());

        return false;
    }
}
