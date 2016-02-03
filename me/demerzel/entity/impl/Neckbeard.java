package me.demerzel.entity.impl;

import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityBehavior;
import me.demerzel.location.Location;
import me.demerzel.util.ImageManager;

/**
 * Created by Demerzel on 1/29/16.
 */
public class Neckbeard extends EntityMob {
    public Neckbeard(Location location){
        super(new ImageManager().loadImage("/assets/image/entities/neckbeard.png"),"Neckbeard", "A generic neckbeard found at most conventions. M'lady.", 20, 1000, 2, location, 20, 0, 7, "The Neckbeard tips his fedora.", EntityBehavior.HOSTILE);
    }
}
