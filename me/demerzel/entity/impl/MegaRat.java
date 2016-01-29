package me.demerzel.entity.impl;

import me.demerzel.entity.EntityMob;
import me.demerzel.location.Location;

/**
 * Created by Demerzel on 1/29/16.
 */
public class MegaRat extends EntityMob {
    public MegaRat(Location location){
        super("Mega Rat", "An enormous rat, said to be the King of all Ratkind. Still not that tough.", 10, 3, 7, location, 10, 400, 4, "The Mega Rat grosses you out! I HATE rats!");
    }
}
