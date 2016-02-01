package me.demerzel.item.impl;

import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.ItemType;

/**
 * Created by Demerzel on 1/29/16.
 */
public class BodyArmor extends Item {
    public BodyArmor(){
        super(3, 15, 0, 80, "BodyArmor", "Basic body armor. Provides some protection against attacks.", "", true, ItemSlot.CHEST, ItemType.ARMOR);
    }
}
