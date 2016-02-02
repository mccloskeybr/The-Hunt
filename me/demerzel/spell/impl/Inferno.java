package me.demerzel.spell.impl;

import me.demerzel.entity.Entity;
import me.demerzel.spell.*;

/**
 * Created by Demerzel on 2/1/16.
 */
public class Inferno extends Spell implements LingerEffect{
    public Inferno() {
        super("Inferno", "A raging inferno envelops your target, dealing damage over time.", 8, 30, SpellType.LINGERING, SpellElement.FIRE, SpellTarget.SINGLETARGET);
    }

    @Override
    public void onCast(Entity entity) {

    }

    @Override
    public void fire(Entity entity) {
        int damage = Math.min(entity.getHealth(), getMagnitude());

        if(damage < 0){
            damage = 0;
        }

        entity.modHealth(-damage);
        System.out.println();
        System.out.println("The inferno dealt " + damage + " damage! Remaining HP: [" + entity.getHealth() + "]");
    }
}
