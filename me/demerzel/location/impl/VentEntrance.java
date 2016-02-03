package me.demerzel.location.impl;

import me.demerzel.entity.impl.Guard;
import me.demerzel.location.Location;
import me.demerzel.util.ImageManager;


public class VentEntrance extends Location {
    public VentEntrance(){
        super(new ImageManager().loadImage("/assets/image/rooms/vententrance.png"), "Vent Opening", "You crawl into the vents. The air is hard to breathe in here. You feel a pain in your chest. There are two ways you can go: <West> and <East>");
        addState(1, "Opening Vent Examine Text");
        addMob(new Guard(this));
    }
}
