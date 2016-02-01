package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.location.Exit;
import me.demerzel.location.Location;
import me.demerzel.location.EventEnter;
import me.demerzel.util.GameManager;


public class Go extends Command{
    public Go(String... aliases) {
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        if(args.length < 2){
            System.out.println("Go where?");
            return false;
        }

        String direction = args[1];
        Location location = player.getLocation();
        for (Exit exit : location.getExits()) {
            if (exit.getDirectionName().equalsIgnoreCase(direction)) {
                if(exit.getActive()){
                    player.setLocation(exit.getLeadsTo());

                    if(player.getLocation() instanceof EventEnter){
                        ((EventEnter) player.getLocation()).onEnter(player);
                    }

                    GameManager.getInstance().showLocation();
                    return true;
                }
            }
        }
        return false;
    }
}
