package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityBehavior;
import me.demerzel.entity.EntityMob;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.entity.EventKilled;
import me.demerzel.item.ItemSlot;
import me.demerzel.item.ItemType;
import me.demerzel.spell.LingerEffect;
import me.demerzel.spell.Spell;
import me.demerzel.spell.SpellManager;
import me.demerzel.spell.SpellTarget;
import me.demerzel.util.GameManager;
import me.demerzel.util.Utilities;

import java.util.ArrayList;

/**
 * Created by Demerzel on 1/31/16.
 */
public class Cast extends Command {
    public Cast(String... aliases) {
        super(aliases);
    }

    @Override
    public boolean execute(String[] args, EntityPlayer player) {
        SpellManager spellManager = new SpellManager();

        if(args.length < 2){
            System.out.println("Usage: cast <spell> <target>");
            return false;
        }

        Spell spell = spellManager.getSpell(args[1]);

        if(spell == null){
            System.out.println("Spell not found...");
            return false;
        }

        if(!player.hasSpell(spell)){
            System.out.println("You don't have that spell!");
            return false;
        }

        if(player.getMana() < spell.getCost()){
            System.out.println("You need more mana to cast that!");
            return false;
        }

        if(spell.getTarget() != SpellTarget.SELF){
            EntityMob mob = player.getLocation().getMob(0);

            spell.onCast(mob);
            GameManager.getInstance().showEntities();
            System.out.println();
        }else{
            spell.onCast(player);
        }

        if(spell instanceof LingerEffect){
            GameManager.getInstance().getBattleManager().addLingerEffect(spell);
        }

        player.modMana(-spell.getCost());
        return true;
    }
}
