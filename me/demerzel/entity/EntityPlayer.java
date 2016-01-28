package me.demerzel.entity;

import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.location.Location;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Demerzel on 1/28/16.
 */
public class EntityPlayer extends Entity {
    private int wallet;
    private int experience;
    private boolean pooped;
    private ArrayList<Item> inventory;
    private HashMap<ItemSlot, Item> equipped;

    public EntityPlayer(String name, String bio, Location location) {
        super(name, bio, 20, 10, 4, location);
        inventory = new ArrayList<>();
        equipped = new HashMap<>();
    }

    public int getMoney() {
        return wallet;
    }

    public void setMoney(int wallet) {
        this.wallet = wallet;
    }

    public void modMoney(int amt){
        this.wallet += amt;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void modExperience(int amt){
        this.experience += amt;
    }

    public int getArmor(){
        int armor = 0;
        for(HashMap.Entry<ItemSlot, Item> entry: getEquipped().entrySet()){
            armor += entry.getValue().getArmor();
        }

        return armor;
    }

    public int getAttack(){
        int attack = 0;
        for(HashMap.Entry<ItemSlot, Item> entry: getEquipped().entrySet()){
            attack += entry.getValue().getDamage();
        }

        return attack;
    }

    public boolean isPooped() {
        return pooped;
    }

    public void setPooped(boolean pooped) {
        this.pooped = pooped;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item){
        inventory.add(item);
    }

    public boolean removeItem(Item item){
        if(inventory.contains(item)){
            inventory.remove(item);
            return true;
        }

        return false;
    }

    public HashMap<ItemSlot, Item> getEquipped(){
        return equipped;
    }

    public void equip(Item item){
        if(equipped.get(item.getSlot()) != null){
            inventory.add(equipped.get(item.getSlot()));
            equipped.replace(item.getSlot(), item);
        }

        equipped.put(item.getSlot(), item);
        inventory.remove(item);
    }

    public void unequip(Item item){
        equipped.remove(item.getSlot(), item);
        inventory.add(item);
    }
}
