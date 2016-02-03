package me.demerzel.entity.impl;

import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityBehavior;
import me.demerzel.item.impl.armor.BodyArmor;
import me.demerzel.location.Location;
import me.demerzel.util.ImageManager;

/**
 * Created by Demerzel on 1/28/16.
 */
public class Guard extends EntityMob{
    public Guard(Location location) {
        super(new ImageManager().loadImage("/assets/image/entities/guard.png"), "Guard", "A generic guard", 20, 0, 4, location, 20, 20, 3, "The Guard fires his pistol at you!", EntityBehavior.HOSTILE);
        addLoot(new BodyArmor());
    }
}