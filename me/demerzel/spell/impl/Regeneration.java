package me.demerzel.spell.impl;

import me.demerzel.entity.Entity;
import me.demerzel.spell.*;

/**
 * Created by Demerzel on 2/1/16.
 */
public class Regeneration extends Spell implements LingerEffect {
    public Regeneration() {
        super("Regen", "Slowly regenerates the user's health over time", 7, 35, SpellType.LINGERING, SpellElement.DIVINE, SpellTarget.SELF);
    }

    @Override
    public void onCast(Entity entity) {
        System.out.println("A healing energy surrounds you!");
        System.out.println();
    }

    @Override
    public void fire(Entity entity) {
        int healed;

        if(entity.getMaxHealth() - entity.getHealth() < getMagnitude()){
            healed = entity.getMaxHealth() - entity.getHealth();
        }else{
            healed = getMagnitude();
        }


        entity.modHealth(healed);
        System.out.println();
        System.out.println("You regained " + healed + " HP! Remaining HP: [" + entity.getHealth() + "]");
    }
}
