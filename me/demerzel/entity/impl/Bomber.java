package me.demerzel.entity.impl;

import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.entity.EventKilled;
import me.demerzel.location.Location;
import me.demerzel.util.GameManager;

import java.util.Random;

/**
 * Created by Demerzel on 1/28/16.
 */
public class Bomber extends EntityMob implements EventKilled {
    public Bomber(Location location) {
        super("Bomber", "An enemy with suicidal tendencies. If they spot you, they'll rush at you.", 5, 0, 6, location, 3, 2, 50, "The Bomber rushes at you! He explodes!");
    }

    @Override
    public void onDeath(EntityPlayer player){
        double d = Math.random();
        if(d >= 0.6){
            int damage = Math.max(0, 5 - player.getArmor());
            player.modHealth(-damage);
            System.out.println("The bomber exploded! You lost " + damage + " health! Remaining HP: [" + player.getHealth() + "]");
        }
    }

    @Override
    public void attack(EntityPlayer player){
        System.out.println(getAttackText());
        double d = Math.random();
        if(d >= 0.1){
            int damage = Math.min(player.getHealth(), getStrength() - player.getArmor());
            damage = Math.max(0, damage);

            player.modHealth(-damage);
            System.out.println("You took " + damage + " damage! Remaining HP: [" + player.getHealth() + "]");
        }else{
            System.out.println("But he misses. What a jerk!");
        }

        player.getLocation().removeMob(this);
    }
}
