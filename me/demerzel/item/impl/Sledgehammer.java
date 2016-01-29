package me.demerzel.item.impl;

import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.ItemType;


public class Sledgehammer extends Item{
    public Sledgehammer(){
        super(1, 0, 7, 200, "Sledgehammer", "A heavy sledgehammer used for smashing stuff. Smashes all the enemies at once!", "", false, ItemSlot.WEAPON, ItemType.MULTITARGET);
    }
}
