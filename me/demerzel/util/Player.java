package me.demerzel.util;

import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.location.Location;

import java.util.ArrayList;
import java.util.HashMap;


public class Player {
    private int health;
    private int mana;
    private int money;
    private String name;
    private String bio;
    private Location current;
    private boolean pooped = false;
    private ArrayList<Item> items;
    private HashMap<ItemSlot, Item> equippedItems;

    public Player(int health, int mana, int money, String name, String bio, Location location, ArrayList<Item> items) {
        this.health = health;
        this.mana = mana;
        this.money = money;
        this.name = name;
        this.bio = bio;
        this.current = location;
        this.items = items;
        equippedItems = new HashMap<>();
    }

    public Player(String name, String bio, Location location) {
        this(20, 10, 100, name, bio, location, new ArrayList<>());
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

    public int getArmor() {
        int armor = 0;

        for (ItemSlot name: this.getEquippedItems().keySet()){
            int value = this.getEquippedItems().get(name).getArmor();
            armor =+ value;
        }

        return armor;
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

    public Location getLocation() {
        return current;
    }

    public void setLocation(Location current) {
        this.current = current;
    }

    public boolean isPooped() {
        return pooped;
    }

    public void setPooped(boolean pooped) {
        this.pooped = pooped;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void removeItem(Item item){
        if(items.contains(item)){
            items.remove(item);
        }
    }

    public void addItem(Item item){
        items.add(item);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void modMoney(int amt){
        this.money += amt;
    }

    public void equip(Item item){
        if(equippedItems.get(item.getSlot()) != null){
            this.items.add(equippedItems.get(item.getSlot()));
            this.equippedItems.replace(item.getSlot(), item);
        }

        this.equippedItems.put(item.getSlot(), item);
        this.items.remove(item);
    }

    public void unequip(Item item){
        this.equippedItems.remove(item.getSlot(), item);
        this.items.add(item);
    }

    public HashMap<ItemSlot, Item> getEquippedItems() {
        return equippedItems;
    }
}
