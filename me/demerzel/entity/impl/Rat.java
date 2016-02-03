package me.demerzel.entity.impl;

import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityBehavior;
import me.demerzel.location.Location;
import me.demerzel.util.ImageManager;

/**
 * Created by Demerzel on 1/29/16.
 */
public class Rat extends EntityMob {
    public Rat(Location location){
        super(new ImageManager().loadImage("/assets/image/entities/rat.png"), "Sewage Rat", "A disgusting rat found in the sewer. Gross.", 3, 0, 8, location, 3, 1, 2, "The Rat bites you! Hope you got your shots...", EntityBehavior.HOSTILE);
    }
}
