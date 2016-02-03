package me.demerzel.location.impl;

import me.demerzel.entity.impl.HeavyGuard;
import me.demerzel.location.Location;
import me.demerzel.util.ImageManager;


public class VentWest extends Location{
    public VentWest(){
        super(new ImageManager().loadImage("/assets/image/rooms/ventwest.png"), "West vent", "The western vent. You can continue down the vent or turn back.");
        addState(1, "West Vent Examine Text");
        addMob(new HeavyGuard(this));
        addMob(new HeavyGuard(this));
    }
}
