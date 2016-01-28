package me.demerzel.location.impl;

import me.demerzel.location.Location;
import me.demerzel.util.Player;


public class VentWest extends Location {
    public VentWest(){
        super("West vent", "It is becoming impossible to breathe! The air is poisoned!");
    }

    @Override
    public void run(Player player) {
        player.modHealth(-5);
    }
}
