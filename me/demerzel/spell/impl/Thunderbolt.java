package me.demerzel.spell.impl;

import me.demerzel.entity.Entity;
import me.demerzel.spell.Spell;
import me.demerzel.spell.SpellElement;
import me.demerzel.spell.SpellTarget;
import me.demerzel.spell.SpellType;

/**
 * Created by Demerzel on 2/1/16.
 */
public class Thunderbolt extends Spell {
    public Thunderbolt() {
        super("Thunderbolt", "Blasts an enemy with the power of lightning", 25, 30, SpellType.FIREONCE, SpellElement.THUNDER, SpellTarget.SINGLETARGET);
    }

    @Override
    public void onCast(Entity entity) {
        int damage = Math.min(entity.getHealth(), getMagnitude());

        if(damage < 0){
            damage = 0;
        }

        System.out.println("The enemy was blasted with electricity! It took " + damage + " damage!");
        entity.modHealth(-damage);
    }
}
