package me.demerzel.item.impl;

import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;


public class Helmet extends Item{
    public Helmet(){
        super(2, 10, 0, "Helmet", "A hardened helmet", "You throw the helmet at the enemy.", true, ItemSlot.HEAD);
    }
}
