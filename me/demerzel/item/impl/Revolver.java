package me.demerzel.item.impl;

import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.Usable;


public class Revolver extends Item implements Usable{
    public Revolver(){
        super(2, 0, 10, "Revolver", "A heavy revolver.", "BANG BANG BANG!", true, ItemSlot.WEAPON);
    }

    @Override
    public void use() {
        System.out.println("You fire the revolver into the air, but nothing happens. Calm down, just because you're in America doesn't mean you can shoot everything.");
    }
}
