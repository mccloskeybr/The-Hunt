package me.demerzel.location.impl;

import me.demerzel.entity.impl.Shopkeeper;
import me.demerzel.location.Location;

/**
 * Created by Demerzel on 1/29/16.
 */
public class Store extends Location {
    public Store() {
        super("The Store", "A generic store. You can buy things here!");
        addMob(new Shopkeeper(this));
    }
}
