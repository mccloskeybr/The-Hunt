package me.demerzel.item;

import me.demerzel.item.impl.armor.BodyArmor;
import me.demerzel.item.impl.misc.BookThunderbolt;
import me.demerzel.item.impl.misc.HealthPot;
import me.demerzel.item.impl.misc.ManaPot;
import me.demerzel.item.impl.weapon.BasicBow;
import me.demerzel.item.impl.weapon.Fists;
import me.demerzel.item.impl.weapon.Revolver;

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
        new ManaPot().register(this);
        new BookThunderbolt().register(this);
    }

    public Item getItem(String item){
        return itemHashMap.get(item);
    }

    public HashMap<String, Item> getItemHashMap() {
        return itemHashMap;
    }

    public void add(String in, Item item){
        itemHashMap.put(in, item);
    }
}
