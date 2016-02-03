package me.demerzel.entity.impl;

import me.demerzel.entity.Entity;
import me.demerzel.entity.EntityBehavior;
import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.location.Location;
import me.demerzel.util.ImageManager;

import java.util.Random;

/**
 * Created by Demerzel on 2/2/16.
 */
public class Depression extends EntityMob {
    private String[] insult = {
            "You're a pathetic loser wasting your time on a text-based video game.",
            "Don't you have anything better to do?",
            "Do you REALLY think you're special?",
            "You're adopted"
    };

    public Depression(Location location) {
        super(new ImageManager().loadImage("/assets/image/entities/depression.png"), "Depression", "The TRUE enemy of humanity", 300, 200, 3, location, 1, 1, 20, "Depression makes you feel bad!", EntityBehavior.HOSTILE);
    }

    @Override
    public void attack(EntityPlayer player){
        int r = new Random().nextInt(insult.length);
        System.out.println(getAttackText());
        say(insult[r], false);
        System.out.println();
        double d = Math.random();
        if(d >= 0.1){
            int damage = Math.min(player.getHealth(), getStrength() - player.getArmor());

            if(damage < 0){
                damage = 0;
            }

            player.modHealth(-damage);
            System.out.println("You took " + damage + " damage! Remaining HP: [" + player.getHealth() + "]");
        }else{
            System.out.println("But he misses. What a jerk!");
        }
    }
}