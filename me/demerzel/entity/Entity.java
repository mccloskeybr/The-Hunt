package me.demerzel.entity;

import me.demerzel.location.Location;
import me.demerzel.spell.Spell;
import me.demerzel.util.Utilities;
import org.apache.commons.lang3.text.WordUtils;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Demerzel on 1/28/16.
 */
public abstract class Entity {
    private String name;
    private String bio;
    private int health;
    private int maxHealth;
    private int mana;
    private int maxMana;
    private int speed;
    private Location location;
    private EntityBehavior type;
    private ArrayList<Spell> spells;

    public Entity(String name, String bio, int maxHealth, int maxMana, int speed, Location location, EntityBehavior type) {
        this.name = name;
        this.bio = bio;
        this.maxHealth = maxHealth;
        this.maxMana = maxMana;
        this.health = maxHealth;
        this.mana = maxMana;
        this.speed = speed;
        this.location = location;
        this.type = type;

        spells = new ArrayList<>();
    }

    public String getName() {
        return WordUtils.capitalizeFully(name);
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

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void modMaxHealth(int amt) { this.maxHealth += amt; }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public void modMaxMana(int amt) { this.maxMana += amt; }

    public EntityBehavior getType() {
        return type;
    }

    public void setType(EntityBehavior type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void say(String out, boolean wait){
        if(wait){
            Utilities.cmd("<" + getName() + ">: " + out);
            System.out.println("Press <Enter> to continue...");
        }else{
            System.out.println("<" + getName() + ">: " + out);
        }
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }

    public void addSpell(Spell spell){
        spells.add(spell);
    }

    public void removeSpell(Spell spell){
        if(spells.contains(spell)){
            spells.remove(spell);
        }
    }

    public boolean hasSpell(Spell spell){
        for(Spell s : getSpells()){
            if(s.getClass().equals(spell.getClass())){
                return true;
            }
        }

        return false;
    }

    public void heal(){
        setHealth(getMaxHealth());
        setMana(getMaxMana());
    }

}
