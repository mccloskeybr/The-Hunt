package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.spell.Spell;

/**
 * Created by Demerzel on 1/31/16.
 */
public class Spellbook extends Command {
    public Spellbook(String... aliases){
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        System.out.println("You currently know: ");
        for(Spell spell : player.getSpells()){
            System.out.println(spell.getName() + " [Power: " + spell.getMagnitude() + "] [Cost: " + spell.getCost() + "] | " + spell.getDescription());
        }

        return false;
    }
}
