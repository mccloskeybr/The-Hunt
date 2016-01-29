package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityMob;
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

        if(location.getMobs().size() > 1 || location.getMobs().size() == 0){
            System.out.println("There are " + location.getMobs().size() + " entities in here.");
        }else{
            System.out.println("There is 1 entity in here.");
        }
        for(EntityMob mob : location.getMobs()){
            System.out.println("> " + mob.getName() + " | " + mob.getBio());
        }

        return false;
    }
}
