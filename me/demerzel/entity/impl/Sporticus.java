package me.demerzel.entity.impl;

import me.demerzel.entity.EntityBehavior;
import me.demerzel.entity.EntityMob;
import me.demerzel.location.Location;
import me.demerzel.util.ImageManager;

/**
 * Created by Demerzel on 2/2/16.
 */
public class Sporticus extends EntityMob {
    public Sporticus(Location location) {
        super(new ImageManager().loadImage("/assets/image/entities/sporticus.png"), "Sporticus", "A man in the land of Lazytown. He lives in a blimp and help keep kids healthy by making them do slave labor.", 600, 0, 10, location, 1000, 800, 40, "Sporticus sneaks up behind you and two-hand palm-punches you!", EntityBehavior.HOSTILE);
    }
}
