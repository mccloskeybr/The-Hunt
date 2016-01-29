package me.demerzel.item.impl;

import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.ItemType;


public class Helmet extends Item{
    public Helmet(){
        super(2, 3, 0, 40, "Helmet", "A hardened helmet", "You throw the helmet at the enemy.", true, ItemSlot.HEAD, ItemType.ARMOR);
    }
}
