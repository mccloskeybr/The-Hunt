package me.demerzel.item.impl.weapon;

import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.ItemType;

/**
 * Created by Demerzel on 1/29/16.
 */
public class BasicBow extends Item {
    public BasicBow(){
        super(0, 4, 10, "BasicBow", "The Basic Bow. Pull back the string and the arrow goes flying. You know how a bow works.", "", true, ItemSlot.WEAPON, ItemType.SINGLETARGET);
    }
}
