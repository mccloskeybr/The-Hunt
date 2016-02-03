package me.demerzel.entity.impl;

import me.demerzel.entity.EntityBehavior;
import me.demerzel.entity.EntityMob;
import me.demerzel.location.Location;

/**
 * Created by Demerzel on 2/2/16.
 */
public class Goblin extends EntityMob {
    public Goblin(Location location) {
        super("Goblin", "A generic video game goblin", 10, 5, 6, location, 10, 5, 2, "The goblin's hair solidifies and fires like needles!", EntityBehavior.HOSTILE);
    }
}
