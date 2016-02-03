package me.demerzel.entity.impl;

import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityBehavior;
import me.demerzel.item.impl.weapon.Revolver;
import me.demerzel.location.Location;
import me.demerzel.util.ImageManager;

/**
 * Created by Demerzel on 1/28/16.
 */
public class HeavyGuard extends EntityMob {
    public HeavyGuard(Location location) {
        super(new ImageManager().loadImage("/assets/image/entities/heavyguard.png"), "Heavy Guard", "A guard with some armor. Also needs to lose a few pounds.", 30, 0, 3, location, 30, 30, 5, "The Heavy Guard fires his pistol at you!", EntityBehavior.HOSTILE);
        addLoot(new Revolver());
    }
}
