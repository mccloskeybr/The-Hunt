package me.demerzel.entity;

import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.location.Location;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Demerzel on 1/28/16.
 */
public abstract class Entity {
    private String name;
    private String bio;
    private int health;
    private int mana;
    private int speed;
    private Location location;

    public Entity(String name, String bio, int health, int mana, int speed, Location location) {
        this.name = name;
        this.bio = bio;
        this.health = health;
        this.mana = mana;
        this.speed = speed;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void modHealth(int amt){
        this.health += amt;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void modMana(int amt){
        this.mana += amt;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void modSpeed(int amt){
        this.speed += amt;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
