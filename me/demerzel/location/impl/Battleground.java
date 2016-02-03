package me.demerzel.location.impl;

import me.demerzel.location.Location;
import me.demerzel.util.ImageManager;

/**
 * Created by Demerzel on 1/31/16.
 */
public class Battleground extends Location {
    public Battleground() {
        super(new ImageManager().loadImage("/assets/image/rooms/battleground.png"), "Battleground", "The battleground");
        addState(1, "The Battleground");
    }
}
