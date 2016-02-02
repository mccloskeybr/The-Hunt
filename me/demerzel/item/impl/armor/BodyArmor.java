package me.demerzel.item.impl.armor;

import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.ItemType;

/**
 * Created by Demerzel on 1/29/16.
 */
public class BodyArmor extends Item {
    public BodyArmor(){
        super(2, 0, 80, "BodyArmor", "Basic body armor. Provides some protection against attacks.", "", true, ItemSlot.CHEST, ItemType.ARMOR);
    }
}
