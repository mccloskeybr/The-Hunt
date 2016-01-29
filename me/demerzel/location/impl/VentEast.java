package me.demerzel.location.impl;

import me.demerzel.entity.EntityPlayer;
import me.demerzel.entity.impl.Dragon;
import me.demerzel.location.Location;
import me.demerzel.location.Runnable;


public class VentEast extends Location{
    public VentEast(){
        super("East Vent", "The air clears up. You can breathe easily now.");
        addState(1, "East Vent Examine Text");
        addMob(new Dragon(this));
    }
}
