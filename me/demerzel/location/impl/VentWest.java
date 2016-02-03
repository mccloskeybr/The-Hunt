package me.demerzel.location.impl;

import me.demerzel.entity.EntityPlayer;
import me.demerzel.entity.impl.HeavyGuard;
import me.demerzel.location.Location;
import me.demerzel.location.EventEnter;


public class VentWest extends Location{
    public VentWest(){
        super("West vent", "The western vent. You can continue down the vent or turn back.");
        addState(1, "West Vent Examine Text");
        addMob(new HeavyGuard(this));
        addMob(new HeavyGuard(this));
    }
}
