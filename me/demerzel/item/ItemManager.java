package me.demerzel.item;

import me.demerzel.item.impl.*;

import java.util.HashMap;

/**
 * Created by Demerzel on 1/31/16.
 */
public class ItemManager {
    private HashMap<String, Item> itemHashMap;

    public ItemManager(){
        itemHashMap = new HashMap<>();

        new BasicBow().register(this);
        new BodyArmor().register(this);
        new Fists().register(this);
        new HealthPot().register(this);
        new Revolver().register(this);
    }

    public Item getItem(String item){
        return itemHashMap.get(item);
    }

    public HashMap<String, Item> getSpellHashMap() {
        return itemHashMap;
    }

    public void add(String in, Item item){
        itemHashMap.put(in, item);
    }
}
