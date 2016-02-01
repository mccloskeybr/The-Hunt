package me.demerzel.spell.impl;

import me.demerzel.entity.Entity;
import me.demerzel.entity.EntityMob;
import me.demerzel.spell.Spell;
import me.demerzel.spell.SpellElement;
import me.demerzel.spell.SpellTarget;
import me.demerzel.spell.SpellType;

/**
 * Created by Demerzel on 1/31/16.
 */
public class Heal extends Spell {
    public Heal() {
        super("Heal", "A magical energy heals your wounds.", 15, 15, SpellType.FIREONCE, SpellElement.DIVINE, SpellTarget.SELF);
    }

    public void onCast(Entity entity) {
        int healed;

        if(entity.getMaxHealth() - entity.getHealth() < getMagnitude()){
            healed = entity.getMaxHealth() - entity.getHealth();
        }else{
            healed = getMagnitude();
        }


        entity.modHealth(healed);
        System.out.println("A magical energy repairs your wounds! You gained " + healed + " HP!");
    }
}
