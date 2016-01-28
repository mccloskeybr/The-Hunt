package me.demerzel.item.impl;

import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;


public class Sledgehammer extends Item{
    public Sledgehammer(){
        super(1, 0, 5, "Sledgehammer", "A heavy sledgehammer used for smashing stuff.", "You pull the sledgehammer out of your inventory and swing it against the wall. The bricks crumble revealing a hidden passageway! Unfortunately, it was a poorly made Sledgehammer and it breaks :/", false, ItemSlot.BACKUP);
    }
}
