package me.demerzel.entity.impl;

import me.demerzel.entity.EntityMob;
import me.demerzel.item.Item;
import me.demerzel.item.impl.Revolver;
import me.demerzel.location.Location;
import me.demerzel.util.Game;

/**
 * Created by Demerzel on 1/28/16.
 */
public class Guard extends EntityMob {
    public Guard(Location location) {
        super("Guard", "A generic guard", 20, 0, 4, location, 5, 3);
        addLoot(new Revolver());
    }


    @Override
    public void onDefeat() {
        System.out.println("You have defeated the " + getName());

        for(Item item:this.getLoot()){
            Game.getPlayer().addItem(item);
            System.out.println("Looted " + item.getName() + " from " + getName());
        }

        Game.getPlayer().modExperience(getExpRewarded());
        System.out.println("Gained " + getExpRewarded() + " EXP!");
    }
}