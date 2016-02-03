package me.demerzel.spell.impl;

import me.demerzel.entity.Entity;
import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.spell.*;

/**
 * Created by Demerzel on 1/31/16.
 */
public class Fireball extends Spell{
    public Fireball() {
        super("Fireball", "The player lobs a fireball at the enemy.", 10, 5, SpellType.FIREONCE, SpellElement.FIRE, SpellTarget.SINGLETARGET);
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
