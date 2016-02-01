package me.demerzel.entity.impl;

import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityBehavior;
import me.demerzel.location.Location;

/**
 * Created by Demerzel on 1/29/16.
 */
public class ExpTester extends EntityMob {
    public ExpTester(Location location) {
        super("Tester", "", 1, 0, 0, location, 30, 100, 0, "The Tester tests your limits!", EntityBehavior.HOSTILE);
    }
}
