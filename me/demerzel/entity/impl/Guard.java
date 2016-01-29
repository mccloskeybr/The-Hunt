package me.demerzel.entity.impl;

import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityType;
import me.demerzel.item.impl.Helmet;
import me.demerzel.location.Location;

/**
 * Created by Demerzel on 1/28/16.
 */
public class Guard extends EntityMob{
    public Guard(Location location) {
        super("Guard", "A generic guard", 20, 0, 4, location, 5, 20, 3, "The Guard fires his pistol at you!", EntityType.HOSTILE);
        addLoot(new Helmet());
    }
}