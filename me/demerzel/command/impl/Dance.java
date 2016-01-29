package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.location.Location;
import me.demerzel.util.GameManager;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Demerzel on 1/28/16.
 */
public class Dance extends Command {
    private String[] danceMoves = {
            "You shake dat booty",
            "You shake your moneymaker",
            "You dance your pants off"
    };

    public Dance(String... aliases) {
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        Random rand = new Random();
        Location location = player.getLocation();
        System.out.println(danceMoves[rand.nextInt(danceMoves.length)]);

        if(location.getMobs().size() > 0){
            System.out.println("Your dance moves are so good they melt your foes' brains! \n");

            ArrayList<EntityMob> toRemove = new ArrayList<>();
            for(EntityMob mob: location.getMobs()){
                mob.onDefeat();
                toRemove.add(mob);
            }

            location.getMobs().removeAll(toRemove);
            GameManager.getInstance().showEnemies();
        }
        return false;
    }
}
