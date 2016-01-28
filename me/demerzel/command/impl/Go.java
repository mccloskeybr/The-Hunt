package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.location.Exit;
import me.demerzel.util.Game;


public class Go extends Command{
    public Go(String... aliases) {
        super(aliases);
    }

    @Override
    public boolean execute(String[] args) {
        String direction = args[1];
        for (Exit exit : Game.getPlayer().getLocation().getExits()) {
            if (exit.getDirectionName().equalsIgnoreCase(direction)) {
                if(exit.getActive()){
                    Game.getPlayer().setLocation(exit.getLeadsTo());
                    Game.getPlayer().getLocation().run(Game.getPlayer());
                    Game.showLocation();

                    return true;
                }
            }
        }
        return false;
    }
}
