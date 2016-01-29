package me.demerzel.entity.impl;

import me.demerzel.entity.EntityMob;
import me.demerzel.location.Location;

/**
 * Created by Demerzel on 1/29/16.
 */
public class Rat extends EntityMob {
    public Rat(Location location){
        super("Sewage Rat", "A disgusting rat found in the sewer. Gross.", 3, 0, 8, location, 3, 2);
    }
}
