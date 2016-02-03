package me.demerzel.location.impl;

import me.demerzel.entity.impl.Dragon;
import me.demerzel.location.Location;
import me.demerzel.util.ImageManager;


public class VentEast extends Location{
    public VentEast(){
        super(new ImageManager().loadImage("/assets/image/rooms/venteast.png"), "East Vent", "The air clears up. You can breathe easily now.");
        addState(1, "East Vent Examine Text");
        addMob(new Dragon(this));
    }
}
