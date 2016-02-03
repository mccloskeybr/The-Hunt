package me.demerzel.spell;

import me.demerzel.spell.impl.*;

import java.util.HashMap;

/**
 * Created by Demerzel on 1/31/16.
 */
public class SpellManager {
    private HashMap<String, Spell> spellHashMap;

    public SpellManager(){
        spellHashMap = new HashMap<>();

        new Fireball().register(this);
        new Heal().register(this);
        new Firestorm().register(this);
        new Regeneration().register(this);
        new Inferno().register(this);
        new Thunderbolt().register(this);
    }

    public Spell getSpell(String spell){
        return spellHashMap.get(spell);
    }

    public HashMap<String, Spell> getSpellHashMap() {
        return spellHashMap;
    }

    public void add(String in, Spell spell){
        spellHashMap.put(in, spell);
    }
}
