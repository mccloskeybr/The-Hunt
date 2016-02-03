package me.demerzel.entity;

import me.demerzel.item.Item;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.impl.misc.HealthPot;
import me.demerzel.location.Location;
import me.demerzel.spell.impl.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Demerzel on 1/28/16.
 */
public class EntityPlayer extends Entity {

    private int level;
    private int baseAttack;
    private int baseSpeed;
    private int wallet;
    private int experience;
    private boolean pooped;
    private ArrayList<Item> inventory;
    private HashMap<ItemSlot, Item> equipped;

    public EntityPlayer(String name, String bio, Location location) {
        super(name, bio, 60, 50, 4, location, EntityBehavior.PLAYER);
        inventory = new ArrayList<>();
        equipped = new HashMap<>();
        wallet = 100;
        pooped = false;
        level = 1;

        this.baseAttack = 4;
        this.baseSpeed = 4;
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

        while(nextLevel() <= 0){
            Random r = new Random();


            int addedHp = (int) Math.max(1, r.nextInt(15));
            int addedStr = (int) Math.max(1, r.nextInt(3));
            int addedSpd = (int) Math.max(1, r.nextInt(3));

            level++;

            System.out.println("=========================");
            System.out.println("  Level Up! New Level: " + getLevel());
            System.out.println("   Health increased by: " + addedHp);
            System.out.println(" Strength increased by: " + (addedStr));
            System.out.println("   Speed increased by: " + (addedSpd));
            System.out.println("=========================");

            modMaxHealth(addedHp);
            baseAttack += addedStr;
            baseSpeed += addedSpd;
            heal();
        }
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
            attack += entry.getValue().getMagnitude();
        }

        return (attack + baseAttack);
    }

    @Override
    public int getSpeed(){
        return (baseSpeed);
    }

    public int getSpeed(int level){
        return (int) (4 + (Math.log10(level) * 10));
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
        return level;
    }

    public int getLevel(int experience){
        return (int) (-5/2 + (Math.sqrt(experience + 125) / (2 * Math.sqrt(5))));
    }

    public int nextLevel(){
        double LEVEL_CONSTANT = 20;
        return (int) (LEVEL_CONSTANT * (level) * (level + 5) - getExperience());
    }
}
