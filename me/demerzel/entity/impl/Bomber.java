package me.demerzel.entity.impl;

import me.demerzel.entity.EntityMob;
import me.demerzel.entity.Runnable;
import me.demerzel.location.Location;
import me.demerzel.util.GameManager;

import java.util.Random;

/**
 * Created by Demerzel on 1/28/16.
 */
public class Bomber extends EntityMob implements Runnable{
    public Bomber(Location location) {
        super("Bomber", "An enemy with suicidal tendencies. If they spot you, they'll rush at you.", 5, 0, 6, location, 3, 50);
    }

    @Override
    public void run(){
        Random random = new Random();
        if(random.nextBoolean()){
            GameManager.getInstance().getPlayer().modHealth(-5);
            System.out.println("The bomber exploded! You lost 5 health!");
        }
    }
}
