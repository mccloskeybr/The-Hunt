package me.demerzel.location.impl;

import me.demerzel.location.Location;
import me.demerzel.util.ImageManager;


public class Start extends Location{

    public Start() {
        super(new ImageManager().loadImage("/assets/image/rooms/start.png"), "Entrance to The Compound", "The outside of the compound. There are three entrances: The front door <North>, the vents <West>, and  <East>");
        addState(1, "Start Examine Text");
    }
}
