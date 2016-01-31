package me.demerzel.item.impl;

import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.ItemType;

/**
 * Created by Demerzel on 1/29/16.
 */
public class Revolver extends Item{
    public Revolver(){
        super(2, 0, 10, 100, "Revolver", "A medium-sized hand gun. Packs quite a wallop!", "", true, ItemSlot.WEAPON, ItemType.SINGLETARGET);
    }
}
