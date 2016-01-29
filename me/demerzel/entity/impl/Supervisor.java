package me.demerzel.entity.impl;

import me.demerzel.entity.EntityMob;
import me.demerzel.location.Location;

/**
 * Created by Demerzel on 1/29/16.
 */
public class Supervisor extends EntityMob {
    public Supervisor(Location location) {
        super("The Supervisor", "The first boss you ever fight. He's tough, but not THAT tough.", 40, 10, 5, location, 100, 200, 7, "The Supervisor starts yelling at you about wages or something. I stopped paying attention.");
    }
}
