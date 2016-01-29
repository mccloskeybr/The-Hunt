package me.demerzel.item.impl;

import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.ItemType;

/**
 * Created by Demerzel on 1/29/16.
 */
public class TheColt extends Item {
    public TheColt(){
        super(4, 0, 40000, 10000, "The_Colt", "A gun that can kill any living thing", "", true, ItemSlot.WEAPON, ItemType.SINGLETARGET);
    }
}
