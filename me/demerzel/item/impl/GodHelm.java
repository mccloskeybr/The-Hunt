package me.demerzel.item.impl;

import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.ItemType;

/**
 * Created by Demerzel on 1/29/16.
 */
public class GodHelm extends Item {
    public GodHelm(){
        super(5, 30000, 0, 10000, "GodHelm", "A helm made by the gods. The wearer is immune from all damage.", "", true, ItemSlot.HEAD, ItemType.ARMOR);
    }
}
