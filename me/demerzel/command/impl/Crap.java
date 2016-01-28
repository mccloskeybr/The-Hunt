package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.util.Game;


public class Crap extends Command {
    public Crap(String[] aliases, String description) {
        super(aliases, description);
    }

    @Override
    public boolean execute(String[] args) {
        if(!Game.getPlayer().isPooped()){
            Game.getPlayer().setPooped(true);
            System.out.println("You squat down and take a crap in the middle of the room. How unsanitary!");
        }else{
            System.out.println("Your bowels are empty.");
        }
        return false;
    }
}
