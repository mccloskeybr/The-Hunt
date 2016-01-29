package me.demerzel.location.impl;

import me.demerzel.entity.EntityPlayer;
import me.demerzel.entity.impl.Guard;
import me.demerzel.location.Location;


public class Start extends Location{

    public Start() {
        super("Entrance to The Compound", "The outside of the compound. There are three entrances: The front door <North>, the vents <West>, and  <East>");
        addState(1, "Start Examine Text");
        addMob(new Guard(this));
        addMob(new Guard(this));
    }
}
