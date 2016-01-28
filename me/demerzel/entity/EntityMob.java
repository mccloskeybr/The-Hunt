package me.demerzel.entity;

import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.location.Location;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Demerzel on 1/28/16.
 */
public abstract class EntityMob extends Entity {
    private int expRewarded;
    private int strength;
    private int uid;
    private static int count = 1;
    private ArrayList<Item> loot;

    public EntityMob(String name, String bio, int health, int mana, int speed, Location location, int expRewarded, int strength) {
        super(name, bio, health, mana, speed, location);
        this.loot = new ArrayList<>();
        this.expRewarded = expRewarded;
        this.strength = strength;

        this.uid = count;
        count++;
    }

    public int getExpRewarded() {
        return expRewarded;
    }

    public void setExpRewarded(int expRewarded) {
        this.expRewarded = expRewarded;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getUid() {
        return uid;
    }

    public int getCount(){
        return count;
    }

    public ArrayList<Item> getLoot() {
        return loot;
    }

    public void addLoot(Item item){
        loot.add(item);
    }

    public void removeLoot(Item item){
        if(loot.contains(item)){
            loot.add(item);
        }
    }

    public abstract void onDefeat();
}
