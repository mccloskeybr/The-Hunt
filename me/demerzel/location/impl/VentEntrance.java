package me.demerzel.location.impl;

import me.demerzel.entity.EntityPlayer;
import me.demerzel.location.Location;


public class VentEntrance extends Location {
    public VentEntrance(){
        super("Vent Opening", "You crawl into the vents. The air is hard to breathe in here. You feel a pain in your chest. There are two ways you can go: <West> and <East>");
        addState(1, "Opening Vent Examine Text");
    }

    @Override
    public void run(EntityPlayer player) {

    }
}
