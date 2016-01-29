package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.location.Exit;
import me.demerzel.location.Location;
import me.demerzel.location.Runnable;
import me.demerzel.util.GameManager;


public class Go extends Command{
    public Go(String... aliases) {
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        String direction = args[1];
        Location location = player.getLocation();
        for (Exit exit : location.getExits()) {
            if (exit.getDirectionName().equalsIgnoreCase(direction)) {
                if(exit.getActive()){
                    player.setLocation(exit.getLeadsTo());

                    if(location instanceof Runnable){
                        ((Runnable) player.getLocation()).run(player);
                    }

                    GameManager.getInstance().showLocation();

                    return true;
                }
            }
        }
        return false;
    }
}
