package me.demerzel.location.impl;

import me.demerzel.entity.impl.shopkeepers.Hobo;
import me.demerzel.location.Location;

/**
 * Created by Demerzel on 2/2/16.
 */
public class VentMoreWest extends Location {
    public VentMoreWest() {
        super("West Vent", "The western end of the vent. A crazy hobo has set up shop here.");

        addMob(new Hobo("Crazy Hobo", this));
        addState(1, "This place smells like homeless people.");
        addState(2, "The corpse of the hobo you killed is still here. I hope you feel good about yourself.");
    }
}
