package me.demerzel.location.impl;

import me.demerzel.entity.EntityPlayer;
import me.demerzel.entity.impl.HeavyGuard;
import me.demerzel.location.Location;
import me.demerzel.location.Runnable;


public class VentWest extends Location implements Runnable{
    public VentWest(){
        super("West vent", "It is becoming impossible to breathe! The air is poisoned!");
        addState(1, "West Vent Examine Text");
        addMob(new HeavyGuard(this));
        addMob(new HeavyGuard(this));
    }

    @Override
    public void run(EntityPlayer player) {
        player.modHealth(-5);
    }
}
