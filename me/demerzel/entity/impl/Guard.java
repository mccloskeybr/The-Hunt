package me.demerzel.entity.impl;

import me.demerzel.entity.Attackable;
import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.item.impl.Helmet;
import me.demerzel.location.Location;

/**
 * Created by Demerzel on 1/28/16.
 */
public class Guard extends EntityMob implements Attackable {
    public Guard(Location location) {
        super("Guard", "A generic guard", 20, 0, 4, location, 5, 3);
        addLoot(new Helmet());
    }

    @Override
    public void attack(EntityPlayer player) {
        System.out.println("The guard fires his pistol at you!");
        double d = Math.random();
        if(d >= 0.1){
            int damage = getStrength() - player.getArmor();
            player.modHealth(-damage);
            System.out.println("You took " + damage + " damage!");
        }else{
            System.out.println("But he misses. What a jerk!");
        }
    }
}