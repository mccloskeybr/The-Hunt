package me.demerzel.item.impl;

import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.ItemType;

/**
 * Created by Demerzel on 1/31/16.
 */
public class Fists extends Item {
    public Fists(){
        super(4, 0, 2, 0, "Fists", "A REAL man's guns", "", true, ItemSlot.WEAPON, ItemType.SINGLETARGET);
    }
}
