package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.util.GameManager;


public class Crap extends Command {
    public Crap(String... aliases) {
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        if(!player.isPooped()){
            player.setPooped(true);
            System.out.println("You squat down and take a crap in the middle of the room. How unsanitary!");
        }else{
            System.out.println("Your bowels are empty.");
        }
        return false;
    }
}
