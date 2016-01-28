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
        super("Guard", "A generic guard", 10, 0, 4, location, 5, 3);
        addLoot(new Revolver());
    }

    @Override
    public void onDefeat() {
        for(Item item:this.getLoot()){
            Game.getPlayer().addItem(item);
        }

        Game.getPlayer().modExperience(getExpRewarded());
        System.out.println("You have defeated " + getName());
    }
}