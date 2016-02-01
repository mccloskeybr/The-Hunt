package me.demerzel.entity;

import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.impl.HealthPot;
import me.demerzel.location.Location;
import me.demerzel.spell.impl.Fireball;
import me.demerzel.spell.impl.Firestorm;
import me.demerzel.spell.impl.Heal;

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
        super(name, bio, 30, 50, 4, location, EntityBehavior.PLAYER);
        inventory = new ArrayList<>();
        equipped = new HashMap<>();
        wallet = 100;
        pooped = false;

        addSpell(new Fireball());
        addSpell(new Heal());
        addSpell(new Firestorm());
        addItem(new HealthPot());
    }

    @Override
    public int getHealth(){
        return (int) (super.getHealth() + (Math.log10(getLevel()) * 20));
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
        if(getLevel(getExperience() + amt) > getLevel()){
            System.out.println("=========================");
            System.out.println("  Level Up! New Level: " + (getLevel(getExperience() + amt)));
            System.out.println("=========================");
        }

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
        int attack = 1;
        for(HashMap.Entry<ItemSlot, Item> entry: getEquipped().entrySet()){
            attack += entry.getValue().getMagnitude();
        }

        return (int) (attack + (Math.log10(getLevel()) * 10));
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

    public int getLevel(){
        return (int) (Math.sqrt(100 * (2 * getExperience() + 25)) + 50) / 100;
    }

    public int getLevel(int experience){
        return (int) (Math.sqrt(100 * (2 * experience + 25)) + 50) / 100;
    }
}
