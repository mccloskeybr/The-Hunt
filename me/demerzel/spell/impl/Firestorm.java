package me.demerzel.spell.impl;

import me.demerzel.entity.Entity;
import me.demerzel.spell.Spell;
import me.demerzel.spell.SpellElement;
import me.demerzel.spell.SpellTarget;
import me.demerzel.spell.SpellType;

/**
 * Created by Demerzel on 1/31/16.
 */
public class Firestorm extends Spell {
    public Firestorm() {
        super("Firestorm", "A destructive storm of fire envelops your enemies!", 20, 15, SpellType.FIREONCE, SpellElement.FIRE, SpellTarget.MULTITARGET);
    }

    @Override
    public void onCast(Entity entity) {
        int damage = Math.min(entity.getHealth(), getMagnitude());

        if(damage < 0){
            damage = 0;
        }

        System.out.println("The enemy is consumed by fire! It took " + damage + " damage!");
        entity.modHealth(-damage);
    }
}
