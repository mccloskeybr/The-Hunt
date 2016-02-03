package me.demerzel.location.impl;

import me.demerzel.location.Location;

/**
 * Created by Demerzel on 1/31/16.
 */
public class Battleground extends Location {
    public Battleground() {
        super("Battleground", "The battleground");
        addState(1, "The Battleground");
    }
}
