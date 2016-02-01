package me.demerzel.spell;

import me.demerzel.command.CommandManager;
import me.demerzel.entity.Entity;
import me.demerzel.entity.EntityMob;

/**
 * Created by Demerzel on 1/31/16.
 */
public abstract class Spell {
    private String name;
    private String description;
    private int magnitude;
    private int cost;
    private SpellType type;
    private SpellElement element;
    private SpellTarget target;

    public Spell(String name, String description, int magnitude, int cost, SpellType type, SpellElement element, SpellTarget target){
        this.name = name;
        this.description = description;
        this.magnitude = magnitude;
        this.cost = cost;
        this.type = type;
        this.element = element;
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpellType getType() {
        return type;
    }

    public void setType(SpellType type) {
        this.type = type;
    }

    public SpellElement getElement() {
        return element;
    }

    public void setElement(SpellElement element) {
        this.element = element;
    }

    public SpellTarget getTarget() {
        return target;
    }

    public void setTarget(SpellTarget target) {
        this.target = target;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(int magnitude) {
        this.magnitude = magnitude;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void register(SpellManager spellManager){
        spellManager.add(name.toLowerCase(), this);
    }

    public abstract void onCast(Entity entity);
}
